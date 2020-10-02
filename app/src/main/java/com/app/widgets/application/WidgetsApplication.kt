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

            //Edittext background -> For Line background set R.drawable.edittext_bg_line
            ContextCompat.getDrawable(this, R.drawable.edittext_bg_line),

            //Edittext icon color
            ContextCompat.getColor(this, R.color.colorPrimary),

            //Edittext background tint, if Edittext background -> line then set
            //ContextCompat.getColor(this, R.color.green_color), or set 0

            ContextCompat.getColor(this, R.color.colorPrimary)
        )

        //Text color
        CustomEdittextSDK.getInstance().etTextColor = ContextCompat.getColor(this,R.color.edit_text_text_color);
        CustomEdittextSDK.getInstance().etHintColor = ContextCompat.getColor(this,R.color.edit_text_hint_color);

        //Set font typeface
        CustomEdittextSDK.getInstance().typeface = getFontTypeface(this)

        //Set edit text size
        CustomEdittextSDK.getInstance().textSize = resources.getDimensionPixelSize(R.dimen.edit_text_size).toFloat();
    }
}