package com.vtu.movielist.model


import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class Question(
    @SerializedName("id")
    val id: String? = null,
    @SerializedName("tags")
    val tags: List<String?>? = null,
    @SerializedName("title")
    val title: String? = null
) : Parcelable