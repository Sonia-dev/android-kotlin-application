package com.example.examandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.examandroid.model.Photo
import kotlinx.android.synthetic.main.activity_main3.*

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        val bundle:Bundle?=intent.extras
        val picture: ImageView = findViewById(R.id.picture)
        val usertext: TextView =findViewById(R.id.usertext)
        val smaldes: TextView =findViewById(R.id.altdesc)
        val desc: TextView =findViewById(R.id.desc)
        val createdate: TextView =findViewById(R.id.createdate)
        val updatedate: TextView =findViewById(R.id.updatedate)
        back.setOnClickListener {
            super.onBackPressed();
        }

        val photos=intent.getParcelableExtra<Photo>(MainActivity.INTENT_PARCELABLE)
        Glide.with(this)
            .load(photos?.urls!!.small)
            .into(picture!!)
        // picture.setImageResource(photos!!.user!!.profile_image!!)
        usertext.setText("username : "+photos!!.user!!.username)
        smaldes.setText("small description:"+photos!!.alt_description)
        desc.setText("description : "+photos!!.description)
        createdate.setText("created date : "+photos.created_at)
        updatedate.setText("updated date : "+photos.updated_at)
    }
}
