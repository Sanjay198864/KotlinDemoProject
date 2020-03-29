package com.mydemoapp.utils

import android.content.Context
import android.widget.Toast

class DialogUtil {

    fun showToast(context: Context, msg: String) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
    }
}