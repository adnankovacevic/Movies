package com.example.movies.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.movies.R
import com.example.movies.util.Constants
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_details.*
import kotlinx.android.synthetic.main.activity_details.movieImage

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val movieTitle: String = intent.getStringExtra(Constants.TITLE).toString()
        val moviePosterPath: String = intent.getStringExtra(Constants.POSTER_PATH).toString()
        val movieOverview: String = intent.getStringExtra(Constants.OVERVIEW).toString()
        val movieRating: Double = intent.getDoubleExtra(Constants.RATING, 0.0)


        details_overview_text.text = movieOverview
        movieTitle_details.text = movieTitle
        details_rating_text.text = movieRating.toString()
        Picasso.get().load("https://image.tmdb.org/t/p/w780${moviePosterPath}")
            .into(movieImage)


    }
}