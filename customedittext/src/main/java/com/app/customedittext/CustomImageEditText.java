package com.app.customedittext;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

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

    public CustomImageEditText(Context context) {
        super(context);
        initialize(context);
    }

    public CustomImageEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialize(context);
    }

    private void initialize(Context context){
        View view = LayoutInflater.from(context).inflate(R.layout.custom_image_edittext, this, true);
        rlView = view.findViewById(R.id.rl_view);
        ivEtLeft = view.findViewById(R.id.iv_left);
        ivEtRight = view.findViewById(R.id.iv_right);
        editText = view.findViewById(R.id.edit_text);

        ivEtRight.setVisibility(GONE);
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


}
