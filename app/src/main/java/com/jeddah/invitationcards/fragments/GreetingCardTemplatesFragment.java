package com.jeddah.invitationcards.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.jeddah.invitationcards.R;
import com.jeddah.invitationcards.activities.MainActivity;
import com.jeddah.invitationcards.adapters.GreetingCardsTemplateAdapter;

import java.util.ArrayList;

public class GreetingCardTemplatesFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private ImageView backToActivity;
    private TextView cardTitle;
    private GreetingCardsTemplateAdapter greetingCardsTemplateAdapter;
     String mParam1;
     String mParam2;
     ArrayList<Integer> mResources;
     View rootView;
     String type;
     RecyclerView valentineCardsTemplates;

    public static GreetingCardTemplatesFragment newInstance(String str, String str2) {
        GreetingCardTemplatesFragment greetingCardTemplatesFragment = new GreetingCardTemplatesFragment();
        Bundle bundle = new Bundle();
        bundle.putString(ARG_PARAM1, str);
        bundle.putString(ARG_PARAM2, str2);
        greetingCardTemplatesFragment.setArguments(bundle);
        return greetingCardTemplatesFragment;
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
        View inflate = layoutInflater.inflate(R.layout.fragment_greeting_card_templates, viewGroup, false);
        this.rootView = inflate;
        this.valentineCardsTemplates = (RecyclerView) inflate.findViewById(R.id.card_templates_rv);
        this.backToActivity = (ImageView) this.rootView.findViewById(R.id.back_to_main_activity);
        this.cardTitle = (TextView) this.rootView.findViewById(R.id.card_title);
        return this.rootView;
    }

    @Override
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (MainActivity.mainActivity != null) {
            if (MainActivity.mainActivity.CARD_TYPE.equals("wedding_card")) {
                setCardPreviewAdapter("wedding_card");
                this.cardTitle.setText("Wedding Invitations");
            } else if (MainActivity.mainActivity.CARD_TYPE.equals("birthday_card")) {
                setCardPreviewAdapter("birthday_card");
                this.cardTitle.setText("Birthday Invitations");
            } else if (MainActivity.mainActivity.CARD_TYPE.equals("anniversary_card")) {
                setCardPreviewAdapter("anniversary_card");
                this.cardTitle.setText("Anniversary Invitations");
            } else if (MainActivity.mainActivity.CARD_TYPE.equals("engagement_card")) {
                setCardPreviewAdapter("engagement_card");
                this.cardTitle.setText("Engagement Invitations");
            } else if (MainActivity.mainActivity.CARD_TYPE.equals("housewarming_card")) {
                setCardPreviewAdapter("housewarming_card");
                this.cardTitle.setText("Housewarming Invitations");
            }
            this.backToActivity.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    if (MainActivity.mainActivity.greetingCardTemplatesFragment != null && MainActivity.mainActivity.greetingCardTemplatesFragment.isVisible()) {
                        MainActivity.mainActivity.removeGreetingCardTemplatesFragment(false);
                    }
                }
            });
        }
    }

    private void setCardPreviewAdapter(String str) {
        this.mResources = new ArrayList<>();
        if (str.equals("wedding_card")) {
            this.mResources.add(Integer.valueOf(R.drawable.wedding_card_1));
            this.mResources.add(Integer.valueOf(R.drawable.wedding_card_2));
            this.mResources.add(Integer.valueOf(R.drawable.wedding_card_3));
            this.mResources.add(Integer.valueOf(R.drawable.wedding_card_4));
            this.mResources.add(Integer.valueOf(R.drawable.wedding_card_5));
            this.mResources.add(Integer.valueOf(R.drawable.wedding_card_6));
            this.mResources.add(Integer.valueOf(R.drawable.wedding_card_7));
            this.mResources.add(Integer.valueOf(R.drawable.wedding_card_8));
            this.mResources.add(Integer.valueOf(R.drawable.wedding_card_9));
            this.mResources.add(Integer.valueOf(R.drawable.wedding_card_10));
        } else if (str.equals("birthday_card")) {
            this.mResources.add(Integer.valueOf(R.drawable.birthday_cards_1));
            this.mResources.add(Integer.valueOf(R.drawable.birthday_cards_2));
            this.mResources.add(Integer.valueOf(R.drawable.birthday_cards_3));
            this.mResources.add(Integer.valueOf(R.drawable.birthday_cards_4));
            this.mResources.add(Integer.valueOf(R.drawable.birthday_cards_5));
            this.mResources.add(Integer.valueOf(R.drawable.birthday_cards_6));
            this.mResources.add(Integer.valueOf(R.drawable.birthday_cards_7));
            this.mResources.add(Integer.valueOf(R.drawable.birthday_cards_8));
            this.mResources.add(Integer.valueOf(R.drawable.birthday_cards_9));
            this.mResources.add(Integer.valueOf(R.drawable.birthday_cards_10));
        } else if (str.equals("anniversary_card")) {
            this.mResources.add(Integer.valueOf(R.drawable.anniversary_card_11));
            this.mResources.add(Integer.valueOf(R.drawable.anniversary_card_12));
            this.mResources.add(Integer.valueOf(R.drawable.anniversary_card_13));
            this.mResources.add(Integer.valueOf(R.drawable.anniversary_card_14));
            this.mResources.add(Integer.valueOf(R.drawable.anniversary_card_15));
            this.mResources.add(Integer.valueOf(R.drawable.anniversary_card_1));
            this.mResources.add(Integer.valueOf(R.drawable.anniversary_card_2));
            this.mResources.add(Integer.valueOf(R.drawable.anniversary_card_6));
            this.mResources.add(Integer.valueOf(R.drawable.anniversary_card_9));
            this.mResources.add(Integer.valueOf(R.drawable.anniversary_card_10));
        } else if (str.equals("housewarming_card")) {
            this.mResources.add(Integer.valueOf(R.drawable.house_warming_card_1));
            this.mResources.add(Integer.valueOf(R.drawable.house_warming_card_2));
            this.mResources.add(Integer.valueOf(R.drawable.house_warming_card_3));
            this.mResources.add(Integer.valueOf(R.drawable.house_warming_card_4));
            this.mResources.add(Integer.valueOf(R.drawable.house_warming_card_5));
            this.mResources.add(Integer.valueOf(R.drawable.house_warming_card_6));
            this.mResources.add(Integer.valueOf(R.drawable.house_warming_card_7));
            this.mResources.add(Integer.valueOf(R.drawable.house_warming_card_8));
            this.mResources.add(Integer.valueOf(R.drawable.house_warming_card_9));
            this.mResources.add(Integer.valueOf(R.drawable.house_warming_card_10));
        } else {
            this.mResources.add(Integer.valueOf(R.drawable.engagement_card_1));
            this.mResources.add(Integer.valueOf(R.drawable.engagement_card_2));
            this.mResources.add(Integer.valueOf(R.drawable.engagement_card_3));
            this.mResources.add(Integer.valueOf(R.drawable.engagement_card_4));
            this.mResources.add(Integer.valueOf(R.drawable.engagement_card_5));
            this.mResources.add(Integer.valueOf(R.drawable.engagement_card_6));
            this.mResources.add(Integer.valueOf(R.drawable.engagement_card_7));
            this.mResources.add(Integer.valueOf(R.drawable.engagement_card_8));
            this.mResources.add(Integer.valueOf(R.drawable.engagement_card_9));
            this.mResources.add(Integer.valueOf(R.drawable.engagement_card_10));
        }
        new LinearLayoutManager(getActivity()).setOrientation(RecyclerView.VERTICAL);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            public int getSpanSize(int i) {
                return 1;
            }
        });
        this.valentineCardsTemplates.setLayoutManager(gridLayoutManager);
        this.valentineCardsTemplates.setHasFixedSize(true);
        this.valentineCardsTemplates.setItemViewCacheSize(21);
        this.valentineCardsTemplates.setDrawingCacheEnabled(true);
        this.valentineCardsTemplates.setDrawingCacheQuality(1048576);
        GreetingCardsTemplateAdapter greetingCardsTemplateAdapter2 = new GreetingCardsTemplateAdapter(getActivity(), this.mResources, MainActivity.mainActivity.CARD_TYPE);
        this.greetingCardsTemplateAdapter = greetingCardsTemplateAdapter2;
        this.valentineCardsTemplates.setAdapter(greetingCardsTemplateAdapter2);
    }
}
