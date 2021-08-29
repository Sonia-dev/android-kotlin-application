package com.example.examandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.examandroid.model.Photo
import kotlinx.android.synthetic.main.activity_main3.*

class DetailhorizActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detailhoriz)
        back.setOnClickListener {
            super.onBackPressed();
        }
        val picture: ImageView = findViewById(R.id.imageView2)


        val photos=intent.getParcelableExtra<Photo>(MainActivity.INTENT_PARCELABLE)
        Glide.with(this)
            .load(photos?.urls!!.full)
            .into(picture!!)
    }
}




