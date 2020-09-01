package com.esq.gads2020practiceproject1.utils

import android.content.Context
import android.view.View
import android.widget.EditText
import android.widget.Toast

fun Context.shortToast(msg: String) {
    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
}

fun Context.longToast(msg: String) {
    Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
}

fun EditText.requestFocusWithErrorMessage(msg: String) {
    this.error = msg
}