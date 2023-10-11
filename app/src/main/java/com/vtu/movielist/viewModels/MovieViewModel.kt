package com.vtu.movielist.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vtu.movielist.model.MovieTitle
import com.vtu.movielist.repository.MovieRepository
import com.vtu.movielist.repository.MovieRepositoryImpl
import com.vtu.movielist.util.Status
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(private val repository: MovieRepository) : ViewModel() {

    private val _movieList = MutableStateFlow(listOf<MovieTitle>())
    val movieList = _movieList.asStateFlow()

    private val _movieListError = MutableStateFlow("")
    val movieListError = _movieListError.asStateFlow()

    private val _progressBarVisible = MutableStateFlow(false)
    val progressBarVisible = _progressBarVisible.asStateFlow()


//    private val _movieList = MutableLiveData(listOf<MovieTitle>())
//    val movieList : LiveData<List<MovieTitle>> = _movieList
//
//    private val _movieListError = MutableLiveData("")
//    val movieListError : LiveData<String> = _movieListError
//
//    private val _progressBarVisible = MutableLiveData(false)
//    val progressBarVisible : LiveData<Boolean> = _progressBarVisible

    fun getMovieList() {
        viewModelScope.launch {
            repository.getMovieDetails().let {
                when (it.status) {
                    Status.SUCCESS -> {
                        it.data?.let { list ->
                            _movieList.value = list
                            _progressBarVisible.value = false
                        }
                    }
                    Status.LOADING -> {
                        //Enable progress bar
                        _progressBarVisible.value = true
                    }
                    else -> {
                        //Show error dialog
                        _progressBarVisible.value = false
                        _movieListError.value = "Error loading movie list"
                    }
                }
            }
        }
    }
}