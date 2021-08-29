package com.example.examandroid.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue


@Parcelize
data class User (
    val username:String,
    val profile_image: @RawValue Profile_Image?): Parcelable {

}