package com.example.newsapi

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class MyAdapter(val context : Context, val userList : List<MyDataItem>) : RecyclerView.Adapter<MyAdapter.ViewHolder>(){
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var author : TextView = itemView.findViewById(R.id.author)
        var title  : TextView = itemView.findViewById(R.id.title)
        var img    : ImageView = itemView.findViewById(R.id.image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var itemView = LayoutInflater.from(context).inflate(R.layout.row_items, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, @SuppressLint("RecyclerView") position: Int) {
        holder.author.text = userList[position].author
        holder.title.text = userList[position].title
        Glide.with(holder.itemView.context).load(userList[position].urlToImage).into(holder.img)
        holder.itemView.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                val activity = v!!.context as AppCompatActivity
                val demoFragment = Fragment(userList[position])
                activity.supportFragmentManager.beginTransaction().replace(R.id.display, demoFragment)
                    .addToBackStack(null).commit()

            }

        })
    }

    override fun getItemCount(): Int {
        return userList.size
    }
}