package com.example.superhero.app.extensions

import android.widget.ImageView
import com.bumptech.glide.Glide


fun ImageView.loadUrl(url: String){
    Glide
        .with(this)
        .load(url)
        .into(this)

/*
fun ImageView.loadUrl(url: String) {
    this.load(url)


 */

}