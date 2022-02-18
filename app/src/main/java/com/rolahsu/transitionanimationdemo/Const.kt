package com.rolahsu.transitionanimationdemo

import androidx.annotation.DrawableRes

const val START_IMAGE = "START_IMAGE"
const val END_IMAGE = "END_IMAGE"
const val RECYCLERVIEW_IMAGE = "RECYCLERVIEW_IMAGE"

internal object ImageData {

    @DrawableRes
    val IMAGE_DRAWABLES = intArrayOf(
            R.drawable.ic_baseline_thumb_up_24,
            R.drawable.ic_baseline_thumb_up,
            R.drawable.ic_baseline_account_circle_24,
            R.drawable.ic_baseline_toys_24,
            R.drawable.ic_baseline_arrow_back_24,
            R.drawable.ic_launcher_foreground,
    )
}