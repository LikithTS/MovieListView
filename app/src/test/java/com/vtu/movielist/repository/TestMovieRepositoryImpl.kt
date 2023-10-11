package com.vtu.movielist.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.vtu.movielist.entities.MovieTitleEntity
import com.vtu.movielist.model.MovieTitle
import com.vtu.movielist.util.Resource
import com.vtu.movielist.util.Status

class TestMovieRepositoryImpl : MovieRepository {

    val movieTitle = mutableListOf<MovieTitle>()
    val movieTitleEntity = mutableListOf<MovieTitleEntity>()

    private val movieList = MutableLiveData<List<MovieTitle>>(movieTitle)
    private val movieListEntity = MutableLiveData<List<MovieTitleEntity>>(movieTitleEntity)
    private var isLoadingEnabled = false
    private var showError = false

    fun updateLoadingStatus(value : Boolean) {
        isLoadingEnabled = true
    }

    fun showError(value : Boolean) {
        showError = value
    }

    fun refreshMutableList() {
        movieList.postValue(movieTitle)
        movieListEntity.postValue(movieTitleEntity)
    }

    fun addListOfMovieTitle() : List<MovieTitle>{
        movieTitle.add(1, MovieTitle(false, 1,"TopGun", 1))
        movieTitle.add(2, MovieTitle(false, 2,"MI1", 2))
        movieTitle.add(3, MovieTitle(false, 3,"MI2", 3))
        movieTitle.add(4, MovieTitle(false, 4,"MI3", 4))
        return movieTitle
    }

    override suspend fun getMovieDetails(): Resource<List<MovieTitle>> {
        val movieTitleList = addListOfMovieTitle()
        return if(isLoadingEnabled) {
            Resource(Status.LOADING, movieTitleList, null)
        } else if(showError) {
            Resource(Status.ERROR, null, "Error")
        } else {
            Resource(Status.SUCCESS, movieTitleList, null)
        }
    }

    override suspend fun insertMovieData(movieTitle: MovieTitleEntity) {
        movieTitleEntity.add(movieTitle)
        refreshMutableList()
    }

    override suspend fun deleteMovieData(id: Int) {
        val movietTitleData = movieTitleEntity[id]
        movieTitleEntity.remove(movietTitleData)
        refreshMutableList()
    }

    override fun getAllMovieList(): LiveData<List<MovieTitleEntity>> {
        return movieListEntity
    }
}