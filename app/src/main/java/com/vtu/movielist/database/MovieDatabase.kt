package com.vtu.movielist.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.vtu.movielist.dao.MovieDao
import com.vtu.movielist.entities.MovieTitleEntity

@Database(
    entities = [MovieTitleEntity::class],
    version = 1
)
abstract class MovieDatabase : RoomDatabase() {

    abstract val dao : MovieDao

}