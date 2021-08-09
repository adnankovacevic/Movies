package com.example.movies.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.example.movies.*
import com.example.movies.adapter.MovieAdapter
import com.example.movies.adapter.MovieViewHolder
import com.example.movies.util.RVItemDecoration
import com.example.movies.data.Result
import com.example.movies.util.Constants
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MovieView, MovieViewHolder.OnItemClickListener {

    private var movieAdapter = MovieAdapter(this)

    var movies = mutableListOf<Result>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val presenter = MoviePresenter(this)
        presenter.loadMovies()
        presenter.onRefresh()


        val manager = GridLayoutManager(this, 2)
        movieList.apply {
            layoutManager = manager
            addItemDecoration(RVItemDecoration(2))
            adapter = movieAdapter

        }
    }

    override fun displayMovies(data: MutableList<Result>) {
        movieAdapter.movieList = data
        movieAdapter.notifyDataSetChanged()
    }

    override fun displayErrorMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun displayProgressBar() {
        progressBar.visibility = View.VISIBLE
    }

    override fun removeProgressBar() {
        progressBar.visibility = View.GONE
    }

    override fun refreshScreen() {
        refresh.setOnRefreshListener {

            /*
            swipe.isRefreshing = false
            displayData(adapter.movieList)
             */
            Handler().postDelayed({
                refresh.isRefreshing = false
                displayMovies(movieAdapter.movieList)
            }, 1500)
        }
    }

    override fun onItemClicked(movieItem: Result) {
        val intent = Intent(this, DetailsActivity::class.java)
        intent.putExtra(Constants.ID, movieItem)
        intent.putExtra(Constants.TITLE, movieItem)
        intent.putExtra(Constants.POSTER_PATH, movieItem)
        intent.putExtra(Constants.BACKDROP_PATH, movieItem)
        intent.putExtra(Constants.OVERVIEW, movieItem)
        intent.putExtra(Constants.RATING, movieItem)
        this.startActivity(intent)
    }
}