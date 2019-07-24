package com.example.trainingtask

import com.google.gson.annotations.SerializedName

import java.util.ArrayList

class Movie(
    @field:SerializedName("poster_path")
    var posterPath: String?, @field:SerializedName("adult")
    var isAdult: Boolean, @field:SerializedName("overview")
    var overview: String?, @field:SerializedName("release_date")
    var releaseDate: String?, genreIds: List<Int>, @field:SerializedName("id")
    var id: Int?,
    @field:SerializedName("original_title")
    var originalTitle: String?, @field:SerializedName("original_language")
    var originalLanguage: String?, @field:SerializedName("title")
    var title: String?, @field:SerializedName("backdrop_path")
        var backdropPath: String?, @field:SerializedName("popularity")
    var popularity: Double?,
    @field:SerializedName("vote_count")
    var voteCount: Int?, @field:SerializedName("video")
    var video: Boolean?, @field:SerializedName("vote_average")
    var voteAverage: Double?
) {
    @SerializedName("genre_ids")
    var genreIds: List<Int> = ArrayList()

    init {
        this.genreIds = genreIds
    }
}