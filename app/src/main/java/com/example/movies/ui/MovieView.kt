package com.example.movies.ui

import com.example.movies.data.Result

interface MovieView {
    fun displayMovies(data: MutableList<Result>)
    fun displayErrorMessage(message: String)
    fun displayProgressBar()
    fun removeProgressBar()
    fun refreshScreen()
}