package com.app.customedittext.model;

import android.graphics.Typeface;
import android.graphics.drawable.Drawable;

public class CustomEdittextSDK {

    private static CustomEdittextSDK customImageEditText = null;
    private Drawable viewBackground;
    private Float textSize = 0f;
    private int imageLeftTint;
    private int backgroundTint;
    private int etTextColor;
    private int etHintColor;
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

    public int getEtTextColor() {
        return etTextColor;
    }

    public void setEtTextColor(int etTextColor) {
        this.etTextColor = etTextColor;
    }

    public int getEtHintColor() {
        return etHintColor;
    }

    public void setEtHintColor(int etHintColor) {
        this.etHintColor = etHintColor;
    }

    public Float getTextSize() {
        return textSize;
    }

    public void setTextSize(Float textSize) {
        this.textSize = textSize;
    }

    public void setViewBackground(Drawable viewBackground) {
        this.viewBackground = viewBackground;
    }

    public void setImageLeftTint(int imageLeftTint) {
        this.imageLeftTint = imageLeftTint;
    }

    public void setBackgroundTint(int backgroundTint) {
        this.backgroundTint = backgroundTint;
    }
}
