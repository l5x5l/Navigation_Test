package com.strayalpaca.presentation.navParam

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Item(
    val id : Int,
    val title : String
) : Parcelable
