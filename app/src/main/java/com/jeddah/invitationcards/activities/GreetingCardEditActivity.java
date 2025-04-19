package com.jeddah.invitationcards.activities;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.jeddah.invitationcards.R;
import com.jeddah.invitationcards.adapters.StickerPreViewAdapter;
import com.jeddah.invitationcards.adapters.ThemeColorsAdapter;
import com.jeddah.invitationcards.fragments.AddStickerFragment;
import com.jeddah.invitationcards.fragments.ElementsFragment;
import com.jeddah.invitationcards.utils.Utils;
import com.jeddah.invitationcards.views.PhotoDrawView;
import com.jeddah.invitationcards.views.StickerView;
import com.rtugeek.android.colorseekbar.ColorSeekBar;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;
import java.util.Random;

public class GreetingCardEditActivity extends AppCompatActivity implements View.OnTouchListener {
    private static final String CHARS = "abcdefghijkmnopqrstuvwxyzABCDEFGHJKLMNOPQRSTUVWXYZ234567890!@#$";


    public static GreetingCardEditActivity activity;
    static final Random random = new Random();
    int anInt = 0;
    public int INT_RESOURCE_ID_TO_COPY;
    AlertDialog OptionDialog;
    int POSITION;


    int SHADOW_COLOR = 0;

    int SHADOW_PROGRESS = 0;

    String TYPE;
    Typeface TYPE_FACE;
    View VIEW;

    LinearLayout addSticker;

    AddStickerFragment addStickerFragment;
    LinearLayout addText;
    RecyclerView annStickersPrevRecycler;

    TextView anniversaryStickers;
    ImageView backToMain;
    RecyclerView birStickersPrevRecycler;

    TextView birthdayStickers;
    Bitmap bitmap;
    int bmHeight;
    double bmRatio;
    int bmWidth;
    Animation bottomDown;

    LinearLayout bottomPanel;
    int bottombarHeight;
    String categoryType;
    ImageView collapseFontColorOptions;
    ImageView collapseFontShadowColorOptions;
    ImageView collapseFontSizeOptions;
    ImageView collapseFontStyleOptions;
    ImageView collapseMoreTextOptions;
    ImageView collapseStickerOptions;

    ColorSeekBar colorSeekBar;

    RelativeLayout colorsSuperLinearLayout;

    Context context;
    int counter = -1;


    float f172dX;


    float f173dY;
    public LinearLayout deleteText;
    public TextView displaySelectedFontColor;
    public TextView displaySelectedFontShadowColor;

    EditText ed1;

    EditText ed2;

    EditText ed3;

    EditText ed4;

    EditText ed5;

    EditText ed6;

    EditText ed7;

    RelativeLayout editCardContainer;
    ArrayList<EditText> editTextList;
    View editTextView;
    ImageView edit_text_ic;
    ElementsFragment elementsFragment;
    RecyclerView engStickersPrevRecycler;

    TextView engagementStickers;
    String filePath;
    String filename;
    TextView font1;
    TextView font2;
    TextView font3;
    TextView font4;
    TextView font5;
    TextView font6;
    TextView font7;
    TextView font8;

    LinearLayout fontColorOptions;
    ImageView fontColorOptionsBack;
    ImageView fontColorSelection;

    LinearLayout fontShadowColorOptions;
    ImageView fontShadowColorOptionsBack;
    ImageView fontShadowColorSelection;

    LinearLayout fontSizeOptions;
    ImageView fontSizeOptionsBack;
    RecyclerView fontSizeRecycler;
    public TextView fontSizeSelection;

    LinearLayout fontStyleOptions;
    ImageView fontStyleOptionsBack;
    TextView fontStyleSelection;

    LinearLayout fontsLinear;
    String from;
    GestureDetector gestureDetector;
    ImageView gradient1;
    ImageView gradient10;
    ImageView gradient11;
    ImageView gradient12;
    ImageView gradient2;
    ImageView gradient3;
    ImageView gradient4;
    ImageView gradient5;
    ImageView gradient6;
    ImageView gradient7;
    ImageView gradient8;
    ImageView gradient9;
    View greetingCardView;
    FrameLayout hiddenPanel;

    HorizontalScrollView horizontalScrollView;

    TextView houseWarmingStickers;
    RecyclerView hwStickersPrevRecycler;
    ArrayList<String> imagesFromStorage;
    float initialXPoint;
    Intent intent;
    boolean isFirstTimeColorChange = true;
    boolean isFirstTimeShadowColorChange = true;
    Boolean isMoving = false;
    public boolean isShaderApplied = false;

    View lastTouchedView;
    StickerView mCurrentView;
    double mDensity;
    ArrayList<Integer> mResources;
    ArrayList<View> mViews;

    ImageView mainBoldText;
    LinearLayout mainFontColorOption;

    ImageView mainItalicText;

    ImageView mainNonBoldText;

    ImageView mainNonItalicText;
    ImageView mainSlideUp;

    ImageView mainTextNoUnderline;

    ImageView mainTextNonStrike;

    LinearLayout mainTextOptions;

    ImageView mainTextStrike;

    ImageView mainTextUnderline;

    ImageView moreNonBoldText;

    ImageView moreNonItalicText;

    ImageView moreTextNoUnderline;

    ImageView moreTextNonStrike;

    LinearLayout moreTextOptions;
    ImageView newElement;
    LinearLayout options_new;
    PhotoDrawView photoDrawView;
    ImageView saveImg;
    TextView sc1;
    TextView sc10;
    TextView sc11;
    TextView sc12;
    TextView sc2;
    TextView sc3;
    TextView sc4;
    TextView sc5;
    TextView sc6;
    TextView sc7;
    TextView sc8;
    TextView sc9;
    ImageView selectedCard;
    ImageView selectedImage;
    Bitmap selectedPhoto;
    TextView textView;
    TextView textView1;
    TextView textView2;
    TextView textView3;
    TextView textView4;
    TextView textView5;
    TextView textView6;
    TextView textView7;
    TextView textView10;
    TextView textView8;
    TextView textView9;
    TextView textView11;

    ColorSeekBar shadowColor;
    RecyclerView shadowColorRecycler;

    LinearLayout shadowLinerLayout;
    public SeekBar shadowRadius;
    FrameLayout stickerFragmentFrame;

    LinearLayout stickerOptions;
    ImageView stickerOptionsBack;
    StickerPreViewAdapter stickerPreviewAdapter;

    FrameLayout stickerViewContainer;
    ViewFlipper stickerViewFlipper;
    RecyclerView stickersPrevRecycler;

    ImageView subBoldText;
    String subCategory;

    ImageView subItalicText;
    TextView subTextColor;
    TextView subTextGradient;
    TextView subTextShadow;

    ImageView subTextStrike;

    ImageView subTextUnderline;
    ImageView textAlignBottom;
    ImageView textAlignCenterHorizontal;
    ImageView textAlignCenterVertical;
    ImageView textAlignLeft;
    ImageView textAlignRight;
    ImageView textAlignTop;
    TextView textColor;
    TextView textFont;
    TextView textSize;
    SeekBar textSizeSeekBar;
    ThemeColorsAdapter themeColorsAdapter;
    RecyclerView themeColorsRecycler;
    int touchMode = 0;
    String type;
    View view;

    TextView weddingStickers;


    public Bitmap getSelectedPhoto() {
        return this.selectedPhoto;
    }

    public void setSelectedPhoto(Bitmap bitmap2) {
        this.selectedPhoto = bitmap2;
    }

    public View getView() {
        return this.view;
    }

    public void setView(View view2) {
        this.view = view2;
    }


    public void onCreate(Bundle bundle) {
        getWindow().setFlags(1024, 1024);
        super.onCreate(bundle);
        setContentView((int) R.layout.card_edit_layout_2);
        activity = this;
        this.POSITION = getIntent().hasExtra("position") ? getIntent().getIntExtra("position", 0) : 0;
        this.TYPE = getIntent().hasExtra("type") ? getIntent().getStringExtra("type") : null;
        Intent intent2 = getIntent();
        this.intent = intent2;
        this.context = this;
        this.categoryType = intent2.getStringExtra("category");
        this.filename = "img_" + String.format("%d.jpg", new Object[]{Long.valueOf(System.currentTimeMillis())});


        this.gestureDetector = new GestureDetector(this, new SingleTapConfirm());
        this.editTextList = new ArrayList<>();
        initVars();
        this.mViews = new ArrayList<>();
        setGreetingCard(this.TYPE, this.POSITION);
        this.bottomDown = AnimationUtils.loadAnimation(this.context, R.anim.bottom_down);
    }

    private void initVars() {
        this.stickersPrevRecycler = (RecyclerView) findViewById(R.id.stickers_preview_recycler);
        this.engStickersPrevRecycler = (RecyclerView) findViewById(R.id.stickers_preview_recycler_2);
        this.birStickersPrevRecycler = (RecyclerView) findViewById(R.id.stickers_preview_recycler_3);
        this.annStickersPrevRecycler = (RecyclerView) findViewById(R.id.stickers_preview_recycler_4);
        this.hwStickersPrevRecycler = (RecyclerView) findViewById(R.id.stickers_preview_recycler_5);
        this.stickerViewFlipper = (ViewFlipper) findViewById(R.id.stickers_view_flipper);
        this.newElement = (ImageView) findViewById(R.id.new_element);
        this.saveImg = (ImageView) findViewById(R.id.save_img);
        this.options_new = (LinearLayout) findViewById(R.id.options_new);
        this.edit_text_ic = (ImageView) findViewById(R.id.edit_text_ic);
        this.editCardContainer = (RelativeLayout) findViewById(R.id.edit_card_container);
        this.backToMain = (ImageView) findViewById(R.id.back_to_main);
        this.fontsLinear = (LinearLayout) findViewById(R.id.fonts_linear);
        this.bottomPanel = (LinearLayout) findViewById(R.id.card_edit_bottom_panel);
        this.colorsSuperLinearLayout = (RelativeLayout) findViewById(R.id.colors_super_linear_layout);
        this.colorSeekBar = (ColorSeekBar) findViewById(R.id.color_seek_bar);
        this.shadowColor = (ColorSeekBar) findViewById(R.id.shadow_color_seek_bar);
        this.horizontalScrollView = (HorizontalScrollView) findViewById(R.id.gradient_scroll_layout);
        this.textSizeSeekBar = (SeekBar) findViewById(R.id.text_size_bar);
        this.shadowRadius = (SeekBar) findViewById(R.id.shadow_radius_seek_bar);
        this.shadowLinerLayout = (LinearLayout) findViewById(R.id.shadow_liner_layout);
        this.addText = (LinearLayout) findViewById(R.id.add_edit_text);
        this.addSticker = (LinearLayout) findViewById(R.id.add_stickers);
        this.deleteText = (LinearLayout) findViewById(R.id.delete_edit_text);
        this.textSize = (TextView) findViewById(R.id.text_size);
        this.textColor = (TextView) findViewById(R.id.text_color);
        this.textFont = (TextView) findViewById(R.id.text_font);
        this.subTextColor = (TextView) findViewById(R.id.text_sub_color);
        this.subTextGradient = (TextView) findViewById(R.id.text_sub_color_gradient);
        this.subTextShadow = (TextView) findViewById(R.id.text_sub_color_shadow);
        this.font1 = (TextView) findViewById(R.id.alger_font_style);
        this.font2 = (TextView) findViewById(R.id.britanic_font_style);
        this.font3 = (TextView) findViewById(R.id.frscript_font_style);
        this.font4 = (TextView) findViewById(R.id.gil_font_style);
        this.font5 = (TextView) findViewById(R.id.harngton_font_style);
        this.font6 = (TextView) findViewById(R.id.mtcorsva_font_style);
        this.font7 = (TextView) findViewById(R.id.ottumhmkbold_font_style);
        this.font8 = (TextView) findViewById(R.id.roboto_medium_font_style);
        this.mainBoldText = (ImageView) findViewById(R.id.main_bold_text);
        this.mainItalicText = (ImageView) findViewById(R.id.main_italic_text);
        this.mainTextUnderline = (ImageView) findViewById(R.id.main_text_underline);
        this.mainTextStrike = (ImageView) findViewById(R.id.main_text_strike);
        this.mainSlideUp = (ImageView) findViewById(R.id.main_slide_up);
        this.subBoldText = (ImageView) findViewById(R.id.sub_bold_text);
        this.subItalicText = (ImageView) findViewById(R.id.sub_italic_text);
        this.subTextUnderline = (ImageView) findViewById(R.id.sub_text_underline);
        this.subTextStrike = (ImageView) findViewById(R.id.sub_text_strike);
        this.mainFontColorOption = (LinearLayout) findViewById(R.id.main_font_color_option);
        this.mainTextOptions = (LinearLayout) findViewById(R.id.main_text_options);
        this.moreTextOptions = (LinearLayout) findViewById(R.id.more_text_options_linear);
        this.stickerOptions = (LinearLayout) findViewById(R.id.sub_stickers);
        this.fontStyleOptions = (LinearLayout) findViewById(R.id.sub_font_styles);
        this.fontSizeOptions = (LinearLayout) findViewById(R.id.sub_font_size);
        this.fontColorOptions = (LinearLayout) findViewById(R.id.sub_font_color);
        this.fontShadowColorOptions = (LinearLayout) findViewById(R.id.sub_font_shadow_color);
        this.fontStyleSelection = (TextView) findViewById(R.id.text_font_style_selection);
        this.fontSizeSelection = (TextView) findViewById(R.id.text_size_selection);
        this.stickerOptionsBack = (ImageView) findViewById(R.id.sticker_options_back);
        this.fontColorSelection = (ImageView) findViewById(R.id.text_color_selection);
        this.fontShadowColorSelection = (ImageView) findViewById(R.id.text_shadow_color_selection);
        this.fontStyleOptionsBack = (ImageView) findViewById(R.id.font_style_options_back);
        this.fontSizeOptionsBack = (ImageView) findViewById(R.id.font_size_options_back);
        this.fontColorOptionsBack = (ImageView) findViewById(R.id.font_color_options_back);
        this.fontShadowColorOptionsBack = (ImageView) findViewById(R.id.font_shadow_color_options_back);
        this.collapseStickerOptions = (ImageView) findViewById(R.id.collapse_sticker_options);
        this.collapseMoreTextOptions = (ImageView) findViewById(R.id.collapse_more_options);
        this.collapseFontStyleOptions = (ImageView) findViewById(R.id.collapse_font_style_options);
        this.collapseFontSizeOptions = (ImageView) findViewById(R.id.collapse_font_size_options);
        this.collapseFontColorOptions = (ImageView) findViewById(R.id.collapse_font_color_options);
        this.collapseFontShadowColorOptions = (ImageView) findViewById(R.id.collapse_font_shadow_color_options);
        this.displaySelectedFontColor = (TextView) findViewById(R.id.display_selected_font_color);
        this.displaySelectedFontShadowColor = (TextView) findViewById(R.id.display_selected_font_shadow_color);
        this.textAlignLeft = (ImageView) findViewById(R.id.text_align_left);
        this.textAlignCenterHorizontal = (ImageView) findViewById(R.id.text_align_center_horizontal);
        this.textAlignRight = (ImageView) findViewById(R.id.text_align_right);
        this.textAlignTop = (ImageView) findViewById(R.id.text_align_top);
        this.textAlignCenterVertical = (ImageView) findViewById(R.id.text_align_center_vertical);
        this.textAlignBottom = (ImageView) findViewById(R.id.text_align_bottom);
        this.mainNonBoldText = (ImageView) findViewById(R.id.main_non_bold_text);
        this.mainNonItalicText = (ImageView) findViewById(R.id.main_non_italic_text);
        this.mainTextNoUnderline = (ImageView) findViewById(R.id.main_text_no_underline);
        this.mainTextNonStrike = (ImageView) findViewById(R.id.main_text_non_strike);
        this.moreNonBoldText = (ImageView) findViewById(R.id.more_non_bold_text);
        this.moreNonItalicText = (ImageView) findViewById(R.id.more_non_italic_text);
        this.moreTextNoUnderline = (ImageView) findViewById(R.id.more_no_underline_text);
        this.moreTextNonStrike = (ImageView) findViewById(R.id.more_non_strike_text);
        this.gradient1 = (ImageView) findViewById(R.id.gradient_1);
        this.gradient2 = (ImageView) findViewById(R.id.gradient_2);
        this.gradient3 = (ImageView) findViewById(R.id.gradient_3);
        this.gradient4 = (ImageView) findViewById(R.id.gradient_4);
        this.gradient5 = (ImageView) findViewById(R.id.gradient_5);
        this.gradient6 = (ImageView) findViewById(R.id.gradient_6);
        this.gradient7 = (ImageView) findViewById(R.id.gradient_7);
        this.gradient8 = (ImageView) findViewById(R.id.gradient_8);
        this.gradient9 = (ImageView) findViewById(R.id.gradient_9);
        this.gradient10 = (ImageView) findViewById(R.id.gradient_10);
        this.gradient11 = (ImageView) findViewById(R.id.gradient_11);
        this.gradient12 = (ImageView) findViewById(R.id.gradient_12);
        this.sc1 = (TextView) findViewById(R.id.sc1);
        this.sc2 = (TextView) findViewById(R.id.sc2);
        this.sc3 = (TextView) findViewById(R.id.sc3);
        this.sc4 = (TextView) findViewById(R.id.sc4);
        this.sc5 = (TextView) findViewById(R.id.sc5);
        this.sc6 = (TextView) findViewById(R.id.sc6);
        this.sc7 = (TextView) findViewById(R.id.sc7);
        this.sc8 = (TextView) findViewById(R.id.sc8);
        this.sc9 = (TextView) findViewById(R.id.sc9);
        this.sc10 = (TextView) findViewById(R.id.sc10);
        this.sc11 = (TextView) findViewById(R.id.sc11);
        this.sc12 = (TextView) findViewById(R.id.sc12);
        this.textView = (TextView) findViewById(R.id.sh_sc1);
        this.textView4 = (TextView) findViewById(R.id.sh_sc2);
        this.textView5 = (TextView) findViewById(R.id.sh_sc3);
        this.textView6 = (TextView) findViewById(R.id.sh_sc4);
        this.textView7 = (TextView) findViewById(R.id.sh_sc5);
        this.textView10 = (TextView) findViewById(R.id.sh_sc6);
        this.textView8 = (TextView) findViewById(R.id.sh_sc7);
        this.textView9 = (TextView) findViewById(R.id.sh_sc8);
        this.textView11 = (TextView) findViewById(R.id.sh_sc9);
        this.textView1 = (TextView) findViewById(R.id.sh_sc10);
        this.textView2 = (TextView) findViewById(R.id.sh_sc11);
        this.textView3 = (TextView) findViewById(R.id.sh_sc12);
        this.themeColorsRecycler = (RecyclerView) findViewById(R.id.font_colors_theme_recycler);
        this.shadowColorRecycler = (RecyclerView) findViewById(R.id.font_shadow_colors_theme_recycler);
        this.fontSizeRecycler = (RecyclerView) findViewById(R.id.font_size_recycler);
    }

