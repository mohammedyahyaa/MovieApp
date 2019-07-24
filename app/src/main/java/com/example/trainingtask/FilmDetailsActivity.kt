package com.example.trainingtask

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RatingBar
import kotlinx.android.synthetic.main.activity_film_details.*

class FilmDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_film_details)



        img_back.setOnClickListener {

            val intent = Intent(this@FilmDetailsActivity, MainActivity::class.java)
            //   Toast.makeText(applicationContext,"film details activity",Toast.LENGTH_SHORT).show()
            startActivity(intent)

        }

        img_share.setOnClickListener {

            val myIntent = Intent(Intent.ACTION_SEND)

            myIntent.setType("text/plain")
//            val shareBody = "your body here"
//            val shareSub = "your subject here"
//            myIntent.putExtra(Intent.EXTRA_SUBJECT, shareBody)
//            myIntent.putExtra(Intent.EXTRA_SUBJECT, shareSub)
            startActivity(Intent.createChooser(myIntent, "Share selections"))

        }


        val msg = ratingBar.rating.toString()
        tv_print_rating.setText(msg)


    }


}


