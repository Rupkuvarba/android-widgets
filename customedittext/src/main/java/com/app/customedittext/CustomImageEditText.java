package com.app.customedittext;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
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

    private int drawableId = 0;

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


}
