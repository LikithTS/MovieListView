package com.vtu.movielist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.vtu.movielist.adapter.MovieListAdapter
import com.vtu.movielist.databinding.ActivityMainBinding
import com.vtu.movielist.fragments.MovieListFragment
import com.vtu.movielist.viewModels.MovieViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val movieListFragment = MovieListFragment()
        supportFragmentManager.beginTransaction().apply {
            add(R.id.fragment_container, movieListFragment)
            commit()
        }

    }

}