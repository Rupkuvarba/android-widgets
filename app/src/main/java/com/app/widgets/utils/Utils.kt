package com.app.widgets.utils

import android.app.Activity
import android.content.Context
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager

class Utils {

    companion object{

        //Hide - Keyboard
        fun hideKeyboard(context: Context) {
            try {
                (context as Activity).window
                    .setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN)
                if (context.currentFocus != null && context.currentFocus!!.windowToken != null) (context.getSystemService(
                    Context.INPUT_METHOD_SERVICE
                ) as InputMethodManager).hideSoftInputFromWindow(
                    context.currentFocus!!.windowToken,
                    0
                )
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

    }


}