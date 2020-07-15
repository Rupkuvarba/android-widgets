package com.app.widgets.utils.fonts;

import android.content.Context;
import android.graphics.Typeface;
import android.widget.TextView;

public class Fonts {

    // Font - paths
    private static String FONT_REGULAR = "fonts/" + "roboto_regular.ttf";

    public static Typeface getFontTypeface(Context context) {
        return Typeface.createFromAsset(context.getAssets(), FONT_REGULAR);
    }


}
