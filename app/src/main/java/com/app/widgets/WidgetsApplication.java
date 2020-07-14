package com.app.widgets;

import android.app.Application;

import androidx.core.content.ContextCompat;

import com.app.customedittext.CustomEdittextSDK;

public class WidgetsApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        //Set global values of edittext
        CustomEdittextSDK.getInstance().setGlobalValues(
                ContextCompat.getDrawable(this, R.drawable.edittext_bg_line),
                ContextCompat.getColor(this,R.color.edit_text_image_left_color),
                0);
    }
}
