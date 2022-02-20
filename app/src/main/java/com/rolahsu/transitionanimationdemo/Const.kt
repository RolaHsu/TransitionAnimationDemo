package com.rolahsu.transitionanimationdemo

import androidx.annotation.DrawableRes

const val START_IMAGE = "START_IMAGE"
const val END_IMAGE = "END_IMAGE"


// easy sample
const val A_IMAGE = "A_IMAGE"
const val B_IMAGE = "B_IMAGE"

// recyclerView sample
const val RECYCLERVIEW_IMAGE = "RECYCLERVIEW_IMAGE"
var GRID_POSITION: Int? = null

internal object ImageData {

    @DrawableRes
    val IMAGE_DRAWABLES = intArrayOf(R.drawable.dog1,
        R.drawable.cat,
        R.drawable.cat2,
        R.drawable.dog2,
        R.drawable.cat3,
        R.drawable.dog3,
        R.drawable.dog1,
        R.drawable.cat,
        R.drawable.cat2,
        R.drawable.dog2,
        R.drawable.cat3,
        R.drawable.dog3)
}