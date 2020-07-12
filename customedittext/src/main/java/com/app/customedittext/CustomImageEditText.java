package com.app.customedittext;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.InputFilter;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.annotation.Nullable;

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

    }

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

    public void setTypeface(Typeface font) {
        editText.setTypeface(font);
    }

    public void setLeftImageResource(int imgResourse){
        ivEtLeft.setImageResource(imgResourse);
    }

    public void setRightImageResource(int imgResourse){
        ivEtRight.setImageResource(imgResourse);
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

}
