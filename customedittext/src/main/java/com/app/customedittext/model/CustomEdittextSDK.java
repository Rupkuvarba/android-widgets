package com.app.customedittext.model;

import android.graphics.Typeface;
import android.graphics.drawable.Drawable;

public class CustomEdittextSDK {

    private static CustomEdittextSDK customImageEditText = null;
    private Drawable viewBackground;
    private int imageLeftTint;
    private int backgroundTint;
    private Typeface typeface;

    public static synchronized CustomEdittextSDK getInstance() {
        if (customImageEditText == null)
            customImageEditText = new CustomEdittextSDK();

        return customImageEditText;
    }

    public void setGlobalValues(Drawable viewBackground, int imageLeftTint, int backgroundTint){
       this.viewBackground = viewBackground;
       this.imageLeftTint = imageLeftTint;
       this.backgroundTint = backgroundTint;
    }

    public int getImageLeftTint() {
        return imageLeftTint;
    }

    public Drawable getViewBackground() {
        return viewBackground;
    }

    public int getBackgroundTint() {
        return backgroundTint;
    }

    public Typeface getTypeface() {
        return typeface;
    }

    public void setTypeface(Typeface typeface) {
        this.typeface = typeface;
    }
}
