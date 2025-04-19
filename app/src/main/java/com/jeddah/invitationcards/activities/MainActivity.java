package com.jeddah.invitationcards.activities;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.jeddah.invitationcards.Models.UserTemplate;
import com.jeddah.invitationcards.R;
import com.jeddah.invitationcards.adapters.GreetingCardsPreviewAdapter;
import com.jeddah.invitationcards.adapters.UserCardsPreviewAdapter;
import com.jeddah.invitationcards.fragments.GreetingCardTemplatesFragment;
import com.jeddah.invitationcards.utils.Utils;
import com.jeddah.invitationcards.utils.mUtils;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    static final int PERMISSION_CAMERA_REQUEST_CODE = 201;
    public static final int PERMISSION__STORAGE_REQUEST_CODE = 200;
    public static MainActivity mainActivity;
    public String CARD_TYPE;


    RecyclerView anniversaryCardsPreview;

    RecyclerView birthdayCardsPreview;
    boolean camera = false;
    LinearLayout cardBlank;
    LinearLayout cardInstaStory;
    LinearLayout cardLandscape;
    LinearLayout cardPortrait;
    LinearLayout cardSquare;
    FrameLayout cardTemplatesContainerPanel;

    public RecyclerView engagementCardsPreview;
    public GreetingCardTemplatesFragment greetingCardTemplatesFragment;
    GreetingCardsPreviewAdapter greetingCardsPreviewAdapter;
    UserCardsPreviewAdapter userCardsPreviewAdapter;

    RecyclerView UsersCardsPreview;
    ArrayList<Integer> mResources;
    ArrayList<UserTemplate> mUsersTemplatesList =new ArrayList<>();
    Dialog mainDialog;
    CardView more1;
    CardView more2;
    CardView more3;
    CardView more4;
    CardView more5;


    TextView viewAll1;
    TextView viewAll2;
    TextView viewAll3;
    TextView viewAll4;
    TextView viewAll5;

    RecyclerView weddingCardsPreview;
    public DrawerLayout drawer;
    public ActionBarDrawerToggle toggle;


    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_main);
        mainActivity = this;

        // to make the Navigation drawer icon always appear on the action bar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("صـانع البطاقات");


        // drawer layout instance to toggle the menu icon to open
        // drawer and back button to close drawer
        drawer = findViewById(R.id.drawer_layout);
        toggle = new ActionBarDrawerToggle(this, drawer, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        toggle.setDrawerIndicatorEnabled(true);

        // pass the Open and Close toggle for the drawer layout listener
        // to toggle the button
        drawer.addDrawerListener(toggle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(false);
        toggle.syncState();
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(MainActivity.this);
        if (new mUtils(this).getUserID().equals("9vozox8SwNROm7leVCMzAqIvf0U2")){
            navigationView.getMenu().findItem(R.id.nav_admin).setVisible(true);
        }




        FrameLayout frameLayout = findViewById(R.id.native_frame);

        this.UsersCardsPreview = (RecyclerView) findViewById(R.id.house_warming_card_preview_rv);

        this.cardTemplatesContainerPanel = (FrameLayout) findViewById(R.id.card_templates_fragment);
        this.weddingCardsPreview = (RecyclerView) findViewById(R.id.wedding_card_preview_rv);
        this.birthdayCardsPreview = (RecyclerView) findViewById(R.id.birthday_card_preview_rv);
        this.anniversaryCardsPreview = (RecyclerView) findViewById(R.id.anniversary_card_preview_rv);
        this.engagementCardsPreview = (RecyclerView) findViewById(R.id.engagement_card_preview_rv);
        setInvitationCardPreviewAdapter(this.weddingCardsPreview, "wedding_card");
        setInvitationCardPreviewAdapter(this.birthdayCardsPreview, "birthday_card");
        setInvitationCardPreviewAdapter(this.anniversaryCardsPreview, "anniversary_card");
        setInvitationCardPreviewAdapter(this.engagementCardsPreview, "engagement_card");
        //setInvitationCardPreviewAdapter(this.housewarmingCardsPreview, "housewarming_card");
        this.cardBlank = (LinearLayout) findViewById(R.id.card_blank);
        this.cardLandscape = (LinearLayout) findViewById(R.id.card_landscape);
        this.cardPortrait = (LinearLayout) findViewById(R.id.card_portrait);
        this.cardSquare = (LinearLayout) findViewById(R.id.card_square);
        this.cardInstaStory = (LinearLayout) findViewById(R.id.card_insta_story);
        this.cardBlank.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, GreetingCardEditActivity.class);
                intent.putExtra("position", 101);
                intent.putExtra("type", "own_card");
                MainActivity.this.startActivity(intent);
            }
        });
        this.cardLandscape.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, GreetingCardEditActivity.class);
                intent.putExtra("position", 102);
                intent.putExtra("type", "own_card");
                MainActivity.this.startActivity(intent);
            }
        });
        this.cardPortrait.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, GreetingCardEditActivity.class);
                intent.putExtra("position", 103);
                intent.putExtra("type", "own_card");
                MainActivity.this.startActivity(intent);
            }
        });
        this.cardSquare.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, GreetingCardEditActivity.class);
                intent.putExtra("position", 104);
                intent.putExtra("type", "own_card");
                MainActivity.this.startActivity(intent);
            }
        });
        this.cardInstaStory.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, GreetingCardEditActivity.class);
                intent.putExtra("position", 105);
                intent.putExtra("type", "own_card");
                MainActivity.this.startActivity(intent);
            }
        });


        TextView textView = (TextView) findViewById(R.id.view_all_1);
        this.viewAll1 = textView;
        textView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MainActivity.this.CARD_TYPE = "wedding_card";
                MainActivity.this.addGreetingCardTemplatesFragment();
            }
        });
        TextView textView2 = (TextView) findViewById(R.id.view_all_2);
        this.viewAll2 = textView2;
        textView2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MainActivity.this.CARD_TYPE = "birthday_card";
                MainActivity.this.addGreetingCardTemplatesFragment();
            }
        });
        TextView textView3 = (TextView) findViewById(R.id.view_all_3);
        this.viewAll3 = textView3;
        textView3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MainActivity.this.CARD_TYPE = "anniversary_card";
                MainActivity.this.addGreetingCardTemplatesFragment();
            }
        });
        TextView textView4 = (TextView) findViewById(R.id.view_all_4);
        this.viewAll4 = textView4;
        textView4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MainActivity.this.CARD_TYPE = "engagement_card";
                MainActivity.this.addGreetingCardTemplatesFragment();
            }
        });
        TextView textView5 = (TextView) findViewById(R.id.view_all_5);
        this.viewAll5 = textView5;
        textView5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent it = new Intent(MainActivity.this,AllUsersDesigns.class);
                it.putExtra("type","active");
                startActivity(it);
            }
        });
        CardView cardView = (CardView) findViewById(R.id.view_more_right_1);
        this.more1 = cardView;
        cardView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MainActivity.this.CARD_TYPE = "wedding_card";
                MainActivity.this.addGreetingCardTemplatesFragment();
            }
        });
        CardView cardView2 = (CardView) findViewById(R.id.view_more_right_2);
        this.more2 = cardView2;
        cardView2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MainActivity.this.CARD_TYPE = "birthday_card";
                MainActivity.this.addGreetingCardTemplatesFragment();
            }
        });
        CardView cardView3 = (CardView) findViewById(R.id.view_more_right_3);
        this.more3 = cardView3;
        cardView3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MainActivity.this.CARD_TYPE = "anniversary_card";
                MainActivity.this.addGreetingCardTemplatesFragment();
            }
        });
        CardView cardView4 = (CardView) findViewById(R.id.view_more_right_4);
        this.more4 = cardView4;
        cardView4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MainActivity.this.CARD_TYPE = "engagement_card";
                MainActivity.this.addGreetingCardTemplatesFragment();
            }
        });
        CardView cardView5 = (CardView) findViewById(R.id.view_more_right_5);
        this.more5 = cardView5;
        cardView5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MainActivity.this.CARD_TYPE = "housewarming_card";
                MainActivity.this.addGreetingCardTemplatesFragment();
            }
        });
        if (!checkStoragePermission() || !checkCameraPermission()) {
            showPermissionDialog();
        }

        UsersCardsPreview.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        userCardsPreviewAdapter = new UserCardsPreviewAdapter(this, mUsersTemplatesList);
        UsersCardsPreview.setAdapter(userCardsPreviewAdapter);

    }

    @Override
    public void onPostCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onPostCreate(savedInstanceState, persistentState);
        toggle.syncState();
    }





    public void showPermissionDialog() {
        Dialog dialog = new Dialog(this);
        this.mainDialog = dialog;
        dialog.requestWindowFeature(1);
        this.mainDialog.setCancelable(false);
        this.mainDialog.setContentView(R.layout.permission_dialog);
        ((TextView) this.mainDialog.findViewById(R.id.dialog_msg)).setText("طلب تصريح الوصول الى الملفات");
        ((TextView) this.mainDialog.findViewById(R.id.dialog_msg_sub)).setText("الرجاء إعطاء التصريح الازم للتطبيق");
        ((TextView) this.mainDialog.findViewById(R.id.dialog_ok)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MainActivity.this.camera = true;
                if (!MainActivity.this.checkCameraPermission()) {
                    MainActivity.this.requestCameraPermission();
                } else if (!MainActivity.this.checkStoragePermission()) {
                    MainActivity.this.requestStoragePermission();
                }
            }
        });
        this.mainDialog.show();
    }


    private void getUsersTemplates(){
        mUsersTemplatesList.clear();
        FirebaseDatabase.getInstance().getReference().child("templates").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot item : snapshot.getChildren()) {
                    UserTemplate template = item.getValue(UserTemplate.class);
                    Log.e("CHARAF1013",template.getStatus().toString());

                    if (template.getStatus().equals("active")){
                        Log.e("CHARAF1013","active");
                        mUsersTemplatesList.add(template);
                    }
                }
                userCardsPreviewAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        getUsersTemplates();
    }

    private void setInvitationCardPreviewAdapter(RecyclerView recyclerView, String str) {
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
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        GreetingCardsPreviewAdapter greetingCardsPreviewAdapter2 = new GreetingCardsPreviewAdapter(this, this.mResources, str);
        this.greetingCardsPreviewAdapter = greetingCardsPreviewAdapter2;
        recyclerView.setAdapter(greetingCardsPreviewAdapter2);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                if (recyclerView.getId() == MainActivity.this.weddingCardsPreview.getId()) {
                    if (!recyclerView.canScrollHorizontally(1)) {
                        MainActivity.this.more1.setVisibility(View.VISIBLE);
                        MainActivity mainActivity = MainActivity.this;
                        mainActivity.setMoreAnimation(mainActivity.more1, R.anim.left_to_right);
                        return;
                    }
                    MainActivity mainActivity2 = MainActivity.this;
                    mainActivity2.setMoreAnimation(mainActivity2.more1, R.anim.right_to_left);
                    MainActivity.this.more1.setVisibility(View.GONE);
                } else if (recyclerView.getId() == MainActivity.this.birthdayCardsPreview.getId()) {
                    if (!recyclerView.canScrollHorizontally(1)) {
                        MainActivity.this.more2.setVisibility(View.VISIBLE);
                        MainActivity mainActivity3 = MainActivity.this;
                        mainActivity3.setMoreAnimation(mainActivity3.more2, R.anim.left_to_right);
                        return;
                    }
                    MainActivity mainActivity4 = MainActivity.this;
                    mainActivity4.setMoreAnimation(mainActivity4.more2, R.anim.right_to_left);
                    MainActivity.this.more2.setVisibility(View.GONE);
                } else if (recyclerView.getId() == MainActivity.this.anniversaryCardsPreview.getId()) {
                    if (!recyclerView.canScrollHorizontally(1)) {
                        MainActivity.this.more3.setVisibility(View.VISIBLE);
                        MainActivity mainActivity5 = MainActivity.this;
                        mainActivity5.setMoreAnimation(mainActivity5.more3, R.anim.left_to_right);
                        return;
                    }
                    MainActivity mainActivity6 = MainActivity.this;
                    mainActivity6.setMoreAnimation(mainActivity6.more3, R.anim.right_to_left);
                    MainActivity.this.more3.setVisibility(View.GONE);
                } else if (recyclerView.getId() == MainActivity.this.engagementCardsPreview.getId()) {
                    if (!recyclerView.canScrollHorizontally(1)) {
                        MainActivity.this.more4.setVisibility(View.VISIBLE);
                        MainActivity mainActivity7 = MainActivity.this;
                        mainActivity7.setMoreAnimation(mainActivity7.more3, R.anim.left_to_right);
                        return;
                    }
                    MainActivity mainActivity8 = MainActivity.this;
                    mainActivity8.setMoreAnimation(mainActivity8.more3, R.anim.right_to_left);
                    MainActivity.this.more4.setVisibility(View.GONE);
                } else if (recyclerView.getId() != MainActivity.this.UsersCardsPreview.getId()) {
                } else {
                    if (!recyclerView.canScrollHorizontally(1)) {
                        MainActivity.this.more5.setVisibility(View.VISIBLE);
                        MainActivity mainActivity9 = MainActivity.this;
                        mainActivity9.setMoreAnimation(mainActivity9.more3, R.anim.left_to_right);
                        return;
                    }
                    MainActivity mainActivity10 = MainActivity.this;
                    mainActivity10.setMoreAnimation(mainActivity10.more3, R.anim.right_to_left);
                    MainActivity.this.more5.setVisibility(View.GONE);
                }
            }
        });
    }


    public void setMoreAnimation(CardView cardView, int i) {
        Animation loadAnimation = AnimationUtils.loadAnimation(this, i);
        loadAnimation.setRepeatMode(0);
        cardView.setAnimation(loadAnimation);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationEnd(Animation animation) {
                Log.e(":fdf","");
            }

            public void onAnimationRepeat(Animation animation) {
                Log.e(":fdf","");
            }

            public void onAnimationStart(Animation animation) {
                Log.e(":fdf","");
            }
        });
    }

    public void openGreetingCardTemplateFragment() {
        this.greetingCardTemplatesFragment = Utils.addGreetingCardTemplatesFragment(this, R.id.card_templates_fragment, true, (View) null);
    }

    public void addGreetingCardTemplatesFragment() {
        Animation loadAnimation = AnimationUtils.loadAnimation(this, R.anim.bottom_up);
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.card_templates_fragment);
        this.cardTemplatesContainerPanel = frameLayout;
        frameLayout.setVisibility(View.VISIBLE);
        this.cardTemplatesContainerPanel.startAnimation(loadAnimation);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationEnd(Animation animation) {
                Log.e(":fdf","");
            }

            public void onAnimationRepeat(Animation animation) {
                Log.e(":fdf","");
            }

            public void onAnimationStart(Animation animation) {
                Log.e(":fdf","");
            }
        });
        openGreetingCardTemplateFragment();
    }

    public void removeGreetingCardTemplatesFragment(boolean z) {
        Animation loadAnimation = AnimationUtils.loadAnimation(this, R.anim.bottom_down);
        this.greetingCardTemplatesFragment = Utils.getGreetingCardTemplatesFragment(this);
        this.cardTemplatesContainerPanel.startAnimation(loadAnimation);
        this.cardTemplatesContainerPanel.setVisibility(View.GONE);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationRepeat(Animation animation) {
                Log.e(":fdf","");
            }

            public void onAnimationStart(Animation animation) {
                Log.e(":fdf","");
            }

            public void onAnimationEnd(Animation animation) {
                MainActivity.this.getSupportFragmentManager().beginTransaction().remove(MainActivity.this.greetingCardTemplatesFragment).commit();
            }
        });
    }

    public boolean checkCameraPermission() {
        if (ContextCompat.checkSelfPermission(this, "android.permission.CAMERA") != -1 && ContextCompat.checkSelfPermission(this, "android.permission.CAMERA") == 0) {
            return true;
        }
        return false;
    }

    public void requestCameraPermission() {
        ActivityCompat.requestPermissions(this, new String[]{"android.permission.CAMERA"}, PERMISSION_CAMERA_REQUEST_CODE);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        boolean z = false;
        if (i != 200) {
            if (i == PERMISSION_CAMERA_REQUEST_CODE) {
                if (iArr.length <= 0 || iArr[0] != 0) {
                    showCamPermisionDialog();
                } else if (!checkStoragePermission()) {
                    requestStoragePermission();
                } else if (this.mainDialog.isShowing()) {
                    this.mainDialog.dismiss();
                }
            }
        } else if (iArr.length > 0) {
            boolean z2 = iArr[0] == 0;
            if (iArr[1] == 0) {
                z = true;
            }
            if (!z2 || !z) {
                showStoragePermisionDialog();
            } else if (this.camera) {
                this.mainDialog.dismiss();
            }
        }
    }

    private void showCamPermisionDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getString(R.string.permission_request_msg));
        builder.setTitle(getString(R.string.permission_request));
        builder.setPositiveButton(getString(R.string.ok), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                MainActivity.this.requestCameraPermission();
            }
        });
        builder.setNegativeButton(getString(R.string.cancel), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.create().show();
    }

    public boolean checkStoragePermission() {
        return ContextCompat.checkSelfPermission(this, "android.permission.READ_EXTERNAL_STORAGE") == 0 && ContextCompat.checkSelfPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE") == 0;
    }

    public void requestStoragePermission() {
        ActivityCompat.requestPermissions(this, new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"}, 200);
    }

    private void showStoragePermisionDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getString(R.string.permission_request_msg));
        builder.setTitle(getString(R.string.permission_request));
        builder.setPositiveButton(getString(R.string.ok), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        builder.setNegativeButton(getString(R.string.cancel), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                MainActivity.this.finish();
            }
        });
        builder.create().show();
    }


    @Override
    public void onBackPressed() {
        GreetingCardTemplatesFragment greetingCardTemplatesFragment2 = this.greetingCardTemplatesFragment;
        if (greetingCardTemplatesFragment2 == null || !greetingCardTemplatesFragment2.isVisible()) {
            try {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("هل متأكد تريد غلق التطبيق؟").setCancelable(false).setPositiveButton("نعم", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finishAffinity();
                        System.exit(0);
                    }
                }).setNegativeButton("لا", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                builder.create().show();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return;
        }
        removeGreetingCardTemplatesFragment(false);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        drawer.closeDrawer(GravityCompat.START);
        switch (item.getItemId()){
            case R.id.nav_admin:
                Intent it = new Intent(this,AdminPanel.class);
                startActivity(it);
                break;
            case R.id.nav_profile:
                Intent it1 = new Intent(this,ProfileActivity.class);
                startActivity(it1);
                break;
            case R.id.nav_gallery:
                Intent it2 = new Intent(this,GalleryActivity.class);
                startActivity(it2);
                break;
            case R.id.nav_add_design:
                Intent it3 = new Intent(this,UserCreate.class);
                startActivity(it3);
                break;
            case R.id.nav_logout:
                FirebaseAuth.getInstance().signOut();
                new mUtils(this).clearAllData();
                Intent it4 = new Intent(this,LoginActivity.class);
                startActivity(it4);
                finish();
                break;
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        // This is required to make the drawer toggle work
        if(toggle.onOptionsItemSelected(item)) {
            return true;
        }

        /*
         * if you have other menu items in your activity/toolbar
         * handle them here and return true
         */

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
/*
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        //drawer.closeDrawer(GravityCompat.START);
        if (toggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/
}
