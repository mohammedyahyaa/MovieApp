package com.example.trainingtask

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiInterface {




    @GET("movie/popular")
    fun getMovies(@Query ("api_key")apiKey : String  ): Call<MovieResponse>

  /*  @GET("movie/{movie_id}?append_to_response=credits,videos")
    fun getMovieDetails(@Path(value = "movie_id")movieId: Long): Call<Movie>*/


    companion object Factory {
        val BASE_URL = "https://api.themoviedb.org/3/"
        fun create(): ApiInterface {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(ApiInterface::class.java)
        }
    }

}

//
//
//    @GET("movie/popular")
//    fun getPopularMovies(): Call<namesResponse>
//
//    @GET("movie/")
//    fun getRecommendationsForMovie(@Path(value = "movie_id") movieId: String): Call<namesResponse>


//    @GET("movie/popular")
//    fun getPopularMovies(): Observable<MoviePage>
//
//    @GET("movie/{movie_id}/recommendations")
//    fun getRecommendationsForMovie(@Path(value = "movie_id") movieId: Long): Observable<MoviePage>
//

//
//    @GET("search/movie")
//    fun searchMovie(@Query("query") query: String): Observable<MoviePage>









