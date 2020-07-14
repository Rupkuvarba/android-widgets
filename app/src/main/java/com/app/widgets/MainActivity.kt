package com.app.widgets

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.app.customedittext.CustomEdittextSDK
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Set attribute
        etName.setCustomEdittextAttribute()
        etEmail.setCustomEdittextAttribute()
        etPassword.setCustomEdittextAttribute()
    }
}
