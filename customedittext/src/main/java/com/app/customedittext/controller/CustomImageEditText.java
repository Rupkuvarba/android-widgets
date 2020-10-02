package com.app.customedittext.controller;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.annotation.Nullable;

import com.app.customedittext.model.CustomEdittextSDK;
import com.app.customedittext.R;

/**
 * Reference:
 * https://code.tutsplus.com/tutorials/creating-and-publishing-an-android-library--cms-24582
 *
 */

public class CustomImageEditText extends LinearLayout {

    private RelativeLayout rlView;
    private ImageView ivEtLeft;
    private ImageView ivEtRight;
    private EditText editText;

    //ImageView
    private int drawableId = 0;

    //EditText
    private int imeOptions;
    private int inputType;
    private int maxLines, maxLength, lines, gravity;
    private int padding;
    private int padding_start, padding_end, padding_top, padding_bottom;
    private int cursorDrawable = 0;

    private String hintText = "";

    private boolean isEditable = true;

    private String fontPath = "fonts/" + "dm_sans_medium.ttf";

    public RelativeLayout getRlView() {
        return rlView;
    }

    public ImageView getIvEtLeft() {
        return ivEtLeft;
    }

    public EditText getEditText() {
        return editText;
    }

    public ImageView getIvEtRight() {
        return ivEtRight;
    }

    public CustomImageEditText(Context context) {
        this(context, null);
    }

    public CustomImageEditText(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomImageEditText(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        View view = LayoutInflater.from(context).inflate(R.layout.custom_image_edittext, this, true);
        rlView = view.findViewById(R.id.rl_view);
        ivEtLeft = view.findViewById(R.id.iv_left);
        ivEtRight = view.findViewById(R.id.iv_right);
        editText = view.findViewById(R.id.edit_text);

        ivEtRight.setVisibility(GONE);

        TypedArray styleable = getContext().obtainStyledAttributes(
                attrs,
                R.styleable.CustomEditText,
                defStyleAttr,
                0
        );

        //Show left image
        drawableId = styleable.getResourceId(R.styleable.CustomEditText_cie_iv_left_src, 0);
        showLeftDrawable();

        //Ime options
        imeOptions = styleable.getInt(R.styleable.CustomEditText_android_imeOptions, 0);
        setImeOptions(imeOptions);

        //Input type
        inputType = styleable.getInt(R.styleable.CustomEditText_android_inputType, EditorInfo.TYPE_TEXT_VARIATION_NORMAL);
        setInputType(inputType);

        //Hint text
        hintText = styleable.getString(R.styleable.CustomEditText_edt_hint);
        isEditable = styleable.getBoolean(R.styleable.CustomEditText_edt_editable, true);
        maxLength = styleable.getInteger(R.styleable.CustomEditText_android_maxLength, 10000);
        maxLines = styleable.getInteger(R.styleable.CustomEditText_android_maxLines, 100);
        lines = styleable.getInt(R.styleable.CustomEditText_android_lines, 1);
        gravity = styleable.getInt(R.styleable.CustomEditText_android_gravity, Gravity.START);
        padding = styleable.getDimensionPixelOffset(R.styleable.CustomEditText_edt_padding, 0);
        padding_start = styleable.getDimensionPixelOffset(R.styleable.CustomEditText_edt_padding_start, 0);
        padding_end = styleable.getDimensionPixelOffset(R.styleable.CustomEditText_edt_padding_end, 0);
        padding_top = styleable.getDimensionPixelOffset(R.styleable.CustomEditText_edt_padding_top, 0);
        padding_bottom = styleable.getDimensionPixelOffset(R.styleable.CustomEditText_edt_padding_bottom, 0);
        cursorDrawable = styleable.getResourceId(R.styleable.CustomEditText_edt_cursor, 0);

    }

    public void showLeftDrawable() {
        if(drawableId > 0) {
            ivEtLeft.setVisibility(VISIBLE);
            ivEtLeft.setImageResource(drawableId);
        }
    }

    public void setInputType(int inputType) {
        setInputType(inputType, false);
    }

    public void setInputType(int inputType, boolean isPassword) {
        editText.setInputType(inputType);
        if (isPassword)
            editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
    }

    /**
     * Change the editor type integer associated with the text view, which
     * is reported to an Input Method Editor (IME) with when it has focus.
     */
    public void setImeOptions(int imeOptions) {
        editText.setImeOptions(imeOptions);
    }

    public void setCustomEdittextAttribute(){
        //Image left color
        setImageTintColor(CustomEdittextSDK.getInstance().getImageLeftTint());

        //Edittext background and tint color
        setEdittextBackground(CustomEdittextSDK.getInstance().getViewBackground());
        setEdittextBackgroundTint(CustomEdittextSDK.getInstance().getBackgroundTint());
        setEdittextTextColor(CustomEdittextSDK.getInstance().getEtTextColor());
        setEdittextHintColor(CustomEdittextSDK.getInstance().getEtHintColor());
        setEditTextSize(CustomEdittextSDK.getInstance().getTextSize());

        //Edittext Font typeface
        setTypeface(CustomEdittextSDK.getInstance().getTypeface());
        editText.setHint(hintText);

    }

    public void setImageTintColor(int color){
        if(color != 0) {
            int currentApiVersion = android.os.Build.VERSION.SDK_INT;
            if (currentApiVersion >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                ivEtLeft.setImageTintList(ColorStateList.valueOf(color));
            }
        }
    }

    public void setEdittextBackgroundTint(int color){
        if(color != 0) {
            int currentApiVersion = android.os.Build.VERSION.SDK_INT;
            if (currentApiVersion >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                rlView.setBackgroundTintList(ColorStateList.valueOf(color));
            }
        }
    }

    public void setEdittextBackground(Drawable drawableId){
        if(drawableId != null) {
            rlView.setBackground(drawableId);
        }
    }

    public void setTypeface(Typeface typeface) {

        //Set default typeface, if null
        if(typeface == null){
            typeface = Typeface.createFromAsset(getContext().getAssets(), fontPath);
        }

        if(typeface != null) {
            editText.setTypeface(typeface);
        }
    }

    public void setEdittextTextColor(int color){
        if(color != 0) {
            editText.setTextColor(color);
        }
    }

    public void setEdittextHintColor(int color){
        if(color != 0) {
            editText.setHintTextColor(color);
        }
    }

    public void setEditTextSize(float size){

        editText.setTextSize(TypedValue.COMPLEX_UNIT_PX, size);
    }

    public void setEditText(String text){
        editText.setText(text);
    }

    public void setLeftImageResource(int imgResource){
        ivEtLeft.setImageResource(imgResource);
    }

    public void setRightImageResource(int imgResource){
        ivEtRight.setImageResource(imgResource);
    }

}
