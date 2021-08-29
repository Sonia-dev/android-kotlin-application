package com.example.examandroid.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Profile_Image(
    val small:String?,
    val large:String?,
    val medium:String?
): Parcelable {
}