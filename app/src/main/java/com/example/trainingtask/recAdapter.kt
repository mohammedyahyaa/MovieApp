package com.example.trainingtask

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item.view.*


class recAdapter(
    val namesList: List<Movie>,
    val openFilm: MainActivity.OpenFilm

) :
    RecyclerView.Adapter<recAdapter.MyViewHolder>() {

//    var context :Context ? =null

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var textView_name: TextView = view.findViewById<TextView>(R.id.tv_name)
        var textView_age: TextView = view.findViewById<TextView>(R.id.tv_age)
        var imageView: ImageView = view.findViewById<ImageView>(R.id.photoImageViewAD)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item, parent, false)



        return MyViewHolder(itemView)
    }


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val names = namesList!![position]
        holder.textView_name.text = names.title
        holder.textView_age.text = names.releaseDate

        //  var context = MyViewHolder.photoImageViewAD.getContext()

        var BASE_IMAGE_URL = "http://image.tmdb.org/t/p/w185/"

        Picasso.with(holder.itemView.context)
            .load(BASE_IMAGE_URL + names.posterPath)
            //.placeholder(R.drawable.creed)                             // optional
            //.error(R.drawable.mission_impossible)                      // optional
            .into(holder.itemView.photoImageViewAD)


        // holder.itemView.photoImageViewAD.setImageResource(R.drawable.ant_man)

        holder.itemView.setOnClickListener {
            openFilm.openFilm()
        }

    }

    override fun getItemCount(): Int {
        return namesList.size
    }

}
