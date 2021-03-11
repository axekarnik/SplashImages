package com.practice.socialimages.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UnSplashPhoto (
    @SerializedName("id")
    val id: String,

    @SerializedName("description")
    val desc: String,

    @SerializedName("urls")
    val urls : UnpslashPhotoUrls,

    @SerializedName("user")
    val user: UnSplashUser) : Parcelable{

    @Parcelize
    data class UnpslashPhotoUrls(
        val raw : String,
        val full: String,
        val regular: String,
        val small: String,
        val thumb: String
    ) : Parcelable

    @Parcelize
    data class UnSplashUser(
        val name: String,
        val username: String
    ) : Parcelable{
        val attributionUrl get() = "https://unsplash.com/$username?utm_source=SocialImages&utm_medium=referral"
    }
}
