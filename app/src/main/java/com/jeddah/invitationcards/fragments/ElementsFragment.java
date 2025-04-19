package com.jeddah.invitationcards.fragments;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;

import com.jeddah.invitationcards.R;
import com.jeddah.invitationcards.activities.GreetingCardEditActivity;
import com.jeddah.invitationcards.activities.MainActivity;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class ElementsFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final int CAMERA_REQUEST = 2;
    public static final int PICK_IMAGE = 1;
    public static Bitmap selectedImageBitmap;
    Bitmap bitmap;

    LinearLayout cameraImage;
    LinearLayout galleryImage;
    ImageView hiddenDown;
    Uri imageUri;
    String mParam1;
    String mParam2;
    RelativeLayout rootRel;
    View rootView;
    LinearLayout stickerImage;

    public static ElementsFragment newInstance(String str, String str2) {
        ElementsFragment elementsFragment = new ElementsFragment();
        Bundle bundle = new Bundle();
        bundle.putString(ARG_PARAM1, str);
        bundle.putString(ARG_PARAM2, str2);
        elementsFragment.setArguments(bundle);
        return elementsFragment;
    }

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.mParam1 = getArguments().getString(ARG_PARAM1);
            this.mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_elements, viewGroup, false);
        this.rootView = inflate;
        this.hiddenDown = (ImageView) inflate.findViewById(R.id.hidden_down);
        this.cameraImage = (LinearLayout) this.rootView.findViewById(R.id.camera_btn_linear);
        this.galleryImage = (LinearLayout) this.rootView.findViewById(R.id.gallery_btn_linear);
        this.stickerImage = (LinearLayout) this.rootView.findViewById(R.id.stickers_btn_linear);
        this.rootRel = (RelativeLayout) this.rootView.findViewById(R.id.elements_root_frame);
        return this.rootView;
    }

    @Override
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.hiddenDown.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                GreetingCardEditActivity.activity.removeElementsFragment(true);
            }
        });
        this.galleryImage.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (MainActivity.mainActivity.checkStoragePermission()) {
                    Intent intent = new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    intent.setType("image/*");
                    ElementsFragment.this.startActivityForResult(Intent.createChooser(intent, "Select Picture"), 1);
                    return;
                }
                MainActivity.mainActivity.requestStoragePermission();
            }
        });
        this.stickerImage.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                GreetingCardEditActivity.activity.setStickerFragment();
            }
        });
        this.cameraImage.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (MainActivity.mainActivity.checkCameraPermission() && MainActivity.mainActivity.checkStoragePermission()) {
                    ElementsFragment.this.launchCamera();
                } else if (!MainActivity.mainActivity.checkCameraPermission()) {
                    MainActivity.mainActivity.requestCameraPermission();
                } else if (!MainActivity.mainActivity.checkStoragePermission()) {
                    MainActivity.mainActivity.requestStoragePermission();
                }
            }
        });
    }

    public void launchCamera() {
        if (ContextCompat.checkSelfPermission((Context) Objects.requireNonNull(getContext()), "android.permission.CAMERA") == 0) {
            File file = new File(Environment.getExternalStorageDirectory() + "/Android/data/" + ((Context) Objects.requireNonNull(getContext())).getPackageName() + "/temp data");
            if (!file.exists()) {
                file.mkdirs();
            }
            Uri uriForFile = FileProvider.getUriForFile((Context) Objects.requireNonNull(getContext()), getContext().getString(R.string.file_provider_authority), new File(file, "image_capture.jpg"));
            Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
            intent.putExtra("output", uriForFile);
            startActivityForResult(intent, 2);
        }
    }

    @Override
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            if (i == 1) {
                this.imageUri = intent.getData();
                try {
                    Bitmap bitmap2 = MediaStore.Images.Media.getBitmap(( Objects.requireNonNull(getContext())).getContentResolver(), this.imageUri);
                    this.bitmap = bitmap2;
                    selectedImageBitmap = bitmap2;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else if (i == 2) {
                Bitmap bitmap3 = null;
                File file = new File(Environment.getExternalStorageDirectory() + "/Android/data/" + ((Context) Objects.requireNonNull(getContext())).getPackageName() + "/temp data");
                if (!file.exists()) {
                    file.mkdirs();
                }
                try {
                    bitmap3 = MediaStore.Images.Media.getBitmap(getContext().getContentResolver(), Uri.fromFile(new File(file, "image_capture.jpg")));
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                Bitmap bitmap4 = bitmap3;
                Matrix matrix = new Matrix();
                matrix.postRotate(90.0f);
                selectedImageBitmap = Bitmap.createBitmap(bitmap4, 0, 0, bitmap4.getWidth(), bitmap4.getHeight(), matrix, true);
            }
            if (selectedImageBitmap != null) {
                GreetingCardEditActivity.activity.setSelectedPhoto(selectedImageBitmap);
                GreetingCardEditActivity.activity.removeElementsFragment(false);
            }
        }
    }

    public void onBackPressed() {
        getActivity().onBackPressed();
    }
}
