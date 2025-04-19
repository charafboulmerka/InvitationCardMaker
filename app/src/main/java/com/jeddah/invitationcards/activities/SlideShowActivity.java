package com.jeddah.invitationcards.activities;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ViewFlipper;

import androidx.core.content.FileProvider;

import com.bumptech.glide.Glide;
import com.jeddah.invitationcards.R;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

public class SlideShowActivity extends Activity {
    ImageView deleteImage;
    String deletePath;
    TextView imgName;
    ArrayList<String> imgPaths = new ArrayList<>();
    int index;
    private float initialXPoint;
    String matchPath = null;
    
    public ViewFlipper myViewFlipper;
    LinearLayout selectBackToGallery;
    ImageView selectShare;
    ImageView back_to_img;

    
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_slide_show);
        this.matchPath = getIntent().getStringExtra("matchPath");
        this.myViewFlipper = (ViewFlipper) findViewById(R.id.myflipper);

        back_to_img = findViewById(R.id.back_to_img);
        back_to_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        if (GalleryActivity.galleryActivity != null) {
            this.imgPaths = GalleryActivity.galleryActivity.getImagesFromDevice();
        }
        Iterator<String> it = this.imgPaths.iterator();
        while (true) {
            if (it.hasNext()) {
                if (it.next().equals(this.matchPath)) {
                    this.index = this.imgPaths.indexOf(this.matchPath);
                    break;
                }
            } else {
                break;
            }
        }
        for (int i = 0; i < this.imgPaths.size(); i++) {
            updateImage(this.imgPaths.get(i), -1);
        }
        this.deletePath = this.imgPaths.get(this.myViewFlipper.getDisplayedChild());
        TextView textView = (TextView) findViewById(R.id.img_name);
        this.imgName = textView;
        textView.setText(this.imgPaths.get(this.myViewFlipper.getDisplayedChild()).substring(this.imgPaths.get(this.myViewFlipper.getDisplayedChild()).lastIndexOf("/") + 1));
        this.deleteImage = (ImageView) findViewById(R.id.delete_image);
        this.selectShare = (ImageView) findViewById(R.id.select_share);
        this.selectBackToGallery = (LinearLayout) findViewById(R.id.select_back);
        this.deleteImage.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (SlideShowActivity.this.deletePath != null) {
                    SlideShowActivity.this.showDeleteDialog();
                }
            }
        });
        this.selectBackToGallery.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                GalleryActivity.galleryActivity.updateList(false);
                SlideShowActivity.this.onBackPressed();
            }
        });
        this.selectShare.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                SlideShowActivity.this.shareImage();
            }
        });
    }

    private void updateImage(String str, int i) {
        if (i == -1) {
            ImageView imageView = new ImageView(getApplicationContext());
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            Glide.with((Activity) this).load(str).into(imageView);
            this.myViewFlipper.addView(imageView);
            this.myViewFlipper.setDisplayedChild(this.index);
            return;
        }
        ImageView imageView2 = new ImageView(getApplicationContext());
        imageView2.setScaleType(ImageView.ScaleType.FIT_CENTER);
        Glide.with((Activity) this).load(str).into(imageView2);
        this.myViewFlipper.addView(imageView2);
        this.myViewFlipper.setDisplayedChild(i);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        GalleryActivity.galleryActivity.updateList(false);
    }

    public void shareImage() {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(this.imgPaths.get(this.myViewFlipper.getDisplayedChild()));
        for (int i = 0; i < arrayList2.size(); i++) {
            arrayList.add(FileProvider.getUriForFile(this, getString(R.string.file_provider_authority), new File((String) arrayList2.get(i))));
        }
        Intent intent = new Intent("android.intent.action.SEND_MULTIPLE");
        intent.setFlags(268435456);
        intent.putExtra("android.intent.extra.TEXT", getString(R.string.app_name) + " : https://play.google.com/store/apps/details?id=" + getApplicationContext().getPackageName());
        intent.setType("image/*");
        intent.addFlags(1);
        intent.putParcelableArrayListExtra("android.intent.extra.STREAM", arrayList);
        startActivity(Intent.createChooser(intent, "send"));
    }

    public void showDeleteDialog() {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(1);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.activity_custom_dialog);
        ((TextView) dialog.findViewById(R.id.dialog_msg)).setText("Conform Delete.");
        ((TextView) dialog.findViewById(R.id.dialog_msg_sub)).setText("Are you sure want to delete selected items permanently.");
        ((TextView) dialog.findViewById(R.id.dialog_ok)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                SlideShowActivity slideShowActivity = SlideShowActivity.this;
                slideShowActivity.removeImage(slideShowActivity.imgPaths.get(SlideShowActivity.this.myViewFlipper.getDisplayedChild()));
                if (SlideShowActivity.this.imgPaths == null || SlideShowActivity.this.imgPaths.size() <= 0) {
                    GalleryActivity.galleryActivity.updateList(false);
                    SlideShowActivity.this.onBackPressed();
                } else {
                    SlideShowActivity.this.myViewFlipper.removeViewAt(SlideShowActivity.this.myViewFlipper.getDisplayedChild());
                }
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

    public void removeImage(String str) {
        File file = new File(str);
        if (!file.exists()) {
            return;
        }
        if (file.delete()) {
            this.imgPaths = GalleryActivity.galleryActivity.getImagesFromDevice();
            System.out.println("file Deleted :");
            return;
        }
        System.out.println("file not Deleted :");
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.initialXPoint = motionEvent.getX();
            return false;
        } else if (action != 1) {
            return false;
        } else {
            if (this.initialXPoint > motionEvent.getX()) {
                if (this.myViewFlipper.getDisplayedChild() == this.imgPaths.size() - 1) {
                    return false;
                }
                this.myViewFlipper.setInAnimation(this, R.anim.in_from_right);
                this.myViewFlipper.setOutAnimation(this, R.anim.out_from_left);
                this.myViewFlipper.showNext();
                this.imgName.setText(this.imgPaths.get(this.myViewFlipper.getDisplayedChild()).substring(this.imgPaths.get(this.myViewFlipper.getDisplayedChild()).lastIndexOf("/") + 1));
                this.deletePath = this.imgPaths.get(this.myViewFlipper.getDisplayedChild());
                return false;
            } else if (this.myViewFlipper.getDisplayedChild() == 0) {
                return false;
            } else {
                this.myViewFlipper.setInAnimation(this, R.anim.in_from_left);
                this.myViewFlipper.setOutAnimation(this, R.anim.out_from_right);
                this.myViewFlipper.showPrevious();
                this.imgName.setText(this.imgPaths.get(this.myViewFlipper.getDisplayedChild()).substring(this.imgPaths.get(this.myViewFlipper.getDisplayedChild()).lastIndexOf("/") + 1));
                this.deletePath = this.imgPaths.get(this.myViewFlipper.getDisplayedChild());
                return false;
            }
        }
    }
}
