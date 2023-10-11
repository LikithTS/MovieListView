package com.vtu.movielist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.vtu.movielist.R
import com.vtu.movielist.databinding.MovieItemsBinding
import com.vtu.movielist.fragments.MovieDetailFragment
import com.vtu.movielist.model.MovieTitle
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

class MovieListAdapter(val movieTitleClick : (MovieTitle) -> Unit): RecyclerView.Adapter<MovieListAdapter.MovieListViewHolder>() {


    inner class MovieListViewHolder(val binding : MovieItemsBinding) : RecyclerView.ViewHolder(binding.root)

    private val diffCallback = object : DiffUtil.ItemCallback<MovieTitle>() {
        override fun areItemsTheSame(oldItem: MovieTitle, newItem: MovieTitle): Boolean {
            return oldItem.id  == newItem.id
        }

        override fun areContentsTheSame(oldItem: MovieTitle, newItem: MovieTitle): Boolean {
            return oldItem == newItem
        }
    }

    private val listDiffer = AsyncListDiffer(this, diffCallback)

    var movies : List<MovieTitle>
        get() = listDiffer.currentList
        set(value) {
            listDiffer.submitList(value)
        }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieListViewHolder {
        return MovieListViewHolder(MovieItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: MovieListViewHolder, position: Int) {
        holder.binding.apply {
            val movieDate = movies[position]
            movieNames.text = movieDate.title
        }

        holder.binding.listItemView.setOnClickListener {
            movieTitleClick(movies[position])
        }
    }
}