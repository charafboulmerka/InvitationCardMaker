package com.jeddah.invitationcards.adapters;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.jeddah.invitationcards.R;
import com.jeddah.invitationcards.activities.GalleryActivity;
import com.jeddah.invitationcards.activities.SlideShowActivity;

import java.util.ArrayList;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ViewHolder> {
    public Context CONTEXT;
    public boolean isLongSelection = false;
    public ArrayList<String> mData;
    private LayoutInflater mInflater;
    public boolean selectAll;
    public ArrayList<Integer> selectedItems = new ArrayList<>();

    public long getItemId(int i) {
        return (long) i;
    }

    public int getItemViewType(int i) {
        return i;
    }

    public ImageAdapter(Context context, ArrayList<String> arrayList, boolean z) {
        this.CONTEXT = context;
        this.mInflater = LayoutInflater.from(context);
        this.mData = arrayList;
        this.selectAll = z;
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(this.mInflater.inflate(R.layout.image_item, viewGroup, false));
    }

    public void onBindViewHolder(final ViewHolder viewHolder, final int i) {
        Glide.with(this.CONTEXT).load(this.mData.get(i)).into(viewHolder.image);
        Log.e("INDEX", "select all : " + this.selectAll);
        if (this.selectAll) {
            this.selectedItems.clear();
            for (int i2 = 0; i2 < this.mData.size(); i2++) {
                ArrayList<Integer> arrayList = this.selectedItems;
                ArrayList<String> arrayList2 = this.mData;
                arrayList.add(Integer.valueOf(arrayList2.indexOf(arrayList2.get(i2))));
                Log.e("INDEX", "selected items all : " + this.selectedItems.toString());
            }
            TextView textView = GalleryActivity.galleryActivity.selectCount;
            textView.setText("selected : " + getItemCount());
            setImageFilter(viewHolder);
        } else if (this.selectedItems.size() == 0) {
            removeImageFilter(viewHolder);
            GalleryActivity.galleryActivity.selectCount.setText("selected : ");
            GalleryActivity.galleryActivity.toolOptions.setVisibility(View.VISIBLE);
            GalleryActivity.galleryActivity.selectionOptions.setVisibility(View.GONE);
        } else {
            GalleryActivity.galleryActivity.toolOptions.setVisibility(View.GONE);
            GalleryActivity.galleryActivity.selectionOptions.setVisibility(View.VISIBLE);
        }
        viewHolder.image.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (!ImageAdapter.this.isLongSelection) {
                    Intent intent = new Intent(ImageAdapter.this.CONTEXT, SlideShowActivity.class);
                    intent.putExtra("paths", ImageAdapter.this.mData);
                    intent.putExtra("matchPath", ImageAdapter.this.mData.get(i));
                    ImageAdapter.this.CONTEXT.startActivity(intent);
                } else if (ImageAdapter.this.selectedItems.contains(Integer.valueOf(i))) {
                    ImageAdapter.this.selectedItems.remove(ImageAdapter.this.selectedItems.indexOf(Integer.valueOf(i)));
                    TextView textView = GalleryActivity.galleryActivity.selectCount;
                    textView.setText("selected : " + ImageAdapter.this.selectedItems.size());
                    ImageAdapter.this.removeImageFilter(viewHolder);
                } else {
                    ImageAdapter.this.selectedItems.add(Integer.valueOf(i));
                    TextView textView2 = GalleryActivity.galleryActivity.selectCount;
                    textView2.setText("selected : " + ImageAdapter.this.selectedItems.size());
                    ImageAdapter.this.setImageFilter(viewHolder);
                }
            }
        });
        viewHolder.image.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view) {
                ImageAdapter.this.isLongSelection = true;
                GalleryActivity.galleryActivity.selectCount.setText("selected : 1");
                GalleryActivity.galleryActivity.selectionOptions.setVisibility(View.VISIBLE);
                GalleryActivity.galleryActivity.toolOptions.setVisibility(View.GONE);
                ImageAdapter.this.selectedItems.add(Integer.valueOf(i));
                ImageAdapter.this.setImageFilter(viewHolder);
                return true;
            }
        });
    }

    
    public void setImageFilter(ViewHolder viewHolder) {
        viewHolder.image.setColorFilter(this.CONTEXT.getResources().getColor(R.color.transparent_blue));
    }

    
    public void removeImageFilter(ViewHolder viewHolder) {
        viewHolder.image.setColorFilter(this.CONTEXT.getResources().getColor(R.color.transparent));
    }

    public int getItemCount() {
        return this.mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image;

        ViewHolder(View view) {
            super(view);
            this.image = (ImageView) view.findViewById(R.id.img);
        }
    }
}
