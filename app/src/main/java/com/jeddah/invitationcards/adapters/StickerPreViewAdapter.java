package com.jeddah.invitationcards.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import com.jeddah.invitationcards.PicEditor;
import com.jeddah.invitationcards.R;
import com.jeddah.invitationcards.activities.GreetingCardEditActivity;

import java.util.ArrayList;

public class StickerPreViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int STRING = 3;
    private Context mContext;
    ArrayList<Integer> mRecyclerViewItems;
    String typeOfD = "";

    @Override
    public int getItemViewType(int i) {
        return 3;
    }

    public StickerPreViewAdapter(Context context, ArrayList<Integer> arrayList, String str) {
        this.typeOfD = str;
        this.mContext = context;
        this.mRecyclerViewItems = new ArrayList<>();
        this.mRecyclerViewItems = arrayList;
    }

    public int getItemCount() {
        return this.mRecyclerViewItems.size();
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.sticker_item, viewGroup, false));
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, final int i) {
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        Animation loadAnimation = AnimationUtils.loadAnimation(this.mContext, R.anim.scale_up);
        viewHolder2.stickerImg.setImageResource(this.mRecyclerViewItems.get(i).intValue());
        viewHolder2.stickerImg.startAnimation(loadAnimation);
        viewHolder2.stickerImg.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (!mContext.getClass().getName().contains("PicEditor")){
                    GreetingCardEditActivity.activity.INT_RESOURCE_ID_TO_COPY = StickerPreViewAdapter.this.mRecyclerViewItems.get(i).intValue();
                    GreetingCardEditActivity.activity.addStickerView(StickerPreViewAdapter.this.mRecyclerViewItems.get(i).intValue());
                }else{
                    PicEditor.activity.INT_RESOURCE_ID_TO_COPY = StickerPreViewAdapter.this.mRecyclerViewItems.get(i).intValue();
                    PicEditor.activity.addStickerView(StickerPreViewAdapter.this.mRecyclerViewItems.get(i).intValue());
                }

            }
        });
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        
        public ImageView stickerImg;

        ViewHolder(View view) {
            super(view);
            this.stickerImg = (ImageView) view.findViewById(R.id.sticker_img);
        }
    }
}
