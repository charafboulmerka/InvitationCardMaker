package com.jeddah.invitationcards.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import com.jeddah.invitationcards.R;
import com.jeddah.invitationcards.activities.GreetingCardEditActivity;

import java.util.ArrayList;

public class GreetingCardsPreviewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int STRING = 3;
    
    public Context mContext;
    ArrayList<Integer> mRecyclerViewItems;
    String type = "";

    @Override
    public int getItemViewType(int i) {
        return 3;
    }

    public GreetingCardsPreviewAdapter(Context context, ArrayList<Integer> arrayList, String str) {
        this.type = str;
        this.mContext = context;
        this.mRecyclerViewItems = new ArrayList<>();
        this.mRecyclerViewItems = arrayList;
    }

    public int getItemCount() {
        return this.mRecyclerViewItems.size();
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.single_greeting_preview_item, viewGroup, false));
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, final int i) {
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        Animation loadAnimation = AnimationUtils.loadAnimation(this.mContext, R.anim.scale_up);
        viewHolder2.greetingPreviewItem.setImageResource(this.mRecyclerViewItems.get(i).intValue());
        viewHolder2.greetingPreviewItem.startAnimation(loadAnimation);
        viewHolder2.greetingPreviewItem.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(GreetingCardsPreviewAdapter.this.mContext, GreetingCardEditActivity.class);
                intent.putExtra("position", i);
                intent.putExtra("type", GreetingCardsPreviewAdapter.this.type);
                GreetingCardsPreviewAdapter.this.mContext.startActivity(intent);
            }
        });
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        
        public ImageView greetingPreviewItem;

        ViewHolder(View view) {
            super(view);
            this.greetingPreviewItem = (ImageView) view.findViewById(R.id.single_greeting_card_img_item);
        }
    }
}