    private void clickables() {
        this.edit_text_ic.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (GreetingCardEditActivity.this.getLastTouchedEditTextView() != null) {
                    GreetingCardEditActivity activity = GreetingCardEditActivity.this;
                    new FileSaveDialog(activity, activity.getResources(), GreetingCardEditActivity.this.getLastTouchedEditTextView().getText().toString()).show();
                }
            }
        });
        this.newElement.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                GreetingCardEditActivity.this.setBottomUpHiddenLayout();
            }
        });
        this.saveImg.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (GreetingCardEditActivity.this.getLastTouchedEditTextView() != null) {
                    GreetingCardEditActivity.this.getLastTouchedEditTextView().setBackground(ContextCompat.getDrawable(GreetingCardEditActivity.this.getApplicationContext(), R.drawable.img_highlight_2));
                    if (GreetingCardEditActivity.this.getLastTouchedEditTextView().isFocusable()) {
                        GreetingCardEditActivity.this.getLastTouchedEditTextView().clearFocus();
                    }
                }
                GreetingCardEditActivity.this.save();

            }
        });
        this.selectedCard.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (GreetingCardEditActivity.this.getSelectedPhoto() == null) {
                    if (GreetingCardEditActivity.this.mCurrentView != null) {
                        GreetingCardEditActivity.this.mCurrentView.setInEdit(false);
                    }
                    if (GreetingCardEditActivity.this.getLastTouchedEditTextView() == null) {
                        return;
                    }
                    if (GreetingCardEditActivity.this.getLastTouchedEditTextView().isFocusable() || GreetingCardEditActivity.this.selectedCard.isClickable()) {
                        GreetingCardEditActivity.this.clearHighlights();
                        GreetingCardEditActivity.this.fontSizeSelection.setText("0");
                        GreetingCardEditActivity.this.fontStyleSelection.setTypeface((Typeface) null);
                        GreetingCardEditActivity.this.fontStyleSelection.setText("default font");
                        if (GreetingCardEditActivity.this.getLastTouchedEditTextView().isFocusable()) {
                            GreetingCardEditActivity.this.getLastTouchedEditTextView().setBackground(ContextCompat.getDrawable(GreetingCardEditActivity.this.getApplicationContext(), R.drawable.img_highlight_2));
                            GreetingCardEditActivity.this.getLastTouchedEditTextView().clearFocus();
                            GreetingCardEditActivity.this.hideKeyboard(view);
                            return;
                        }
                        return;
                    }
                    return;
                }
                GreetingCardEditActivity.this.selectedCard.setClickable(false);
            }
        });
        this.textAlignLeft.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (GreetingCardEditActivity.this.getLastTouchedEditTextView() != null) {
                    GreetingCardEditActivity.this.getLastTouchedEditTextView().setGravity(3);
                } else {
                    Toast.makeText(GreetingCardEditActivity.this.context, "Please select a text.", Toast.LENGTH_SHORT).show();
                }
            }
        });
        this.textAlignCenterHorizontal.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (GreetingCardEditActivity.this.getLastTouchedEditTextView() != null) {
                    GreetingCardEditActivity.this.getLastTouchedEditTextView().setGravity(1);
                } else {
                    Toast.makeText(GreetingCardEditActivity.this.context, "Please select a text.", Toast.LENGTH_SHORT).show();
                }
            }
        });
        this.textAlignRight.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (GreetingCardEditActivity.this.getLastTouchedEditTextView() != null) {
                    GreetingCardEditActivity.this.getLastTouchedEditTextView().setGravity(5);
                } else {
                    Toast.makeText(GreetingCardEditActivity.this.context, "Please select a text.", Toast.LENGTH_SHORT).show();
                }
            }
        });
        this.textAlignTop.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (GreetingCardEditActivity.this.getLastTouchedEditTextView() != null) {
                    GreetingCardEditActivity.this.getLastTouchedEditTextView().setGravity(48);
                } else {
                    Toast.makeText(GreetingCardEditActivity.this.context, "Please select a text.", Toast.LENGTH_SHORT).show();
                }
            }
        });
        this.textAlignCenterVertical.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (GreetingCardEditActivity.this.getLastTouchedEditTextView() != null) {
                    GreetingCardEditActivity.this.getLastTouchedEditTextView().setGravity(16);
                } else {
                    Toast.makeText(GreetingCardEditActivity.this.context, "Please select a text.", Toast.LENGTH_SHORT).show();
                }
            }
        });
        this.textAlignBottom.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (GreetingCardEditActivity.this.getLastTouchedEditTextView() != null) {
                    GreetingCardEditActivity.this.getLastTouchedEditTextView().setGravity(80);
                } else {
                    Toast.makeText(GreetingCardEditActivity.this.context, "Please select a text.", Toast.LENGTH_SHORT).show();
                }
            }
        });
        this.deleteText.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                GreetingCardEditActivity.this.fontsLinear.setVisibility(View.GONE);
                GreetingCardEditActivity.this.colorsSuperLinearLayout.setVisibility(View.GONE);
                GreetingCardEditActivity.this.textSizeSeekBar.setVisibility(View.GONE);
                if (GreetingCardEditActivity.this.lastTouchedView == null) {
                    Toast.makeText(GreetingCardEditActivity.this.context, "Please select any text box..", Toast.LENGTH_SHORT).show();
                } else if (GreetingCardEditActivity.this.lastTouchedView.getParent() == GreetingCardEditActivity.this.stickerViewContainer) {
                    GreetingCardEditActivity.this.stickerViewContainer.removeView(GreetingCardEditActivity.this.lastTouchedView);
                } else if (GreetingCardEditActivity.this.lastTouchedView.getId() == GreetingCardEditActivity.this.ed1.getId()) {
                    GreetingCardEditActivity.this.ed1.setVisibility(View.GONE);
                } else if (GreetingCardEditActivity.this.lastTouchedView.getId() == GreetingCardEditActivity.this.ed2.getId()) {
                    GreetingCardEditActivity.this.ed2.setVisibility(View.GONE);
                } else if (GreetingCardEditActivity.this.lastTouchedView.getId() == GreetingCardEditActivity.this.ed3.getId()) {
                    GreetingCardEditActivity.this.ed3.setVisibility(View.GONE);
                } else if (GreetingCardEditActivity.this.lastTouchedView.getId() == GreetingCardEditActivity.this.ed4.getId()) {
                    GreetingCardEditActivity.this.ed4.setVisibility(View.GONE);
                } else if (GreetingCardEditActivity.this.lastTouchedView.getId() == GreetingCardEditActivity.this.ed5.getId()) {
                    GreetingCardEditActivity.this.ed5.setVisibility(View.GONE);
                } else if (GreetingCardEditActivity.this.lastTouchedView.getId() == GreetingCardEditActivity.this.ed6.getId()) {
                    GreetingCardEditActivity.this.ed6.setVisibility(View.GONE);
                } else if (GreetingCardEditActivity.this.lastTouchedView.getId() == GreetingCardEditActivity.this.ed7.getId()) {
                    GreetingCardEditActivity.this.ed7.setVisibility(View.GONE);
                }
            }
        });
        this.addText.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                GreetingCardEditActivity.this.fontsLinear.setVisibility(View.GONE);
                GreetingCardEditActivity.this.colorsSuperLinearLayout.setVisibility(View.GONE);
                GreetingCardEditActivity.this.textSizeSeekBar.setVisibility(View.GONE);
                GreetingCardEditActivity.this.setNewEditText().setOnTouchListener(GreetingCardEditActivity.this);
            }
        });
        this.addSticker.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                GreetingCardEditActivity activity = GreetingCardEditActivity.this;
                activity.setBottomLayoutOpenNavigation(activity.stickerOptions, GreetingCardEditActivity.this.moreTextOptions, R.anim.left_to_right);
            }
        });
        this.mainBoldText.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (GreetingCardEditActivity.this.getLastTouchedEditTextView() != null) {
                    GreetingCardEditActivity.this.mainBoldText.setVisibility(View.GONE);
                    GreetingCardEditActivity.this.mainNonBoldText.setVisibility(View.VISIBLE);
                    GreetingCardEditActivity.this.getLastTouchedEditTextView().setTypeface(GreetingCardEditActivity.this.getLastTouchedEditTextView().getTypeface(), 1);
                    return;
                }
                Toast.makeText(GreetingCardEditActivity.this.context, "Please select a text.", Toast.LENGTH_SHORT).show();
            }
        });
        this.subBoldText.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (GreetingCardEditActivity.this.getLastTouchedEditTextView() != null) {
                    GreetingCardEditActivity.this.subBoldText.setVisibility(View.GONE);
                    GreetingCardEditActivity.this.moreNonBoldText.setVisibility(View.VISIBLE);
                    GreetingCardEditActivity.this.getLastTouchedEditTextView().setTypeface(GreetingCardEditActivity.this.getLastTouchedEditTextView().getTypeface(), Typeface.BOLD);
                    return;
                }
                Toast.makeText(GreetingCardEditActivity.this.context, "Please select a text.", Toast.LENGTH_SHORT).show();
            }
        });
        this.mainItalicText.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (GreetingCardEditActivity.this.getLastTouchedEditTextView() != null) {
                    GreetingCardEditActivity.this.mainItalicText.setVisibility(View.GONE);
                    GreetingCardEditActivity.this.mainNonItalicText.setVisibility(View.VISIBLE);
                    GreetingCardEditActivity.this.getLastTouchedEditTextView().setTypeface(GreetingCardEditActivity.this.getLastTouchedEditTextView().getTypeface(), Typeface.ITALIC);
                    return;
                }
                Toast.makeText(GreetingCardEditActivity.this.context, "Please select a text.", Toast.LENGTH_SHORT).show();
            }
        });
        this.subItalicText.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (GreetingCardEditActivity.this.getLastTouchedEditTextView() != null) {
                    GreetingCardEditActivity.this.subItalicText.setVisibility(View.GONE);
                    GreetingCardEditActivity.this.moreNonItalicText.setVisibility(View.VISIBLE);
                    GreetingCardEditActivity.this.getLastTouchedEditTextView().setTypeface(GreetingCardEditActivity.this.getLastTouchedEditTextView().getTypeface(), Typeface.ITALIC);
                    return;
                }
                Toast.makeText(GreetingCardEditActivity.this.context, "Please select a text.", Toast.LENGTH_SHORT).show();
            }
        });
        this.mainTextUnderline.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (GreetingCardEditActivity.this.getLastTouchedEditTextView() != null) {
                    GreetingCardEditActivity.this.mainTextUnderline.setVisibility(View.GONE);
                    GreetingCardEditActivity.this.mainTextNoUnderline.setVisibility(View.VISIBLE);
                    GreetingCardEditActivity.this.getLastTouchedEditTextView().setPaintFlags(8);
                    return;
                }
                Toast.makeText(GreetingCardEditActivity.this.context, "Please select a text.", Toast.LENGTH_SHORT).show();
            }
        });
        this.subTextUnderline.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (GreetingCardEditActivity.this.getLastTouchedEditTextView() != null) {
                    GreetingCardEditActivity.this.subTextUnderline.setVisibility(View.GONE);
                    GreetingCardEditActivity.this.moreTextNoUnderline.setVisibility(View.VISIBLE);
                    GreetingCardEditActivity.this.getLastTouchedEditTextView().setPaintFlags(8);
                    return;
                }
                Toast.makeText(GreetingCardEditActivity.this.context, "Please select a text.", Toast.LENGTH_SHORT).show();
            }
        });
        this.mainTextStrike.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (GreetingCardEditActivity.this.getLastTouchedEditTextView() != null) {
                    GreetingCardEditActivity.this.mainTextStrike.setVisibility(View.GONE);
                    GreetingCardEditActivity.this.mainTextNonStrike.setVisibility(View.VISIBLE);
                    GreetingCardEditActivity.this.getLastTouchedEditTextView().setPaintFlags(16);
                    return;
                }
                Toast.makeText(GreetingCardEditActivity.this.context, "Please select a text.", Toast.LENGTH_SHORT).show();
            }
        });
        this.subTextStrike.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (GreetingCardEditActivity.this.getLastTouchedEditTextView() != null) {
                    GreetingCardEditActivity.this.subTextStrike.setVisibility(View.GONE);
                    GreetingCardEditActivity.this.moreTextNonStrike.setVisibility(View.VISIBLE);
                    GreetingCardEditActivity.this.getLastTouchedEditTextView().setPaintFlags(16);
                    return;
                }
                Toast.makeText(GreetingCardEditActivity.this.context, "Please select a text.", Toast.LENGTH_SHORT).show();
            }
        });
        this.mainNonBoldText.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (GreetingCardEditActivity.this.getLastTouchedEditTextView() != null) {
                    GreetingCardEditActivity.this.mainBoldText.setVisibility(View.VISIBLE);
                    GreetingCardEditActivity.this.mainNonBoldText.setVisibility(View.GONE);
                    GreetingCardEditActivity.this.getLastTouchedEditTextView().setTypeface((Typeface) null);
                    GreetingCardEditActivity.this.getLastTouchedEditTextView().setTypeface(GreetingCardEditActivity.this.getLastTouchedEditTextView().getTypeface(), Typeface.NORMAL);
                    return;
                }
                Toast.makeText(GreetingCardEditActivity.this.context, "Please select a text.", Toast.LENGTH_SHORT).show();
            }
        });
        this.mainNonItalicText.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (GreetingCardEditActivity.this.getLastTouchedEditTextView() != null) {
                    GreetingCardEditActivity.this.mainItalicText.setVisibility(View.VISIBLE);
                    GreetingCardEditActivity.this.mainNonItalicText.setVisibility(View.GONE);
                    GreetingCardEditActivity.this.getLastTouchedEditTextView().setTypeface((Typeface) null);
                    GreetingCardEditActivity.this.getLastTouchedEditTextView().setTypeface(GreetingCardEditActivity.this.getLastTouchedEditTextView().getTypeface(), Typeface.NORMAL);
                    return;
                }
                Toast.makeText(GreetingCardEditActivity.this.context, "Please select a text.", Toast.LENGTH_SHORT).show();
            }
        });
        this.mainTextNoUnderline.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (GreetingCardEditActivity.this.getLastTouchedEditTextView() != null) {
                    GreetingCardEditActivity.this.mainTextUnderline.setVisibility(View.VISIBLE);
                    GreetingCardEditActivity.this.mainTextNoUnderline.setVisibility(View.GONE);
                    GreetingCardEditActivity.this.getLastTouchedEditTextView().setTypeface((Typeface) null);
                    GreetingCardEditActivity.this.getLastTouchedEditTextView().setPaintFlags(GreetingCardEditActivity.this.getLastTouchedEditTextView().getPaintFlags() & -9);
                    return;
                }
                Toast.makeText(GreetingCardEditActivity.this.context, "Please select a text.", Toast.LENGTH_SHORT).show();
            }
        });
        this.mainTextNonStrike.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (GreetingCardEditActivity.this.getLastTouchedEditTextView() != null) {
                    GreetingCardEditActivity.this.mainTextStrike.setVisibility(View.VISIBLE);
                    GreetingCardEditActivity.this.mainTextNonStrike.setVisibility(View.GONE);
                    GreetingCardEditActivity.this.getLastTouchedEditTextView().setPaintFlags(GreetingCardEditActivity.this.getLastTouchedEditTextView().getPaintFlags() & -17);
                    return;
                }
                Toast.makeText(GreetingCardEditActivity.this.context, "Please select a text.", Toast.LENGTH_SHORT).show();
            }
        });
        this.moreNonBoldText.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (GreetingCardEditActivity.this.getLastTouchedEditTextView() != null) {
                    GreetingCardEditActivity.this.subBoldText.setVisibility(View.VISIBLE);
                    GreetingCardEditActivity.this.moreNonBoldText.setVisibility(View.GONE);
                    GreetingCardEditActivity.this.getLastTouchedEditTextView().setTypeface((Typeface) null);
                    GreetingCardEditActivity.this.getLastTouchedEditTextView().setTypeface(GreetingCardEditActivity.this.getLastTouchedEditTextView().getTypeface(), Typeface.NORMAL);
                    return;
                }
                Toast.makeText(GreetingCardEditActivity.this.context, "Please select a text.", Toast.LENGTH_SHORT).show();
            }
        });
        this.moreNonItalicText.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (GreetingCardEditActivity.this.getLastTouchedEditTextView() != null) {
                    GreetingCardEditActivity.this.subItalicText.setVisibility(View.VISIBLE);
                    GreetingCardEditActivity.this.moreNonItalicText.setVisibility(View.GONE);
                    GreetingCardEditActivity.this.getLastTouchedEditTextView().setTypeface((Typeface) null);
                    GreetingCardEditActivity.this.getLastTouchedEditTextView().setTypeface(GreetingCardEditActivity.this.getLastTouchedEditTextView().getTypeface(), Typeface.NORMAL);
                    return;
                }
                Toast.makeText(GreetingCardEditActivity.this.context, "Please select a text.", Toast.LENGTH_SHORT).show();
            }
        });
        this.moreTextNoUnderline.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (GreetingCardEditActivity.this.getLastTouchedEditTextView() != null) {
                    GreetingCardEditActivity.this.subTextUnderline.setVisibility(View.VISIBLE);
                    GreetingCardEditActivity.this.moreTextNoUnderline.setVisibility(View.GONE);
                    GreetingCardEditActivity.this.getLastTouchedEditTextView().setTypeface((Typeface) null);
                    GreetingCardEditActivity.this.getLastTouchedEditTextView().setPaintFlags(GreetingCardEditActivity.this.getLastTouchedEditTextView().getPaintFlags() & -9);
                    return;
                }
                Toast.makeText(GreetingCardEditActivity.this.context, "Please select a text.", Toast.LENGTH_SHORT).show();
            }
        });
        this.moreTextNonStrike.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (GreetingCardEditActivity.this.getLastTouchedEditTextView() != null) {
                    GreetingCardEditActivity.this.subTextStrike.setVisibility(View.VISIBLE);
                    GreetingCardEditActivity.this.moreTextNonStrike.setVisibility(View.GONE);
                    GreetingCardEditActivity.this.getLastTouchedEditTextView().setPaintFlags(GreetingCardEditActivity.this.getLastTouchedEditTextView().getPaintFlags() & -17);
                    return;
                }
                Toast.makeText(GreetingCardEditActivity.this.context, "Please select a text.", Toast.LENGTH_SHORT).show();
            }
        });
        this.textFont.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                GreetingCardEditActivity.this.fontsLinear.setVisibility(View.VISIBLE);
                GreetingCardEditActivity.this.colorsSuperLinearLayout.setVisibility(View.GONE);
                GreetingCardEditActivity.this.textSizeSeekBar.setVisibility(View.GONE);
            }
        });
        this.textColor.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                GreetingCardEditActivity.this.fontsLinear.setVisibility(View.GONE);
                GreetingCardEditActivity.this.colorsSuperLinearLayout.setVisibility(View.VISIBLE);
                GreetingCardEditActivity.this.textSizeSeekBar.setVisibility(View.GONE);
            }
        });
        this.textSize.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                GreetingCardEditActivity.this.fontsLinear.setVisibility(View.GONE);
                GreetingCardEditActivity.this.colorsSuperLinearLayout.setVisibility(View.GONE);
                GreetingCardEditActivity.this.textSizeSeekBar.setVisibility(View.VISIBLE);
            }
        });
        this.subTextColor.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                GreetingCardEditActivity.this.colorSeekBar.setVisibility(View.VISIBLE);
                GreetingCardEditActivity.this.horizontalScrollView.setVisibility(View.GONE);
                GreetingCardEditActivity.this.shadowLinerLayout.setVisibility(View.GONE);
            }
        });
        this.subTextGradient.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                GreetingCardEditActivity.this.colorSeekBar.setVisibility(View.GONE);
                GreetingCardEditActivity.this.horizontalScrollView.setVisibility(View.VISIBLE);
                GreetingCardEditActivity.this.shadowLinerLayout.setVisibility(View.GONE);
            }
        });
        this.subTextShadow.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                GreetingCardEditActivity.this.colorSeekBar.setVisibility(View.GONE);
                GreetingCardEditActivity.this.horizontalScrollView.setVisibility(View.GONE);
                GreetingCardEditActivity.this.shadowLinerLayout.setVisibility(View.VISIBLE);
            }
        });
        this.colorSeekBar.setOnColorChangeListener(new ColorSeekBar.OnColorChangeListener() {


            EditText f174et = ((EditText) GreetingCardEditActivity.this.stickerViewContainer.getChildAt(GreetingCardEditActivity.this.stickerViewContainer.indexOfChild(GreetingCardEditActivity.this.lastTouchedView)));

            public void onColorChangeListener(int i, int i2, int i3) {
                if (GreetingCardEditActivity.this.lastTouchedView != null) {
                    if (GreetingCardEditActivity.this.isShaderApplied) {
                        GreetingCardEditActivity.this.getLastTouchedEditTextView().getPaint().setShader((Shader) null);
                        GreetingCardEditActivity.this.isShaderApplied = false;
                    }
                    if (GreetingCardEditActivity.this.getLastTouchedEditTextView() != null) {
                        GreetingCardEditActivity.this.getLastTouchedEditTextView().setTextColor(i3);
                    }
                    GreetingCardEditActivity.this.displaySelectedFontColor.setBackgroundColor(i3);
                }
            }
        });
        this.shadowColor.setOnColorChangeListener(new ColorSeekBar.OnColorChangeListener() {
            public void onColorChangeListener(int i, int i2, int i3) {
                int unused = GreetingCardEditActivity.this.SHADOW_COLOR = i3;
                if (GreetingCardEditActivity.this.lastTouchedView != null) {
                    if (GreetingCardEditActivity.this.isShaderApplied) {
                        GreetingCardEditActivity.this.getLastTouchedEditTextView().getPaint().setShader((Shader) null);
                        GreetingCardEditActivity.this.isShaderApplied = false;
                    }
                    GreetingCardEditActivity.this.getLastTouchedEditTextView().setShadowLayer(1.0f, (float) GreetingCardEditActivity.this.SHADOW_PROGRESS, (float) GreetingCardEditActivity.this.SHADOW_PROGRESS, GreetingCardEditActivity.this.SHADOW_COLOR);
                    GreetingCardEditActivity.this.displaySelectedFontShadowColor.setBackgroundColor(GreetingCardEditActivity.this.SHADOW_COLOR);
                }
            }
        });
        this.textSizeSeekBar.setMax(40);
        this.textSizeSeekBar.setProgress(14);
        this.textSizeSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            /* renamed from: et */
            EditText f175et = ((EditText) GreetingCardEditActivity.this.stickerViewContainer.getChildAt(GreetingCardEditActivity.this.stickerViewContainer.indexOfChild(GreetingCardEditActivity.this.lastTouchedView)));

            public void onStartTrackingTouch(SeekBar seekBar) {
                Log.e("f","");
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                Log.e("f","");
            }

            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (i > 10 && GreetingCardEditActivity.this.lastTouchedView != null) {
                    GreetingCardEditActivity.this.getLastTouchedEditTextView().setTextSize((float) i);
                    TextView textView = GreetingCardEditActivity.this.fontSizeSelection;
                    textView.setText("" + i);
                }
            }
        });
        this.shadowRadius.setMax(25);
        this.shadowRadius.setProgress(1);
        this.shadowRadius.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onStartTrackingTouch(SeekBar seekBar) {
                Log.e("f","");
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                Log.e("f","");
            }

            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                int unused = GreetingCardEditActivity.this.SHADOW_PROGRESS = i;
                if (i > 1 && GreetingCardEditActivity.this.lastTouchedView != null) {
                    GreetingCardEditActivity.this.getLastTouchedEditTextView().setShadowLayer(1.0f, (float) GreetingCardEditActivity.this.SHADOW_PROGRESS, (float) GreetingCardEditActivity.this.SHADOW_PROGRESS, GreetingCardEditActivity.this.SHADOW_COLOR);
                }
            }
        });
        RelativeLayout relativeLayout = this.editCardContainer;
        EditText editText = (EditText) relativeLayout.getChildAt(relativeLayout.indexOfChild(this.lastTouchedView));
        this.font1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (GreetingCardEditActivity.this.lastTouchedView != null) {
                    Typeface font = ResourcesCompat.getFont(GreetingCardEditActivity.this, R.font.alger);
                    GreetingCardEditActivity.this.fontStyleSelection.setText("alger");
                    GreetingCardEditActivity.this.fontStyleSelection.setTypeface(font);
                    GreetingCardEditActivity.this.getLastTouchedEditTextView().setTypeface(font);
                    return;
                }
                Toast.makeText(GreetingCardEditActivity.this.context, "Please select any text box..", Toast.LENGTH_SHORT).show();
            }
        });
        this.font2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (GreetingCardEditActivity.this.lastTouchedView != null) {
                    Typeface font = ResourcesCompat.getFont(GreetingCardEditActivity.this, R.font.britanic);
                    GreetingCardEditActivity.this.fontStyleSelection.setText("britanic");
                    GreetingCardEditActivity.this.fontStyleSelection.setTypeface(font);
                    GreetingCardEditActivity.this.getLastTouchedEditTextView().setTypeface(font);
                    return;
                }
                Toast.makeText(GreetingCardEditActivity.this.context, "Please select any text box..", Toast.LENGTH_SHORT).show();
            }
        });
        this.font3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (GreetingCardEditActivity.this.lastTouchedView != null) {
                    Typeface font = ResourcesCompat.getFont(GreetingCardEditActivity.this, R.font.frscript);
                    GreetingCardEditActivity.this.fontStyleSelection.setText("fr-script");
                    GreetingCardEditActivity.this.fontStyleSelection.setTypeface(font);
                    GreetingCardEditActivity.this.getLastTouchedEditTextView().setTypeface(font);
                    return;
                }
                Toast.makeText(GreetingCardEditActivity.this.context, "Please select any text box..", Toast.LENGTH_SHORT).show();
            }
        });
        this.font4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (GreetingCardEditActivity.this.lastTouchedView != null) {
                    Typeface font = ResourcesCompat.getFont(GreetingCardEditActivity.this, R.font.gil);
                    GreetingCardEditActivity.this.fontStyleSelection.setText("gil");
                    GreetingCardEditActivity.this.fontStyleSelection.setTypeface(font);
                    GreetingCardEditActivity.this.getLastTouchedEditTextView().setTypeface(font);
                    return;
                }
                Toast.makeText(GreetingCardEditActivity.this.context, "Please select any text box..", Toast.LENGTH_SHORT).show();
            }
        });
        this.font5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (GreetingCardEditActivity.this.lastTouchedView != null) {
                    Typeface font = ResourcesCompat.getFont(GreetingCardEditActivity.this, R.font.harngton);
                    GreetingCardEditActivity.this.fontStyleSelection.setText("harngton");
                    GreetingCardEditActivity.this.fontStyleSelection.setTypeface(font);
                    GreetingCardEditActivity.this.getLastTouchedEditTextView().setTypeface(font);
                    return;
                }
                Toast.makeText(GreetingCardEditActivity.this.context, "Please select any text box..", Toast.LENGTH_SHORT).show();
            }
        });
        this.font6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (GreetingCardEditActivity.this.lastTouchedView != null) {
                    Typeface font = ResourcesCompat.getFont(GreetingCardEditActivity.this, R.font.mtcorsva);
                    GreetingCardEditActivity.this.fontStyleSelection.setText("mt corsva");
                    GreetingCardEditActivity.this.fontStyleSelection.setTypeface(font);
                    GreetingCardEditActivity.this.getLastTouchedEditTextView().setTypeface(font);
                    return;
                }
                Toast.makeText(GreetingCardEditActivity.this.context, "Please select any text box..", Toast.LENGTH_SHORT).show();
            }
        });
        this.font7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (GreetingCardEditActivity.this.lastTouchedView != null) {
                    Typeface font = ResourcesCompat.getFont(GreetingCardEditActivity.this, R.font.ottumhmkbold);
                    GreetingCardEditActivity.this.fontStyleSelection.setText("ottumhmk-bold");
                    GreetingCardEditActivity.this.fontStyleSelection.setTypeface(font);
                    GreetingCardEditActivity.this.getLastTouchedEditTextView().setTypeface(font);
                    return;
                }
                Toast.makeText(GreetingCardEditActivity.this.context, "Please select any text box..", Toast.LENGTH_SHORT).show();
            }
        });
        this.font8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (GreetingCardEditActivity.this.lastTouchedView != null) {
                    Typeface font = ResourcesCompat.getFont(GreetingCardEditActivity.this, R.font.roboto_medium);
                    GreetingCardEditActivity.this.fontStyleSelection.setText("roboto-medium");
                    GreetingCardEditActivity.this.fontStyleSelection.setTypeface(font);
                    GreetingCardEditActivity.this.getLastTouchedEditTextView().setTypeface(font);
                    return;
                }
                Toast.makeText(GreetingCardEditActivity.this.context, "Please select any text box..", Toast.LENGTH_SHORT).show();
            }
        });
        this.backToMain.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                GreetingCardEditActivity.this.onBackPressed();
            }
        });
    }


    public void clearHighlights() {
        this.edit_text_ic.setAlpha(0.0f);
        this.edit_text_ic.setVisibility(View.GONE);
        switch (this.anInt) {
            case 1:
                this.ed1.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.img_highlight_2));
                this.ed1.setPadding(50, 15, 50, 15);
                return;
            case 2:
                this.ed1.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.img_highlight_2));
                this.ed2.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.img_highlight_2));
                this.ed1.setPadding(50, 15, 50, 15);
                this.ed1.setPadding(50, 15, 50, 15);
                this.ed2.setPadding(50, 15, 50, 15);
                return;
            case 3:
                this.ed1.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.img_highlight_2));
                this.ed2.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.img_highlight_2));
                this.ed3.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.img_highlight_2));
                this.ed1.setPadding(50, 15, 50, 15);
                this.ed2.setPadding(50, 15, 50, 15);
                this.ed3.setPadding(50, 15, 50, 15);
                return;
            case 4:
                this.ed1.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.img_highlight_2));
                this.ed2.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.img_highlight_2));
                this.ed3.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.img_highlight_2));
                this.ed4.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.img_highlight_2));
                this.ed1.setPadding(50, 15, 50, 15);
                this.ed2.setPadding(50, 15, 50, 15);
                this.ed3.setPadding(50, 15, 50, 15);
                this.ed4.setPadding(50, 15, 50, 15);
                return;
            case 5:
                this.ed1.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.img_highlight_2));
                this.ed2.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.img_highlight_2));
                this.ed3.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.img_highlight_2));
                this.ed4.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.img_highlight_2));
                this.ed5.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.img_highlight_2));
                this.ed1.setPadding(50, 15, 50, 15);
                this.ed2.setPadding(50, 15, 50, 15);
                this.ed3.setPadding(50, 15, 50, 15);
                this.ed4.setPadding(50, 15, 50, 15);
                this.ed5.setPadding(50, 15, 50, 15);
                return;
            case 6:
                this.ed1.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.img_highlight_2));
                this.ed2.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.img_highlight_2));
                this.ed3.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.img_highlight_2));
                this.ed4.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.img_highlight_2));
                this.ed5.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.img_highlight_2));
                this.ed6.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.img_highlight_2));
                this.ed1.setPadding(50, 15, 50, 15);
                this.ed2.setPadding(50, 15, 50, 15);
                this.ed3.setPadding(50, 15, 50, 15);
                this.ed4.setPadding(50, 15, 50, 15);
                this.ed5.setPadding(50, 15, 50, 15);
                this.ed6.setPadding(50, 15, 50, 15);
                return;
            case 7:
                this.ed1.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.img_highlight_2));
                this.ed2.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.img_highlight_2));
                this.ed3.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.img_highlight_2));
                this.ed4.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.img_highlight_2));
                this.ed5.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.img_highlight_2));
                this.ed6.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.img_highlight_2));
                this.ed7.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.img_highlight_2));
                this.ed1.setPadding(50, 15, 50, 15);
                this.ed2.setPadding(50, 15, 50, 15);
                this.ed3.setPadding(50, 15, 50, 15);
                this.ed4.setPadding(50, 15, 50, 15);
                this.ed5.setPadding(50, 15, 50, 15);
                this.ed6.setPadding(50, 15, 50, 15);
                this.ed7.setPadding(50, 15, 50, 15);
                return;
            default:
                return;
        }
    }

    private void decreaseTextSize(int i) {
        switch (this.anInt) {
            case 1:
                EditText editText = this.ed1;
                editText.setTextSize((editText.getTextSize() / 3.0f) - ((float) i));
                return;
            case 2:
                EditText editText2 = this.ed1;
                float f = (float) i;
                editText2.setTextSize((editText2.getTextSize() / 3.0f) - f);
                EditText editText3 = this.ed2;
                editText3.setTextSize((editText3.getTextSize() / 3.0f) - f);
                return;
            case 3:
                EditText editText4 = this.ed1;
                float f2 = (float) i;
                editText4.setTextSize((editText4.getTextSize() / 3.0f) - f2);
                EditText editText5 = this.ed2;
                editText5.setTextSize((editText5.getTextSize() / 3.0f) - f2);
                EditText editText6 = this.ed3;
                editText6.setTextSize((editText6.getTextSize() / 3.0f) - f2);
                return;
            case 4:
                EditText editText7 = this.ed1;
                float f3 = (float) i;
                editText7.setTextSize((editText7.getTextSize() / 3.0f) - f3);
                EditText editText8 = this.ed2;
                editText8.setTextSize((editText8.getTextSize() / 3.0f) - f3);
                EditText editText9 = this.ed3;
                editText9.setTextSize((editText9.getTextSize() / 3.0f) - f3);
                EditText editText10 = this.ed4;
                editText10.setTextSize((editText10.getTextSize() / 3.0f) - f3);
                return;
            case 5:
                EditText editText11 = this.ed1;
                float f4 = (float) i;
                editText11.setTextSize((editText11.getTextSize() / 3.0f) - f4);
                EditText editText12 = this.ed2;
                editText12.setTextSize((editText12.getTextSize() / 3.0f) - f4);
                EditText editText13 = this.ed3;
                editText13.setTextSize((editText13.getTextSize() / 3.0f) - f4);
                EditText editText14 = this.ed4;
                editText14.setTextSize((editText14.getTextSize() / 3.0f) - f4);
                EditText editText15 = this.ed5;
                editText15.setTextSize((editText15.getTextSize() / 3.0f) - f4);
                return;
            case 6:
                EditText editText16 = this.ed1;
                float f5 = (float) i;
                editText16.setTextSize((editText16.getTextSize() / 3.0f) - f5);
                EditText editText17 = this.ed2;
                editText17.setTextSize((editText17.getTextSize() / 3.0f) - f5);
                EditText editText18 = this.ed3;
                editText18.setTextSize((editText18.getTextSize() / 3.0f) - f5);
                EditText editText19 = this.ed4;
                editText19.setTextSize((editText19.getTextSize() / 3.0f) - f5);
                EditText editText20 = this.ed5;
                editText20.setTextSize((editText20.getTextSize() / 3.0f) - f5);
                EditText editText21 = this.ed6;
                editText21.setTextSize((editText21.getTextSize() / 3.0f) - f5);
                return;
            case 7:
                EditText editText22 = this.ed1;
                float f6 = (float) i;
                editText22.setTextSize((editText22.getTextSize() / 3.0f) - f6);
                EditText editText23 = this.ed2;
                editText23.setTextSize((editText23.getTextSize() / 3.0f) - f6);
                EditText editText24 = this.ed3;
                editText24.setTextSize((editText24.getTextSize() / 3.0f) - f6);
                EditText editText25 = this.ed4;
                editText25.setTextSize((editText25.getTextSize() / 3.0f) - f6);
                EditText editText26 = this.ed5;
                editText26.setTextSize((editText26.getTextSize() / 3.0f) - f6);
                EditText editText27 = this.ed6;
                editText27.setTextSize((editText27.getTextSize() / 3.0f) - f6);
                EditText editText28 = this.ed7;
                editText28.setTextSize((editText28.getTextSize() / 3.0f) - f6);
                return;
            default:
                return;
        }
    }


    public EditText setNewEditText() {
        this.counter++;
        EditText editText = new EditText(this);
        editText.setId(this.counter);
        editText.setTextColor(ContextCompat.getColor(this, R.color.white));
        editText.setGravity(17);
        editText.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.edit_text_back_1));
        editText.setTextSize(18.0f);
        editText.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        editText.setPadding(50, 15, 50, 15);
        editText.setText("enter text here" + this.counter);
        this.stickerViewContainer.addView(editText);
        return editText;
    }

    private void setLastTouchedView(View view2) {
        this.lastTouchedView = view2;
    }

    public EditText getLastTouchedEditTextView() {
        View view2 = this.lastTouchedView;
        if (view2 == null) {
            return null;
        }
        if (this.ed1 != null && view2.getId() == this.ed1.getId()) {
            return this.ed1;
        }
        if (this.ed2 != null && this.lastTouchedView.getId() == this.ed2.getId()) {
            return this.ed2;
        }
        if (this.ed3 != null && this.lastTouchedView.getId() == this.ed3.getId()) {
            return this.ed3;
        }
        if (this.ed4 != null && this.lastTouchedView.getId() == this.ed4.getId()) {
            return this.ed4;
        }
        if (this.ed5 != null && this.lastTouchedView.getId() == this.ed5.getId()) {
            return this.ed5;
        }
        if (this.ed6 != null && this.lastTouchedView.getId() == this.ed6.getId()) {
            return this.ed6;
        }
        if (this.ed7 != null && this.lastTouchedView.getId() == this.ed7.getId()) {
            return this.ed7;
        }
        FrameLayout frameLayout = this.stickerViewContainer;
        return (EditText) frameLayout.getChildAt(frameLayout.indexOfChild(this.lastTouchedView));
    }

    private void initializeStickerView() {
        this.weddingStickers = (TextView) findViewById(R.id.wedding_stickers);
        this.engagementStickers = (TextView) findViewById(R.id.engagement_stickers);
        this.anniversaryStickers = (TextView) findViewById(R.id.anniversary_stickers);
        this.birthdayStickers = (TextView) findViewById(R.id.birthday_stickers);
        this.houseWarmingStickers = (TextView) findViewById(R.id.house_warming_stickers);
        setWeddingStickerResources(this.stickersPrevRecycler);
        setEngagementStickerResources(this.engStickersPrevRecycler);
        setBirthdayStickerResources(this.birStickersPrevRecycler);
        setAnniversaryStickerResources(this.annStickersPrevRecycler);
        setHouseWarmingStickerResources(this.hwStickersPrevRecycler);
        this.weddingStickers.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                GreetingCardEditActivity.this.weddingStickers.setBackgroundColor(GreetingCardEditActivity.this.getResources().getColor(R.color.grey));
                GreetingCardEditActivity.this.engagementStickers.setBackground(ContextCompat.getDrawable(GreetingCardEditActivity.this.context, R.drawable.sticker_text_back));
                GreetingCardEditActivity.this.birthdayStickers.setBackground(ContextCompat.getDrawable(GreetingCardEditActivity.this.context, R.drawable.sticker_text_back));
                GreetingCardEditActivity.this.anniversaryStickers.setBackground(ContextCompat.getDrawable(GreetingCardEditActivity.this.context, R.drawable.sticker_text_back));
                GreetingCardEditActivity.this.houseWarmingStickers.setBackground(ContextCompat.getDrawable(GreetingCardEditActivity.this.context, R.drawable.sticker_text_back));
                GreetingCardEditActivity.this.updateStickerViewLayouts("wedding_stickers");
            }
        });
        this.engagementStickers.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                GreetingCardEditActivity.this.engagementStickers.setBackgroundColor(GreetingCardEditActivity.this.getResources().getColor(R.color.grey));
                GreetingCardEditActivity.this.weddingStickers.setBackground(ContextCompat.getDrawable(GreetingCardEditActivity.this.context, R.drawable.sticker_text_back));
                GreetingCardEditActivity.this.birthdayStickers.setBackground(ContextCompat.getDrawable(GreetingCardEditActivity.this.context, R.drawable.sticker_text_back));
                GreetingCardEditActivity.this.anniversaryStickers.setBackground(ContextCompat.getDrawable(GreetingCardEditActivity.this.context, R.drawable.sticker_text_back));
                GreetingCardEditActivity.this.houseWarmingStickers.setBackground(ContextCompat.getDrawable(GreetingCardEditActivity.this.context, R.drawable.sticker_text_back));
                GreetingCardEditActivity.this.updateStickerViewLayouts("engagement_stickers");
            }
        });
        this.birthdayStickers.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                GreetingCardEditActivity.this.birthdayStickers.setBackgroundColor(GreetingCardEditActivity.this.getResources().getColor(R.color.grey));
                GreetingCardEditActivity.this.weddingStickers.setBackground(ContextCompat.getDrawable(GreetingCardEditActivity.this.context, R.drawable.sticker_text_back));
                GreetingCardEditActivity.this.engagementStickers.setBackground(ContextCompat.getDrawable(GreetingCardEditActivity.this.context, R.drawable.sticker_text_back));
                GreetingCardEditActivity.this.anniversaryStickers.setBackground(ContextCompat.getDrawable(GreetingCardEditActivity.this.context, R.drawable.sticker_text_back));
                GreetingCardEditActivity.this.houseWarmingStickers.setBackground(ContextCompat.getDrawable(GreetingCardEditActivity.this.context, R.drawable.sticker_text_back));
                GreetingCardEditActivity.this.updateStickerViewLayouts("birthday_stickers");
            }
        });
        this.anniversaryStickers.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                GreetingCardEditActivity.this.anniversaryStickers.setBackgroundColor(GreetingCardEditActivity.this.getResources().getColor(R.color.grey));
                GreetingCardEditActivity.this.weddingStickers.setBackground(ContextCompat.getDrawable(GreetingCardEditActivity.this.context, R.drawable.sticker_text_back));
                GreetingCardEditActivity.this.engagementStickers.setBackground(ContextCompat.getDrawable(GreetingCardEditActivity.this.context, R.drawable.sticker_text_back));
                GreetingCardEditActivity.this.birthdayStickers.setBackground(ContextCompat.getDrawable(GreetingCardEditActivity.this.context, R.drawable.sticker_text_back));
                GreetingCardEditActivity.this.houseWarmingStickers.setBackground(ContextCompat.getDrawable(GreetingCardEditActivity.this.context, R.drawable.sticker_text_back));
                GreetingCardEditActivity.this.updateStickerViewLayouts("anniversary_stickers");
            }
        });
        this.houseWarmingStickers.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                GreetingCardEditActivity.this.houseWarmingStickers.setBackgroundColor(GreetingCardEditActivity.this.getResources().getColor(R.color.grey));
                GreetingCardEditActivity.this.weddingStickers.setBackground(ContextCompat.getDrawable(GreetingCardEditActivity.this.context, R.drawable.sticker_text_back));
                GreetingCardEditActivity.this.engagementStickers.setBackground(ContextCompat.getDrawable(GreetingCardEditActivity.this.context, R.drawable.sticker_text_back));
                GreetingCardEditActivity.this.birthdayStickers.setBackground(ContextCompat.getDrawable(GreetingCardEditActivity.this.context, R.drawable.sticker_text_back));
                GreetingCardEditActivity.this.anniversaryStickers.setBackground(ContextCompat.getDrawable(GreetingCardEditActivity.this.context, R.drawable.sticker_text_back));
                GreetingCardEditActivity.this.updateStickerViewLayouts("house_warming_stickers");
            }
        });
        this.stickerViewContainer.setDrawingCacheEnabled(true);
        this.stickerViewContainer.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        FrameLayout frameLayout = this.stickerViewContainer;
        frameLayout.layout(0, 0, frameLayout.getMeasuredWidth(), this.stickerViewContainer.getMeasuredHeight());
        this.stickerViewContainer.buildDrawingCache(true);
    }


    public void updateStickerViewLayouts(String str) {
        this.mResources = new ArrayList<>();
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 6);
        if (str.equals("wedding_stickers")) {
            setWeddingStickerResources((RecyclerView) null);
        } else if (str.equals("engagement_stickers")) {
            setEngagementStickerResources((RecyclerView) null);
        } else if (str.equals("birthday_stickers")) {
            setBirthdayStickerResources((RecyclerView) null);
        } else if (str.equals("anniversary_stickers")) {
            setAnniversaryStickerResources((RecyclerView) null);
        } else if (str.equals("house_warming_stickers")) {
            setHouseWarmingStickerResources((RecyclerView) null);
        }
        this.stickerPreviewAdapter = new StickerPreViewAdapter(this, this.mResources, str);
        new LinearLayoutManager(this).setOrientation(RecyclerView.VERTICAL);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            public int getSpanSize(int i) {
                return 1;
            }
        });
        this.stickersPrevRecycler.setLayoutManager(gridLayoutManager);
        this.stickersPrevRecycler.setHasFixedSize(true);
        this.stickersPrevRecycler.setItemViewCacheSize(20);
        this.stickersPrevRecycler.setAdapter(this.stickerPreviewAdapter);
    }

    private void setWeddingStickerResources(RecyclerView recyclerView) {
        this.mResources = new ArrayList<>();
        for (int i = 2; i <= 36; i++) {
            ArrayList<Integer> arrayList = this.mResources;
            Resources resources = getResources();
            arrayList.add(Integer.valueOf(resources.getIdentifier("wed_" + i, "drawable", ((Context) Objects.requireNonNull(this.context)).getPackageName())));
        }
        if (recyclerView != null) {
            setStickerAdapter(this.mResources, recyclerView);
        }
    }

    private void setEngagementStickerResources(RecyclerView recyclerView) {
        for (int i = 1; i <= 36; i++) {
            ArrayList<Integer> arrayList = this.mResources;
            Resources resources = getResources();
            arrayList.add(Integer.valueOf(resources.getIdentifier("eng_" + i, "drawable", ((Context) Objects.requireNonNull(this.context)).getPackageName())));
        }
        if (recyclerView != null) {
            setStickerAdapter(this.mResources, recyclerView);
        }
    }

    private void setBirthdayStickerResources(RecyclerView recyclerView) {
        for (int i = 1; i <= 36; i++) {
            ArrayList<Integer> arrayList = this.mResources;
            Resources resources = getResources();
            arrayList.add(Integer.valueOf(resources.getIdentifier("bday_" + i, "drawable", ((Context) Objects.requireNonNull(this.context)).getPackageName())));
        }
        if (recyclerView != null) {
            setStickerAdapter(this.mResources, recyclerView);
        }
    }

    private void setAnniversaryStickerResources(RecyclerView recyclerView) {
        for (int i = 1; i <= 36; i++) {
            ArrayList<Integer> arrayList = this.mResources;
            Resources resources = getResources();
            arrayList.add(Integer.valueOf(resources.getIdentifier("ani_" + i, "drawable", ((Context) Objects.requireNonNull(this.context)).getPackageName())));
        }
        if (recyclerView != null) {
            setStickerAdapter(this.mResources, recyclerView);
        }
    }

    private void setHouseWarmingStickerResources(RecyclerView recyclerView) {
        for (int i = 1; i <= 36; i++) {
            ArrayList<Integer> arrayList = this.mResources;
            Resources resources = getResources();
            arrayList.add(Integer.valueOf(resources.getIdentifier("hw_" + i, "drawable", ((Context) Objects.requireNonNull(this.context)).getPackageName())));
        }
        if (recyclerView != null) {
            setStickerAdapter(this.mResources, recyclerView);
        }
    }

    private void setStickerAdapter(ArrayList<Integer> arrayList, RecyclerView recyclerView) {
        this.stickerPreviewAdapter = new StickerPreViewAdapter(this, arrayList, this.type);
        new LinearLayoutManager(this).setOrientation(RecyclerView.VERTICAL);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 6);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            public int getSpanSize(int i) {
                return 1;
            }
        });
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemViewCacheSize(20);
        recyclerView.setAdapter(this.stickerPreviewAdapter);
    }

    public void setGreetingCard(String str, int i) {
        LayoutInflater from2 = LayoutInflater.from(this);
        int i2 = 0;
        if (!str.equals("own_card") || i < 0) {
            if (!str.equals("wedding_card") || i < 0) {
                if (!str.equals("birthday_card") || i < 0) {
                    if (!str.equals("anniversary_card") || i < 0) {
                        if (!str.equals("housewarming_card") || i < 0) {
                            if (str.equals("engagement_card") && i >= 0) {
                                switch (i) {
                                    case 0:
                                        i2 = R.layout.engagement_card_1;
                                        break;
                                    case 1:
                                        i2 = R.layout.engagement_card_2;
                                        break;
                                    case 2:
                                        i2 = R.layout.engagement_card_3;
                                        break;
                                    case 3:
                                        i2 = R.layout.engagement_card_4;
                                        break;
                                    case 4:
                                        i2 = R.layout.engagement_card_5;
                                        break;
                                    case 5:
                                        i2 = R.layout.engagement_card_6;
                                        break;
                                    case 6:
                                        i2 = R.layout.engagement_card_7;
                                        break;
                                    case 7:
                                        i2 = R.layout.engagement_card_8;
                                        break;
                                    case 8:
                                        i2 = R.layout.engagement_card_9;
                                        break;
                                    case 9:
                                        i2 = R.layout.engagement_card_10;
                                        break;
                                }
                            }
                        } else {
                            switch (i) {
                                case 0:
                                    i2 = R.layout.house_warming_card_1;
                                    break;
                                case 1:
                                    i2 = R.layout.house_warming_card_2;
                                    break;
                                case 2:
                                    i2 = R.layout.house_warming_card_3;
                                    break;
                                case 3:
                                    i2 = R.layout.house_warming_card_4;
                                    break;
                                case 4:
                                    i2 = R.layout.house_warming_card_5;
                                    break;
                                case 5:
                                    i2 = R.layout.house_warming_card_6;
                                    break;
                                case 6:
                                    i2 = R.layout.house_warming_card_7;
                                    break;
                                case 7:
                                    i2 = R.layout.house_warming_card_8;
                                    break;
                                case 8:
                                    i2 = R.layout.house_warming_card_9;
                                    break;
                                case 9:
                                    i2 = R.layout.house_warming_card_10;
                                    break;
                            }
                        }
                    } else {
                        switch (i) {
                            case 0:
                                i2 = R.layout.anniversary_card_11;
                                break;
                            case 1:
                                i2 = R.layout.anniversary_card_12;
                                break;
                            case 2:
                                i2 = R.layout.anniversary_card_13;
                                break;
                            case 3:
                                i2 = R.layout.anniversary_card_14;
                                break;
                            case 4:
                                i2 = R.layout.anniversary_card_15;
                                break;
                            case 5:
                                i2 = R.layout.anniversary_card_1;
                                break;
                            case 6:
                                i2 = R.layout.anniversary_card_2;
                                break;
                            case 7:
                                i2 = R.layout.anniversary_card_6;
                                break;
                            case 8:
                                i2 = R.layout.anniversary_card_9;
                                break;
                            case 9:
                                i2 = R.layout.anniversary_card_10;
                                break;
                        }
                    }
                } else {
                    switch (i) {
                        case 0:
                            i2 = R.layout.birthday_card_1;
                            break;
                        case 1:
                            i2 = R.layout.birthday_card_2;
                            break;
                        case 2:
                            i2 = R.layout.birthday_card_3;
                            break;
                        case 3:
                            i2 = R.layout.birthday_card_4;
                            break;
                        case 4:
                            i2 = R.layout.birthday_card_5;
                            break;
                        case 5:
                            i2 = R.layout.birthday_card_6;
                            break;
                        case 6:
                            i2 = R.layout.birthday_card_7;
                            break;
                        case 7:
                            i2 = R.layout.birthday_card_8;
                            break;
                        case 8:
                            i2 = R.layout.birthday_card_9;
                            break;
                        case 9:
                            i2 = R.layout.birthday_card_10;
                            break;
                    }
                }
            } else {
                switch (i) {
                    case 0:
                        i2 = R.layout.wedding_card_1;
                        break;
                    case 1:
                        i2 = R.layout.wedding_card_2;
                        break;
                    case 2:
                        i2 = R.layout.wedding_card_3;
                        break;
                    case 3:
                        i2 = R.layout.wedding_card_4;
                        break;
                    case 4:
                        i2 = R.layout.wedding_card_5;
                        break;
                    case 5:
                        i2 = R.layout.wedding_card_6;
                        break;
                    case 6:
                        i2 = R.layout.wedding_card_7;
                        break;
                    case 7:
                        i2 = R.layout.wedding_card_8;
                        break;
                    case 8:
                        i2 = R.layout.wedding_card_9;
                        break;
                    case 9:
                        i2 = R.layout.wedding_card_10;
                        break;
                }
            }
        } else {
            switch (i) {
                case 101:
                    i2 = R.layout.create_blank_card;
                    setCreateCardLayout(101, 4, 50);
                    break;
                case 102:
                    i2 = R.layout.create_landscape_card;
                    setCreateCardLayout(102, 3, 100);
                    break;
                case 103:
                    i2 = R.layout.create_portrait_card;
                    setCreateCardLayout(103, 15, 10);
                    break;
                case 104:
                    i2 = R.layout.create_square_card;
                    setCreateCardLayout(104, 5, 50);
                    break;
                case 105:
                    i2 = R.layout.create_insta_story_card;
                    setCreateCardLayout(105, 10, 8);
                    break;
            }
        }
        this.greetingCardView = from2.inflate(i2, (ViewGroup) null);
        setGreetingCardLayout(this.TYPE, i);
    }

    private void setCreateCardLayout(int i, int i2, int i3) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.editCardContainer.getLayoutParams();
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        layoutParams.width = displayMetrics.widthPixels;
        layoutParams.height = displayMetrics.heightPixels;
        if (i == 103) {
            layoutParams.topMargin = (displayMetrics.heightPixels / i2) + (displayMetrics.heightPixels / 20);
            layoutParams.bottomMargin = (displayMetrics.heightPixels / i2) + (displayMetrics.heightPixels / 20);
            layoutParams.leftMargin = displayMetrics.widthPixels / i3;
            layoutParams.rightMargin = displayMetrics.widthPixels / i3;
        } else if (i == 104) {
            layoutParams.topMargin = (displayMetrics.heightPixels / i2) + (displayMetrics.heightPixels / 15);
            layoutParams.bottomMargin = (displayMetrics.heightPixels / i2) + (displayMetrics.heightPixels / 15);
            layoutParams.leftMargin = displayMetrics.widthPixels / i3;
            layoutParams.rightMargin = displayMetrics.widthPixels / i3;
        } else {
            layoutParams.topMargin = displayMetrics.heightPixels / i2;
            layoutParams.bottomMargin = displayMetrics.heightPixels / i2;
            layoutParams.leftMargin = displayMetrics.widthPixels / i3;
            layoutParams.rightMargin = displayMetrics.widthPixels / i3;
        }
        this.editCardContainer.setLayoutParams(layoutParams);
    }

    private void resetImageViews() {
        this.ed1 = null;
        this.ed2 = null;
        this.ed3 = null;
        this.ed4 = null;
        this.ed5 = null;
        this.ed6 = null;
        this.ed7 = null;
    }

    private void setGreetingCardLayout(String str, int i) {
        String str2 = str;
        resetImageViews();
        if (this.greetingCardView != null) {
            this.editCardContainer.removeAllViews();
        }
        this.editCardContainer.addView(this.greetingCardView);
        this.stickerViewContainer = (FrameLayout) findViewById(R.id.sticker_view_container);
        initializeStickerView();
        if (!str2.equals("wedding_card")) {
            if (!str2.equals("housewarming_card")) {
                if (!str2.equals("birthday_card")) {
                    if (!str2.equals("anniversary_card")) {
                        if (str2.equals("engagement_card")) {
                            switch (i) {
                                case 0:
                                    this.anInt = 5;
                                    this.ed1 = (EditText) findViewById(R.id.edit_text_1);
                                    this.ed2 = (EditText) findViewById(R.id.edit_text_2);
                                    this.ed3 = (EditText) findViewById(R.id.edit_text_3);
                                    this.ed4 = (EditText) findViewById(R.id.edit_text_4);
                                    this.ed5 = (EditText) findViewById(R.id.edit_text_5);
                                    this.ed1.setTextSize(16.0f);
                                    this.ed2.setTextSize(28.0f);
                                    this.ed3.setTextSize(12.0f);
                                    this.ed4.setTextSize(20.0f);
                                    this.ed5.setTextSize(14.0f);
                                    break;
                                case 1:
                                    this.anInt = 5;
                                    this.ed1 = (EditText) findViewById(R.id.edit_text_1);
                                    this.ed2 = (EditText) findViewById(R.id.edit_text_2);
                                    this.ed3 = (EditText) findViewById(R.id.edit_text_3);
                                    this.ed4 = (EditText) findViewById(R.id.edit_text_4);
                                    this.ed5 = (EditText) findViewById(R.id.edit_text_5);
                                    this.ed1.setTextSize(14.0f);
                                    this.ed2.setTextSize(28.0f);
                                    this.ed3.setTextSize(11.0f);
                                    this.ed4.setTextSize(20.0f);
                                    this.ed5.setTextSize(12.0f);
                                    break;
                                case 2:
                                    this.anInt = 5;
                                    this.ed1 = (EditText) findViewById(R.id.edit_text_1);
                                    this.ed2 = (EditText) findViewById(R.id.edit_text_2);
                                    this.ed3 = (EditText) findViewById(R.id.edit_text_3);
                                    this.ed4 = (EditText) findViewById(R.id.edit_text_4);
                                    this.ed5 = (EditText) findViewById(R.id.edit_text_5);
                                    this.ed1.setTextSize(28.0f);
                                    this.ed2.setTextSize(16.0f);
                                    this.ed3.setTextSize(28.0f);
                                    this.ed4.setTextSize(16.0f);
                                    this.ed5.setTextSize(12.0f);
                                    break;
                                case 3:
                                    this.anInt = 6;
                                    this.ed1 = (EditText) findViewById(R.id.edit_text_1);
                                    this.ed2 = (EditText) findViewById(R.id.edit_text_2);
                                    this.ed3 = (EditText) findViewById(R.id.edit_text_3);
                                    this.ed4 = (EditText) findViewById(R.id.edit_text_4);
                                    this.ed5 = (EditText) findViewById(R.id.edit_text_5);
                                    this.ed6 = (EditText) findViewById(R.id.edit_text_6);
                                    this.ed1.setTextSize(18.0f);
                                    this.ed2.setTextSize(13.0f);
                                    this.ed3.setTextSize(30.0f);
                                    this.ed4.setTextSize(14.0f);
                                    this.ed5.setTextSize(26.0f);
                                    this.ed6.setTextSize(14.0f);
                                    break;
                                case 4:
                                    this.anInt = 6;
                                    this.ed1 = (EditText) findViewById(R.id.edit_text_1);
                                    this.ed2 = (EditText) findViewById(R.id.edit_text_2);
                                    this.ed3 = (EditText) findViewById(R.id.edit_text_3);
                                    this.ed4 = (EditText) findViewById(R.id.edit_text_4);
                                    this.ed5 = (EditText) findViewById(R.id.edit_text_5);
                                    this.ed6 = (EditText) findViewById(R.id.edit_text_6);
                                    this.ed1.setTextSize(16.0f);
                                    this.ed2.setTextSize(18.0f);
                                    this.ed3.setTextSize(26.0f);
                                    this.ed4.setTextSize(14.0f);
                                    this.ed5.setTextSize(22.0f);
                                    this.ed6.setTextSize(10.0f);
                                    break;
                                case 5:
                                    this.anInt = 7;
                                    this.ed1 = (EditText) findViewById(R.id.edit_text_1);
                                    this.ed2 = (EditText) findViewById(R.id.edit_text_2);
                                    this.ed3 = (EditText) findViewById(R.id.edit_text_3);
                                    this.ed4 = (EditText) findViewById(R.id.edit_text_4);
                                    this.ed5 = (EditText) findViewById(R.id.edit_text_5);
                                    this.ed6 = (EditText) findViewById(R.id.edit_text_6);
                                    this.ed7 = (EditText) findViewById(R.id.edit_text_7);
                                    this.ed1.setTextSize(16.0f);
                                    this.ed2.setTextSize(12.0f);
                                    this.ed3.setTextSize(30.0f);
                                    this.ed4.setTextSize(12.0f);
                                    this.ed5.setTextSize(12.0f);
                                    this.ed6.setTextSize(18.0f);
                                    this.ed7.setTextSize(10.0f);
                                    break;
                                case 6:
                                    this.anInt = 5;
                                    this.ed1 = (EditText) findViewById(R.id.edit_text_1);
                                    this.ed2 = (EditText) findViewById(R.id.edit_text_2);
                                    this.ed3 = (EditText) findViewById(R.id.edit_text_3);
                                    this.ed4 = (EditText) findViewById(R.id.edit_text_4);
                                    this.ed5 = (EditText) findViewById(R.id.edit_text_5);
                                    this.ed1.setTextSize(14.0f);
                                    this.ed2.setTextSize(26.0f);
                                    this.ed3.setTextSize(16.0f);
                                    this.ed4.setTextSize(22.0f);
                                    this.ed5.setTextSize(12.0f);
                                    break;
                                case 7:
                                    this.anInt = 6;
                                    this.ed1 = (EditText) findViewById(R.id.edit_text_1);
                                    this.ed2 = (EditText) findViewById(R.id.edit_text_2);
                                    this.ed3 = (EditText) findViewById(R.id.edit_text_3);
                                    this.ed4 = (EditText) findViewById(R.id.edit_text_4);
                                    this.ed5 = (EditText) findViewById(R.id.edit_text_5);
                                    this.ed6 = (EditText) findViewById(R.id.edit_text_6);
                                    this.ed1.setTextSize(24.0f);
                                    this.ed2.setTextSize(13.0f);
                                    this.ed3.setTextSize(27.0f);
                                    this.ed4.setTextSize(18.0f);
                                    this.ed5.setTextSize(16.0f);
                                    this.ed6.setTextSize(12.0f);
                                    break;
                                case 8:
                                    this.anInt = 6;
                                    this.ed1 = (EditText) findViewById(R.id.edit_text_1);
                                    this.ed2 = (EditText) findViewById(R.id.edit_text_2);
                                    this.ed3 = (EditText) findViewById(R.id.edit_text_3);
                                    this.ed4 = (EditText) findViewById(R.id.edit_text_4);
                                    this.ed5 = (EditText) findViewById(R.id.edit_text_5);
                                    this.ed6 = (EditText) findViewById(R.id.edit_text_6);
                                    this.ed1.setTextSize(26.0f);
                                    this.ed2.setTextSize(11.0f);
                                    this.ed3.setTextSize(30.0f);
                                    this.ed4.setTextSize(12.0f);
                                    this.ed5.setTextSize(22.0f);
                                    this.ed6.setTextSize(12.0f);
                                    break;
                                case 9:
                                    this.anInt = 6;
                                    this.ed1 = (EditText) findViewById(R.id.edit_text_1);
                                    this.ed2 = (EditText) findViewById(R.id.edit_text_2);
                                    this.ed3 = (EditText) findViewById(R.id.edit_text_3);
                                    this.ed4 = (EditText) findViewById(R.id.edit_text_4);
                                    this.ed5 = (EditText) findViewById(R.id.edit_text_5);
                                    this.ed6 = (EditText) findViewById(R.id.edit_text_6);
                                    this.ed1.setTextSize(35.0f);
                                    this.ed2.setTextSize(11.0f);
                                    this.ed3.setTextSize(40.0f);
                                    this.ed4.setTextSize(12.0f);
                                    this.ed5.setTextSize(22.0f);
                                    this.ed6.setTextSize(12.0f);
                                    break;
                                default:
                                    this.anInt = 0;
                                    break;
                            }
                        }
                    } else {
                        switch (i) {
                            case 0:
                                this.anInt = 7;
                                this.ed1 = (EditText) findViewById(R.id.edit_text_1);
                                this.ed2 = (EditText) findViewById(R.id.edit_text_2);
                                this.ed3 = (EditText) findViewById(R.id.edit_text_3);
                                this.ed4 = (EditText) findViewById(R.id.edit_text_4);
                                this.ed5 = (EditText) findViewById(R.id.edit_text_5);
                                this.ed6 = (EditText) findViewById(R.id.edit_text_6);
                                this.ed7 = (EditText) findViewById(R.id.edit_text_7);
                                this.ed1.setTextSize(37.0f);
                                this.ed2.setTextSize(20.0f);
                                this.ed3.setTextSize(30.0f);
                                this.ed4.setTextSize(20.0f);
                                this.ed5.setTextSize(10.0f);
                                this.ed6.setTextSize(20.0f);
                                this.ed7.setTextSize(10.0f);
                                break;
                            case 1:
                                this.anInt = 6;
                                this.ed1 = (EditText) findViewById(R.id.edit_text_1);
                                this.ed2 = (EditText) findViewById(R.id.edit_text_2);
                                this.ed3 = (EditText) findViewById(R.id.edit_text_3);
                                this.ed4 = (EditText) findViewById(R.id.edit_text_4);
                                this.ed5 = (EditText) findViewById(R.id.edit_text_5);
                                this.ed6 = (EditText) findViewById(R.id.edit_text_6);
                                this.ed1.setTextSize(50.0f);
                                this.ed2.setTextSize(60.0f);
                                this.ed3.setTextSize(50.0f);
                                this.ed4.setTextSize(12.0f);
                                this.ed5.setTextSize(50.0f);
                                this.ed6.setTextSize(12.0f);
                                break;
                            case 2:
                                this.anInt = 5;
                                this.ed1 = (EditText) findViewById(R.id.edit_text_1);
                                this.ed2 = (EditText) findViewById(R.id.edit_text_2);
                                this.ed3 = (EditText) findViewById(R.id.edit_text_3);
                                this.ed4 = (EditText) findViewById(R.id.edit_text_4);
                                this.ed5 = (EditText) findViewById(R.id.edit_text_5);
                                this.ed1.setTextSize(18.0f);
                                this.ed2.setTextSize(45.0f);
                                this.ed3.setTextSize(12.0f);
                                this.ed4.setTextSize(30.0f);
                                this.ed5.setTextSize(15.0f);
                                break;
                            case 3:
                                this.anInt = 5;
                                this.ed1 = (EditText) findViewById(R.id.edit_text_1);
                                this.ed2 = (EditText) findViewById(R.id.edit_text_2);
                                this.ed3 = (EditText) findViewById(R.id.edit_text_3);
                                this.ed4 = (EditText) findViewById(R.id.edit_text_4);
                                this.ed5 = (EditText) findViewById(R.id.edit_text_5);
                                this.ed1.setTextSize(45.0f);
                                this.ed2.setTextSize(45.0f);
                                this.ed3.setTextSize(15.0f);
                                this.ed4.setTextSize(35.0f);
                                this.ed5.setTextSize(12.0f);
                                break;
                            case 4:
                                this.anInt = 6;
                                this.ed1 = (EditText) findViewById(R.id.edit_text_1);
                                this.ed2 = (EditText) findViewById(R.id.edit_text_2);
                                this.ed3 = (EditText) findViewById(R.id.edit_text_3);
                                this.ed4 = (EditText) findViewById(R.id.edit_text_4);
                                this.ed5 = (EditText) findViewById(R.id.edit_text_5);
                                this.ed6 = (EditText) findViewById(R.id.edit_text_6);
                                this.ed1.setTextSize(30.0f);
                                this.ed2.setTextSize(18.0f);
                                this.ed3.setTextSize(40.0f);
                                this.ed4.setTextSize(12.0f);
                                this.ed5.setTextSize(20.0f);
                                this.ed6.setTextSize(12.0f);
                                break;
                            case 5:
                                this.anInt = 4;
                                this.ed1 = (EditText) findViewById(R.id.edit_text_1);
                                this.ed2 = (EditText) findViewById(R.id.edit_text_2);
                                this.ed3 = (EditText) findViewById(R.id.edit_text_3);
                                this.ed4 = (EditText) findViewById(R.id.edit_text_4);
                                this.ed1.setTextSize(18.0f);
                                this.ed2.setTextSize(25.0f);
                                this.ed3.setTextSize(15.0f);
                                this.ed4.setTextSize(18.0f);
                                break;
                            case 6:
                                this.anInt = 4;
                                this.ed1 = (EditText) findViewById(R.id.edit_text_1);
                                this.ed2 = (EditText) findViewById(R.id.edit_text_2);
                                this.ed3 = (EditText) findViewById(R.id.edit_text_3);
                                this.ed4 = (EditText) findViewById(R.id.edit_text_4);
                                this.ed1.setTextSize(30.0f);
                                this.ed2.setTextSize(35.0f);
                                this.ed3.setTextSize(20.0f);
                                this.ed4.setTextSize(12.0f);
                                break;
                            case 7:
                                this.anInt = 5;
                                this.ed1 = (EditText) findViewById(R.id.edit_text_1);
                                this.ed2 = (EditText) findViewById(R.id.edit_text_2);
                                this.ed3 = (EditText) findViewById(R.id.edit_text_3);
                                this.ed4 = (EditText) findViewById(R.id.edit_text_4);
                                this.ed5 = (EditText) findViewById(R.id.edit_text_5);
                                this.ed1.setTextSize(18.0f);
                                this.ed2.setTextSize(16.0f);
                                this.ed3.setTextSize(15.0f);
                                this.ed4.setTextSize(10.0f);
                                this.ed5.setTextSize(12.0f);
                                break;
                            case 8:
                                this.anInt = 5;
                                this.ed1 = (EditText) findViewById(R.id.edit_text_1);
                                this.ed2 = (EditText) findViewById(R.id.edit_text_2);
                                this.ed3 = (EditText) findViewById(R.id.edit_text_3);
                                this.ed4 = (EditText) findViewById(R.id.edit_text_4);
                                this.ed5 = (EditText) findViewById(R.id.edit_text_5);
                                this.ed1.setTextSize(20.0f);
                                this.ed2.setTextSize(40.0f);
                                this.ed3.setTextSize(20.0f);
                                this.ed4.setTextSize(25.0f);
                                this.ed5.setTextSize(18.0f);
                                break;
                            case 9:
                                this.anInt = 5;
                                this.ed1 = (EditText) findViewById(R.id.edit_text_1);
                                this.ed2 = (EditText) findViewById(R.id.edit_text_2);
                                this.ed3 = (EditText) findViewById(R.id.edit_text_3);
                                this.ed4 = (EditText) findViewById(R.id.edit_text_4);
                                this.ed5 = (EditText) findViewById(R.id.edit_text_5);
                                this.ed1.setTextSize(15.0f);
                                this.ed2.setTextSize(25.0f);
                                this.ed3.setTextSize(18.0f);
                                this.ed4.setTextSize(12.0f);
                                this.ed5.setTextSize(15.0f);
                                break;
                            default:
                                this.anInt = 1;
                                this.ed1 = (EditText) findViewById(R.id.edit_text_1);
                                break;
                        }
                    }
                } else {
                    switch (i) {
                        case 0:
                            this.anInt = 5;
                            this.ed1 = (EditText) findViewById(R.id.edit_text_1);
                            this.ed2 = (EditText) findViewById(R.id.edit_text_2);
                            this.ed3 = (EditText) findViewById(R.id.edit_text_3);
                            this.ed4 = (EditText) findViewById(R.id.edit_text_4);
                            this.ed5 = (EditText) findViewById(R.id.edit_text_5);
                            this.ed6 = (EditText) findViewById(R.id.edit_text_6);
                            this.ed1.setTextSize(18.0f);
                            this.ed2.setTextSize(30.0f);
                            this.ed3.setTextSize(30.0f);
                            this.ed4.setTextSize(18.0f);
                            this.ed5.setTextSize(20.0f);
                            this.ed6.setTextSize(10.0f);
                            break;
                        case 1:
                            this.anInt = 6;
                            this.ed1 = (EditText) findViewById(R.id.edit_text_1);
                            this.ed2 = (EditText) findViewById(R.id.edit_text_2);
                            this.ed3 = (EditText) findViewById(R.id.edit_text_3);
                            this.ed4 = (EditText) findViewById(R.id.edit_text_4);
                            this.ed5 = (EditText) findViewById(R.id.edit_text_5);
                            this.ed6 = (EditText) findViewById(R.id.edit_text_6);
                            this.ed1.setTextSize(22.0f);
                            this.ed2.setTextSize(55.0f);
                            this.ed3.setTextSize(18.0f);
                            this.ed4.setTextSize(25.0f);
                            this.ed5.setTextSize(10.0f);
                            this.ed6.setTextSize(25.0f);
                            break;
                        case 2:
                            this.anInt = 7;
                            this.ed1 = (EditText) findViewById(R.id.edit_text_1);
                            this.ed2 = (EditText) findViewById(R.id.edit_text_2);
                            this.ed3 = (EditText) findViewById(R.id.edit_text_3);
                            this.ed4 = (EditText) findViewById(R.id.edit_text_4);
                            this.ed5 = (EditText) findViewById(R.id.edit_text_5);
                            this.ed6 = (EditText) findViewById(R.id.edit_text_6);
                            this.ed7 = (EditText) findViewById(R.id.edit_text_7);
                            this.ed1.setTextSize(27.0f);
                            this.ed2.setTextSize(15.0f);
                            this.ed3.setTextSize(20.0f);
                            this.ed4.setTextSize(20.0f);
                            this.ed5.setTextSize(10.0f);
                            this.ed6.setTextSize(10.0f);
                            this.ed7.setTextSize(10.0f);
                            break;
                        case 3:
                            this.anInt = 6;
                            this.ed1 = (EditText) findViewById(R.id.edit_text_1);
                            this.ed2 = (EditText) findViewById(R.id.edit_text_2);
                            this.ed3 = (EditText) findViewById(R.id.edit_text_3);
                            this.ed4 = (EditText) findViewById(R.id.edit_text_4);
                            this.ed5 = (EditText) findViewById(R.id.edit_text_5);
                            this.ed6 = (EditText) findViewById(R.id.edit_text_6);
                            this.ed1.setTextSize(18.0f);
                            this.ed2.setTextSize(55.0f);
                            this.ed3.setTextSize(20.0f);
                            this.ed4.setTextSize(20.0f);
                            this.ed5.setTextSize(20.0f);
                            this.ed6.setTextSize(10.0f);
                            break;
                        case 4:
                            this.anInt = 7;
                            this.ed1 = (EditText) findViewById(R.id.edit_text_1);
                            this.ed2 = (EditText) findViewById(R.id.edit_text_2);
                            this.ed7 = (EditText) findViewById(R.id.edit_text_7);
                            this.ed3 = (EditText) findViewById(R.id.edit_text_3);
                            this.ed4 = (EditText) findViewById(R.id.edit_text_4);
                            this.ed5 = (EditText) findViewById(R.id.edit_text_5);
                            this.ed6 = (EditText) findViewById(R.id.edit_text_6);
                            this.ed1.setTextSize(16.0f);
                            this.ed2.setTextSize(50.0f);
                            this.ed7.setTextSize(50.0f);
                            this.ed3.setTextSize(22.0f);
                            this.ed4.setTextSize(25.0f);
                            this.ed5.setTextSize(25.0f);
                            this.ed6.setTextSize(12.0f);
                            break;
                        case 5:
                            this.anInt = 5;
                            this.ed1 = (EditText) findViewById(R.id.edit_text_1);
                            this.ed2 = (EditText) findViewById(R.id.edit_text_2);
                            this.ed3 = (EditText) findViewById(R.id.edit_text_3);
                            this.ed4 = (EditText) findViewById(R.id.edit_text_4);
                            this.ed5 = (EditText) findViewById(R.id.edit_text_5);
                            this.ed1.setTextSize(15.0f);
                            this.ed2.setTextSize(18.0f);
                            this.ed3.setTextSize(30.0f);
                            this.ed4.setTextSize(30.0f);
                            this.ed5.setTextSize(15.0f);
                            break;
                        case 6:
                            this.anInt = 6;
                            this.ed1 = (EditText) findViewById(R.id.edit_text_1);
                            this.ed2 = (EditText) findViewById(R.id.edit_text_2);
                            this.ed3 = (EditText) findViewById(R.id.edit_text_3);
                            this.ed4 = (EditText) findViewById(R.id.edit_text_4);
                            this.ed5 = (EditText) findViewById(R.id.edit_text_5);
                            this.ed6 = (EditText) findViewById(R.id.edit_text_6);
                            this.ed1.setTextSize(18.0f);
                            this.ed2.setTextSize(40.0f);
                            this.ed3.setTextSize(26.0f);
                            this.ed4.setTextSize(21.0f);
                            this.ed5.setTextSize(22.0f);
                            this.ed6.setTextSize(10.0f);
                            break;
                        case 7:
                            this.anInt = 7;
                            this.ed1 = (EditText) findViewById(R.id.edit_text_1);
                            this.ed2 = (EditText) findViewById(R.id.edit_text_2);
                            this.ed3 = (EditText) findViewById(R.id.edit_text_3);
                            this.ed4 = (EditText) findViewById(R.id.edit_text_4);
                            this.ed5 = (EditText) findViewById(R.id.edit_text_5);
                            this.ed6 = (EditText) findViewById(R.id.edit_text_6);
                            this.ed7 = (EditText) findViewById(R.id.edit_text_7);
                            this.ed1.setTextSize(25.0f);
                            this.ed2.setTextSize(25.0f);
                            this.ed3.setTextSize(25.0f);
                            this.ed4.setTextSize(16.0f);
                            this.ed5.setTextSize(30.0f);
                            this.ed6.setTextSize(35.0f);
                            this.ed7.setTextSize(12.0f);
                            break;
                        case 8:
                            this.anInt = 6;
                            this.ed1 = (EditText) findViewById(R.id.edit_text_1);
                            this.ed2 = (EditText) findViewById(R.id.edit_text_2);
                            this.ed3 = (EditText) findViewById(R.id.edit_text_3);
                            this.ed4 = (EditText) findViewById(R.id.edit_text_4);
                            this.ed5 = (EditText) findViewById(R.id.edit_text_5);
                            this.ed6 = (EditText) findViewById(R.id.edit_text_6);
                            this.ed1.setTextSize(15.0f);
                            this.ed2.setTextSize(35.0f);
                            this.ed3.setTextSize(23.0f);
                            this.ed4.setTextSize(37.0f);
                            this.ed5.setTextSize(22.0f);
                            this.ed6.setTextSize(12.0f);
                            break;
                        case 9:
                            this.anInt = 7;
                            this.ed1 = (EditText) findViewById(R.id.edit_text_1);
                            this.ed2 = (EditText) findViewById(R.id.edit_text_2);
                            this.ed3 = (EditText) findViewById(R.id.edit_text_3);
                            this.ed4 = (EditText) findViewById(R.id.edit_text_4);
                            this.ed5 = (EditText) findViewById(R.id.edit_text_5);
                            this.ed6 = (EditText) findViewById(R.id.edit_text_6);
                            this.ed7 = (EditText) findViewById(R.id.edit_text_7);
                            this.ed1.setTextSize(20.0f);
                            this.ed2.setTextSize(50.0f);
                            this.ed3.setTextSize(20.0f);
                            this.ed4.setTextSize(22.0f);
                            this.ed5.setTextSize(22.0f);
                            this.ed6.setTextSize(12.0f);
                            this.ed7.setTextSize(12.0f);
                            break;
                        default:
                            this.anInt = 1;
                            this.ed1 = (EditText) findViewById(R.id.edit_text_1);
                            break;
                    }
                }
            } else {
                switch (i) {
                    case 0:
                        this.anInt = 3;
                        this.ed1 = (EditText) findViewById(R.id.edit_text_1);
                        this.ed2 = (EditText) findViewById(R.id.edit_text_2);
                        this.ed3 = (EditText) findViewById(R.id.edit_text_3);
                        this.ed1.setTextSize(20.0f);
                        this.ed2.setTextSize(40.0f);
                        this.ed3.setTextSize(15.0f);
                        break;
                    case 1:
                        this.anInt = 4;
                        this.ed1 = (EditText) findViewById(R.id.edit_text_1);
                        this.ed2 = (EditText) findViewById(R.id.edit_text_2);
                        this.ed3 = (EditText) findViewById(R.id.edit_text_3);
                        this.ed4 = (EditText) findViewById(R.id.edit_text_4);
                        this.ed1.setTextSize(20.0f);
                        this.ed2.setTextSize(12.0f);
                        this.ed3.setTextSize(12.0f);
                        this.ed4.setTextSize(12.0f);
                        break;
                    case 2:
                        this.anInt = 5;
                        this.ed1 = (EditText) findViewById(R.id.edit_text_1);
                        this.ed2 = (EditText) findViewById(R.id.edit_text_2);
                        this.ed3 = (EditText) findViewById(R.id.edit_text_3);
                        this.ed4 = (EditText) findViewById(R.id.edit_text_4);
                        this.ed5 = (EditText) findViewById(R.id.edit_text_5);
                        this.ed1.setTextSize(25.0f);
                        this.ed2.setTextSize(25.0f);
                        this.ed3.setTextSize(12.0f);
                        this.ed4.setTextSize(15.0f);
                        this.ed5.setTextSize(12.0f);
                        break;
                    case 3:
                        this.anInt = 6;
                        this.ed1 = (EditText) findViewById(R.id.edit_text_1);
                        this.ed2 = (EditText) findViewById(R.id.edit_text_2);
                        this.ed3 = (EditText) findViewById(R.id.edit_text_3);
                        this.ed4 = (EditText) findViewById(R.id.edit_text_4);
                        this.ed5 = (EditText) findViewById(R.id.edit_text_5);
                        this.ed6 = (EditText) findViewById(R.id.edit_text_6);
                        this.ed1.setTextSize(30.0f);
                        this.ed2.setTextSize(12.0f);
                        this.ed3.setTextSize(30.0f);
                        this.ed4.setTextSize(12.0f);
                        this.ed5.setTextSize(20.0f);
                        this.ed6.setTextSize(12.0f);
                        break;
                    case 4:
                        this.anInt = 6;
                        this.ed1 = (EditText) findViewById(R.id.edit_text_1);
                        this.ed2 = (EditText) findViewById(R.id.edit_text_2);
                        this.ed3 = (EditText) findViewById(R.id.edit_text_3);
                        this.ed4 = (EditText) findViewById(R.id.edit_text_4);
                        this.ed5 = (EditText) findViewById(R.id.edit_text_5);
                        this.ed6 = (EditText) findViewById(R.id.edit_text_6);
                        this.ed1.setTextSize(25.0f);
                        this.ed2.setTextSize(12.0f);
                        this.ed3.setTextSize(25.0f);
                        this.ed4.setTextSize(12.0f);
                        this.ed5.setTextSize(20.0f);
                        this.ed6.setTextSize(12.0f);
                        break;
                    case 5:
                        this.anInt = 6;
                        this.ed1 = (EditText) findViewById(R.id.edit_text_1);
                        this.ed2 = (EditText) findViewById(R.id.edit_text_2);
                        this.ed3 = (EditText) findViewById(R.id.edit_text_3);
                        this.ed4 = (EditText) findViewById(R.id.edit_text_4);
                        this.ed5 = (EditText) findViewById(R.id.edit_text_5);
                        this.ed6 = (EditText) findViewById(R.id.edit_text_6);
                        this.ed1.setTextSize(20.0f);
                        this.ed2.setTextSize(12.0f);
                        this.ed3.setTextSize(20.0f);
                        this.ed4.setTextSize(12.0f);
                        this.ed5.setTextSize(15.0f);
                        this.ed6.setTextSize(12.0f);
                        break;
                    case 6:
                        this.anInt = 6;
                        this.ed1 = (EditText) findViewById(R.id.edit_text_1);
                        this.ed2 = (EditText) findViewById(R.id.edit_text_2);
                        this.ed3 = (EditText) findViewById(R.id.edit_text_3);
                        this.ed4 = (EditText) findViewById(R.id.edit_text_4);
                        this.ed5 = (EditText) findViewById(R.id.edit_text_5);
                        this.ed6 = (EditText) findViewById(R.id.edit_text_6);
                        this.ed1.setTextSize(25.0f);
                        this.ed2.setTextSize(12.0f);
                        this.ed3.setTextSize(20.0f);
                        this.ed4.setTextSize(12.0f);
                        this.ed5.setTextSize(18.0f);
                        this.ed6.setTextSize(12.0f);
                        break;
                    case 7:
                        this.anInt = 5;
                        this.ed1 = (EditText) findViewById(R.id.edit_text_1);
                        this.ed2 = (EditText) findViewById(R.id.edit_text_2);
                        this.ed3 = (EditText) findViewById(R.id.edit_text_3);
                        this.ed4 = (EditText) findViewById(R.id.edit_text_4);
                        this.ed5 = (EditText) findViewById(R.id.edit_text_5);
                        this.ed1.setTextSize(15.0f);
                        this.ed2.setTextSize(22.0f);
                        this.ed3.setTextSize(12.0f);
                        this.ed4.setTextSize(15.0f);
                        this.ed5.setTextSize(12.0f);
                        break;
                    case 8:
                        this.anInt = 6;
                        this.ed1 = (EditText) findViewById(R.id.edit_text_1);
                        this.ed2 = (EditText) findViewById(R.id.edit_text_2);
                        this.ed3 = (EditText) findViewById(R.id.edit_text_3);
                        this.ed4 = (EditText) findViewById(R.id.edit_text_4);
                        this.ed5 = (EditText) findViewById(R.id.edit_text_5);
                        this.ed6 = (EditText) findViewById(R.id.edit_text_6);
                        this.ed1.setTextSize(20.0f);
                        this.ed2.setTextSize(50.0f);
                        this.ed3.setTextSize(15.0f);
                        this.ed4.setTextSize(15.0f);
                        this.ed5.setTextSize(12.0f);
                        this.ed6.setTextSize(25.0f);
                        break;
                    case 9:
                        this.anInt = 7;
                        this.ed1 = (EditText) findViewById(R.id.edit_text_1);
                        this.ed2 = (EditText) findViewById(R.id.edit_text_2);
                        this.ed3 = (EditText) findViewById(R.id.edit_text_3);
                        this.ed4 = (EditText) findViewById(R.id.edit_text_4);
                        this.ed5 = (EditText) findViewById(R.id.edit_text_5);
                        this.ed6 = (EditText) findViewById(R.id.edit_text_6);
                        this.ed7 = (EditText) findViewById(R.id.edit_text_7);
                        this.ed1.setTextSize(12.0f);
                        this.ed2.setTextSize(20.0f);
                        this.ed3.setTextSize(20.0f);
                        this.ed4.setTextSize(20.0f);
                        this.ed5.setTextSize(10.0f);
                        this.ed6.setTextSize(10.0f);
                        this.ed7.setTextSize(10.0f);
                        break;
                    default:
                        this.anInt = 1;
                        this.ed1 = (EditText) findViewById(R.id.edit_text_1);
                        break;
                }
            }
        } else {
            switch (i) {
                case 0:
                    this.anInt = 6;
                    this.ed1 = (EditText) findViewById(R.id.edit_text_1);
                    this.ed2 = (EditText) findViewById(R.id.edit_text_2);
                    this.ed3 = (EditText) findViewById(R.id.edit_text_3);
                    this.ed4 = (EditText) findViewById(R.id.edit_text_4);
                    this.ed5 = (EditText) findViewById(R.id.edit_text_5);
                    this.ed6 = (EditText) findViewById(R.id.edit_text_6);
                    this.ed1.setTextSize(28.0f);
                    this.ed2.setTextSize(20.0f);
                    this.ed3.setTextSize(20.0f);
                    this.ed4.setTextSize(20.0f);
                    this.ed5.setTextSize(20.0f);
                    break;
                case 1:
                    this.anInt = 4;
                    this.ed1 = (EditText) findViewById(R.id.edit_text_1);
                    this.ed2 = (EditText) findViewById(R.id.edit_text_2);
                    this.ed3 = (EditText) findViewById(R.id.edit_text_3);
                    this.ed4 = (EditText) findViewById(R.id.edit_text_4);
                    this.ed1.setTextSize(14.0f);
                    this.ed2.setTextSize(28.0f);
                    this.ed3.setTextSize(12.0f);
                    this.ed4.setTextSize(10.0f);
                    break;
                case 2:
                    this.anInt = 4;
                    this.ed1 = (EditText) findViewById(R.id.edit_text_1);
                    this.ed2 = (EditText) findViewById(R.id.edit_text_2);
                    this.ed3 = (EditText) findViewById(R.id.edit_text_3);
                    this.ed4 = (EditText) findViewById(R.id.edit_text_4);
                    this.ed1.setTextSize(14.0f);
                    this.ed2.setTextSize(26.0f);
                    this.ed3.setTextSize(16.0f);
                    this.ed4.setTextSize(12.0f);
                    break;
                case 3:
                    this.anInt = 5;
                    this.ed1 = (EditText) findViewById(R.id.edit_text_1);
                    this.ed2 = (EditText) findViewById(R.id.edit_text_2);
                    this.ed3 = (EditText) findViewById(R.id.edit_text_3);
                    this.ed4 = (EditText) findViewById(R.id.edit_text_4);
                    this.ed5 = (EditText) findViewById(R.id.edit_text_5);
                    this.ed1.setTextSize(8.0f);
                    this.ed2.setTextSize(30.0f);
                    this.ed3.setTextSize(16.0f);
                    this.ed4.setTextSize(12.0f);
                    this.ed5.setTextSize(12.0f);
                    break;
                case 4:
                    this.anInt = 3;
                    this.ed1 = (EditText) findViewById(R.id.edit_text_1);
                    this.ed2 = (EditText) findViewById(R.id.edit_text_2);
                    this.ed3 = (EditText) findViewById(R.id.edit_text_3);
                    this.ed1.setTextSize(30.0f);
                    this.ed2.setTextSize(30.0f);
                    this.ed3.setTextSize(14.0f);
                    break;
                case 5:
                    this.anInt = 5;
                    this.ed1 = (EditText) findViewById(R.id.edit_text_1);
                    this.ed2 = (EditText) findViewById(R.id.edit_text_2);
                    this.ed3 = (EditText) findViewById(R.id.edit_text_3);
                    this.ed4 = (EditText) findViewById(R.id.edit_text_4);
                    this.ed5 = (EditText) findViewById(R.id.edit_text_5);
                    this.ed1.setTextSize(12.0f);
                    this.ed2.setTextSize(35.0f);
                    this.ed3.setTextSize(18.0f);
                    this.ed4.setTextSize(16.0f);
                    this.ed5.setTextSize(14.0f);
                    break;
                case 6:
                    this.anInt = 3;
                    this.ed1 = (EditText) findViewById(R.id.edit_text_1);
                    this.ed2 = (EditText) findViewById(R.id.edit_text_2);
                    this.ed3 = (EditText) findViewById(R.id.edit_text_3);
                    this.ed1.setTextSize(8.0f);
                    this.ed2.setTextSize(20.0f);
                    this.ed3.setTextSize(12.0f);
                    break;
                case 7:
                    this.anInt = 4;
                    this.ed1 = (EditText) findViewById(R.id.edit_text_1);
                    this.ed2 = (EditText) findViewById(R.id.edit_text_2);
                    this.ed3 = (EditText) findViewById(R.id.edit_text_3);
                    this.ed4 = (EditText) findViewById(R.id.edit_text_4);
                    this.ed1.setTextSize(16.0f);
                    this.ed2.setTextSize(26.0f);
                    this.ed3.setTextSize(16.0f);
                    this.ed4.setTextSize(10.0f);
                    break;
                case 8:
                    this.anInt = 4;
                    this.ed1 = (EditText) findViewById(R.id.edit_text_1);
                    this.ed2 = (EditText) findViewById(R.id.edit_text_2);
                    this.ed3 = (EditText) findViewById(R.id.edit_text_3);
                    this.ed4 = (EditText) findViewById(R.id.edit_text_4);
                    this.ed1.setTextSize(16.0f);
                    this.ed2.setTextSize(30.0f);
                    this.ed3.setTextSize(16.0f);
                    this.ed4.setTextSize(15.0f);
                    break;
                case 9:
                    this.anInt = 4;
                    this.ed1 = (EditText) findViewById(R.id.edit_text_1);
                    this.ed2 = (EditText) findViewById(R.id.edit_text_2);
                    this.ed3 = (EditText) findViewById(R.id.edit_text_3);
                    this.ed4 = (EditText) findViewById(R.id.edit_text_4);
                    this.ed1.setTextSize(14.0f);
                    this.ed2.setTextSize(16.0f);
                    this.ed3.setTextSize(35.0f);
                    this.ed4.setTextSize(12.0f);
                    break;
                default:
                    this.anInt = 1;
                    this.ed1 = (EditText) findViewById(R.id.edit_text_1);
                    break;
            }
        }
        ImageView imageView = (ImageView) findViewById(R.id.selected_image);
        this.selectedCard = imageView;
        imageView.setClickable(false);
        this.selectedImage = (ImageView) findViewById(R.id.selected_image);
        new FrameLayout.LayoutParams(1200, 1200);
        new FrameLayout.LayoutParams(170, 170);
        new FrameLayout.LayoutParams(1128, 191);
        new FrameLayout.LayoutParams(1028, 1920);
        new FrameLayout.LayoutParams(627, 1200);
        this.selectedImage.setScaleType(ImageView.ScaleType.FIT_XY);
        BitmapFactory.decodeResource(this.context.getResources(), R.drawable.wedding_card_1_back);
        clearHighlights();
        initializeEditText();
        setTextSizesAccordingToScreen();
        clickables();
        setTextSizeAdapter(this.fontSizeRecycler, "font_size");
        setThemeColorsAdapter(this.themeColorsRecycler, "font_colors");
        setThemeColorsAdapter(this.shadowColorRecycler, "font_shadow_colors");
        setThemeColorsAdapter(this.stickersPrevRecycler, "stickers");
        setBottomLayoutNavigation();
        setStandardColors();
        setFontsColorGradient();
    }

    private void setTextSizesAccordingToScreen() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int i = displayMetrics.heightPixels;
        int i2 = displayMetrics.widthPixels;
        int i3 = displayMetrics.densityDpi;
        Log.v("TEST", "display height : " + i);
        Log.v("TEST", "display density : " + i3);
    }

    private void setBottomLayoutNavigation() {
        this.mainFontColorOption.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                GreetingCardEditActivity activity = GreetingCardEditActivity.this;
                activity.setBottomLayoutOpenNavigation(activity.fontColorOptions, GreetingCardEditActivity.this.mainTextOptions, R.anim.abc_slide_in_bottom);
            }
        });
        this.mainSlideUp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                GreetingCardEditActivity activity = GreetingCardEditActivity.this;
                activity.setBottomLayoutOpenNavigation(activity.moreTextOptions, GreetingCardEditActivity.this.mainTextOptions, R.anim.abc_slide_in_bottom);
                if (!GreetingCardEditActivity.this.TYPE.equals("own_card")) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) GreetingCardEditActivity.this.editCardContainer.getLayoutParams();
                    layoutParams.bottomMargin = GreetingCardEditActivity.this.getResources().getDisplayMetrics().heightPixels / 5;
                    GreetingCardEditActivity.this.editCardContainer.setLayoutParams(layoutParams);
                }
            }
        });
        this.fontStyleSelection.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                GreetingCardEditActivity activity = GreetingCardEditActivity.this;
                activity.setBottomLayoutOpenNavigation(activity.fontStyleOptions, GreetingCardEditActivity.this.moreTextOptions, R.anim.left_to_right);
            }
        });
        this.fontSizeSelection.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                GreetingCardEditActivity activity = GreetingCardEditActivity.this;
                activity.setBottomLayoutOpenNavigation(activity.fontSizeOptions, GreetingCardEditActivity.this.moreTextOptions, R.anim.left_to_right);
            }
        });
        this.fontColorSelection.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                GreetingCardEditActivity activity = GreetingCardEditActivity.this;
                activity.setBottomLayoutOpenNavigation(activity.fontColorOptions, GreetingCardEditActivity.this.moreTextOptions, R.anim.left_to_right);
            }
        });
        this.fontShadowColorSelection.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                GreetingCardEditActivity activity = GreetingCardEditActivity.this;
                activity.setBottomLayoutOpenNavigation(activity.fontShadowColorOptions, GreetingCardEditActivity.this.moreTextOptions, R.anim.left_to_right);
            }
        });
        this.stickerOptionsBack.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                GreetingCardEditActivity activity = GreetingCardEditActivity.this;
                activity.setBottomLayoutOpenNavigation(activity.moreTextOptions, GreetingCardEditActivity.this.stickerOptions, R.anim.left_to_right);
            }
        });
        this.fontStyleOptionsBack.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                GreetingCardEditActivity activity = GreetingCardEditActivity.this;
                activity.setBottomLayoutOpenNavigation(activity.moreTextOptions, GreetingCardEditActivity.this.fontStyleOptions, R.anim.slide_out_left);
            }
        });
        this.fontSizeOptionsBack.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                GreetingCardEditActivity activity = GreetingCardEditActivity.this;
                activity.setBottomLayoutOpenNavigation(activity.moreTextOptions, GreetingCardEditActivity.this.fontSizeOptions, R.anim.slide_out_left);
            }
        });
        this.fontColorOptionsBack.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                GreetingCardEditActivity activity = GreetingCardEditActivity.this;
                activity.setBottomLayoutOpenNavigation(activity.moreTextOptions, GreetingCardEditActivity.this.fontColorOptions, R.anim.slide_out_left);
            }
        });
        this.fontShadowColorOptionsBack.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                GreetingCardEditActivity activity = GreetingCardEditActivity.this;
                activity.setBottomLayoutOpenNavigation(activity.moreTextOptions, GreetingCardEditActivity.this.fontShadowColorOptions, R.anim.slide_out_left);
            }
        });
        this.collapseMoreTextOptions.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                GreetingCardEditActivity activity = GreetingCardEditActivity.this;
                activity.setBottomLayoutOpenNavigation(activity.mainTextOptions, GreetingCardEditActivity.this.moreTextOptions, R.anim.abc_slide_out_bottom);
                if (!GreetingCardEditActivity.this.TYPE.equals("own_card")) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) GreetingCardEditActivity.this.editCardContainer.getLayoutParams();
                    layoutParams.bottomMargin = GreetingCardEditActivity.this.getResources().getDisplayMetrics().heightPixels / 9;
                    GreetingCardEditActivity.this.editCardContainer.setLayoutParams(layoutParams);
                }
            }
        });
        this.collapseStickerOptions.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                GreetingCardEditActivity.this.options_new.setVisibility(View.VISIBLE);
                GreetingCardEditActivity.this.stickerOptions.setVisibility(View.GONE);
                if (!GreetingCardEditActivity.this.TYPE.equals("own_card")) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) GreetingCardEditActivity.this.editCardContainer.getLayoutParams();
                    layoutParams.bottomMargin = GreetingCardEditActivity.this.getResources().getDisplayMetrics().heightPixels / 9;
                    GreetingCardEditActivity.this.editCardContainer.setLayoutParams(layoutParams);
                }
            }
        });
        this.collapseFontStyleOptions.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                GreetingCardEditActivity activity = GreetingCardEditActivity.this;
                activity.setBottomLayoutOpenNavigation(activity.mainTextOptions, GreetingCardEditActivity.this.fontStyleOptions, R.anim.abc_slide_out_bottom);
                if (!GreetingCardEditActivity.this.TYPE.equals("own_card")) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) GreetingCardEditActivity.this.editCardContainer.getLayoutParams();
                    layoutParams.bottomMargin = GreetingCardEditActivity.this.getResources().getDisplayMetrics().heightPixels / 9;
                    GreetingCardEditActivity.this.editCardContainer.setLayoutParams(layoutParams);
                }
            }
        });
        this.collapseFontSizeOptions.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                GreetingCardEditActivity activity = GreetingCardEditActivity.this;
                activity.setBottomLayoutOpenNavigation(activity.mainTextOptions, GreetingCardEditActivity.this.fontSizeOptions, R.anim.abc_slide_out_bottom);
                if (!GreetingCardEditActivity.this.TYPE.equals("own_card")) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) GreetingCardEditActivity.this.editCardContainer.getLayoutParams();
                    layoutParams.bottomMargin = GreetingCardEditActivity.this.getResources().getDisplayMetrics().heightPixels / 9;
                    GreetingCardEditActivity.this.editCardContainer.setLayoutParams(layoutParams);
                }
            }
        });
        this.collapseFontColorOptions.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                GreetingCardEditActivity activity = GreetingCardEditActivity.this;
                activity.setBottomLayoutOpenNavigation(activity.mainTextOptions, GreetingCardEditActivity.this.fontColorOptions, R.anim.abc_slide_out_bottom);
                if (!GreetingCardEditActivity.this.TYPE.equals("own_card")) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) GreetingCardEditActivity.this.editCardContainer.getLayoutParams();
                    layoutParams.bottomMargin = GreetingCardEditActivity.this.getResources().getDisplayMetrics().heightPixels / 9;
                    GreetingCardEditActivity.this.editCardContainer.setLayoutParams(layoutParams);
                }
            }
        });
        this.collapseFontShadowColorOptions.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                GreetingCardEditActivity activity = GreetingCardEditActivity.this;
                activity.setBottomLayoutOpenNavigation(activity.mainTextOptions, GreetingCardEditActivity.this.fontShadowColorOptions, R.anim.abc_slide_out_bottom);
                if (!GreetingCardEditActivity.this.TYPE.equals("own_card")) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) GreetingCardEditActivity.this.editCardContainer.getLayoutParams();
                    layoutParams.bottomMargin = GreetingCardEditActivity.this.getResources().getDisplayMetrics().heightPixels / 9;
                    GreetingCardEditActivity.this.editCardContainer.setLayoutParams(layoutParams);
                }
            }
        });
    }

    private void setTextSizeAdapter(RecyclerView recyclerView, String str) {
        this.mResources = new ArrayList<>();
        for (int i = 8; i <= 40; i++) {
            this.mResources.add(Integer.valueOf(i));
        }
        this.themeColorsAdapter = new ThemeColorsAdapter(this, this.mResources, str);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemViewCacheSize(20);
        recyclerView.setAdapter(this.themeColorsAdapter);
    }

    private void setThemeColorsAdapter(RecyclerView recyclerView, String str) {
        if (str.equals("stickers")) {
            setWeddingStickerResources(recyclerView);
            this.weddingStickers.setBackgroundColor(getResources().getColor(R.color.grey));
            return;
        }
        this.mResources = new ArrayList<>();
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 10);
        this.mResources.add(Integer.valueOf(Color.parseColor("#2C3539")));
        this.mResources.add(Integer.valueOf(Color.parseColor("#2B1B17")));
        this.mResources.add(Integer.valueOf(Color.parseColor("#34282C")));
        this.mResources.add(Integer.valueOf(Color.parseColor("#25383C")));
        this.mResources.add(Integer.valueOf(Color.parseColor("#3B3131")));
        this.mResources.add(Integer.valueOf(Color.parseColor("#3D3C3A")));
        this.mResources.add(Integer.valueOf(Color.parseColor("#4C4646")));
        this.mResources.add(Integer.valueOf(Color.parseColor("#625D5D")));
        this.mResources.add(Integer.valueOf(Color.parseColor("#726E6D")));
        this.mResources.add(Integer.valueOf(Color.parseColor("#B6B6B4")));
        this.mResources.add(Integer.valueOf(Color.parseColor("#BCC6CC")));
        this.mResources.add(Integer.valueOf(Color.parseColor("#98AFC7")));
        this.mResources.add(Integer.valueOf(Color.parseColor("#616D7E")));
        this.mResources.add(Integer.valueOf(Color.parseColor("#566D7E")));
        this.mResources.add(Integer.valueOf(Color.parseColor("#737CA1")));
        this.mResources.add(Integer.valueOf(Color.parseColor("#4863A0")));
        this.mResources.add(Integer.valueOf(Color.parseColor("#2B547E")));
        this.mResources.add(Integer.valueOf(Color.parseColor("#2B3856")));
        this.mResources.add(Integer.valueOf(Color.parseColor("#151B54")));
        this.mResources.add(Integer.valueOf(Color.parseColor("#000080")));
        this.mResources.add(Integer.valueOf(Color.parseColor("#15317E")));
        this.mResources.add(Integer.valueOf(Color.parseColor("#0000A0")));
        this.mResources.add(Integer.valueOf(Color.parseColor("#0041C2")));
        this.mResources.add(Integer.valueOf(Color.parseColor("#1569C7")));
        this.mResources.add(Integer.valueOf(Color.parseColor("#6960EC")));
        this.mResources.add(Integer.valueOf(Color.parseColor("#368BC1")));
        this.mResources.add(Integer.valueOf(Color.parseColor("#3090C7")));
        this.mResources.add(Integer.valueOf(Color.parseColor("#87AFC7")));
        this.mResources.add(Integer.valueOf(Color.parseColor("#728FCE")));
        this.mResources.add(Integer.valueOf(Color.parseColor("#6698FF")));
        this.mResources.add(Integer.valueOf(Color.parseColor("#617C58")));
        this.mResources.add(Integer.valueOf(Color.parseColor("#728C00")));
        this.mResources.add(Integer.valueOf(Color.parseColor("#667C26")));
        this.mResources.add(Integer.valueOf(Color.parseColor("#254117")));
        this.mResources.add(Integer.valueOf(Color.parseColor("#306754")));
        this.mResources.add(Integer.valueOf(Color.parseColor("#437C17")));
        this.mResources.add(Integer.valueOf(Color.parseColor("#4E9258")));
        this.mResources.add(Integer.valueOf(Color.parseColor("#6AA121")));
        this.mResources.add(Integer.valueOf(Color.parseColor("#54C571")));
        this.mResources.add(Integer.valueOf(Color.parseColor("#9CB071")));
        this.mResources.add(Integer.valueOf(Color.parseColor("#FFDB58")));
        this.mResources.add(Integer.valueOf(Color.parseColor("#FBB917")));
        this.mResources.add(Integer.valueOf(Color.parseColor("#E2A76F")));
        this.mResources.add(Integer.valueOf(Color.parseColor("#FFCBA4")));
        this.mResources.add(Integer.valueOf(Color.parseColor("#D4A017")));
        this.mResources.add(Integer.valueOf(Color.parseColor("#B87333")));
        this.mResources.add(Integer.valueOf(Color.parseColor("#786D5F")));
        this.mResources.add(Integer.valueOf(Color.parseColor("#7F5217")));
        this.mResources.add(Integer.valueOf(Color.parseColor("#E56717")));
        this.mResources.add(Integer.valueOf(Color.parseColor("#7F4E52")));
        this.themeColorsAdapter = new ThemeColorsAdapter(this, this.mResources, str);
        new LinearLayoutManager(this).setOrientation(RecyclerView.VERTICAL);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            public int getSpanSize(int i) {
                return 1;
            }
        });
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(this.themeColorsAdapter);
    }


    public void setBottomLayoutOpenNavigation(View view2, final View view3, int i) {
        Animation loadAnimation = AnimationUtils.loadAnimation(this.context, i);
        loadAnimation.setRepeatMode(0);
        view2.setVisibility(View.VISIBLE);
        view2.startAnimation(loadAnimation);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationRepeat(Animation animation) {
                Log.e("f","");
            }

            public void onAnimationStart(Animation animation) {
                Log.e("f","");
            }

            public void onAnimationEnd(Animation animation) {
                view3.setVisibility(View.GONE);
            }
        });
    }

    private void setStandardColors() {
        this.textView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (GreetingCardEditActivity.this.getLastTouchedEditTextView() != null) {
                    if (GreetingCardEditActivity.this.isShaderApplied) {
                        GreetingCardEditActivity.this.getLastTouchedEditTextView().getPaint().setShader((Shader) null);
                        GreetingCardEditActivity.this.isShaderApplied = false;
                    }
                    GreetingCardEditActivity.this.getLastTouchedEditTextView().setShadowLayer(1.0f, (float) GreetingCardEditActivity.this.SHADOW_PROGRESS, (float) GreetingCardEditActivity.this.SHADOW_PROGRESS, GreetingCardEditActivity.this.getResources().getColor(R.color.Red_Wine));
                    GreetingCardEditActivity.this.displaySelectedFontShadowColor.setBackgroundColor(GreetingCardEditActivity.this.getResources().getColor(R.color.Red_Wine));
                    return;
                }
                Toast.makeText(GreetingCardEditActivity.this, "Please select text.", Toast.LENGTH_SHORT).show();
            }
        });
        this.textView4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (GreetingCardEditActivity.this.getLastTouchedEditTextView() != null) {
                    if (GreetingCardEditActivity.this.isShaderApplied) {
                        GreetingCardEditActivity.this.getLastTouchedEditTextView().getPaint().setShader((Shader) null);
                        GreetingCardEditActivity.this.isShaderApplied = false;
                    }
                    GreetingCardEditActivity.this.getLastTouchedEditTextView().setShadowLayer(1.0f, (float) GreetingCardEditActivity.this.SHADOW_PROGRESS, (float) GreetingCardEditActivity.this.SHADOW_PROGRESS, GreetingCardEditActivity.this.getResources().getColor(R.color.red));
                    GreetingCardEditActivity.this.displaySelectedFontShadowColor.setBackgroundColor(GreetingCardEditActivity.this.getResources().getColor(R.color.red));
                    return;
                }
                Toast.makeText(GreetingCardEditActivity.this, "Please select text.", Toast.LENGTH_SHORT).show();
            }
        });
        this.textView5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (GreetingCardEditActivity.this.getLastTouchedEditTextView() != null) {
                    if (GreetingCardEditActivity.this.isShaderApplied) {
                        GreetingCardEditActivity.this.getLastTouchedEditTextView().getPaint().setShader((Shader) null);
                        GreetingCardEditActivity.this.isShaderApplied = false;
                    }
                    GreetingCardEditActivity.this.getLastTouchedEditTextView().setShadowLayer(1.0f, (float) GreetingCardEditActivity.this.SHADOW_PROGRESS, (float) GreetingCardEditActivity.this.SHADOW_PROGRESS, GreetingCardEditActivity.this.getResources().getColor(R.color.Dark_Orange));
                    GreetingCardEditActivity.this.displaySelectedFontShadowColor.setBackgroundColor(GreetingCardEditActivity.this.getResources().getColor(R.color.Dark_Orange));
                    return;
                }
                Toast.makeText(GreetingCardEditActivity.this, "Please select text.", Toast.LENGTH_SHORT).show();
            }
        });
        this.textView6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (GreetingCardEditActivity.this.getLastTouchedEditTextView() != null) {
                    if (GreetingCardEditActivity.this.isShaderApplied) {
                        GreetingCardEditActivity.this.getLastTouchedEditTextView().getPaint().setShader((Shader) null);
                        GreetingCardEditActivity.this.isShaderApplied = false;
                    }
                    GreetingCardEditActivity.this.getLastTouchedEditTextView().setShadowLayer(1.0f, (float) GreetingCardEditActivity.this.SHADOW_PROGRESS, (float) GreetingCardEditActivity.this.SHADOW_PROGRESS, GreetingCardEditActivity.this.getResources().getColor(R.color.Yellow));
                    GreetingCardEditActivity.this.displaySelectedFontShadowColor.setBackgroundColor(GreetingCardEditActivity.this.getResources().getColor(R.color.Yellow));
                    return;
                }
                Toast.makeText(GreetingCardEditActivity.this, "Please select text.", Toast.LENGTH_SHORT).show();
            }
        });
        this.textView7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (GreetingCardEditActivity.this.getLastTouchedEditTextView() != null) {
                    if (GreetingCardEditActivity.this.isShaderApplied) {
                        GreetingCardEditActivity.this.getLastTouchedEditTextView().getPaint().setShader((Shader) null);
                        GreetingCardEditActivity.this.isShaderApplied = false;
                    }
                    GreetingCardEditActivity.this.getLastTouchedEditTextView().setShadowLayer(1.0f, (float) GreetingCardEditActivity.this.SHADOW_PROGRESS, (float) GreetingCardEditActivity.this.SHADOW_PROGRESS, GreetingCardEditActivity.this.getResources().getColor(R.color.Green_Apple));
                    GreetingCardEditActivity.this.displaySelectedFontShadowColor.setBackgroundColor(GreetingCardEditActivity.this.getResources().getColor(R.color.Green_Apple));
                    return;
                }
                Toast.makeText(GreetingCardEditActivity.this, "Please select text.", Toast.LENGTH_SHORT).show();
            }
        });
        this.textView10.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (GreetingCardEditActivity.this.getLastTouchedEditTextView() != null) {
                    if (GreetingCardEditActivity.this.isShaderApplied) {
                        GreetingCardEditActivity.this.getLastTouchedEditTextView().getPaint().setShader((Shader) null);
                        GreetingCardEditActivity.this.isShaderApplied = false;
                    }
                    GreetingCardEditActivity.this.getLastTouchedEditTextView().setShadowLayer(1.0f, (float) GreetingCardEditActivity.this.SHADOW_PROGRESS, (float) GreetingCardEditActivity.this.SHADOW_PROGRESS, GreetingCardEditActivity.this.getResources().getColor(R.color.dark_green));
                    GreetingCardEditActivity.this.displaySelectedFontShadowColor.setBackgroundColor(GreetingCardEditActivity.this.getResources().getColor(R.color.dark_green));
                    return;
                }
                Toast.makeText(GreetingCardEditActivity.this, "Please select text.", Toast.LENGTH_SHORT).show();
            }
        });
        this.textView8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (GreetingCardEditActivity.this.getLastTouchedEditTextView() != null) {
                    if (GreetingCardEditActivity.this.isShaderApplied) {
                        GreetingCardEditActivity.this.getLastTouchedEditTextView().getPaint().setShader((Shader) null);
                        GreetingCardEditActivity.this.isShaderApplied = false;
                    }
                    GreetingCardEditActivity.this.getLastTouchedEditTextView().setShadowLayer(1.0f, (float) GreetingCardEditActivity.this.SHADOW_PROGRESS, (float) GreetingCardEditActivity.this.SHADOW_PROGRESS, GreetingCardEditActivity.this.getResources().getColor(R.color.blue));
                    GreetingCardEditActivity.this.displaySelectedFontShadowColor.setBackgroundColor(GreetingCardEditActivity.this.getResources().getColor(R.color.blue));
                    return;
                }
                Toast.makeText(GreetingCardEditActivity.this, "Please select text.", Toast.LENGTH_SHORT).show();
            }
        });
        this.textView9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (GreetingCardEditActivity.this.getLastTouchedEditTextView() != null) {
                    if (GreetingCardEditActivity.this.isShaderApplied) {
                        GreetingCardEditActivity.this.getLastTouchedEditTextView().getPaint().setShader((Shader) null);
                        GreetingCardEditActivity.this.isShaderApplied = false;
                    }
                    GreetingCardEditActivity.this.getLastTouchedEditTextView().setShadowLayer(1.0f, (float) GreetingCardEditActivity.this.SHADOW_PROGRESS, (float) GreetingCardEditActivity.this.SHADOW_PROGRESS, GreetingCardEditActivity.this.getResources().getColor(R.color.Navy_Blue));
                    GreetingCardEditActivity.this.displaySelectedFontShadowColor.setBackgroundColor(GreetingCardEditActivity.this.getResources().getColor(R.color.Navy_Blue));
                    return;
                }
                Toast.makeText(GreetingCardEditActivity.this, "Please select text.", Toast.LENGTH_SHORT).show();
            }
        });
        this.textView11.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (GreetingCardEditActivity.this.getLastTouchedEditTextView() != null) {
                    if (GreetingCardEditActivity.this.isShaderApplied) {
                        GreetingCardEditActivity.this.getLastTouchedEditTextView().getPaint().setShader((Shader) null);
                        GreetingCardEditActivity.this.isShaderApplied = false;
                    }
                    GreetingCardEditActivity.this.getLastTouchedEditTextView().setShadowLayer(1.0f, (float) GreetingCardEditActivity.this.SHADOW_PROGRESS, (float) GreetingCardEditActivity.this.SHADOW_PROGRESS, GreetingCardEditActivity.this.getResources().getColor(R.color.Purple));
                    GreetingCardEditActivity.this.displaySelectedFontShadowColor.setBackgroundColor(GreetingCardEditActivity.this.getResources().getColor(R.color.Purple));
                    return;
                }
                Toast.makeText(GreetingCardEditActivity.this, "Please select text.", Toast.LENGTH_SHORT).show();
            }
        });
        this.textView1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (GreetingCardEditActivity.this.getLastTouchedEditTextView() != null) {
                    if (GreetingCardEditActivity.this.isShaderApplied) {
                        GreetingCardEditActivity.this.getLastTouchedEditTextView().getPaint().setShader((Shader) null);
                        GreetingCardEditActivity.this.isShaderApplied = false;
                    }
                    GreetingCardEditActivity.this.getLastTouchedEditTextView().setShadowLayer(1.0f, (float) GreetingCardEditActivity.this.SHADOW_PROGRESS, (float) GreetingCardEditActivity.this.SHADOW_PROGRESS, GreetingCardEditActivity.this.getResources().getColor(R.color.Magenta));
                    GreetingCardEditActivity.this.displaySelectedFontShadowColor.setBackgroundColor(GreetingCardEditActivity.this.getResources().getColor(R.color.Magenta));
                    return;
                }
                Toast.makeText(GreetingCardEditActivity.this, "Please select text.", Toast.LENGTH_SHORT).show();
            }
        });
        this.textView2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (GreetingCardEditActivity.this.getLastTouchedEditTextView() != null) {
                    if (GreetingCardEditActivity.this.isShaderApplied) {
                        GreetingCardEditActivity.this.getLastTouchedEditTextView().getPaint().setShader((Shader) null);
                        GreetingCardEditActivity.this.isShaderApplied = false;
                    }
                    GreetingCardEditActivity.this.getLastTouchedEditTextView().setShadowLayer(1.0f, (float) GreetingCardEditActivity.this.SHADOW_PROGRESS, (float) GreetingCardEditActivity.this.SHADOW_PROGRESS, GreetingCardEditActivity.this.getResources().getColor(R.color.white));
                    GreetingCardEditActivity.this.displaySelectedFontShadowColor.setBackgroundColor(GreetingCardEditActivity.this.getResources().getColor(R.color.white));
                    return;
                }
                Toast.makeText(GreetingCardEditActivity.this, "Please select text.", Toast.LENGTH_SHORT).show();
            }
        });
        this.textView3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (GreetingCardEditActivity.this.getLastTouchedEditTextView() != null) {
                    if (GreetingCardEditActivity.this.isShaderApplied) {
                        GreetingCardEditActivity.this.getLastTouchedEditTextView().getPaint().setShader((Shader) null);
                        GreetingCardEditActivity.this.isShaderApplied = false;
                    }
                    GreetingCardEditActivity.this.getLastTouchedEditTextView().setShadowLayer(1.0f, (float) GreetingCardEditActivity.this.SHADOW_PROGRESS, (float) GreetingCardEditActivity.this.SHADOW_PROGRESS, GreetingCardEditActivity.this.getResources().getColor(R.color.black));
                    GreetingCardEditActivity.this.displaySelectedFontShadowColor.setBackgroundColor(GreetingCardEditActivity.this.getResources().getColor(R.color.black));
                    return;
                }
                Toast.makeText(GreetingCardEditActivity.this, "Please select text.", Toast.LENGTH_SHORT).show();
            }
        });
        this.sc1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (GreetingCardEditActivity.this.getLastTouchedEditTextView() != null) {
                    if (GreetingCardEditActivity.this.isShaderApplied) {
                        GreetingCardEditActivity.this.getLastTouchedEditTextView().getPaint().setShader((Shader) null);
                        GreetingCardEditActivity.this.isShaderApplied = false;
                    }
                    GreetingCardEditActivity.this.getLastTouchedEditTextView().setTextColor(GreetingCardEditActivity.this.getResources().getColor(R.color.Red_Wine));
                    GreetingCardEditActivity.this.displaySelectedFontColor.setBackgroundColor(GreetingCardEditActivity.this.getResources().getColor(R.color.Red_Wine));
                    return;
                }
                Toast.makeText(GreetingCardEditActivity.this, "Please select text.", Toast.LENGTH_SHORT).show();
            }
        });
        this.sc2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (GreetingCardEditActivity.this.getLastTouchedEditTextView() != null) {
                    if (GreetingCardEditActivity.this.isShaderApplied) {
                        GreetingCardEditActivity.this.getLastTouchedEditTextView().getPaint().setShader((Shader) null);
                        GreetingCardEditActivity.this.isShaderApplied = false;
                    }
                    GreetingCardEditActivity.this.getLastTouchedEditTextView().setTextColor(GreetingCardEditActivity.this.getResources().getColor(R.color.red));
                    GreetingCardEditActivity.this.displaySelectedFontColor.setBackgroundColor(GreetingCardEditActivity.this.getResources().getColor(R.color.red));
                    return;
                }
                Toast.makeText(GreetingCardEditActivity.this, "Please select text.", Toast.LENGTH_SHORT).show();
            }
        });
        this.sc3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (GreetingCardEditActivity.this.getLastTouchedEditTextView() != null) {
                    if (GreetingCardEditActivity.this.isShaderApplied) {
                        GreetingCardEditActivity.this.getLastTouchedEditTextView().getPaint().setShader((Shader) null);
                        GreetingCardEditActivity.this.isShaderApplied = false;
                    }
                    GreetingCardEditActivity.this.getLastTouchedEditTextView().setTextColor(GreetingCardEditActivity.this.getResources().getColor(R.color.Dark_Orange));
                    GreetingCardEditActivity.this.displaySelectedFontColor.setBackgroundColor(GreetingCardEditActivity.this.getResources().getColor(R.color.Dark_Orange));
                    return;
                }
                Toast.makeText(GreetingCardEditActivity.this, "Please select text.", Toast.LENGTH_SHORT).show();
            }
        });
        this.sc4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (GreetingCardEditActivity.this.getLastTouchedEditTextView() != null) {
                    if (GreetingCardEditActivity.this.isShaderApplied) {
                        GreetingCardEditActivity.this.getLastTouchedEditTextView().getPaint().setShader((Shader) null);
                        GreetingCardEditActivity.this.isShaderApplied = false;
                    }
                    GreetingCardEditActivity.this.getLastTouchedEditTextView().setTextColor(GreetingCardEditActivity.this.getResources().getColor(R.color.Yellow));
                    GreetingCardEditActivity.this.displaySelectedFontColor.setBackgroundColor(GreetingCardEditActivity.this.getResources().getColor(R.color.Yellow));
                    return;
                }
                Toast.makeText(GreetingCardEditActivity.this, "Please select text.", Toast.LENGTH_SHORT).show();
            }
        });
        this.sc5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (GreetingCardEditActivity.this.getLastTouchedEditTextView() != null) {
                    if (GreetingCardEditActivity.this.isShaderApplied) {
                        GreetingCardEditActivity.this.getLastTouchedEditTextView().getPaint().setShader((Shader) null);
                        GreetingCardEditActivity.this.isShaderApplied = false;
                    }
                    GreetingCardEditActivity.this.getLastTouchedEditTextView().setTextColor(GreetingCardEditActivity.this.getResources().getColor(R.color.Green_Apple));
                    GreetingCardEditActivity.this.displaySelectedFontColor.setBackgroundColor(GreetingCardEditActivity.this.getResources().getColor(R.color.Green_Apple));
                    return;
                }
                Toast.makeText(GreetingCardEditActivity.this, "Please select text.", Toast.LENGTH_SHORT).show();
            }
        });
        this.sc6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (GreetingCardEditActivity.this.getLastTouchedEditTextView() != null) {
                    if (GreetingCardEditActivity.this.isShaderApplied) {
                        GreetingCardEditActivity.this.getLastTouchedEditTextView().getPaint().setShader((Shader) null);
                        GreetingCardEditActivity.this.isShaderApplied = false;
                    }
                    GreetingCardEditActivity.this.getLastTouchedEditTextView().setTextColor(GreetingCardEditActivity.this.getResources().getColor(R.color.dark_green));
                    GreetingCardEditActivity.this.displaySelectedFontColor.setBackgroundColor(GreetingCardEditActivity.this.getResources().getColor(R.color.dark_green));
                    return;
                }
                Toast.makeText(GreetingCardEditActivity.this, "Please select text.", Toast.LENGTH_SHORT).show();
            }
        });
        this.sc7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (GreetingCardEditActivity.this.getLastTouchedEditTextView() != null) {
                    if (GreetingCardEditActivity.this.isShaderApplied) {
                        GreetingCardEditActivity.this.getLastTouchedEditTextView().getPaint().setShader((Shader) null);
                        GreetingCardEditActivity.this.isShaderApplied = false;
                    }
                    GreetingCardEditActivity.this.getLastTouchedEditTextView().setTextColor(GreetingCardEditActivity.this.getResources().getColor(R.color.blue));
                    GreetingCardEditActivity.this.displaySelectedFontColor.setBackgroundColor(GreetingCardEditActivity.this.getResources().getColor(R.color.blue));
                    return;
                }
                Toast.makeText(GreetingCardEditActivity.this, "Please select text.", Toast.LENGTH_SHORT).show();
            }
        });
        this.sc8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (GreetingCardEditActivity.this.getLastTouchedEditTextView() != null) {
                    if (GreetingCardEditActivity.this.isShaderApplied) {
                        GreetingCardEditActivity.this.getLastTouchedEditTextView().getPaint().setShader((Shader) null);
                        GreetingCardEditActivity.this.isShaderApplied = false;
                    }
                    GreetingCardEditActivity.this.getLastTouchedEditTextView().setTextColor(GreetingCardEditActivity.this.getResources().getColor(R.color.Navy_Blue));
                    GreetingCardEditActivity.this.displaySelectedFontColor.setBackgroundColor(GreetingCardEditActivity.this.getResources().getColor(R.color.Navy_Blue));
                    return;
                }
                Toast.makeText(GreetingCardEditActivity.this, "Please select text.", Toast.LENGTH_SHORT).show();
            }
        });
        this.sc9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (GreetingCardEditActivity.this.getLastTouchedEditTextView() != null) {
                    if (GreetingCardEditActivity.this.isShaderApplied) {
                        GreetingCardEditActivity.this.getLastTouchedEditTextView().getPaint().setShader((Shader) null);
                        GreetingCardEditActivity.this.isShaderApplied = false;
                    }
                    GreetingCardEditActivity.this.getLastTouchedEditTextView().setTextColor(GreetingCardEditActivity.this.getResources().getColor(R.color.Purple));
                    GreetingCardEditActivity.this.displaySelectedFontColor.setBackgroundColor(GreetingCardEditActivity.this.getResources().getColor(R.color.Purple));
                    return;
                }
                Toast.makeText(GreetingCardEditActivity.this, "Please select text.", Toast.LENGTH_SHORT).show();
            }
        });
        this.sc10.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (GreetingCardEditActivity.this.getLastTouchedEditTextView() != null) {
                    if (GreetingCardEditActivity.this.isShaderApplied) {
                        GreetingCardEditActivity.this.getLastTouchedEditTextView().getPaint().setShader((Shader) null);
                        GreetingCardEditActivity.this.isShaderApplied = false;
                    }
                    GreetingCardEditActivity.this.getLastTouchedEditTextView().setTextColor(GreetingCardEditActivity.this.getResources().getColor(R.color.Magenta));
                    GreetingCardEditActivity.this.displaySelectedFontColor.setBackgroundColor(GreetingCardEditActivity.this.getResources().getColor(R.color.Magenta));
                    return;
                }
                Toast.makeText(GreetingCardEditActivity.this, "Please select text.", Toast.LENGTH_SHORT).show();
            }
        });
        this.sc11.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (GreetingCardEditActivity.this.getLastTouchedEditTextView() != null) {
                    if (GreetingCardEditActivity.this.isShaderApplied) {
                        GreetingCardEditActivity.this.getLastTouchedEditTextView().getPaint().setShader((Shader) null);
                        GreetingCardEditActivity.this.isShaderApplied = false;
                    }
                    GreetingCardEditActivity.this.getLastTouchedEditTextView().setTextColor(GreetingCardEditActivity.this.getResources().getColor(R.color.white));
                    GreetingCardEditActivity.this.displaySelectedFontColor.setBackgroundColor(GreetingCardEditActivity.this.getResources().getColor(R.color.white));
                    return;
                }
                Toast.makeText(GreetingCardEditActivity.this, "Please select text.", Toast.LENGTH_SHORT).show();
            }
        });
        this.sc12.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (GreetingCardEditActivity.this.getLastTouchedEditTextView() != null) {
                    if (GreetingCardEditActivity.this.isShaderApplied) {
                        GreetingCardEditActivity.this.getLastTouchedEditTextView().getPaint().setShader((Shader) null);
                        GreetingCardEditActivity.this.isShaderApplied = false;
                    }
                    GreetingCardEditActivity.this.getLastTouchedEditTextView().setTextColor(GreetingCardEditActivity.this.getResources().getColor(R.color.black));
                    GreetingCardEditActivity.this.displaySelectedFontColor.setBackgroundColor(GreetingCardEditActivity.this.getResources().getColor(R.color.black));
                    return;
                }
                Toast.makeText(GreetingCardEditActivity.this, "Please select text.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setFontsColorGradient() {
        this.gradient1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (GreetingCardEditActivity.this.getLastTouchedEditTextView() != null) {
                    GreetingCardEditActivity.this.isShaderApplied = true;
                    GreetingCardEditActivity.this.getLastTouchedEditTextView().getPaint().setShader((Shader) null);
                    EditText lastTouchedEditTextView = GreetingCardEditActivity.this.getLastTouchedEditTextView();
                    lastTouchedEditTextView.setText(GreetingCardEditActivity.this.getLastTouchedEditTextView().getText().toString() + "");
                    GreetingCardEditActivity.this.getLastTouchedEditTextView().setTextColor(-1);
                    GreetingCardEditActivity.this.getLastTouchedEditTextView().getPaint().setShader(GreetingCardEditActivity.this.getGradientShader(Color.parseColor("#ff0f47"), Color.parseColor("#ffab96")));
                    GreetingCardEditActivity.this.displaySelectedFontColor.setBackground(ContextCompat.getDrawable(GreetingCardEditActivity.this.context, R.drawable.gradient_color_1));
                    return;
                }
                Toast.makeText(GreetingCardEditActivity.this, "Please select text.", Toast.LENGTH_SHORT).show();
            }
        });
        this.gradient2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (GreetingCardEditActivity.this.getLastTouchedEditTextView() != null) {
                    GreetingCardEditActivity.this.isShaderApplied = true;
                    GreetingCardEditActivity.this.getLastTouchedEditTextView().getPaint().setShader((Shader) null);
                    EditText lastTouchedEditTextView = GreetingCardEditActivity.this.getLastTouchedEditTextView();
                    lastTouchedEditTextView.setText(GreetingCardEditActivity.this.getLastTouchedEditTextView().getText().toString() + "");
                    GreetingCardEditActivity.this.getLastTouchedEditTextView().setTextColor(-1);
                    GreetingCardEditActivity.this.getLastTouchedEditTextView().getPaint().setShader(GreetingCardEditActivity.this.getGradientShader(Color.parseColor("#9f44d3"), Color.parseColor("#e2b0ff")));
                    GreetingCardEditActivity.this.displaySelectedFontColor.setBackground(ContextCompat.getDrawable(GreetingCardEditActivity.this.context, R.drawable.gradient_color_2));
                    return;
                }
                Toast.makeText(GreetingCardEditActivity.this, "Please select text.", Toast.LENGTH_SHORT).show();
            }
        });
        this.gradient3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (GreetingCardEditActivity.this.getLastTouchedEditTextView() != null) {
                    GreetingCardEditActivity.this.isShaderApplied = true;
                    GreetingCardEditActivity.this.getLastTouchedEditTextView().getPaint().setShader((Shader) null);
                    EditText lastTouchedEditTextView = GreetingCardEditActivity.this.getLastTouchedEditTextView();
                    lastTouchedEditTextView.setText(GreetingCardEditActivity.this.getLastTouchedEditTextView().getText().toString() + "");
                    GreetingCardEditActivity.this.getLastTouchedEditTextView().setTextColor(-1);
                    GreetingCardEditActivity.this.getLastTouchedEditTextView().getPaint().setShader(GreetingCardEditActivity.this.getGradientShader(Color.parseColor("#49c628"), Color.parseColor("#70f570")));
                    GreetingCardEditActivity.this.displaySelectedFontColor.setBackground(ContextCompat.getDrawable(GreetingCardEditActivity.this.context, R.drawable.gradient_color_3));
                    return;
                }
                Toast.makeText(GreetingCardEditActivity.this, "Please select text.", Toast.LENGTH_SHORT).show();
            }
        });
        this.gradient4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (GreetingCardEditActivity.this.getLastTouchedEditTextView() != null) {
                    GreetingCardEditActivity.this.isShaderApplied = true;
                    GreetingCardEditActivity.this.getLastTouchedEditTextView().getPaint().setShader((Shader) null);
                    EditText lastTouchedEditTextView = GreetingCardEditActivity.this.getLastTouchedEditTextView();
                    lastTouchedEditTextView.setText(GreetingCardEditActivity.this.getLastTouchedEditTextView().getText().toString() + "");
                    GreetingCardEditActivity.this.getLastTouchedEditTextView().setTextColor(-1);
                    GreetingCardEditActivity.this.getLastTouchedEditTextView().getPaint().setShader(GreetingCardEditActivity.this.getGradientShader(Color.parseColor("#007aff"), Color.parseColor("#00b9ff")));
                    GreetingCardEditActivity.this.displaySelectedFontColor.setBackground(ContextCompat.getDrawable(GreetingCardEditActivity.this.context, R.drawable.gradient_color_4));
                    return;
                }
                Toast.makeText(GreetingCardEditActivity.this, "Please select text.", Toast.LENGTH_SHORT).show();
            }
        });
        this.gradient5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (GreetingCardEditActivity.this.getLastTouchedEditTextView() != null) {
                    GreetingCardEditActivity.this.isShaderApplied = true;
                    GreetingCardEditActivity.this.getLastTouchedEditTextView().getPaint().setShader((Shader) null);
                    EditText lastTouchedEditTextView = GreetingCardEditActivity.this.getLastTouchedEditTextView();
                    lastTouchedEditTextView.setText(GreetingCardEditActivity.this.getLastTouchedEditTextView().getText().toString() + "");
                    GreetingCardEditActivity.this.getLastTouchedEditTextView().setTextColor(-1);
                    GreetingCardEditActivity.this.getLastTouchedEditTextView().getPaint().setShader(GreetingCardEditActivity.this.getGradientShader(Color.parseColor("#f56285"), Color.parseColor("#f089e5")));
                    GreetingCardEditActivity.this.displaySelectedFontColor.setBackground(ContextCompat.getDrawable(GreetingCardEditActivity.this.context, R.drawable.gradient_color_5));
                    return;
                }
                Toast.makeText(GreetingCardEditActivity.this, "Please select text.", Toast.LENGTH_SHORT).show();
            }
        });
        this.gradient6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (GreetingCardEditActivity.this.getLastTouchedEditTextView() != null) {
                    GreetingCardEditActivity.this.isShaderApplied = true;
                    GreetingCardEditActivity.this.getLastTouchedEditTextView().getPaint().setShader((Shader) null);
                    EditText lastTouchedEditTextView = GreetingCardEditActivity.this.getLastTouchedEditTextView();
                    lastTouchedEditTextView.setText(GreetingCardEditActivity.this.getLastTouchedEditTextView().getText().toString() + "");
                    GreetingCardEditActivity.this.getLastTouchedEditTextView().setTextColor(-1);
                    GreetingCardEditActivity.this.getLastTouchedEditTextView().getPaint().setShader(GreetingCardEditActivity.this.getGradientShader(Color.parseColor("#344754"), Color.parseColor("#c0bdb8")));
                    GreetingCardEditActivity.this.displaySelectedFontColor.setBackground(ContextCompat.getDrawable(GreetingCardEditActivity.this.context, R.drawable.gradient_color_6));
                    return;
                }
                Toast.makeText(GreetingCardEditActivity.this, "Please select text.", Toast.LENGTH_SHORT).show();
            }
        });
        this.gradient7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (GreetingCardEditActivity.this.getLastTouchedEditTextView() != null) {
                    GreetingCardEditActivity.this.isShaderApplied = true;
                    GreetingCardEditActivity.this.getLastTouchedEditTextView().getPaint().setShader((Shader) null);
                    EditText lastTouchedEditTextView = GreetingCardEditActivity.this.getLastTouchedEditTextView();
                    lastTouchedEditTextView.setText(GreetingCardEditActivity.this.getLastTouchedEditTextView().getText().toString() + "");
                    GreetingCardEditActivity.this.getLastTouchedEditTextView().setTextColor(-1);
                    GreetingCardEditActivity.this.getLastTouchedEditTextView().getPaint().setShader(GreetingCardEditActivity.this.getGradientShader(Color.parseColor("#0076ff"), Color.parseColor("#00ff80")));
                    GreetingCardEditActivity.this.displaySelectedFontColor.setBackground(ContextCompat.getDrawable(GreetingCardEditActivity.this.context, R.drawable.gradient_color_7));
                    return;
                }
                Toast.makeText(GreetingCardEditActivity.this, "Please select text.", Toast.LENGTH_SHORT).show();
            }
        });
        this.gradient8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (GreetingCardEditActivity.this.getLastTouchedEditTextView() != null) {
                    GreetingCardEditActivity.this.isShaderApplied = true;
                    GreetingCardEditActivity.this.getLastTouchedEditTextView().getPaint().setShader((Shader) null);
                    EditText lastTouchedEditTextView = GreetingCardEditActivity.this.getLastTouchedEditTextView();
                    lastTouchedEditTextView.setText(GreetingCardEditActivity.this.getLastTouchedEditTextView().getText().toString() + "");
                    GreetingCardEditActivity.this.getLastTouchedEditTextView().setTextColor(-1);
                    GreetingCardEditActivity.this.getLastTouchedEditTextView().getPaint().setShader(GreetingCardEditActivity.this.getGradientShader(Color.parseColor("#ff18f7"), Color.parseColor("#ff9500")));
                    GreetingCardEditActivity.this.displaySelectedFontColor.setBackground(ContextCompat.getDrawable(GreetingCardEditActivity.this.context, R.drawable.gradient_color_8));
                    return;
                }
                Toast.makeText(GreetingCardEditActivity.this, "Please select text.", Toast.LENGTH_SHORT).show();
            }
        });
        this.gradient9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (GreetingCardEditActivity.this.getLastTouchedEditTextView() != null) {
                    GreetingCardEditActivity.this.isShaderApplied = true;
                    GreetingCardEditActivity.this.getLastTouchedEditTextView().getPaint().setShader((Shader) null);
                    EditText lastTouchedEditTextView = GreetingCardEditActivity.this.getLastTouchedEditTextView();
                    lastTouchedEditTextView.setText(GreetingCardEditActivity.this.getLastTouchedEditTextView().getText().toString() + "");
                    GreetingCardEditActivity.this.getLastTouchedEditTextView().setTextColor(-1);
                    GreetingCardEditActivity.this.getLastTouchedEditTextView().getPaint().setShader(GreetingCardEditActivity.this.getGradientShader(Color.parseColor("#f2ff00"), Color.parseColor("#00ffcc")));
                    GreetingCardEditActivity.this.displaySelectedFontColor.setBackground(ContextCompat.getDrawable(GreetingCardEditActivity.this.context, R.drawable.gradient_color_9));
                    return;
                }
                Toast.makeText(GreetingCardEditActivity.this, "Please select text.", Toast.LENGTH_SHORT).show();
            }
        });
        this.gradient10.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (GreetingCardEditActivity.this.getLastTouchedEditTextView() != null) {
                    GreetingCardEditActivity.this.isShaderApplied = true;
                    GreetingCardEditActivity.this.getLastTouchedEditTextView().getPaint().setShader((Shader) null);
                    EditText lastTouchedEditTextView = GreetingCardEditActivity.this.getLastTouchedEditTextView();
                    lastTouchedEditTextView.setText(GreetingCardEditActivity.this.getLastTouchedEditTextView().getText().toString() + "");
                    GreetingCardEditActivity.this.getLastTouchedEditTextView().setTextColor(-1);
                    GreetingCardEditActivity.this.getLastTouchedEditTextView().getPaint().setShader(GreetingCardEditActivity.this.getGradientShader(Color.parseColor("#391cff"), Color.parseColor("#ff3b30")));
                    GreetingCardEditActivity.this.displaySelectedFontColor.setBackground(ContextCompat.getDrawable(GreetingCardEditActivity.this.context, R.drawable.gradient_color_10));
                    return;
                }
                Toast.makeText(GreetingCardEditActivity.this, "Please select text.", Toast.LENGTH_SHORT).show();
            }
        });
        this.gradient11.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (GreetingCardEditActivity.this.getLastTouchedEditTextView() != null) {
                    GreetingCardEditActivity.this.isShaderApplied = true;
                    GreetingCardEditActivity.this.getLastTouchedEditTextView().getPaint().setShader((Shader) null);
                    EditText lastTouchedEditTextView = GreetingCardEditActivity.this.getLastTouchedEditTextView();
                    lastTouchedEditTextView.setText(GreetingCardEditActivity.this.getLastTouchedEditTextView().getText().toString() + "");
                    GreetingCardEditActivity.this.getLastTouchedEditTextView().setTextColor(-1);
                    GreetingCardEditActivity.this.getLastTouchedEditTextView().getPaint().setShader(GreetingCardEditActivity.this.getGradientShader(Color.parseColor("#facc22"), Color.parseColor("#ffab96")));
                    GreetingCardEditActivity.this.displaySelectedFontColor.setBackground(ContextCompat.getDrawable(GreetingCardEditActivity.this.context, R.drawable.gradient_color_11));
                    return;
                }
                Toast.makeText(GreetingCardEditActivity.this, "Please select text.", Toast.LENGTH_SHORT).show();
            }
        });
        this.gradient12.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (GreetingCardEditActivity.this.getLastTouchedEditTextView() != null) {
                    GreetingCardEditActivity.this.isShaderApplied = true;
                    GreetingCardEditActivity.this.getLastTouchedEditTextView().getPaint().setShader((Shader) null);
                    EditText lastTouchedEditTextView = GreetingCardEditActivity.this.getLastTouchedEditTextView();
                    lastTouchedEditTextView.setText(GreetingCardEditActivity.this.getLastTouchedEditTextView().getText().toString() + "");
                    GreetingCardEditActivity.this.getLastTouchedEditTextView().setTextColor(-1);
                    GreetingCardEditActivity.this.getLastTouchedEditTextView().getPaint().setShader(GreetingCardEditActivity.this.getGradientShader(Color.parseColor("#360940"), Color.parseColor("#f05f57")));
                    GreetingCardEditActivity.this.displaySelectedFontColor.setBackground(ContextCompat.getDrawable(GreetingCardEditActivity.this.context, R.drawable.gradient_color_12));
                    return;
                }
                Toast.makeText(GreetingCardEditActivity.this, "Please select text.", Toast.LENGTH_SHORT).show();
            }
        });
    }


    public Shader getGradientShader(int i, int i2) {
        return new LinearGradient(0.0f, 0.0f, 0.0f, (float) getLastTouchedEditTextView().getLineHeight(), i, i2, Shader.TileMode.REPEAT);
    }

    public void updateSelectedCard(Bitmap bitmap2) {
        this.selectedCard.setImageBitmap(bitmap2);
    }

    public Drawable getBitmapSelectedCard() {
        return this.selectedCard.getDrawable();
    }

    public void hideKeyboard(View view2) {
        ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(view2.getWindowToken(), 0);
    }

    public void openKeyboard(View view2) {
        ((InputMethodManager) getSystemService("input_method")).toggleSoftInputFromWindow(view2.getApplicationWindowToken(), 2, 1);
    }

    public Bitmap getResizedBitmap(Bitmap bitmap2, int i, int i2) {
        int width = bitmap2.getWidth();
        int height = bitmap2.getHeight();
        Matrix matrix = new Matrix();
        matrix.postScale(((float) i) / ((float) width), ((float) i2) / ((float) height));
        Bitmap createBitmap = Bitmap.createBitmap(bitmap2, 0, 0, width, height, matrix, false);
        bitmap2.recycle();
        return createBitmap;
    }

    private void setEditText(EditText editText, String str, int i) {
        AssetManager assets = this.context.getAssets();
        Typeface createFromAsset = Typeface.createFromAsset(assets, "fonts/" + str + ".ttf");
        this.TYPE_FACE = createFromAsset;
        editText.setText(Utils.readRawTextFile(this.context, i));
        editText.setTypeface(createFromAsset);
        editText.setOnTouchListener(this);
    }

    private void initializeEditText() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        if (this.TYPE.equals("wedding_card") && (i5 = this.POSITION) >= 0) {
            switch (i5) {
                case 0:
                    setEditText(this.ed1, "wedding_card_1_font_2", R.raw.wedding_card_1_text_1);
                    setEditText(this.ed2, "wedding_card_1_font_1", R.raw.wedding_card_1_text_2);
                    setEditText(this.ed3, "wedding_card_1_font_2", R.raw.wedding_card_1_text_3);
                    setEditText(this.ed4, "wedding_card_1_font_1", R.raw.wedding_card_1_text_4);
                    setEditText(this.ed5, "wedding_card_1_font_2", R.raw.wedding_card_1_text_5);
                    setEditText(this.ed6, "wedding_card_1_font_1", R.raw.wedding_card_1_text_6);
                    return;
                case 1:
                    setEditText(this.ed1, "wedding_card_2_htowert", R.raw.wedding_card_2_text_1);
                    setEditText(this.ed2, "wedding_card_2_tcm", R.raw.wedding_card_2_text_2);
                    setEditText(this.ed3, "wedding_card_2_droid_serif_regular", R.raw.wedding_card_2_text_3);
                    setEditText(this.ed4, "wedding_card_2_droid_serif_regular", R.raw.wedding_card_2_text_4);
                    return;
                case 2:
                    setEditText(this.ed1, "wedding_card_3_minion_Italic", R.raw.wedding_card_3_text_1);
                    setEditText(this.ed2, "wedding_card_3_lucida_calligraphy_italic", R.raw.wedding_card_3_text_2);
                    setEditText(this.ed3, "wedding_card_3_minion_Italic", R.raw.wedding_card_3_text_3);
                    setEditText(this.ed4, "wedding_card_3_minion_Italic", R.raw.wedding_card_3_text_4);
                    return;
                case 3:
                    setEditText(this.ed1, "wedding_card_4_minion_Italic", R.raw.wedding_card_4_text_1);
                    setEditText(this.ed2, "wedding_card_4_lucida_calligraphy_italic", R.raw.wedding_card_4_text_2);
                    setEditText(this.ed3, "wedding_card_4_lucida_calligraphy_italic", R.raw.wedding_card_4_text_3);
                    setEditText(this.ed4, "wedding_card_4_lucida_sans", R.raw.wedding_card_4_text_4);
                    setEditText(this.ed5, "wedding_card_4_lucida_sans", R.raw.wedding_card_4_text_5);
                    return;
                case 4:
                    setEditText(this.ed1, "wedding_card_5_edwardian_script_itc", R.raw.wedding_card_5_text_1);
                    setEditText(this.ed2, "wedding_card_5_garamond_regular", R.raw.wedding_card_5_text_2);
                    setEditText(this.ed3, "wedding_card_5_maiandra_gd", R.raw.wedding_card_5_text_3);
                    return;
                case 5:
                    setEditText(this.ed1, "wedding_card_6_lucida_fax_regular", R.raw.wedding_card_6_text_1);
                    setEditText(this.ed2, "wedding_card_6_french_scrip_mt", R.raw.wedding_card_6_text_2);
                    setEditText(this.ed3, "wedding_card_5_edwardian_script_itc", R.raw.wedding_card_6_text_3);
                    setEditText(this.ed4, "wedding_card_5_edwardian_script_itc", R.raw.wedding_card_6_text_4);
                    setEditText(this.ed5, "wedding_card_5_edwardian_script_itc", R.raw.wedding_card_6_text_5);
                    return;
                case 6:
                    setEditText(this.ed1, "wedding_card_7_reat_vibes_regular", R.raw.wedding_card_7_text_1);
                    setEditText(this.ed2, "wedding_card_7_eutemia", R.raw.wedding_card_7_text_2);
                    setEditText(this.ed3, "wedding_card_7_reat_vibes_regular", R.raw.wedding_card_7_text_3);
                    return;
                case 7:
                    setEditText(this.ed1, "wedding_card_8_french_script_mt", R.raw.wedding_card_8_text_1);
                    setEditText(this.ed2, "wedding_card_8_french_script_mt", R.raw.wedding_card_8_text_2);
                    setEditText(this.ed3, "wedding_card_8_french_script_mt", R.raw.wedding_card_8_text_3);
                    setEditText(this.ed4, "wedding_card_8_mt_corsva", R.raw.wedding_card_8_text_4);
                    return;
                case 8:
                    setEditText(this.ed1, "wedding_card_9_brush_sci", R.raw.wedding_card_9_text_1);
                    setEditText(this.ed2, "wedding_card_9_blacksword", R.raw.wedding_card_9_text_2);
                    setEditText(this.ed3, "wedding_card_9_brush_sci", R.raw.wedding_card_9_text_3);
                    setEditText(this.ed4, "wedding_card_9_brush_sci", R.raw.wedding_card_9_text_4);
                    return;
                case 9:
                    setEditText(this.ed1, "wedding_card_7_reat_vibes_regular", R.raw.wedding_card_10_text_1);
                    setEditText(this.ed2, "wedding_card_7_reat_vibes_regular", R.raw.wedding_card_10_text_2);
                    setEditText(this.ed3, "wedding_card_8_french_script_mt", R.raw.wedding_card_10_text_3);
                    setEditText(this.ed4, "wedding_card_7_reat_vibes_regular", R.raw.wedding_card_10_text_4);
                    return;
                default:
                    return;
            }
        } else if (this.TYPE.equals("housewarming_card") && (i4 = this.POSITION) >= 0) {
            switch (i4) {
                case 0:
                    setEditText(this.ed1, "house_warming_montserrat_medium", R.raw.house_warming_card_1_text_1);
                    setEditText(this.ed2, "house_warming_card_1_niconne_regular", R.raw.house_warming_card_1_text_2);
                    setEditText(this.ed3, "house_warming_montserrat_medium", R.raw.house_warming_card_1_text_3);
                    return;
                case 1:
                    setEditText(this.ed1, "house_warming_card_2_montserrat_italic", R.raw.house_warming_card_2_text_1);
                    setEditText(this.ed2, "house_warming_montserrat_medium", R.raw.house_warming_card_2_text_2);
                    setEditText(this.ed3, "house_warming_montserrat_medium", R.raw.house_warming_card_2_text_3);
                    setEditText(this.ed4, "house_warming_montserrat_medium", R.raw.house_warming_card_2_text_4);
                    return;
                case 2:
                    setEditText(this.ed1, "house_warming_card_3_french_script_mt", R.raw.house_warming_card_3_text_1);
                    setEditText(this.ed2, "lucida_calligraphy_italic_3", R.raw.house_warming_card_3_text_2);
                    setEditText(this.ed3, "house_warming_montserrat_medium", R.raw.house_warming_card_3_text_3);
                    setEditText(this.ed4, "lucida_calligraphy_italic_3", R.raw.house_warming_card_3_text_4);
                    setEditText(this.ed5, "house_warming_montserrat_medium", R.raw.house_warming_card_3_text_5);
                    return;
                case 3:
                    setEditText(this.ed1, "house_warming_card_4_niconne", R.raw.house_warming_card_4_text_1);
                    setEditText(this.ed2, "house_warming_card_4_montserrat_extrabold", R.raw.house_warming_card_4_text_2);
                    setEditText(this.ed3, "house_warming_card_4_niconne", R.raw.house_warming_card_4_text_3);
                    setEditText(this.ed4, "house_warming_card_4_montserrat_extrabold", R.raw.house_warming_card_4_text_4);
                    setEditText(this.ed5, "house_warming_card_4_niconne", R.raw.house_warming_card_4_text_5);
                    setEditText(this.ed6, "house_warming_card_4_montserrat_extrabold", R.raw.house_warming_card_4_text_6);
                    return;
                case 4:
                    setEditText(this.ed1, "house_warming_card_5_lobstertwo_regular", R.raw.house_warming_card_5_text_1);
                    setEditText(this.ed2, "engagement_card_10_arlrdbd", R.raw.house_warming_card_5_text_2);
                    setEditText(this.ed3, "house_warming_card_5_lobstertwo_regular", R.raw.house_warming_card_5_text_3);
                    setEditText(this.ed4, "engagement_card_10_arlrdbd", R.raw.house_warming_card_5_text_4);
                    setEditText(this.ed5, "house_warming_card_5_lobstertwo_regular", R.raw.house_warming_card_5_text_5);
                    setEditText(this.ed6, "engagement_card_10_arlrdbd", R.raw.house_warming_card_5_text_6);
                    return;
                case 5:
                    setEditText(this.ed1, "house_warming_card_6_baroquescript", R.raw.house_warming_card_6_text_1);
                    setEditText(this.ed2, "engagement_card_10_arlrdbd", R.raw.house_warming_card_6_text_2);
                    setEditText(this.ed3, "house_warming_card_6_baroquescript", R.raw.house_warming_card_6_text_3);
                    setEditText(this.ed4, "engagement_card_10_arlrdbd", R.raw.house_warming_card_6_text_4);
                    setEditText(this.ed5, "house_warming_card_6_baroquescript", R.raw.house_warming_card_6_text_5);
                    setEditText(this.ed6, "engagement_card_10_arlrdbd", R.raw.house_warming_card_6_text_6);
                    return;
                case 6:
                    setEditText(this.ed1, "house_warming_card_7_lobstertwo_bold", R.raw.house_warming_card_7_text_1);
                    setEditText(this.ed2, "engagement_card_10_arlrdbd", R.raw.house_warming_card_7_text_2);
                    setEditText(this.ed3, "house_warming_card_7_lobstertwo_bold", R.raw.house_warming_card_7_text_3);
                    setEditText(this.ed4, "engagement_card_10_arlrdbd", R.raw.house_warming_card_7_text_4);
                    setEditText(this.ed5, "house_warming_card_7_lobstertwo_bold", R.raw.house_warming_card_7_text_5);
                    setEditText(this.ed6, "engagement_card_10_arlrdbd", R.raw.house_warming_card_7_text_6);
                    return;
                case 7:
                    setEditText(this.ed1, "house_warming_card_8_seguibli", R.raw.house_warming_card_8_text_1);
                    setEditText(this.ed2, "house_warming_card_8_fancypantsnf", R.raw.house_warming_card_8_text_2);
                    setEditText(this.ed3, "house_warming_card_8_seguibli", R.raw.house_warming_card_8_text_3);
                    setEditText(this.ed4, "house_warming_card_8_fancypantsnf", R.raw.house_warming_card_8_text_4);
                    setEditText(this.ed5, "house_warming_card_8_seguibli", R.raw.house_warming_card_8_text_5);
                    return;
                case 8:
                    setEditText(this.ed1, "house_warming_card_9_montserrat_medium", R.raw.house_warming_card_9_text_1);
                    setEditText(this.ed2, "lucida_calligraphy_italic_3", R.raw.house_warming_card_9_text_2);
                    setEditText(this.ed3, "house_warming_card_9_montserrat_medium", R.raw.house_warming_card_9_text_3);
                    setEditText(this.ed4, "house_warming_card_9_montserrat_medium", R.raw.house_warming_card_9_text_4);
                    setEditText(this.ed5, "house_warming_card_9_montserrat_medium", R.raw.house_warming_card_9_text_5);
                    setEditText(this.ed6, "lucida_calligraphy_italic_3", R.raw.house_warming_card_9_text_6);
                    return;
                case 9:
                    setEditText(this.ed1, "house_warming_card_10_montserrat_medium", R.raw.house_warming_card_10_text_1);
                    setEditText(this.ed2, "lucida_handwriting_Italic_11", R.raw.house_warming_card_10_text_2);
                    setEditText(this.ed3, "lucida_handwriting_Italic_11", R.raw.house_warming_card_10_text_3);
                    setEditText(this.ed4, "lucida_handwriting_Italic_11", R.raw.house_warming_card_10_text_4);
                    setEditText(this.ed5, "house_warming_card_10_montserrat_medium", R.raw.house_warming_card_10_text_5);
                    setEditText(this.ed6, "house_warming_card_10_montserrat_medium", R.raw.house_warming_card_10_text_6);
                    setEditText(this.ed7, "house_warming_card_10_montserrat_medium", R.raw.house_warming_card_10_text_7);
                    return;
                default:
                    return;
            }
        } else if (this.TYPE.equals("birthday_card") && (i3 = this.POSITION) >= 0) {
            switch (i3) {
                case 0:
                    setEditText(this.ed1, "birthday_cards_1_Kanit_Medium", R.raw.birthday_cards_1_text_1);
                    setEditText(this.ed2, "birthday_cards_1_comicbd", R.raw.birthday_cards_1_text_2);
                    setEditText(this.ed3, "birthday_cards_1_comicbd", R.raw.birthday_cards_1_text_3);
                    setEditText(this.ed4, "birthday_cards_1_comicbd", R.raw.birthday_cards_1_text_4);
                    setEditText(this.ed5, "birthday_cards_1_comicbd", R.raw.birthday_cards_1_text_5);
                    setEditText(this.ed6, "birthday_cards_1_Kanit_Medium", R.raw.birthday_cards_1_text_6);
                    return;
                case 1:
                    setEditText(this.ed1, "birthday_cards_2_HARLOWSI", R.raw.birthday_cards_2_text_1);
                    setEditText(this.ed2, "birthday_cards_2_HoboStd", R.raw.birthday_cards_2_text_2);
                    setEditText(this.ed3, "birthday_cards_2_HoboStd", R.raw.birthday_cards_2_text_3);
                    setEditText(this.ed4, "birthday_cards_2_HoboStd", R.raw.birthday_cards_2_text_4);
                    setEditText(this.ed6, "birthday_cards_2_HoboStd", R.raw.birthday_cards_2_text_6);
                    setEditText(this.ed5, "birthday_cards_2_Kanit_SemiBoldItalic", R.raw.birthday_cards_2_text_5);
                    return;
                case 2:
                    setEditText(this.ed1, "birthday_cards_3_Roboto_Black", R.raw.birthday_cards_3_text_1);
                    setEditText(this.ed2, "birthday_cards_3_Roboto_Black", R.raw.birthday_cards_3_text_2);
                    setEditText(this.ed3, "birthday_cards_1_Kanit_Medium", R.raw.birthday_cards_3_text_3);
                    setEditText(this.ed4, "birthday_cards_3_Roboto_Black", R.raw.birthday_cards_3_text_4);
                    setEditText(this.ed5, "birthday_cards_3_Roboto_Black", R.raw.birthday_cards_3_text_5);
                    setEditText(this.ed6, "birthday_cards_3_Roboto_Black", R.raw.birthday_cards_3_text_6);
                    setEditText(this.ed7, "birthday_cards_3_Roboto_Medium", R.raw.birthday_cards_3_text_7);
                    return;
                case 3:
                    setEditText(this.ed1, "birthday_cards_4_LobsterTwo_Bold", R.raw.birthday_cards_4_text_1);
                    setEditText(this.ed2, "birthday_cards_4_Lobster_Regular", R.raw.birthday_cards_4_text_2);
                    setEditText(this.ed3, "birthday_cards_4_HoboStd", R.raw.birthday_cards_4_text_3);
                    setEditText(this.ed4, "birthday_cards_4_HoboStd", R.raw.birthday_cards_4_text_4);
                    setEditText(this.ed5, "birthday_cards_4_HoboStd", R.raw.birthday_cards_4_text_5);
                    setEditText(this.ed6, "birthday_cards_4_Kanit_Regular", R.raw.birthday_cards_4_text_6);
                    return;
                case 4:
                    setEditText(this.ed1, "birthday_cards_5_BRLNSDB", R.raw.birthday_cards_5_text_1);
                    setEditText(this.ed2, "birthday_cards_5_Schizoid_Personality", R.raw.birthday_cards_5_text_2);
                    setEditText(this.ed3, "birthday_cards_5_BRLNSDB", R.raw.birthday_cards_5_text_3);
                    setEditText(this.ed4, "birthday_cards_5_BRLNSDB", R.raw.birthday_cards_5_text_4);
                    setEditText(this.ed5, "birthday_cards_5_BRLNSDB", R.raw.birthday_cards_5_text_5);
                    setEditText(this.ed6, "birthday_cards_5_BRLNSDB", R.raw.birthday_cards_5_text_6);
                    setEditText(this.ed7, "birthday_cards_5_Schizoid_Personality", R.raw.bitthday_cards_5_text_7);
                    return;
                case 5:
                    setEditText(this.ed1, "birthday_cards_6_Bungasai_0", R.raw.birthday_cards_6_text_1);
                    setEditText(this.ed2, "birthday_cards_6_Bungasai_0", R.raw.birthday_cards_6_text_2);
                    setEditText(this.ed3, "birthday_cards_6_aArang", R.raw.birthday_cards_6_text_3);
                    setEditText(this.ed4, "birthday_cards_6_Bungasai_0", R.raw.birthday_cards_6_text_4);
                    setEditText(this.ed5, "birthday_cards_6_Bungasai_0", R.raw.birthday_cards_6_text_5);
                    return;
                case 6:
                    setEditText(this.ed1, "birthday_cards_7_BOD_R", R.raw.birthday_cards_7_text_1);
                    setEditText(this.ed2, "birthday_cards_7_ALGER", R.raw.birthday_cards_7_text_2);
                    setEditText(this.ed3, "birthday_cards_7_BOD_R", R.raw.birthday_cards_7_text_3);
                    setEditText(this.ed4, "birthday_cards_7_Amsterdam_Personal_Use", R.raw.birthday_cards_7_text_4);
                    setEditText(this.ed5, "birthday_cards_7_BOD_R", R.raw.birthday_cards_7_text_5);
                    setEditText(this.ed6, "birthday_cards_7_BOD_R", R.raw.birthday_cards_7_text_6);
                    return;
                case 7:
                    setEditText(this.ed1, "birthday_cards_8_FancyPantsNF", R.raw.birthday_cards_8_text_1);
                    setEditText(this.ed2, "birthday_cards_8_BRLNSDB", R.raw.birthday_cards_8_text_2);
                    setEditText(this.ed3, "birthday_cards_8_FancyPantsNF", R.raw.birthday_cards_8_text_3);
                    setEditText(this.ed4, "birthday_cards_8_arialbd", R.raw.birthday_cards_8_text_4);
                    setEditText(this.ed5, "birthday_cards_8_FrenchScriptMT", R.raw.birthday_cards_8_text_5);
                    setEditText(this.ed6, "birthday_cards_8_FrenchScriptMT", R.raw.birthday_cards_8_text_6);
                    setEditText(this.ed7, "birthday_cards_8_arialbd", R.raw.birthday_cards_8_text_7);
                    return;
                case 8:
                    setEditText(this.ed1, "birthday_cards_9_Bungasai_0", R.raw.birthday_cards_9_text_1);
                    setEditText(this.ed2, "birthday_cards_9_BRLNSDB", R.raw.birthday_cards_9_text_2);
                    setEditText(this.ed3, "birthday_cards_9_BOD_R", R.raw.birthday_cards_9_text_3);
                    setEditText(this.ed4, "birthday_cards_9_Niconne_Regular", R.raw.birthday_cards_9_text_4);
                    setEditText(this.ed5, "birthday_cards_9_BRLNSDB", R.raw.birthday_cards_9_text_5);
                    setEditText(this.ed6, "birthday_cards_7_BOD_R", R.raw.birthday_cards_9_text_6);
                    return;
                case 9:
                    setEditText(this.ed1, "birthday_cards_10_Lobster_Regular", R.raw.birthday_cards_10_text_1);
                    setEditText(this.ed2, "birthday_cards_10_Lobster_Regular", R.raw.birthday_cards_10_text_2);
                    setEditText(this.ed3, "birthday_cards_10_HoboStd", R.raw.birthday_cards_10_text_3);
                    setEditText(this.ed4, "birthday_cards_10_HoboStd", R.raw.birthday_cards_10_text_4);
                    setEditText(this.ed5, "birthday_cards_10_HoboStd", R.raw.birthday_cards_10_text_5);
                    setEditText(this.ed6, "birthday_cards_10_Kanit_SemiBold", R.raw.birthday_cards_10_text_6);
                    setEditText(this.ed7, "birthday_cards_8_arialbd", R.raw.birthday_cards_10_text_7);
                    return;
                default:
                    return;
            }
        } else if (this.TYPE.equals("anniversary_card") && (i2 = this.POSITION) >= 0) {
            switch (i2) {
                case 0:
                    setEditText(this.ed1, "anniversary_card_11_niconne_regular", R.raw.anniversary_card_11_text_1);
                    setEditText(this.ed2, "anniversary_card_11_gabriola", R.raw.anniversary_card_11_text_2);
                    setEditText(this.ed3, "anniversary_card_11_niconne_regular", R.raw.anniversary_card_11_text_3);
                    setEditText(this.ed4, "anniversary_card_11_niconne_regular", R.raw.anniversary_card_11_text_4);
                    setEditText(this.ed5, "engagement_card_1_arlrdbd", R.raw.anniversary_card_11_text_5);
                    setEditText(this.ed6, "anniversary_card_11_niconne_regular", R.raw.anniversary_card_11_text_6);
                    setEditText(this.ed7, "engagement_card_1_arlrdbd", R.raw.anniversary_card_11_text_7);
                    return;
                case 1:
                    setEditText(this.ed1, "anniversary_card_12_littleLordfontleroynf", R.raw.anniversary_card_12_text_1);
                    setEditText(this.ed2, "anniversary_card_12_littleLordfontleroynf", R.raw.anniversary_card_12_text_2);
                    setEditText(this.ed3, "anniversary_card_12_littleLordfontleroynf", R.raw.anniversary_card_12_text_3);
                    setEditText(this.ed4, "engagement_card_1_arlrdbd", R.raw.anniversary_card_12_text_4);
                    setEditText(this.ed5, "anniversary_card_12_littleLordfontleroynf", R.raw.anniversary_card_12_text_5);
                    setEditText(this.ed6, "engagement_card_1_arlrdbd", R.raw.anniversary_card_12_text_6);
                    return;
                case 2:
                    setEditText(this.ed1, "anniversary_card_13_bod_blai", R.raw.anniversary_card_13_text_1);
                    setEditText(this.ed2, "anniversary_card_13_frenchscriptmt", R.raw.anniversary_card_13_text_2);
                    setEditText(this.ed3, "anniversary_card_13_montserrat_medium", R.raw.anniversary_card_13_text_3);
                    setEditText(this.ed4, "anniversary_card_13_frenchscriptmt", R.raw.anniversary_card_13_text_4);
                    setEditText(this.ed5, "anniversary_card_13_montserrat_medium", R.raw.anniversary_card_13_text_5);
                    return;
                case 3:
                    setEditText(this.ed1, "anniversary_card_14_littlelordfontleroynf", R.raw.anniversary_card_14_text_1);
                    setEditText(this.ed2, "anniversary_card_14_littlelordfontleroynf", R.raw.anniversary_card_14_text_2);
                    setEditText(this.ed3, "anniversary_card_14_arlrdbd", R.raw.anniversary_card_14_text_3);
                    setEditText(this.ed4, "anniversary_card_14_littlelordfontleroynf", R.raw.anniversary_card_14_text_4);
                    setEditText(this.ed5, "anniversary_card_14_arlrdbd", R.raw.anniversary_card_14_text_5);
                    return;
                case 4:
                    setEditText(this.ed1, "anniversary_card_15_rundkursiv", R.raw.anniversary_card_15_text_1);
                    setEditText(this.ed2, "anniversary_card_15_seguiemj", R.raw.anniversary_card_15_text_2);
                    setEditText(this.ed3, "anniversary_card_15_rundkursiv", R.raw.anniversary_card_15_text_3);
                    setEditText(this.ed4, "anniversary_card_15_montserrat_medium", R.raw.anniversary_card_15_text_4);
                    setEditText(this.ed5, "anniversary_card_15_rundkursiv", R.raw.anniversary_card_15_text_5);
                    setEditText(this.ed6, "anniversary_card_15_montserrat_medium", R.raw.anniversary_card_15_text_6);
                    return;
                case 5:
                    setEditText(this.ed1, "anniversary_card_1_book_antiqua", R.raw.anniversary_card_1_text_1);
                    setEditText(this.ed2, "anniversary_card_1_brock_script", R.raw.anniversary_card_1_text_2);
                    setEditText(this.ed3, "anniversary_card_1_brock_script", R.raw.anniversary_card_1_text_3);
                    setEditText(this.ed4, "anniversary_card_1_calibri_regular", R.raw.anniversary_card_1_text_4);
                    return;
                case 6:
                    setEditText(this.ed1, "anniversary_card_2_allura_regular", R.raw.anniversary_card_2_text_1);
                    setEditText(this.ed2, "anniversary_card_2_alsscrp", R.raw.anniversary_card_2_text_2);
                    setEditText(this.ed3, "anniversary_card_2_allura_regular", R.raw.anniversary_card_2_text_3);
                    setEditText(this.ed4, "anniversary_card_2_source_saans", R.raw.anniversary_card_2_text_4);
                    return;
                case 7:
                    setEditText(this.ed1, "anniversary_card_6_per", R.raw.anniversary_card_6_text_1);
                    setEditText(this.ed2, "anniversary_card_6_baroque_script", R.raw.anniversary_card_6_text_2);
                    setEditText(this.ed3, "anniversary_card_6_per", R.raw.anniversary_card_6_text_3);
                    setEditText(this.ed4, "anniversary_card_6_per", R.raw.anniversary_card_6_text_4);
                    setEditText(this.ed5, "anniversary_card_6_per", R.raw.anniversary_card_6_text_5);
                    return;
                case 8:
                    setEditText(this.ed1, "anniversary_card_9_calibri_regular", R.raw.anniversary_card_9_text_1);
                    setEditText(this.ed2, "anniversary_card_9_arabella", R.raw.anniversary_card_9_text_2);
                    setEditText(this.ed3, "anniversary_card_6_per", R.raw.anniversary_card_9_text_3);
                    setEditText(this.ed4, "anniversary_card_9_niconne_regular", R.raw.anniversary_card_9_text_4);
                    setEditText(this.ed5, "anniversary_card_6_per", R.raw.anniversary_card_9_text_5);
                    return;
                case 9:
                    setEditText(this.ed1, "anniversary_card_9_calibri_regular", R.raw.anniversary_card_10_text_1);
                    setEditText(this.ed2, "anniversary_card_10_aurella", R.raw.anniversary_card_10_text_2);
                    setEditText(this.ed3, "anniversary_card_6_per", R.raw.anniversary_card_10_text_3);
                    setEditText(this.ed4, "anniversary_card_6_per", R.raw.anniversary_card_10_text_4);
                    setEditText(this.ed5, "anniversary_card_6_per", R.raw.anniversary_card_10_text_5);
                    return;
                default:
                    return;
            }
        } else if (this.TYPE.equals("engagement_card") && (i = this.POSITION) >= 0) {
            switch (i) {
                case 0:
                    setEditText(this.ed1, "engagement_card_1_arlrdbd", R.raw.engagement_card_1_text_1);
                    setEditText(this.ed2, "engagement_card_1_niconne_regular", R.raw.engagement_card_1_text_2);
                    setEditText(this.ed3, "engagement_card_1_arlrdbd", R.raw.engagement_card_1_text_3);
                    setEditText(this.ed4, "engagement_card_1_niconne_regular", R.raw.engagement_card_1_text_4);
                    setEditText(this.ed5, "engagement_card_1_arlrdbd", R.raw.engagement_card_1_text_5);
                    return;
                case 1:
                    setEditText(this.ed1, "engagement_card_2_montserrat_medium", R.raw.engagement_card_2_text_1);
                    setEditText(this.ed2, "engagement_card_2_rundkursiv", R.raw.engagement_card_2_text_2);
                    setEditText(this.ed3, "engagement_card_2_montserrat_regular", R.raw.engagement_card_2_text_3);
                    setEditText(this.ed4, "engagement_card_2_rundkursiv", R.raw.engagement_card_2_text_4);
                    setEditText(this.ed5, "engagement_card_2_montserrat_regular", R.raw.engagement_card_2_text_5);
                    return;
                case 2:
                    setEditText(this.ed1, "engagement_card_3_sofia_regular", R.raw.engagement_card_3_text_1);
                    setEditText(this.ed2, "engagement_card_3_gabriola", R.raw.engagement_card_3_text_2);
                    setEditText(this.ed3, "engagement_card_3_sofia_regular", R.raw.engagement_card_3_text_3);
                    setEditText(this.ed4, "engagement_card_3_gabriola", R.raw.engagement_card_3_text_4);
                    setEditText(this.ed5, "engagement_card_3_gabriola", R.raw.engagement_card_3_text_5);
                    return;
                case 3:
                    setEditText(this.ed1, "engagement_card_4_copperplate-gothic", R.raw.engagement_card_4_text_1);
                    setEditText(this.ed2, "engagement_card_4_arlrdbd", R.raw.engagement_card_4_text_2);
                    setEditText(this.ed3, "engagement_card_4_niconne_regular", R.raw.engagement_card_4_text_3);
                    setEditText(this.ed4, "engagement_card_4_arlrdbd", R.raw.engagement_card_4_text_4);
                    setEditText(this.ed5, "engagement_card_4_niconne_regular", R.raw.engagement_card_4_text_5);
                    setEditText(this.ed6, "engagement_card_4_arlrdbd", R.raw.engagement_card_4_text_6);
                    return;
                case 4:
                    setEditText(this.ed1, "engagement_card_5_calibril", R.raw.engagement_card_5_text_1);
                    setEditText(this.ed2, "engagement_card_5_lobster_two_bold", R.raw.engagement_card_5_text_2);
                    setEditText(this.ed3, "engagement_card_5_obster_two_regular", R.raw.engagement_card_5_text_3);
                    setEditText(this.ed4, "engagement_card_5_obster_two_regular", R.raw.engagement_card_5_text_4);
                    setEditText(this.ed5, "engagement_card_5_obster_two_regular", R.raw.engagement_card_5_text_5);
                    setEditText(this.ed6, "engagement_card_5_calibril", R.raw.engagement_card_5_text_6);
                    return;
                case 5:
                    setEditText(this.ed1, "engagement_card_6_baroque_script", R.raw.engagement_card_6_text_1);
                    setEditText(this.ed2, "engagement_card_6_cairo_bold", R.raw.engagement_card_6_text_2);
                    setEditText(this.ed3, "engagement_card_6_niconne_regular", R.raw.engagement_card_6_text_3);
                    setEditText(this.ed4, "engagement_card_6_cairo_regular", R.raw.engagement_card_6_text_4);
                    setEditText(this.ed5, "engagement_card_6_cairo_regular", R.raw.engagement_card_6_text_5);
                    setEditText(this.ed6, "engagement_card_6_niconne_regular", R.raw.engagement_card_6_text_6);
                    setEditText(this.ed7, "engagement_card_6_cairo_semi_bold", R.raw.engagement_card_6_text_7);
                    return;
                case 6:
                    setEditText(this.ed1, "engagement_card_6_niconne_regular", R.raw.engagement_card_7_text_1);
                    setEditText(this.ed2, "engagement_card_7_rundkursiv", R.raw.engagement_card_7_text_2);
                    setEditText(this.ed3, "engagement_card_6_niconne_regular", R.raw.engagement_card_7_text_3);
                    setEditText(this.ed4, "engagement_card_7_rundkursiv", R.raw.engagement_card_7_text_4);
                    setEditText(this.ed5, "engagement_card_6_niconne_regular", R.raw.engagement_card_7_text_5);
                    return;
                case 7:
                    setEditText(this.ed1, "wedding_card_1_font_2", R.raw.engagement_card_8_text_1);
                    setEditText(this.ed2, "engagement_card_5_calibril", R.raw.engagement_card_8_text_2);
                    setEditText(this.ed3, "wedding_card_1_font_2", R.raw.engagement_card_8_text_3);
                    setEditText(this.ed4, "wedding_card_1_font_1", R.raw.engagement_card_8_text_4);
                    setEditText(this.ed5, "wedding_card_1_font_2", R.raw.engagement_card_8_text_5);
                    setEditText(this.ed6, "engagement_card_5_calibril", R.raw.engagement_card_8_text_6);
                    return;
                case 8:
                    setEditText(this.ed1, "engagement_card_9_niconne_regular", R.raw.engagement_card_9_text_1);
                    setEditText(this.ed2, "engagement_card_9_montserrat_regular", R.raw.engagement_card_9_text_2);
                    setEditText(this.ed3, "engagement_card_9_niconne_regular", R.raw.engagement_card_9_text_3);
                    setEditText(this.ed4, "engagement_card_9_arlrdbd", R.raw.engagement_card_9_text_4);
                    setEditText(this.ed5, "engagement_card_9_niconne_regular", R.raw.engagement_card_9_text_5);
                    setEditText(this.ed6, "engagement_card_9_arlrdbd", R.raw.engagement_card_9_text_6);
                    return;
                case 9:
                    setEditText(this.ed1, "engagement_card_10_niconne_regular", R.raw.engagement_card_10_text_1);
                    setEditText(this.ed2, "engagement_card_10_arlrdbd", R.raw.engagement_card_10_text_2);
                    setEditText(this.ed3, "engagement_card_10_niconne_regular", R.raw.engagement_card_10_text_3);
                    setEditText(this.ed4, "engagement_card_10_arlrdbd", R.raw.engagement_card_10_text_4);
                    setEditText(this.ed5, "engagement_card_10_niconne_regular", R.raw.engagement_card_10_text_5);
                    setEditText(this.ed6, "engagement_card_10_arlrdbd", R.raw.engagement_card_10_text_6);
                    return;
                default:
                    return;
            }
        }
    }

    public void showTextDialog(String str, int i, int i2) {
        final Dialog dialog = new Dialog(this);
        AssetManager assets = this.context.getAssets();
        Typeface createFromAsset = Typeface.createFromAsset(assets, "fonts/" + str + ".ttf");
        dialog.requestWindowFeature(1);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.activity_custom_dialog);
        EditText editText = (EditText) dialog.findViewById(R.id.edit_text_1);
        editText.setText(i);
        editText.setText(Utils.readRawTextFile(this.context, i2));
        editText.setTypeface(createFromAsset);
        ((TextView) dialog.findViewById(R.id.dialog_ok)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
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

    public Bitmap textAsBitmap(String str, float f, int i, Typeface typeface) {
        Paint paint = new Paint(1);
        paint.setTextSize(f);
        paint.setColor(i);
        paint.setTextAlign(Paint.Align.LEFT);
        paint.setTypeface(typeface);
        float f2 = -paint.ascent();
        Bitmap createBitmap = Bitmap.createBitmap((int) (paint.measureText(str) + 0.5f), (int) (paint.descent() + f2 + 0.5f), Bitmap.Config.ARGB_8888);
        new Canvas(createBitmap).drawText(str, 0.0f, f2, paint);
        return createBitmap;
    }

    private String getDateTime() {
        return new SimpleDateFormat("yyyyMMdd HH:mm:ss").format(new Date());
    }

    public String getToken(int i) {
        StringBuilder sb = new StringBuilder(i);
        for (int i2 = 0; i2 < i; i2++) {
            sb.append(CHARS.charAt(random.nextInt(63)));
        }
        return sb.toString();
    }

    public static Bitmap createBitmap(Bitmap bitmap2, float f) {
        Matrix matrix = new Matrix();
        matrix.postRotate(f);
        return Bitmap.createBitmap(bitmap2, 0, 0, bitmap2.getWidth(), bitmap2.getHeight(), matrix, true);
    }

    private void openElementsFragment() {
        this.elementsFragment = Utils.addElementsFragment(this, R.id.new_hidden_fragment, true, (View) null);
    }

    private void openAddStickerFragment() {
        removeElementsFragment(true);
        this.addStickerFragment = Utils.addAddStickerFragment(this, R.id.sticker_fragment_container, true, (View) null);
    }


    public void setBottomUpHiddenLayout() {
        this.newElement.setClickable(false);
        Animation loadAnimation = AnimationUtils.loadAnimation(this.context, R.anim.bottom_up);
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.new_hidden_fragment);
        this.hiddenPanel = frameLayout;
        frameLayout.setVisibility(View.VISIBLE);
        this.hiddenPanel.startAnimation(loadAnimation);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationRepeat(Animation animation) {
                Log.e("f","");
            }

            public void onAnimationStart(Animation animation) {
                Log.e("f","");
            }

            public void onAnimationEnd(Animation animation) {
                GreetingCardEditActivity.this.bottomPanel.setVisibility(View.GONE);
            }
        });
        openElementsFragment();
    }

    public void addStickerView(int i) {
        final StickerView stickerView = new StickerView(this.context);
        stickerView.setBitmap(BitmapFactory.decodeResource(getResources(), i), "int");
        stickerView.setOperationListener(new StickerView.OperationListener() {
            public void onDeleteClick() {
                GreetingCardEditActivity.this.mViews.remove(stickerView);
                GreetingCardEditActivity.this.stickerViewContainer.removeView(stickerView);
            }

            public void onEdit(StickerView stickerView) {
                GreetingCardEditActivity.this.mCurrentView.setInEdit(false);
                GreetingCardEditActivity.this.mCurrentView = stickerView;
                GreetingCardEditActivity.this.mCurrentView.setInEdit(true);
            }

            @Override
            public void onTop(StickerView stickerView) {
                Log.e("f","");

            }
        });
        this.stickerViewContainer.addView(stickerView, new RelativeLayout.LayoutParams(-1, -1));
        this.mViews.add(stickerView);
        setCurrentEdit(stickerView);
    }

    public void setStickerFragment() {
        this.newElement.setClickable(false);
        Animation loadAnimation = AnimationUtils.loadAnimation(this.context, R.anim.bottom_up);
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.sticker_fragment_container);
        this.stickerFragmentFrame = frameLayout;
        frameLayout.setVisibility(View.VISIBLE);
        this.stickerFragmentFrame.startAnimation(loadAnimation);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationRepeat(Animation animation) {
                Log.e("f","");
            }

            public void onAnimationStart(Animation animation) {
                Log.e("f","");
            }

            public void onAnimationEnd(Animation animation) {
                GreetingCardEditActivity.this.bottomPanel.setVisibility(View.INVISIBLE);
            }
        });
        openAddStickerFragment();
    }

    public void setCurrentEdit(StickerView stickerView) {
        StickerView stickerView2 = this.mCurrentView;
        if (stickerView2 != null) {
            stickerView2.setInEdit(false);
        }
        this.mCurrentView = stickerView;
        stickerView.setInEdit(true);
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

    public ArrayList<String> getImagesFromDevice(String str) {
        ArrayList<String> arrayList = new ArrayList<>();
        File[] listFiles = new File(str + "/").listFiles();
        if (!isDirectoryNotEmpty(str)) {
            return null;
        }
        for (int i = 0; i < listFiles.length; i++) {
            arrayList.add(listFiles[i].getAbsolutePath());
            Log.e("Files", "FileName:" + listFiles[i].getAbsolutePath());
        }
        return arrayList;
    }


    public void save() {
        Bitmap saveDrawnBitmap = saveDrawnBitmap(this.editCardContainer);

        // Check if the bitmap is valid
        if (saveDrawnBitmap == null) {
            Log.e("CF_IMAGE_ERROR", "Bitmap is null");
            return;
        }

        // Use the public Pictures directory for accessibility
        File directory = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), getResources().getString(R.string.app_name));

        // Ensure the directory exists
        if (!directory.exists() && !directory.mkdirs()) {
            Log.e("CF_IMAGE_ERROR", "Failed to create directory: " + directory.getAbsolutePath());
            return;
        }

        // Define the file to save the image
        File file2 = new File(directory, this.filename);

        try {
            // Save the bitmap as a PNG file
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            saveDrawnBitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();

            Log.e("CF_IMAGE_SAVED", "Image saved at: " + file2.getAbsolutePath());

            // Refresh the gallery to show the newly saved image
            MediaScannerConnection.scanFile(this, new String[]{file2.getAbsolutePath()}, null, (path, uri) -> {
                Log.e("CF_IMAGE_INFO", "Gallery refreshed for file: " + file2.getAbsolutePath());
            });

        } catch (Exception e) {
            Log.e("CF_IMAGE_ERROR", "Error during image saving", e);
        }

        // Set the file path for sharing or other purposes
        this.filePath = file2.getAbsolutePath();

        // Pass the path to another activity for sharing
        Intent intent2 = new Intent(this, SaveShareImageActivity.class);
        intent2.putExtra("PATH", this.filePath);
        startActivity(intent2);

        finish();
    }

    public void saveOld2() {
        Bitmap saveDrawnBitmap = saveDrawnBitmap(this.editCardContainer);

        // Check if the bitmap is valid
        if (saveDrawnBitmap == null) {
            Log.e("CF_IMAGE_ERROR", "Bitmap is null");
            return;
        }

        // Use getExternalFilesDir for app-specific directory (no permissions required)
        File directory = new File(getExternalFilesDir(Environment.DIRECTORY_PICTURES), getResources().getString(R.string.app_name));

        // Ensure the directory exists
        if (!directory.exists() && !directory.mkdirs()) {
            Log.e("CF_IMAGE_ERROR", "Failed to create directory: " + directory.getAbsolutePath());
            return;
        }

        // Define the file to save the image
        File file2 = new File(directory, this.filename);

        try {
            // Save the bitmap as a PNG file
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            saveDrawnBitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();

            Log.e("CF_IMAGE_SAVED", "Image saved at: " + file2.getAbsolutePath());

            // Refresh the gallery to show the newly saved image
            MediaScannerConnection.scanFile(this, new String[]{file2.getAbsolutePath()}, null, null);
            Log.e("CF_IMAGE_INFO", "Gallery refreshed for file: " + file2.getAbsolutePath());
        } catch (Exception e) {
            Log.e("CF_IMAGE_ERROR", "Error during image saving", e);
        }

        // Set the file path for sharing or other purposes
        this.filePath = file2.getAbsolutePath();

        // Pass the path to another activity for sharing
        Intent intent2 = new Intent(this, SaveShareImageActivity.class);
        intent2.putExtra("PATH", this.filePath);
        startActivity(intent2);

        finish();
    }

    public void saveOld() {
        Bitmap saveDrawnBitmap = saveDrawnBitmap(this.editCardContainer);
        String str = Environment.getExternalStorageDirectory().toString() + "/" + getResources().getString(R.string.app_name);
        File file = new File(str);
        file.mkdirs();
        File file2 = new File(file, this.filename);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            saveDrawnBitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        refreshGallery(file2);
        this.filePath = str + "/" + this.filename;
        Intent intent2 = new Intent(this, SaveShareImageActivity.class);
        intent2.putExtra("PATH", this.filePath);
        startActivity(intent2);
        finish();
    }

    public Bitmap saveDrawnBitmap(RelativeLayout relativeLayout) {
        Bitmap createBitmap = Bitmap.createBitmap(relativeLayout.getWidth(), relativeLayout.getHeight(), Bitmap.Config.ARGB_8888);
        relativeLayout.draw(new Canvas(createBitmap));
        return createBitmap;
    }

    private void refreshGallery(File file) {
        Intent intent2 = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
        intent2.setData(Uri.fromFile(file));
        sendBroadcast(intent2);
    }

    public void removeElementsFragment(boolean z) {
        this.elementsFragment = Utils.getElementsFragment(this);
        this.newElement.setClickable(true);
        this.bottomPanel.setVisibility(View.VISIBLE);
        this.selectedCard.setClickable(z);
        this.hiddenPanel.startAnimation(this.bottomDown);
        this.hiddenPanel.setVisibility(View.GONE);
        this.bottomDown.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationRepeat(Animation animation) {
                Log.e("f","");
            }

            public void onAnimationStart(Animation animation) {
                Log.e("f","");
            }

            public void onAnimationEnd(Animation animation) {
                GreetingCardEditActivity.this.getSupportFragmentManager().beginTransaction().remove(GreetingCardEditActivity.this.elementsFragment).commit();
            }
        });
    }

    public void removeAddStickerFragment(boolean z) {
        this.addStickerFragment = Utils.getAddStickerFragment(this);
        this.newElement.setClickable(true);
        this.bottomPanel.setVisibility(View.VISIBLE);
        this.selectedCard.setClickable(z);
        this.stickerFragmentFrame.startAnimation(this.bottomDown);
        this.stickerFragmentFrame.setVisibility(View.GONE);
        this.bottomDown.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationRepeat(Animation animation) {
                Log.e("f","");
            }

            public void onAnimationStart(Animation animation) {
                Log.e("f","");
            }

            public void onAnimationEnd(Animation animation) {
                GreetingCardEditActivity.this.getSupportFragmentManager().beginTransaction().remove(GreetingCardEditActivity.this.addStickerFragment).commit();
            }
        });
    }

    public void onBackPressed() {
        ElementsFragment elementsFragment2 = this.elementsFragment;
        if (elementsFragment2 == null || !elementsFragment2.isVisible()) {
            AddStickerFragment addStickerFragment2 = this.addStickerFragment;
            if (addStickerFragment2 == null || !addStickerFragment2.isVisible()) {
                super.onBackPressed();
            } else {
                removeAddStickerFragment(true);
            }
        } else {
            removeElementsFragment(true);
        }
    }

    public boolean onTouch(View view2, MotionEvent motionEvent) {
        setView(view2);
        int paddingBottom = view2.getPaddingBottom();
        int paddingLeft = view2.getPaddingLeft();
        int paddingRight = view2.getPaddingRight();
        int paddingTop = view2.getPaddingTop();
        if (!this.gestureDetector.onTouchEvent(motionEvent)) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f172dX = view2.getX() - motionEvent.getRawX();
                this.f173dY = view2.getY() - motionEvent.getRawY();
                this.touchMode = 1;
                if (getLastTouchedEditTextView() != null) {
                    getLastTouchedEditTextView().clearFocus();
                }
                setLastTouchedView(view2);
                clearHighlights();
                this.edit_text_ic.setVisibility(View.VISIBLE);
                this.edit_text_ic.setAlpha(1.0f);
                this.edit_text_ic.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide));
                getLastTouchedEditTextView().setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.edit_text_back_1));
                getLastTouchedEditTextView().setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
                TextView textView = this.fontSizeSelection;
                textView.setText("" + (((int) getLastTouchedEditTextView().getTextSize()) / 3));
                this.displaySelectedFontColor.setBackgroundColor(getLastTouchedEditTextView().getCurrentTextColor());
                this.displaySelectedFontShadowColor.setBackgroundColor(getLastTouchedEditTextView().getShadowColor());
            } else if (action != 2) {
                return false;
            } else {
                if (this.touchMode == 1) {
                    if (getLastTouchedEditTextView() != null) {
                        getLastTouchedEditTextView().clearFocus();
                    }
                    setLastTouchedView(view2);
                    clearHighlights();
                    this.edit_text_ic.setAlpha(1.0f);
                    this.edit_text_ic.setVisibility(View.VISIBLE);
                    this.edit_text_ic.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide));
                    getLastTouchedEditTextView().setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.edit_text_back_1));
                    getLastTouchedEditTextView().setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
                    TextView textView2 = this.fontSizeSelection;
                    textView2.setText("" + (((int) getLastTouchedEditTextView().getTextSize()) / 3));
                    this.displaySelectedFontColor.setBackgroundColor(getLastTouchedEditTextView().getCurrentTextColor());
                    this.displaySelectedFontShadowColor.setBackgroundColor(getLastTouchedEditTextView().getShadowColor());
                    view2.animate().x((motionEvent.getRawX() + this.f172dX) - (((float) view2.getWidth()) / 100.0f)).y((motionEvent.getRawY() + this.f173dY) - (((float) view2.getHeight()) / 100.0f)).setDuration(0).start();
                }
            }
        }
        return true;
    }

    private class SingleTapConfirm extends GestureDetector.SimpleOnGestureListener {
        private SingleTapConfirm() {
        }

        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (GreetingCardEditActivity.this.getLastTouchedEditTextView() != null) {
                GreetingCardEditActivity activity = GreetingCardEditActivity.this;
                activity.f172dX = activity.getView().getX() - motionEvent.getRawX();
                GreetingCardEditActivity greetingCardEditActivity2 = GreetingCardEditActivity.this;
                greetingCardEditActivity2.f173dY = greetingCardEditActivity2.getView().getY() - motionEvent.getRawY();
                GreetingCardEditActivity.this.touchMode = 1;
                GreetingCardEditActivity greetingCardEditActivity3 = GreetingCardEditActivity.this;
                new FileSaveDialog(greetingCardEditActivity3, greetingCardEditActivity3.getResources(), GreetingCardEditActivity.this.getLastTouchedEditTextView().getText().toString()).show();
            }
            return true;
        }
    }
}
