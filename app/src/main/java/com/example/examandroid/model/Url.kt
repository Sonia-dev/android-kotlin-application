package com.example.examandroid.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Url (
    val raw:String?,
    val full:String?,
    val regular:String?,
    val small:String?,
    val thumb:String?
):Parcelable{
}