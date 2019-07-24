package com.example.trainingtask

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {


    private var recyclerView: RecyclerView? = null
    private var mAdapter: recAdapter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val apiService = ApiInterface?.create()
        val call = apiService.getMovies("a52c775a630c8b990fe9365ca601e2bf")


        Log.d("REQUEST", call.toString() + "")


        val openFilm = object : OpenFilm {
            override fun openFilm() {
                val intent = Intent(this@MainActivity, FilmDetailsActivity::class.java)
                //   Toast.makeText(applicationContext,"film details activity",Toast.LENGTH_SHORT).show()
                startActivity(intent)
            }
        }



        call.enqueue(object : Callback<MovieResponse> {

            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {


                if (response.isSuccessful()) {

                    Toast.makeText(applicationContext, "server returned movies", Toast.LENGTH_SHORT).show();
                    var nameslist = response.body()!!.results
                    mAdapter = recAdapter(nameslist!!, openFilm)
                    recyclerView = findViewById(R.id.recyclerView) as RecyclerView
                    val mLayoutManager = LinearLayoutManager(applicationContext)
                    recyclerView!!.layoutManager = mLayoutManager
                    recyclerView!!.itemAnimator = DefaultItemAnimator()
                    recyclerView!!.adapter = mAdapter

                } else {

                    Toast.makeText(applicationContext, "server does not return data", Toast.LENGTH_SHORT).show();
                }


            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {

                Toast.makeText(applicationContext, "faild to request", Toast.LENGTH_SHORT).show()
            }
        })


    }


    interface OpenFilm {
        fun openFilm()
    }

//    fun getMoviess(): List<names> {
//
//        val apiService = ApiInterface.create()
//        val call = apiService.getMovies("a52c775a630c8b990fe9365ca601e2bf")
//
//
//        var nameslistRet: List<names>? = null
//
//        var retrofit: Retrofit = Retrofit.Builder()
//            .baseUrl(BASE_URL)
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//
//        var api = retrofit.create(ApiInterface::class.java)
//        //var call = api.getMovies("6f520821cbe7d8a6623235903a2787d5")
//        call.enqueue(object : Callback<namesResponse> {
//
//            override fun onResponse(call: Call<namesResponse>, response: Response<namesResponse>) {
//
//                if (response != null) {
//
//                    nameslistRet = response.body()!!.results
//                }
//
//            }
//
//            override fun onFailure(call: Call<namesResponse>, t: Throwable) {
//                Toast.makeText(applicationContext, "${t.toString()}", Toast.LENGTH_SHORT).show()
//
//            }
//        })
//
//        return nameslistRet!!
//    }


}


