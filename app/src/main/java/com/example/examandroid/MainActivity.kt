package com.example.examandroid

import android.content.Intent
import android.os.Bundle
import androidx.annotation.Nullable
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.ItemDecoration


import com.example.examandroid.model.Photo
import com.example.examandroid.model.PhotoAdapter
import com.example.examandroid.model.UserAdapter
import com.example.examandroid.viewModel.photoViewModel
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : FragmentActivity() {


    companion object{
        val INTENT_PARCELABLE="OBJECT_INTENT"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recycleViewh.setHasFixedSize(true)
        recycleViewh.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false)

        recycleView.setLayoutManager(GridLayoutManager(this, 2))
        val itemDecoration: ItemDecoration =
            DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        recycleView.addItemDecoration(itemDecoration)
        recycleView.setHasFixedSize(true)

        val model: photoViewModel =
            ViewModelProviders.of(this).get(photoViewModel::class.java)
        model.getPhotos()?.observe(this, object : Observer<List<Photo?>?> {
            override fun onChanged(@Nullable PhotoList: List<Photo?>?) {
                var PhotoAdapter = PhotoAdapter(this@MainActivity, PhotoList!!)
                var UserAdapter = UserAdapter(this@MainActivity, PhotoList!!)
                PhotoAdapter.itemClickListener = { position, element ->
                   //Toast.makeText(applicationContext, "position: $position - element: $element", Toast.LENGTH_SHORT)
                     //        .show()
                   val intent= Intent (this@MainActivity, MainActivity2::class.java)
                   intent.putExtra(INTENT_PARCELABLE, PhotoList[position])

                    startActivity(intent)
                }
                UserAdapter.itemClickListener = { position, element ->
                    /* Toast.makeText(applicationContext, "position: $position - element: ${element.user}", Toast.LENGTH_SHORT)
                             .show()*/
                    val intent= Intent (this@MainActivity,DetailhorizActivity::class.java)
                    intent.putExtra(INTENT_PARCELABLE, PhotoList[position])

                    startActivity(intent)
                }

                recycleView.adapter = PhotoAdapter
                recycleViewh.adapter = UserAdapter


            }
        })

    }




}