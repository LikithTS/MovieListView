package com.vtu.movielist.viewModels

import android.arch.core.executor.testing.InstantTaskExecutorRule
import com.vtu.movielist.repository.TestMovieRepositoryImpl
import com.vtu.movielist.util.MainCoroutineRule
import com.vtu.movielist.util.getOrAwaitValue
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import org.junit.Rule

@ExperimentalCoroutinesApi
class MovieViewModelTest {

    private lateinit var viewModel: MovieViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    var movieRepository = TestMovieRepositoryImpl()

    @Before
    fun setUp() {
        viewModel = MovieViewModel(movieRepository)
    }


    @Test
    fun `show progress bar when getting data from the server`() = runBlocking{
        //Given
        movieRepository.updateLoadingStatus(true)

        //When
        viewModel.getMovieList()

        //Then
        assertEquals(true, viewModel.progressBarVisible.getOrAwaitValue())
    }

    @Test
    fun `show error when getting data from the server fails`() = runBlocking{
        //Given
        movieRepository.showError(true)

        //When
        viewModel.getMovieList()
        val result = viewModel.movieListError.getOrAwaitValue(5)

        //Then
        assertEquals("Error loading movie list", result)
    }

}