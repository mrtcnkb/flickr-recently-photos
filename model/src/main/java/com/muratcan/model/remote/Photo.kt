package com.muratcan.model.remote

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Photo(
    val farm: Int,
    val id: String,
    val isfamily: Int,
    val isfriend: Int,
    val ispublic: Int,
    val owner: String,
    val secret: String,
    val server: String,
    val title: String
): Parcelable {
    fun getPhotoUri(): String =
        "https://farm$farm.staticflickr.com/$server/${id}_${secret}_c.jpg"

    fun titleIsNotBlank(): Boolean = title.isNotBlank()

}