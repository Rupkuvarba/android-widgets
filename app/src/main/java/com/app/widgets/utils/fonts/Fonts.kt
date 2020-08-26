package com.app.widgets.utils.fonts

import android.content.Context
import android.graphics.Typeface

object Fonts {
    // Font - paths
    private const val FONT_REGULAR = "fonts/" + "roboto_bold.ttf"

    @JvmStatic
    fun getFontTypeface(context: Context): Typeface {
        return Typeface.createFromAsset(context.assets, FONT_REGULAR)
    }
}