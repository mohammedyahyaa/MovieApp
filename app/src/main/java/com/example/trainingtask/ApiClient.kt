package com.example.trainingtask

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

open class ApiClient {

    val baseUri : String ="http://api.themoviedb.org/3/"

    var ret :Retrofit? = null

    public open fun  R() : Retrofit? {

        if(ret==null){

            ret=Retrofit.Builder().baseUrl(baseUri).addConverterFactory(GsonConverterFactory.create()).build()
        }


        return ret
    }
}