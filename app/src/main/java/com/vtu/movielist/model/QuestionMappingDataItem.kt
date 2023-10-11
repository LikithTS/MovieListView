package com.vtu.movielist.model


import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class QuestionMappingDataItem(
    @SerializedName("question")
    val question: String? = null,
    @SerializedName("volunteer")
    val volunteer: String? = null
) : Parcelable