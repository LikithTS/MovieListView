package com.vtu.movielist.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "MovieTitle")
data class MovieTitleEntity(
    val title : String,
    val description : String,
    val movieRating : String,
    @PrimaryKey val id : Int
)
