package com.jeddah.invitationcards.adapters;

import android.content.Context;
import android.graphics.Shader;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.jeddah.invitationcards.PicEditor;
import com.jeddah.invitationcards.R;
import com.jeddah.invitationcards.activities.GreetingCardEditActivity;

import java.util.ArrayList;

public class ThemeColorsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int STRING = 3;
    
    public Context mContext;
    ArrayList<Integer> mRecyclerViewItems;
    String type = "";

    @Override
    public int getItemViewType(int i) {
        return 3;
    }

    public ThemeColorsAdapter(Context context, ArrayList<Integer> arrayList, String str) {
        this.type = str;
        this.mContext = context;
        this.mRecyclerViewItems = new ArrayList<>();
        this.mRecyclerViewItems = arrayList;
    }

    public int getItemCount() {
        return this.mRecyclerViewItems.size();
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view;
        if (this.type.equals("font_size")) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.single_text_size_item, viewGroup, false);
        } else {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.single_theme_item, viewGroup, false);
        }
        return new ViewHolder(view);
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, final int i) {
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        Animation loadAnimation = AnimationUtils.loadAnimation(this.mContext, R.anim.scale_up);
        if (this.type.equals("font_size")) {
            TextView access$000 = viewHolder2.textSizeOrColor;
            access$000.setText("" + this.mRecyclerViewItems.get(i));
        } else {
            viewHolder2.textSizeOrColor.setBackgroundColor(this.mRecyclerViewItems.get(i).intValue());
        }
        viewHolder2.textSizeOrColor.startAnimation(loadAnimation);
        viewHolder2.textSizeOrColor.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (isPicEditorAct()){
                    if (ThemeColorsAdapter.this.type.equals("font_size")) {
                        if (PicEditor.activity.getLastTouchedEditTextView() != null) {
                            PicEditor.activity.getLastTouchedEditTextView().setTextSize((float) ThemeColorsAdapter.this.mRecyclerViewItems.get(i).intValue());
                            TextView textView = PicEditor.activity.fontSizeSelection;
                            textView.setText("" + ThemeColorsAdapter.this.mRecyclerViewItems.get(i));
                            return;
                        }
                        Toast.makeText(ThemeColorsAdapter.this.mContext, "Please select text.", Toast.LENGTH_SHORT).show();
                    } else if (ThemeColorsAdapter.this.type.equals("font_shadow_colors")) {
                        if (PicEditor.activity.getLastTouchedEditTextView() != null) {
                            if (PicEditor.activity.isShaderApplied) {
                                PicEditor.activity.getLastTouchedEditTextView().getPaint().setShader((Shader) null);
                                PicEditor.activity.isShaderApplied = false;
                            }
                            PicEditor.activity.getLastTouchedEditTextView().setShadowLayer(1.0f, (float) GreetingCardEditActivity.activity.shadowRadius.getProgress(), (float) GreetingCardEditActivity.activity.shadowRadius.getProgress(), ThemeColorsAdapter.this.mRecyclerViewItems.get(i).intValue());
                            PicEditor.activity.displaySelectedFontShadowColor.setBackgroundColor(ThemeColorsAdapter.this.mRecyclerViewItems.get(i).intValue());
                            return;
                        }
                        Toast.makeText(ThemeColorsAdapter.this.mContext, "Please select text.", Toast.LENGTH_SHORT).show();
                    } else if (PicEditor.activity.getLastTouchedEditTextView() != null) {
                        if (PicEditor.activity.isShaderApplied) {
                            PicEditor.activity.getLastTouchedEditTextView().getPaint().setShader((Shader) null);
                            PicEditor.activity.isShaderApplied = false;
                        }
                        PicEditor.activity.getLastTouchedEditTextView().setTextColor(ThemeColorsAdapter.this.mRecyclerViewItems.get(i).intValue());
                        PicEditor.activity.displaySelectedFontColor.setBackgroundColor(ThemeColorsAdapter.this.mRecyclerViewItems.get(i).intValue());
                    } else {
                        Toast.makeText(ThemeColorsAdapter.this.mContext, "Please select text.", Toast.LENGTH_SHORT).show();
                    }
                }else { //Not PicEditor
                    if (ThemeColorsAdapter.this.type.equals("font_size")) {
                        if (GreetingCardEditActivity.activity.getLastTouchedEditTextView() != null) {
                            GreetingCardEditActivity.activity.getLastTouchedEditTextView().setTextSize((float) ThemeColorsAdapter.this.mRecyclerViewItems.get(i).intValue());
                            TextView textView = GreetingCardEditActivity.activity.fontSizeSelection;
                            textView.setText("" + ThemeColorsAdapter.this.mRecyclerViewItems.get(i));
                            return;
                        }
                        Toast.makeText(ThemeColorsAdapter.this.mContext, "Please select text.", Toast.LENGTH_SHORT).show();
                    } else if (ThemeColorsAdapter.this.type.equals("font_shadow_colors")) {
                        if (GreetingCardEditActivity.activity.getLastTouchedEditTextView() != null) {
                            if (GreetingCardEditActivity.activity.isShaderApplied) {
                                GreetingCardEditActivity.activity.getLastTouchedEditTextView().getPaint().setShader((Shader) null);
                                GreetingCardEditActivity.activity.isShaderApplied = false;
                            }
                            GreetingCardEditActivity.activity.getLastTouchedEditTextView().setShadowLayer(1.0f, (float) GreetingCardEditActivity.activity.shadowRadius.getProgress(), (float) GreetingCardEditActivity.activity.shadowRadius.getProgress(), ThemeColorsAdapter.this.mRecyclerViewItems.get(i).intValue());
                            GreetingCardEditActivity.activity.displaySelectedFontShadowColor.setBackgroundColor(ThemeColorsAdapter.this.mRecyclerViewItems.get(i).intValue());
                            return;
                        }
                        Toast.makeText(ThemeColorsAdapter.this.mContext, "Please select text.", Toast.LENGTH_SHORT).show();
                    } else if (GreetingCardEditActivity.activity.getLastTouchedEditTextView() != null) {
                        if (GreetingCardEditActivity.activity.isShaderApplied) {
                            GreetingCardEditActivity.activity.getLastTouchedEditTextView().getPaint().setShader((Shader) null);
                            GreetingCardEditActivity.activity.isShaderApplied = false;
                        }
                        GreetingCardEditActivity.activity.getLastTouchedEditTextView().setTextColor(ThemeColorsAdapter.this.mRecyclerViewItems.get(i).intValue());
                        GreetingCardEditActivity.activity.displaySelectedFontColor.setBackgroundColor(ThemeColorsAdapter.this.mRecyclerViewItems.get(i).intValue());
                    } else {
                        Toast.makeText(ThemeColorsAdapter.this.mContext, "Please select text.", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    public Boolean isPicEditorAct(){
        if (mContext.getClass().getName().contains("PicEditor")){
            return true;
        }else {
            return false;
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        
        public TextView textSizeOrColor;

        ViewHolder(View view) {
            super(view);
            if (ThemeColorsAdapter.this.type.equals("font_size")) {
                this.textSizeOrColor = (TextView) view.findViewById(R.id.text_size_item);
            } else {
                this.textSizeOrColor = (TextView) view.findViewById(R.id.theme_color_item);
            }
        }
    }
}
