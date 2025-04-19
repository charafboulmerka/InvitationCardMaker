package com.jeddah.invitationcards.fragments;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.jeddah.invitationcards.R;
import com.jeddah.invitationcards.activities.GreetingCardEditActivity;
import com.jeddah.invitationcards.adapters.StickerPreViewAdapter;
import com.jeddah.invitationcards.views.StickerView;

import java.util.ArrayList;
import java.util.Objects;

public class AddStickerFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    public static AddStickerFragment addStickerFragment;
    public int INT_RESOURCE_ID_TO_COPY;
    private Bitmap bitmap;
    private ImageView imageView;
    public RelativeLayout mContentRootView;
    public StickerView mCurrentView;
    private String mParam1;
    private String mParam2;
    private ArrayList<Integer> mResources;
    public ArrayList<View> mViews;
    private View rootView;
    private CardView saveSticker;
    private StickerPreViewAdapter stickerPreviewAdapter;
    private RecyclerView stickerRecyclerView;
    private String type;

    public static AddStickerFragment newInstance(String str, String str2) {
        AddStickerFragment addStickerFragment2 = new AddStickerFragment();
        Bundle bundle = new Bundle();
        bundle.putString(ARG_PARAM1, str);
        bundle.putString(ARG_PARAM2, str2);
        addStickerFragment2.setArguments(bundle);
        return addStickerFragment2;
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
        View inflate = layoutInflater.inflate(R.layout.fragment_add_stricker, viewGroup, false);
        this.rootView = inflate;
        this.stickerRecyclerView = (RecyclerView) inflate.findViewById(R.id.stickers_preview_recycler);
        this.saveSticker = (CardView) this.rootView.findViewById(R.id.sticker_done);
        this.mContentRootView = (RelativeLayout) this.rootView.findViewById(R.id.sticker_content);
        this.imageView = (ImageView) this.rootView.findViewById(R.id.sticker_back);
        return this.rootView;
    }

    @Override
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        addStickerFragment = this;
        this.mViews = new ArrayList<>();
        this.imageView.setImageDrawable(GreetingCardEditActivity.activity.getBitmapSelectedCard());
        this.mContentRootView.setDrawingCacheEnabled(true);
        this.mContentRootView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        RelativeLayout relativeLayout = this.mContentRootView;
        relativeLayout.layout(0, 0, relativeLayout.getMeasuredWidth(), this.mContentRootView.getMeasuredHeight());
        this.mContentRootView.buildDrawingCache(true);
        setStickersRecyclerView();
        this.mContentRootView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (AddStickerFragment.this.mCurrentView != null) {
                    AddStickerFragment.this.mCurrentView.setInEdit(false);
                }
            }
        });
        this.saveSticker.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AddStickerFragment.this.saveSticker();
                GreetingCardEditActivity.activity.removeAddStickerFragment(true);
            }
        });
    }

    public void setStickersRecyclerView() {
        this.type = "stickers";
        this.mResources = new ArrayList<>();
        for (int i = 1; i <= 38; i++) {
            ArrayList<Integer> arrayList = this.mResources;
            Resources resources = getResources();
            arrayList.add(Integer.valueOf(resources.getIdentifier("sticker_" + i, "drawable", ((FragmentActivity) Objects.requireNonNull(getActivity())).getPackageName())));
        }
        this.stickerRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), 0, false));
        StickerPreViewAdapter stickerPreViewAdapter = new StickerPreViewAdapter(getActivity(), this.mResources, this.type);
        this.stickerPreviewAdapter = stickerPreViewAdapter;
        this.stickerRecyclerView.setAdapter(stickerPreViewAdapter);
    }

    public void addStickerView(String str) {
        final StickerView stickerView = new StickerView(getActivity());
        stickerView.setBitmap(BitmapFactory.decodeFile(str), "path");
        stickerView.setOperationListener(new StickerView.OperationListener() {
            public void onDeleteClick() {
                AddStickerFragment.this.mViews.remove(stickerView);
                AddStickerFragment.this.mContentRootView.removeView(stickerView);
            }

            public void onEdit(StickerView stickerView) {
                AddStickerFragment.this.mCurrentView.setInEdit(false);
                AddStickerFragment.this.mCurrentView = stickerView;
                AddStickerFragment.this.mCurrentView.setInEdit(true);
            }

            @Override
            public void onTop(StickerView stickerView) {
                Log.e(":fdf","");

            }
        });
        this.mContentRootView.addView(stickerView, new RelativeLayout.LayoutParams(-1, -1));
        this.mViews.add(stickerView);
        setCurrentEdit(stickerView);
    }

    public void addStickerView(int i) {
        final StickerView stickerView = new StickerView(getActivity());
        stickerView.setBitmap(BitmapFactory.decodeResource(getResources(), i), "int");
        stickerView.setOperationListener(new StickerView.OperationListener() {
            public void onDeleteClick() {
                AddStickerFragment.this.mViews.remove(stickerView);
                AddStickerFragment.this.mContentRootView.removeView(stickerView);
            }

            public void onEdit(StickerView stickerView) {
                AddStickerFragment.this.mCurrentView.setInEdit(false);
                AddStickerFragment.this.mCurrentView = stickerView;
                AddStickerFragment.this.mCurrentView.setInEdit(true);
            }

            @Override
            public void onTop(StickerView stickerView) {
                Log.e(":fdf","");

            }
        });

        this.mContentRootView.addView(stickerView, new RelativeLayout.LayoutParams(-1, -1));
        this.mViews.add(stickerView);
        setCurrentEdit(stickerView);
    }

    public void setCurrentEdit(StickerView stickerView) {
        StickerView stickerView2 = this.mCurrentView;
        if (stickerView2 != null) {
            stickerView2.setInEdit(false);
        }
        this.mCurrentView = stickerView;
        stickerView.setInEdit(true);
    }

    
    public void saveSticker() {
        StickerView stickerView = this.mCurrentView;
        if (stickerView != null) {
            stickerView.setInEdit(false);
        }
        this.bitmap = Bitmap.createBitmap(this.mContentRootView.getDrawingCache());
        GreetingCardEditActivity activity = GreetingCardEditActivity.activity;
        GreetingCardEditActivity greetingCardEditActivity2 = GreetingCardEditActivity.activity;
        Bitmap bitmap2 = this.bitmap;
        activity.updateSelectedCard(greetingCardEditActivity2.getResizedBitmap(bitmap2, bitmap2.getWidth(), this.bitmap.getHeight() + 50));
        for (int i = 0; i < this.mViews.size(); i++) {
            this.mContentRootView.removeView(this.mViews.get(i));
        }
        this.mViews = new ArrayList<>();
        this.mContentRootView.removeView(this.mCurrentView);
    }
}
