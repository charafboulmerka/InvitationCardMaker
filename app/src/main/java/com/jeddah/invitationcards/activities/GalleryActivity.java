package com.jeddah.invitationcards.activities;

import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.astritveliu.boom.Boom;
import com.jeddah.invitationcards.R;
import com.jeddah.invitationcards.adapters.ImageAdapter;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class GalleryActivity extends AppCompatActivity {
    public static GalleryActivity galleryActivity;

    public LinearLayout backToHome;
    ImageAdapter imageAdapter;
    public RecyclerView imageRecycler;
    ArrayList<String> imagesList;

    public TextView noImagesToShow;
    LinearLayout selectBack;
    public TextView selectCount;
    ImageView selectDelete;
    ImageView selectSelectAll;
    ImageView selectShare;
    public LinearLayout selectionOptions;
    public LinearLayout toolOptions;


    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_gallery);


        this.noImagesToShow = (TextView) findViewById(R.id.no_images_txt);
        galleryActivity = this;

        this.imageRecycler = (RecyclerView) findViewById(R.id.image_recycler);
        if (isDirectoryNotEmpty(Environment.getExternalStorageDirectory().toString() + "/" + getResources().getString(R.string.app_name))) {
            ArrayList<String> imagesFromDevice = getImagesFromDevice();
            this.imagesList = imagesFromDevice;
            if (imagesFromDevice == null || imagesFromDevice.size() <= 0) {
                this.noImagesToShow.setVisibility(View.VISIBLE);
            } else {
                this.noImagesToShow.setVisibility(View.GONE);
            }
            setImageAdapter(this.imagesList, false);
        } else {
            this.noImagesToShow.setVisibility(View.VISIBLE);
        }
        this.selectionOptions = (LinearLayout) findViewById(R.id.select_options);
        this.selectCount = (TextView) findViewById(R.id.select_count);
        this.selectDelete = (ImageView) findViewById(R.id.select_delete);
        this.selectShare = (ImageView) findViewById(R.id.select_share);
        this.selectBack = (LinearLayout) findViewById(R.id.select_back_linear);
        this.selectSelectAll = (ImageView) findViewById(R.id.select_selectall);
        this.toolOptions = (LinearLayout) findViewById(R.id.tool_options);
        this.selectDelete.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                GalleryActivity.this.showDeleteDialog();
            }
        });
        this.selectBack.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                GalleryActivity.this.updateList(false);
                GalleryActivity.this.selectCount.setText("selected : 0");
                GalleryActivity.this.selectionOptions.setVisibility(View.GONE);
                GalleryActivity.this.toolOptions.setVisibility(View.VISIBLE);
            }
        });
        this.selectShare.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                for (int i = 0; i < GalleryActivity.this.imageAdapter.selectedItems.size(); i++) {
                    GalleryActivity.this.shareImages();
                }
            }
        });
        this.selectSelectAll.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (GalleryActivity.this.imageAdapter.selectAll) {
                    GalleryActivity.this.updateList(false);
                } else {
                    GalleryActivity.this.updateList(true);
                }
            }
        });
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.back_to_home_linear);
        this.backToHome = linearLayout;
        linearLayout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                GalleryActivity.this.onBackPressed();
            }
        });
    }

    private void setImageAdapter(ArrayList<String> arrayList, boolean z) {
        this.imageAdapter = new ImageAdapter(this, arrayList, z);
        new LinearLayoutManager(this).setOrientation(RecyclerView.VERTICAL);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            public int getSpanSize(int i) {
                return 1;
            }
        });
        this.imageRecycler.setLayoutManager(gridLayoutManager);
        this.imageRecycler.setHasFixedSize(true);
        this.imageRecycler.setItemViewCacheSize(20);
        this.imageRecycler.setAdapter(this.imageAdapter);
    }

    public ArrayList<String> getImagesFromDevice() {
        ArrayList<String> arrayList = new ArrayList<>();
        String str = Environment.getExternalStorageDirectory().toString() + "/" + getResources().getString(R.string.app_name) + "/";
        File[] listFiles = new File(str).listFiles();
        Arrays.sort(listFiles, new Comparator() {
            public int compare(Object obj, Object obj2) {
                File file = (File) obj;
                File file2 = (File) obj2;
                if (file.lastModified() > file2.lastModified()) {
                    return -1;
                }
                return file.lastModified() < file2.lastModified() ? 1 : 0;
            }
        });
        if (!isDirectoryNotEmpty(str)) {
            return null;
        }
        for (int i = 0; i < listFiles.length; i++) {
            arrayList.add(listFiles[i].getAbsolutePath());
            Log.e("Files", "FileName:" + listFiles[i].getAbsolutePath());
        }
        return arrayList;
    }

    public void shareImages() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.imageAdapter.selectedItems.size(); i++) {
            arrayList.add(FileProvider.getUriForFile(this, getString(R.string.file_provider_authority), new File(this.imagesList.get(this.imageAdapter.selectedItems.get(i).intValue()))));
        }
        setLocation(arrayList);
    }

    public void setLocation(ArrayList arrayList){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View view = getLayoutInflater().inflate(R.layout.location_model,null);
        builder.setView(view);

        EditText edtLocaion = view.findViewById(R.id.edtLocation);
        Button btnShareLocation = view.findViewById(R.id.btnShareLocation);
        new Boom(btnShareLocation);
        Dialog dialog = builder.create();
        btnShareLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    dialog.dismiss();
                    Intent intent = new Intent("android.intent.action.SEND_MULTIPLE");
                    intent.setFlags(268435456);
                    intent.putExtra("android.intent.extra.TEXT", edtLocaion.getText().toString());
                    intent.setType("image/*");
                    intent.addFlags(1);
                    intent.putParcelableArrayListExtra("android.intent.extra.STREAM", arrayList);
                    startActivity(Intent.createChooser(intent, "send"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        dialog.show();

    }

    public boolean isDirectoryNotEmpty(String str) {
        Log.e("TEST_1", "directoryPath" + str);
        try {
            File file = new File(str);
            if (!file.exists() || !file.isDirectory()) {
                System.out.println("This is not a directory");
                return false;
            } else if (!file.exists() || file.list().length <= 0) {
                System.out.println("Directory is empty!");
                return false;
            } else {
                System.out.println("Directory is not empty!");
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void showDeleteDialog() {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(1);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.activity_custom_dialog);
        ((TextView) dialog.findViewById(R.id.dialog_msg)).setText("تأكيد عملية الحذف");
        ((TextView) dialog.findViewById(R.id.dialog_msg_sub)).setText("هل متأكد تريد خذف هذا الملف ؟");
        ((TextView) dialog.findViewById(R.id.dialog_ok)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                GalleryActivity.this.deleteAllSelectedItems();
                dialog.dismiss();
            }
        });
        TextView textView = (TextView) dialog.findViewById(R.id.dialog_cancel);
        textView.setVisibility(View.VISIBLE);
        textView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    public void deleteAllSelectedItems() {
        File file = new File(Environment.getExternalStorageDirectory().toString() + "/" + getResources().getString(R.string.app_name));
        if (this.imageAdapter.selectedItems.size() != 0) {
            for (int i = 0; i < this.imageAdapter.selectedItems.size(); i++) {
                Log.e("DELETE", "delete images paths : " + this.imagesList.get(this.imageAdapter.selectedItems.get(i).intValue()));
                removeImage(this.imagesList.get(this.imageAdapter.selectedItems.get(i).intValue()));
            }
            updateList(false);
            this.selectionOptions.setVisibility(View.GONE);
            this.toolOptions.setVisibility(View.VISIBLE);
        } else {
            updateList(false);
            this.selectionOptions.setVisibility(View.GONE);
            this.toolOptions.setVisibility(View.VISIBLE);
        }
        refreshGallery(file);
    }

    private void refreshGallery(File file) {
        Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
        intent.setData(Uri.fromFile(file));
        sendBroadcast(intent);
    }

    public void updateList(boolean z) {
        this.imagesList = getImagesFromDevice();
        if (getImagesFromDevice() != null) {
            this.imageRecycler.setVisibility(View.VISIBLE);
            this.noImagesToShow.setVisibility(View.GONE);
            setImageAdapter(this.imagesList, z);
            return;
        }
        this.imageRecycler.setVisibility(View.GONE);
        this.selectionOptions.setVisibility(View.GONE);
        this.toolOptions.setVisibility(View.VISIBLE);
        this.noImagesToShow.setVisibility(View.VISIBLE);
    }

    public void removeImage(String str) {
        File file = new File(str);
        if (!file.exists()) {
            return;
        }
        if (file.delete()) {
            System.out.println("file Deleted :");
        } else {
            System.out.println("file not Deleted :");
        }
    }

    @Override
    public void onBackPressed() {

        super.onBackPressed();
    }

}
