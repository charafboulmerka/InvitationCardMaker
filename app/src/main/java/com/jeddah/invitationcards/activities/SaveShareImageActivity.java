package com.jeddah.invitationcards.activities;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;


import com.astritveliu.boom.Boom;
import com.jeddah.invitationcards.R;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;

public class SaveShareImageActivity extends AppCompatActivity {


     ImageView back;
     Bundle bundle;

     String imagePath;
     ImageView rate;
     ImageView share;
     ImageView shareImageview;


     @Override
    public void onCreate(Bundle bundle2) {
        super.onCreate(bundle2);
        setContentView((int) R.layout.save_share_image_activity);



        Bundle extras = getIntent().getExtras();
        this.bundle = extras;
        if (extras != null) {
            this.imagePath = extras.getString("PATH");
        }
        this.back = (ImageView) findViewById(R.id.share_back);

        this.rate = (ImageView) findViewById(R.id.rate_app);
        this.share = (ImageView) findViewById(R.id.share_app);
        this.back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                SaveShareImageActivity.this.onBackPressed();
            }
        });


        this.rate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                SaveShareImageActivity.this.rate();
            }
        });
        this.share.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                setLocation();
            }
        });
        this.shareImageview = (ImageView) findViewById(R.id.share_imageView);

        this.shareImageview.setImageBitmap(BitmapFactory.decodeFile(compressImage(this.imagePath)));
    }

    public void setLocation(){
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
                    Intent intent = new Intent("android.intent.action.SEND");
                    intent.setType("text/plain");
                    intent.putExtra("android.intent.extra.SUBJECT", getString(R.string.app_name));
                    intent.putExtra("android.intent.extra.TEXT", edtLocaion.getText().toString() );
                    SaveShareImageActivity.this.startActivity(Intent.createChooser(intent, "مشاركة على"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        dialog.show();

    }

    public String compressImage(String str) {
        Bitmap bitmap = null;
        Bitmap bitmap2 = null;
        Bitmap bitmap3 = null;

        String realPathFromURI = getRealPathFromURI(str);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;

        Bitmap decodeFile = BitmapFactory.decodeFile(realPathFromURI, options);
        int originalHeight = options.outHeight;
        int originalWidth = options.outWidth;

        // Check for invalid image dimensions
        if (originalHeight <= 0 || originalWidth <= 0) {
            Log.e("compressImage", "Invalid image dimensions: width=" + originalWidth + ", height=" + originalHeight);
            return str; // Return original path if image is invalid
        }

        // Calculate the aspect ratio
        float aspectRatio = (originalHeight != 0) ? (float) originalWidth / originalHeight : 1.0f;

        float newHeight = (float) originalHeight;
        float newWidth = (float) originalWidth;

        // Resize the image if it exceeds the maximum width or height
        if (newHeight > 1476.0f || newWidth > 1050.0f) {
            if (aspectRatio < 0.7113821f) {
                newWidth = (1476.0f / newHeight) * newWidth;
                newHeight = 1476.0f;
            } else {
                if (aspectRatio > 0.7113821f) {
                    newHeight = (1050.0f / newWidth) * newHeight;
                } else {
                    newHeight = 1476.0f;
                }
                newWidth = 1050.0f;
            }
        }

        // Set sample size for downscaling
        options.inSampleSize = calculateInSampleSize(options, (int) newWidth, (int) newHeight);
        options.inJustDecodeBounds = false;
        options.inPurgeable = true;
        options.inInputShareable = true;
        options.inTempStorage = new byte[16384];

        try {
            decodeFile = BitmapFactory.decodeFile(realPathFromURI, options);
        } catch (OutOfMemoryError e) {
            e.printStackTrace();
        }

        if (decodeFile == null) {
            Log.e("compressImage", "Decoded bitmap is null");
            return str; // Return original path if decoding fails
        }

        try {
            bitmap = Bitmap.createBitmap((int) newWidth, (int) newHeight, Bitmap.Config.ARGB_8888);
        } catch (OutOfMemoryError e) {
            e.printStackTrace();
            bitmap = null;
        }

        if (bitmap != null) {
            float scaleWidth = newWidth / options.outWidth;
            float scaleHeight = newHeight / options.outHeight;
            Matrix matrix = new Matrix();
            matrix.setScale(scaleWidth, scaleHeight);

            Canvas canvas = new Canvas(bitmap);
            canvas.setMatrix(matrix);
            canvas.drawBitmap(decodeFile, 0, 0, new Paint(Paint.FILTER_BITMAP_FLAG));

            // Handle EXIF orientation
            try {
                ExifInterface exifInterface = new ExifInterface(realPathFromURI);
                int orientation = exifInterface.getAttributeInt(ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_NORMAL);
                Matrix rotationMatrix = new Matrix();

                switch (orientation) {
                    case ExifInterface.ORIENTATION_ROTATE_90:
                        rotationMatrix.postRotate(90);
                        break;
                    case ExifInterface.ORIENTATION_ROTATE_180:
                        rotationMatrix.postRotate(180);
                        break;
                    case ExifInterface.ORIENTATION_ROTATE_270:
                        rotationMatrix.postRotate(270);
                        break;
                    default:
                        // No rotation needed
                        break;
                }

                if (rotationMatrix != null) {
                    bitmap2 = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), rotationMatrix, true);
                } else {
                    bitmap2 = bitmap;
                }

            } catch (IOException e) {
                e.printStackTrace();
                bitmap2 = bitmap;
            }

            // Compress and save the final image
            try {
                String compressedImagePath = this.imagePath;
                bitmap2.compress(Bitmap.CompressFormat.JPEG, 80, new FileOutputStream(compressedImagePath));
                return compressedImagePath;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return str; // Return original path if file saving fails
            }
        } else {
            Log.e("compressImage", "Bitmap creation failed");
            return str; // Return original path if bitmap creation failed
        }
    }

    public String compressImageOld(String str) {
        Bitmap bitmap;
        Bitmap bitmap2;
        Bitmap bitmap3;
        String realPathFromURI = getRealPathFromURI(str);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        Bitmap decodeFile = BitmapFactory.decodeFile(realPathFromURI, options);
        int i = options.outHeight;
        int i2 = options.outWidth;
        //float f = (float) (i2 / i);
        float f = i != 0 ? (float) i2 / i : 1.0f; // Valeur par défaut si hauteur invalide

        float f2 = (float) i;
        if (f2 > 1476.0f || ((float) i2) > 1050.0f) {
            if (f < 0.7113821f) {
                i2 = (int) ((1476.0f / f2) * ((float) i2));
                i = (int) 1476.0f;
            } else {
                i = f > 0.7113821f ? (int) ((1050.0f / ((float) i2)) * f2) : (int) 1476.0f;
                i2 = (int) 1050.0f;
            }
        }
        options.inSampleSize = calculateInSampleSize(options, i2, i);
        options.inJustDecodeBounds = false;
        options.inPurgeable = true;
        options.inInputShareable = true;
        options.inTempStorage = new byte[16384];
        try {
            decodeFile = BitmapFactory.decodeFile(realPathFromURI, options);
        } catch (OutOfMemoryError e) {
            e.printStackTrace();
        }
        try {
            bitmap = Bitmap.createBitmap(i2, i, Bitmap.Config.ARGB_8888);
        } catch (OutOfMemoryError e2) {
            e2.printStackTrace();
            bitmap = null;
        }
        Bitmap bitmap4 = bitmap;
        float f3 = (float) i2;
        float f4 = f3 / ((float) options.outWidth);
        float f5 = (float) i;
        float f6 = f5 / ((float) options.outHeight);
        float f7 = f3 / 2.0f;
        float f8 = f5 / 2.0f;
        Matrix matrix = new Matrix();
        matrix.setScale(f4, f6, f7, f8);
        Canvas canvas = new Canvas(bitmap4);
        canvas.setMatrix(matrix);
        canvas.drawBitmap(decodeFile, f7 - ((float) (decodeFile.getWidth() / 2)), f8 - ((float) (decodeFile.getHeight() / 2)), new Paint(2));
        try {
            int attributeInt = new ExifInterface(realPathFromURI).getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 0);
            Log.d("EXIF", "Exif: " + attributeInt);
            Matrix matrix2 = new Matrix();
            if (attributeInt == 6) {
                matrix2.postRotate(90.0f);
                Log.d("EXIF", "Exif: " + attributeInt);
            } else if (attributeInt == 3) {
                matrix2.postRotate(180.0f);
                Log.d("EXIF", "Exif: " + attributeInt);
            } else if (attributeInt == 8) {
                matrix2.postRotate(270.0f);
                Log.d("EXIF", "Exif: " + attributeInt);
            }
            bitmap3 = bitmap4;
            try {
                bitmap2 = Bitmap.createBitmap(bitmap4, 0, 0, bitmap4.getWidth(), bitmap4.getHeight(), matrix2, true);
            } catch (Exception e33) {

                e33.printStackTrace();
                bitmap2 = bitmap3;
                String str2 = this.imagePath;
                bitmap2.compress(Bitmap.CompressFormat.JPEG, 80, new FileOutputStream(str2));
                return str2;
            }
        } catch (IOException e4) {

            bitmap3 = bitmap4;
            e4.printStackTrace();
            bitmap2 = bitmap3;
            String str22 = this.imagePath;
            try {
                bitmap2.compress(Bitmap.CompressFormat.JPEG, 80, new FileOutputStream(str22));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            return str22;
        }
        String str222 = this.imagePath;
        try {
            bitmap2.compress(Bitmap.CompressFormat.JPEG, 80, new FileOutputStream(str222));
        } catch (FileNotFoundException e5) {
            e5.printStackTrace();
        }
        return str222;
    }

    @SuppressLint("Range")
    private String getRealPathFromURI(String str) {
        Uri parse = Uri.parse(str);
        Cursor query = getContentResolver().query(parse, (String[]) null, (String) null, (String[]) null, (String) null);
        if (query == null) {
            return parse.getPath();
        }
        query.moveToFirst();
        return query.getString(query.getColumnIndex("_data"));
    }

    public int calculateInSampleSize(BitmapFactory.Options options, int i, int i2) {
        int i3;
        int i4 = options.outHeight;
        int i5 = options.outWidth;
        if (i4 > i2 || i5 > i) {
            i3 = Math.round(((float) i4) / ((float) i2));
            int round = Math.round(((float) i5) / ((float) i));
            if (i3 >= round) {
                i3 = round;
            }
        } else {
            i3 = 1;
        }
        while (((float) (i5 * i4)) / ((float) (i3 * i3)) > ((float) (i * i2 * 2))) {
            i3++;
        }
        return i3;
    }


    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }


    public void rate() {
        startActivity(new Intent("android.intent.action.VIEW"));
    }

    public void myClickHandler(View view) {
        int id = view.getId();
        if (id == R.id.instagramShare) {
        setLocationShare("instagram");
        }
        if (id == R.id.share_imageView) {
            Toast.makeText(this, getString(R.string.saved_image_message), Toast.LENGTH_SHORT).show();
        }
        if (id == R.id.whatsup_share) {
            setLocationShare("whatsapp");
        }
        if (id == R.id.facebook_share) {
            setLocationShare("facebook");
        }
        if (id == R.id.more) {
            setLocationShare("more");
        }
    }

    public void setLocationShare(String mType){
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
               if (Objects.equals(mType, "instagram")){
                   goInstagram(edtLocaion.getText().toString());
               }else if (Objects.equals(mType, "whatsapp")){
                   goWhatsapp(edtLocaion.getText().toString());
               }else if (Objects.equals(mType, "more")){
                   goMore(edtLocaion.getText().toString());
               }else if (Objects.equals(mType, "facebook")){
                   initShareIntent(edtLocaion.getText().toString());
               }
            }
        });
        dialog.show();

    }

    private void goWhatsapp(String location){
        try {
            Uri uriForFile2 = FileProvider.getUriForFile(this, getString(R.string.file_provider_authority), new File(this.imagePath));
            Intent intent2 = new Intent();
            intent2.putExtra("android.intent.extra.SUBJECT", getString(R.string.app_name));
            intent2.putExtra("android.intent.extra.TEXT",location);
            intent2.setType("image/*");
            intent2.setAction("android.intent.action.SEND");
            intent2.putExtra("android.intent.extra.STREAM", uriForFile2);
            intent2.setPackage("com.whatsapp");
            startActivity(intent2);
        } catch (Exception unused2) {
            Toast.makeText(this, getString(R.string.no_whatsapp_app), Toast.LENGTH_SHORT).show();
        }
    }

    private void goInstagram(String location){
        try {
            Uri uriForFile = FileProvider.getUriForFile(this, getString(R.string.file_provider_authority), new File(this.imagePath));
            Intent intent = new Intent();
            intent.putExtra("android.intent.extra.SUBJECT", getString(R.string.app_name));
            intent.putExtra("android.intent.extra.TEXT",location);
            intent.setType("image/*");
            intent.setAction("android.intent.action.SEND");
            intent.putExtra("android.intent.extra.STREAM", uriForFile);
            intent.setPackage("com.instagram.android");
            startActivity(intent);
        } catch (Exception unused) {
            Toast.makeText(this, getString(R.string.no_instagram_app), Toast.LENGTH_SHORT).show();
        }
    }

    private void goMore(String location){
        Uri uriForFile3 = FileProvider.getUriForFile(this, getString(R.string.file_provider_authority), new File(this.imagePath));
        Intent intent3 = new Intent("android.intent.action.SEND");
        intent3.putExtra("android.intent.extra.SUBJECT", getString(R.string.app_name));
        intent3.putExtra("android.intent.extra.TEXT",location);
        intent3.setType("image/*");
        intent3.putExtra("android.intent.extra.STREAM", uriForFile3);
        startActivity(intent3);
    }

    private void initShareIntent(String location) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.TITLE", getString(R.string.app_name));
        intent.putExtra("android.intent.extra.TEXT", location);
        intent.setType("image/jpeg");
        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());
        if (Build.VERSION.SDK_INT >= 18) {
            try {
                builder.detectFileUriExposure();
            } catch (Exception e2) {
                e2.printStackTrace();
            } catch (OutOfMemoryError e3) {
                e3.printStackTrace();
            } catch (StackOverflowError e4) {
                e4.printStackTrace();
            }
        }
        Uri uriForFile = FileProvider.getUriForFile(this, getString(R.string.file_provider_authority), new File(this.imagePath));
        intent.putExtra("android.intent.extra.STREAM", uriForFile);
        for (ResolveInfo resolveInfo : getApplicationContext().getPackageManager().queryIntentActivities(intent, 0)) {


            if (resolveInfo.activityInfo.name.contains("facebook")) {
                try {
                    ActivityInfo activityInfo = resolveInfo.activityInfo;
                    ComponentName componentName = new ComponentName(activityInfo.applicationInfo.packageName, activityInfo.name);
                    intent.addCategory("android.intent.category.LAUNCHER");
                    intent.setFlags(270532608);
                    intent.setComponent(componentName);
                    startActivity(intent);
                } catch (Exception e5) {
                    e5.printStackTrace();
                } catch (OutOfMemoryError e6) {
                    e6.printStackTrace();
                } catch (StackOverflowError e7) {
                    e7.printStackTrace();
                }
            } else {
                try {     } catch (Exception e8) {
                    e8.printStackTrace();
                } catch (OutOfMemoryError e9) {
                    e9.printStackTrace();
                } catch (StackOverflowError e10) {
                    e10.printStackTrace();
                }
            }
        }
    }
}
