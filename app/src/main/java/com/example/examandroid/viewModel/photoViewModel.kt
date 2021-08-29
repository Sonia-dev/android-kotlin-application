package com.example.examandroid.viewModel



import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.examandroid.api.ApiInterface
import com.example.examandroid.api.RetrofitInstance2
import com.example.examandroid.model.Photo
import com.example.examandroid.model.User

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class photoViewModel : ViewModel() {
    //this is the data that we will fetch asynchronously
    private var PhotoList: MutableLiveData<List<Photo>>? = null
    val errorMessage = MutableLiveData<String>()
    //we will call this method to get the data
    fun getPhotos(): MutableLiveData<List<Photo>>? {
        //if the list is null
        if (PhotoList == null) {
            PhotoList = MutableLiveData<List<Photo>>()
            //we will load it asynchronously from server in this method
            loadPhotos()
        }
        //finally we will return the list
        return PhotoList
    }
    //This method is using Retrofit to get the JSON data from URL
    private fun loadPhotos() {
        val retIn =
            RetrofitInstance2.getRetrofitInstance2().create(ApiInterface::class.java)
        val response = retIn.getAllData("16")
        response?.enqueue(object : Callback<List<Photo>> {


            override fun onFailure(call: Call<List<Photo>>, t: Throwable) {
                errorMessage.postValue(t.message)
            }

            override fun onResponse(call: Call<List<Photo>>, response: Response<List<Photo>>) {

                    PhotoList?.postValue(response.body())

            } }) } }
