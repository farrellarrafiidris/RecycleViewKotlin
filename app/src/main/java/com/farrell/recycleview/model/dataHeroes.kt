package com.farrell.recycleview.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize

data class dataHeroes(
    val name        : String,
    val description : String,
    val image      : Int,
):Parcelable

