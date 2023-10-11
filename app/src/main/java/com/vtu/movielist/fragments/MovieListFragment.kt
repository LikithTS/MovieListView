package com.vtu.movielist.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.vtu.movielist.R
import com.vtu.movielist.adapter.MovieListAdapter
import com.vtu.movielist.databinding.FragmentMovieDetailBinding
import com.vtu.movielist.databinding.FragmentMovieListBinding
import com.vtu.movielist.util.isOnline
import com.vtu.movielist.viewModels.MovieViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest

/**
 * A simple [Fragment] subclass.
 * Use the [MovieListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
@AndroidEntryPoint
class MovieListFragment : Fragment() {

    private val movieViewModel : MovieViewModel by viewModels()
    private lateinit var movieAdapter : MovieListAdapter
    private lateinit var binding : FragmentMovieListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentMovieListBinding.inflate(LayoutInflater.from(context))

        setUpRecyclerViewer()
        binding.progressView.visibility = View.VISIBLE

        lifecycleScope.launchWhenCreated {
            movieViewModel.movieList.collect{
                if(it.isNotEmpty()) {
                    binding.progressView.visibility = View.GONE
                    movieAdapter.movies = it
                }
            }

//            movieViewModel.movieList.observe(viewLifecycleOwner) {
//                binding.progressView.visibility = View.GONE
//                movieAdapter.movies = it
//            }
        }
        if(context?.isOnline() == true) {
            movieViewModel.getMovieList()
        }

        return binding.root
    }

    private fun setUpRecyclerViewer() = binding.movieList.apply {
        movieAdapter = MovieListAdapter { pos ->
            println("Position $pos")
            activity?.supportFragmentManager?.beginTransaction()?.apply {
                replace(R.id.fragment_container, MovieDetailFragment())
                addToBackStack(null)
                commit()
            }
        }
        adapter = movieAdapter
        layoutManager = LinearLayoutManager(context)
    }

}