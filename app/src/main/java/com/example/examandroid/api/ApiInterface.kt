package com.example.examandroid.api


import android.net.Uri
import com.example.examandroid.model.Photo
import com.example.examandroid.model.User
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.ResponseBody
import okhttp3.logging.HttpLoggingInterceptor
import org.json.JSONObject
import retrofit2.Retrofit
import retrofit2.Call
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query


interface ApiInterface {

        @Headers("Authorization: Client-ID"+"5hwkD2A2WGRR-szVqpFS01xZvJN-xMjIBG3jmQQ0hCU")
        @GET("photos/random?client_id=5hwkD2A2WGRR-szVqpFS01xZvJN-xMjIBG3jmQQ0hCU")
        fun getAllData(@Query("count") count: String): Call<List<Photo>>



    }
class RetrofitInstance2 {
    companion object {

        private const val BASE_URL = "https://api.unsplash.com/"
        private const val ACCESS_KEY = "5hwkD2A2WGRR-szVqpFS01xZvJN-xMjIBG3jmQQ0hCU"

        private var mRetrofit: Retrofit? = null
        val interceptor: HttpLoggingInterceptor =
            HttpLoggingInterceptor().apply {
                this.level = HttpLoggingInterceptor.Level.BODY
            }
        val client: OkHttpClient = OkHttpClient.Builder().apply {
            this.addInterceptor(interceptor)
        }.build()
        fun getRetrofitInstance2(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(RetrofitInstance2.BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }

}

