package com.example.movies.ui

import com.example.movies.data.Movie
import com.example.movies.data.Result
import com.example.movies.data.network.ServiceBuilder
import com.example.movies.data.network.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MoviePresenter(val view: MovieView) {

    fun loadMovies() {
        view.displayProgressBar()

        val service = ServiceBuilder.buildService(ApiService::class.java)
        val response = service.getPopularMovies("ebffad33c0ea8de053e4eb38ba115d76")

        response.enqueue(object : Callback<Movie> {
            override fun onResponse(call: Call<Movie>, response: Response<Movie>) {
                view.removeProgressBar()
                view.displayMovies(response.body()!!.results as MutableList<Result>)
            }

            override fun onFailure(call: Call<Movie>, t: Throwable) {
                view.removeProgressBar()
                view.displayErrorMessage("No connection available...")
            }

        })
    }

    fun onRefresh() {
        view.refreshScreen()
    }
}