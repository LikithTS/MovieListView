package com.vtu.movielist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.vtu.movielist.databinding.MovieItemsBinding
import com.vtu.movielist.model.MovieTitle

class TestAdapter(val handleItemClick : (Int) -> Unit) : RecyclerView.Adapter<TestAdapter.MovieTestTileViewHolder>() {


    inner class MovieTestTileViewHolder(val binding : MovieItemsBinding) : RecyclerView.ViewHolder(binding.root)

    private val diffUtil = object : DiffUtil.ItemCallback<MovieTitle>() {
        override fun areItemsTheSame(oldItem: MovieTitle, newItem: MovieTitle): Boolean {
           return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: MovieTitle, newItem: MovieTitle): Boolean {
            return oldItem == newItem
        }
    }

    private val diffData = AsyncListDiffer(this, diffUtil)

    var movieList :List<MovieTitle>
    get() = diffData.currentList
    set(value) = diffData.submitList(value)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieTestTileViewHolder {
        return MovieTestTileViewHolder(MovieItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: MovieTestTileViewHolder, position: Int) {
        holder.binding.movieNames.text = movieList[position].title
    }

    override fun getItemCount(): Int {
       return movieList.size
    }
}