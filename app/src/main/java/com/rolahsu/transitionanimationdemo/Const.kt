package com.rolahsu.transitionanimationdemo

import androidx.annotation.DrawableRes

const val START_IMAGE = "START_IMAGE"
const val END_IMAGE = "END_IMAGE"
const val RECYCLERVIEW_IMAGE = "RECYCLERVIEW_IMAGE"
const val A_IMAGE = "A_IMAGE"
const val B_IMAGE = "B_IMAGE"

internal object ImageData {

    @DrawableRes
    val IMAGE_DRAWABLES = intArrayOf(
            R.drawable.dog1,
            R.drawable.cat,
            R.drawable.cat2,
            R.drawable.dog2,
            R.drawable.cat3,
            R.drawable.dog3
    )
}