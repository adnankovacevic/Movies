package com.example.movies.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.movies.R
import com.example.movies.data.Result

class MovieAdapter(private val itemClickListener: MovieViewHolder.OnItemClickListener) :
    RecyclerView.Adapter<MovieViewHolder>() {

    var movieList = mutableListOf<Result>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder =
        MovieViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false)
        )

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(movieList[position], itemClickListener)

    }

    override fun getItemCount(): Int = movieList.size
}