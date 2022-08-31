package com.example.newsapi

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide

class Fragment(val myDataItem: MyDataItem) : Fragment(R.layout.fragment_layout){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = super.onCreateView(inflater, container, savedInstanceState)

        val text: TextView? = view?.findViewById(R.id.fragAuth)
        val title: TextView? = view?.findViewById(R.id.fragTitle)
        val image: ImageView? = view?.findViewById(R.id.fragImage)
        val content: TextView? = view?.findViewById(R.id.fragContent)
        val heading: TextView? = view?.findViewById(R.id.fragHeading)

        text?.setText(myDataItem.author)
        title?.setText(myDataItem.title)
        content?.setText(myDataItem.content)
        heading?.setText(myDataItem.description)
        if (image != null) {
            Glide.with(this).load(myDataItem.urlToImage).into(image)
        }

        return view
    }

}