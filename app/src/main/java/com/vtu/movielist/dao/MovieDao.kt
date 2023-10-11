package com.vtu.movielist.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.vtu.movielist.entities.MovieTitleEntity
import retrofit2.http.GET

@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun storeMovieDetails(movieDetails : MovieTitleEntity)

    @Query("SELECT * FROM MovieTitle")
    fun getMovieDetails() : LiveData<List<MovieTitleEntity>>

    @Query("DELETE FROM MovieTitle where id = :movieId")
    suspend fun deleteMovieDetails(movieId : Int)

}