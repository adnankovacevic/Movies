package com.example.movies.data.network

import com.example.movies.data.Movie
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("/3/movie/now_playing")
    fun getPopularMovies(@Query("api_key") api_key: String): Call<Movie>
}