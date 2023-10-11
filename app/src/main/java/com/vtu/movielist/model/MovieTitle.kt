package com.vtu.movielist.model


import com.google.gson.annotations.SerializedName
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MovieTitle(
    @SerializedName("completed")
    val completed: Boolean? = null,
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("title")
    val title: String? = null,
    @SerializedName("userId")
    val userId: Int? = null
) : Parcelable