package com.vtu.movielist.api

import androidx.room.Query
import androidx.room.Update
import com.vtu.movielist.model.MovieTitle
import com.vtu.movielist.util.Resource
import retrofit2.Response
import retrofit2.http.DELETE
import retrofit2.http.GET

interface MovieApiService {

    @GET("/todos")
    suspend fun getMovieList() : Response<List<MovieTitle>>

}