package com.ruialmeida.quarentilograms.shared.extensions.platform

import android.content.Context
import android.widget.Toast
import androidx.annotation.StringRes

fun Any.showToast(context: Context, @StringRes text: Int, duration: Int = Toast.LENGTH_SHORT) = Toast.makeText(context, text, duration).show()