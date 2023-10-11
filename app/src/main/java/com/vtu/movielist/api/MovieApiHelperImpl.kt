package com.vtu.movielist.api

import com.vtu.movielist.model.MovieTitle
import retrofit2.Response
import javax.inject.Inject

class MovieApiHelperImpl @Inject constructor(val apiService: MovieApiService) : MovieApiHelper {

    override suspend fun getMovieDetails(): Response<List<MovieTitle>> {
        return apiService.getMovieList()
    }
}