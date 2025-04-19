package com.jeddah.invitationcards.activities;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.core.content.res.ResourcesCompat;

import com.jeddah.invitationcards.PicEditor;
import com.jeddah.invitationcards.R;

public class FileSaveDialog extends Dialog {

     Context context;
    private View.OnClickListener cancelListener = new View.OnClickListener() {
        public void onClick(View view) {
            FileSaveDialog.this.dismiss();
        }
    };

    EditText editText;
    TextView font1;
    TextView font2;
    TextView font3;
    TextView font4;
    TextView font5;
    TextView font6;
    TextView font7;
    TextView font8;


    ImageView mainBoldText;
    LinearLayout mainFontColorOption;

    ImageView mainItalicText;

    ImageView mainNonBoldText;

    ImageView mainNonItalicText;
    ImageView mainSlideUp;

    ImageView mainTextNoUnderline;

    ImageView mainTextNonStrike;

    ImageView mainTextStrike;

    ImageView mainTextUnderline;


    private View.OnClickListener saveListener = new View.OnClickListener() {
        public void onClick(View view) {
            if (context.getClass().getName().contains("PicEditor")){
                PicEditor.activity.getLastTouchedEditTextView().setText(FileSaveDialog.this.editText.getText().toString());
                if (FileSaveDialog.this.editText.getTypeface() != null) {
                    PicEditor.activity.getLastTouchedEditTextView().setTypeface(FileSaveDialog.this.editText.getTypeface());
                }
                if (FileSaveDialog.this.editText.getTypeface() != null) {
                    PicEditor.activity.getLastTouchedEditTextView().setPaintFlags(FileSaveDialog.this.editText.getPaintFlags());
                }
            }else{
                GreetingCardEditActivity.activity.getLastTouchedEditTextView().setText(FileSaveDialog.this.editText.getText().toString());
                if (FileSaveDialog.this.editText.getTypeface() != null) {
                    GreetingCardEditActivity.activity.getLastTouchedEditTextView().setTypeface(FileSaveDialog.this.editText.getTypeface());
                }
                if (FileSaveDialog.this.editText.getTypeface() != null) {
                    GreetingCardEditActivity.activity.getLastTouchedEditTextView().setPaintFlags(FileSaveDialog.this.editText.getPaintFlags());
                }
            }
            FileSaveDialog.this.dismiss();


        }
    };


