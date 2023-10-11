package com.vtu.movielist.api

import com.vtu.movielist.model.MovieTitle
import com.vtu.movielist.util.Resource
import retrofit2.Response

interface MovieApiHelper {

    suspend fun getMovieDetails() : Response<List<MovieTitle>>
}