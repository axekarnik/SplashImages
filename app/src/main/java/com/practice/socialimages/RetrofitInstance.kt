package com.practice.socialimages

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitInstance  {
    private lateinit  var instance : RetrofitInstance
    companion object {
        const val BASE_URL = "https://api.unsplash.com/"
        val interceptor = HttpLoggingInterceptor().apply {
            this.level = HttpLoggingInterceptor.Level.BODY
        }
        val httpClient = OkHttpClient.Builder().apply {
            this.addInterceptor(interceptor).build()

        }.build()

        fun getInstance()  = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .client(httpClient)
            .build()
    }




}