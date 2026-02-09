package com.arlina.android_laba10_11_kuzvah.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Student(
    @DrawableRes val imageResouceId: Int,
    @StringRes val name: Int,
    val age: Int,
    @StringRes val description: Int
) {
}