package com.app.widgets.application

import android.app.Application
import androidx.core.content.ContextCompat
import com.app.customedittext.model.CustomEdittextSDK
import com.app.widgets.R
import com.app.widgets.utils.fonts.Fonts.getFontTypeface

class WidgetsApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        //Set global values of custom edittext
        CustomEdittextSDK.getInstance().setGlobalValues(
            ContextCompat.getDrawable(this, R.drawable.edittext_bg_line),
            ContextCompat.getColor(this, R.color.edit_text_image_left_color),
            0
        )

        //Text color
        CustomEdittextSDK.getInstance().etTextColor = ContextCompat.getColor(this,R.color.edit_text_text_color);
        CustomEdittextSDK.getInstance().etHintColor = ContextCompat.getColor(this,R.color.edit_text_hint_color);

        //Set font typeface
        CustomEdittextSDK.getInstance().typeface = getFontTypeface(this)
    }
}