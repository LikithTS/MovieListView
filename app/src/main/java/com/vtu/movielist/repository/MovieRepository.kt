package com.vtu.movielist.repository

import androidx.lifecycle.LiveData
import com.vtu.movielist.entities.MovieTitleEntity
import com.vtu.movielist.model.MovieTitle
import com.vtu.movielist.util.Resource
import retrofit2.Response

interface MovieRepository {

    suspend fun getMovieDetails() : Resource<List<MovieTitle>>

    suspend fun insertMovieData(movieTitle: MovieTitleEntity)

    suspend fun deleteMovieData(id : Int)

    fun getAllMovieList() : LiveData<List<MovieTitleEntity>>
}