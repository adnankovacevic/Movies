package com.example.movies.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.movies.R
import com.example.movies.data.Result
import com.example.movies.util.Constants
import com.squareup.picasso.Picasso

class MovieViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val title: TextView = itemView.findViewById(R.id.tvTitle)
    private val image: ImageView = itemView.findViewById(R.id.ivPoster)

    fun bind(movie: Result, clickListener: OnItemClickListener) {
        title.text = movie.title
        Picasso.get().load(Constants.TMBD_IMG_URL + movie.posterPath).into(image)

        itemView.setOnClickListener {
            clickListener.onItemClicked(movie)
        }
    }

    interface OnItemClickListener {
        fun onItemClicked(movieItem: Result)
    }
}