    public FileSaveDialog(final Context context, Resources resources, String str) {
        super(context);
        this.context = context;
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        setContentView(R.layout.edit_text_vew_pop_up);
        setTitle(" Edit ");
        setCancelable(false);
        EditText editText2 = (EditText) findViewById(R.id.edit_text_update);
        this.editText = editText2;
        editText2.requestFocus();
        this.editText.setText(str);
        EditText editText3 = this.editText;
        editText3.setSelection(editText3.getText().length());
        ((InputMethodManager) context.getSystemService("input_method")).showSoftInput(this.editText, 1);
        ((ImageView) findViewById(R.id.btn_cancel)).setOnClickListener(this.cancelListener);
        ((CardView) findViewById(R.id.btn_update)).setOnClickListener(this.saveListener);
        this.mainBoldText = (ImageView) findViewById(R.id.main_bold_text);
        this.mainItalicText = (ImageView) findViewById(R.id.main_italic_text);
        this.mainTextUnderline = (ImageView) findViewById(R.id.main_text_underline);
        this.mainTextStrike = (ImageView) findViewById(R.id.main_text_strike);
        this.mainNonBoldText = (ImageView) findViewById(R.id.main_non_bold_text);
        this.mainNonItalicText = (ImageView) findViewById(R.id.main_non_italic_text);
        this.mainTextNoUnderline = (ImageView) findViewById(R.id.main_text_no_underline);
        this.mainTextNonStrike = (ImageView) findViewById(R.id.main_text_non_strike);
        this.mainFontColorOption = (LinearLayout) findViewById(R.id.main_font_color_option);
        this.font1 = (TextView) findViewById(R.id.alger_font_style);
        this.font2 = (TextView) findViewById(R.id.britanic_font_style);
        this.font3 = (TextView) findViewById(R.id.frscript_font_style);
        this.font4 = (TextView) findViewById(R.id.gil_font_style);
        this.font5 = (TextView) findViewById(R.id.harngton_font_style);
        this.font6 = (TextView) findViewById(R.id.mtcorsva_font_style);
        this.font7 = (TextView) findViewById(R.id.ottumhmkbold_font_style);
        this.font8 = (TextView) findViewById(R.id.roboto_medium_font_style);
        this.font1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                FileSaveDialog.this.editText.setTypeface(ResourcesCompat.getFont(context, R.font.alger));
            }
        });
        this.font2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                FileSaveDialog.this.editText.setTypeface(ResourcesCompat.getFont(context, R.font.britanic));
            }
        });
        this.font3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                FileSaveDialog.this.editText.setTypeface(ResourcesCompat.getFont(context, R.font.frscript));
            }
        });
        this.font4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                FileSaveDialog.this.editText.setTypeface(ResourcesCompat.getFont(context, R.font.gil));
            }
        });
        this.font5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                FileSaveDialog.this.editText.setTypeface(ResourcesCompat.getFont(context, R.font.harngton));
            }
        });
        this.font6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                FileSaveDialog.this.editText.setTypeface(ResourcesCompat.getFont(context, R.font.mtcorsva));
            }
        });
        this.font7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                FileSaveDialog.this.editText.setTypeface(ResourcesCompat.getFont(context, R.font.ottumhmkbold));
            }
        });
        this.font8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                FileSaveDialog.this.editText.setTypeface(ResourcesCompat.getFont(context, R.font.roboto_medium));
            }
        });
        this.mainBoldText.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                FileSaveDialog.this.mainBoldText.setVisibility(View.GONE);
                FileSaveDialog.this.mainNonBoldText.setVisibility(View.VISIBLE);
                FileSaveDialog.this.editText.setTypeface(FileSaveDialog.this.editText.getTypeface(), 1);
            }
        });
        this.mainItalicText.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                FileSaveDialog.this.mainItalicText.setVisibility(View.GONE);
                FileSaveDialog.this.mainNonItalicText.setVisibility(View.VISIBLE);
                FileSaveDialog.this.editText.setTypeface(FileSaveDialog.this.editText.getTypeface(), 2);
            }
        });
        this.mainTextUnderline.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                FileSaveDialog.this.mainTextUnderline.setVisibility(View.GONE);
                FileSaveDialog.this.mainTextNoUnderline.setVisibility(View.VISIBLE);
                FileSaveDialog.this.editText.setPaintFlags(8);
            }
        });
        this.mainTextStrike.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                FileSaveDialog.this.mainTextStrike.setVisibility(View.GONE);
                FileSaveDialog.this.mainTextNonStrike.setVisibility(View.VISIBLE);
                FileSaveDialog.this.editText.setPaintFlags(16);
            }
        });
        this.mainNonBoldText.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                FileSaveDialog.this.mainBoldText.setVisibility(View.VISIBLE);
                FileSaveDialog.this.mainNonBoldText.setVisibility(View.GONE);
                FileSaveDialog.this.editText.setTypeface(FileSaveDialog.this.editText.getTypeface(), 0);
            }
        });
        this.mainNonItalicText.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                FileSaveDialog.this.mainItalicText.setVisibility(View.VISIBLE);
                FileSaveDialog.this.mainNonItalicText.setVisibility(View.GONE);
                FileSaveDialog.this.editText.setTypeface((Typeface) null);
                FileSaveDialog.this.editText.setTypeface(FileSaveDialog.this.editText.getTypeface(), 0);
            }
        });
        this.mainTextNoUnderline.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                FileSaveDialog.this.mainTextUnderline.setVisibility(View.VISIBLE);
                FileSaveDialog.this.mainTextNoUnderline.setVisibility(View.GONE);
                FileSaveDialog.this.editText.setTypeface((Typeface) null);
                FileSaveDialog.this.editText.setPaintFlags(FileSaveDialog.this.editText.getPaintFlags() & -9);
            }
        });
        this.mainTextNonStrike.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                FileSaveDialog.this.mainTextStrike.setVisibility(View.VISIBLE);
                FileSaveDialog.this.mainTextNonStrike.setVisibility(View.GONE);
                FileSaveDialog.this.editText.setPaintFlags(FileSaveDialog.this.editText.getPaintFlags() & -17);
            }
        });
    }
}
