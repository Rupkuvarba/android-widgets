# android-widgets

1. Custom Image edittext 

![alt text](https://github.com/Rupkuvarba/android-widgets/blob/master/screenshot/Screenshot7.png)


# Setup

1 - Add jitpack.io repositories to you project build.gradle

allprojects {
    repositories {
    
       maven { url 'https://jitpack.io' }
    }
}

2- Add it as a dependency to your app build.gradle

dependencies {

    implementation 'com.github.Rupkuvarba:android-widgets:v1.0'
}


# Usage
Step1: Set Edittext global value from application class


    override fun onCreate() {
        super.onCreate()
        
        //Set global values of custom edittext
        CustomEdittextSDK.getInstance().setGlobalValues(

            //Edittext background -> For Line background set R.drawable.edittext_bg_line
            ContextCompat.getDrawable(this, R.drawable.rounded_edittext),

            //Edittext icon color
            ContextCompat.getColor(this, R.color.edit_text_hint_color),
            
            //Edittext background tint, if Edittext background -> line then set
            //ContextCompat.getColor(this, R.color.green_color), or set 0
            
            0
        )

        //Text color
        CustomEdittextSDK.getInstance().etTextColor = ContextCompat.getColor(this,R.color.edit_text_text_color);
        CustomEdittextSDK.getInstance().etHintColor = ContextCompat.getColor(this,R.color.edit_text_hint_color);

        //Set font typeface
        CustomEdittextSDK.getInstance().typeface = getFontTypeface(this)

        //Set edit text size
        CustomEdittextSDK.getInstance().textSize = resources.getDimensionPixelSize(R.dimen.edit_text_size).toFloat();
    }
    


Step2: Xml file 


<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:layout_margin="20dp"
    tools:context=".controller.MainActivity">

    <com.app.customedittext.controller.CustomImageEditText
        android:id="@+id/etName"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:imeOptions="actionNext"
        android:inputType="text"
        app:edt_hint = "Name"
        app:cie_iv_left_src="@drawable/ic_user"/>

    <com.app.customedittext.controller.CustomImageEditText
        android:id="@+id/etEmail"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:imeOptions="actionNext"
        android:inputType="textEmailAddress"
        app:edt_hint = "Email"
        app:cie_iv_left_src="@drawable/ic_email"/>

    <com.app.customedittext.controller.CustomImageEditText
        android:id="@+id/etPassword"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:imeOptions="actionDone"
        android:inputType="textPassword"
        app:edt_hint = "Password"
        app:cie_iv_left_src="@drawable/ic_password"/>

    <Button
        android:id="@+id/btnSubmit"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="30sp"
        android:text="Submit"
        android:layout_gravity="center_horizontal"
        android:background="@color/colorPrimary"
        android:textAllCaps="false"
        android:textSize="20dp"
        android:textColor="@color/white"/>

</LinearLayout>

Step3: Set attributes in code file

etName.setCustomEdittextAttribute()
etEmail.setCustomEdittextAttribute()
etPassword.setCustomEdittextAttribute()

https://github.com/Rupkuvarba/android-widgets/blob/master/screenshot






