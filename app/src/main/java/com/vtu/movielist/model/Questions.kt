package com.vtu.movielist.model


import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class Questions(
    @SerializedName("questions")
    val questions: List<Question?>? = null,
    @SerializedName("volunteers")
    val volunteers: List<Volunteer?>? = null
) : Parcelable