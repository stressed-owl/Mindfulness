package com.delusional_bear.mindfulness.data

import android.content.Context
import androidx.annotation.StringRes

class StringResource(@StringRes val resId: Int) {
    fun asString(context: Context): String =context.getString(resId)
}

