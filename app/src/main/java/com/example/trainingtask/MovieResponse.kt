package com.example.trainingtask

import com.example.trainingtask.Movie
import com.google.gson.annotations.SerializedName

class MovieResponse {
    @SerializedName("page")
    var page: Int = 0
    @SerializedName("results")
    var results: List<Movie>? = null
    @SerializedName("total_results")
    var totalResults: Int = 0
    @SerializedName("total_pages")
    var totalPages: Int = 0
}