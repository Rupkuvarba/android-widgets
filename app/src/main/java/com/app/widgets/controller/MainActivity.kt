package com.app.widgets.controller

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import com.app.widgets.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Set attribute
        etName.setCustomEdittextAttribute()
        etEmail.setCustomEdittextAttribute()
        etPassword.setCustomEdittextAttribute()

        etEmail.setEditText("rup.barad@atharvasystem.com")
        etEmail.setEdittextTextColor(resources.getColor(R.color.colorAccent))

    }
}
