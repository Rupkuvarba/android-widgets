package com.app.widgets.controller

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.app.widgets.R
import com.app.widgets.utils.Utils
import com.app.widgets.utils.fonts.Fonts
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Set attribute
        etName.setCustomEdittextAttribute()
        etEmail.setCustomEdittextAttribute()
        etPassword.setCustomEdittextAttribute()

        etName.setImageTintColor(ContextCompat.getColor(this, R.color.green_color))
        etEmail.setEditText("rup.barad@atharvasystem.com")
        etEmail.setEdittextTextColor(ContextCompat.getColor(this, R.color.colorAccent))
        etPassword.setEdittextBackground(ContextCompat.getDrawable(this, R.drawable.rounded_edittext));

        btnSubmit.setOnClickListener(clickListener);
        btnSubmit.typeface = Fonts.getFontTypeface(this);
    }

    private val clickListener = View.OnClickListener { view ->
        when (view.id){
            R.id.btnSubmit -> submitData()
        }
    }

    private fun submitData(){
        Utils.hideKeyboard(this)
        val inputData = "Name: "+etName.editText.text.toString() + " \nEmail: " + etEmail.editText.text.toString();
        Toast.makeText(this, inputData, Toast.LENGTH_SHORT).show()
    }

}
