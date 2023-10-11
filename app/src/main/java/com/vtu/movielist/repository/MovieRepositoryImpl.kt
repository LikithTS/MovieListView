package com.vtu.movielist.repository

import androidx.lifecycle.LiveData
import com.vtu.movielist.api.MovieApiHelper
import com.vtu.movielist.dao.MovieDao
import com.vtu.movielist.entities.MovieTitleEntity
import com.vtu.movielist.model.MovieTitle
import com.vtu.movielist.util.Resource
import com.vtu.movielist.util.Status
import retrofit2.Response
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val apiHelper: MovieApiHelper,
    private val movieDao: MovieDao
) : MovieRepository {

    override suspend fun getMovieDetails(): Resource<List<MovieTitle>> {
        val data = apiHelper.getMovieDetails()
        return if (data.isSuccessful) {
//            Resource.success(data.body())
            Resource(Status.SUCCESS, data.body(), null)
        } else {
//            Resource.error(data.body(), "Error")
            Resource(Status.ERROR, null, "Error")
        }
    }

    override suspend fun insertMovieData(movieTitle: MovieTitleEntity) {
        movieDao.storeMovieDetails(movieDetails = movieTitle)
    }

    override suspend fun deleteMovieData(id: Int) {
        movieDao.deleteMovieDetails(id)
    }

    override fun getAllMovieList(): LiveData<List<MovieTitleEntity>> {
        return movieDao.getMovieDetails()
    }
}