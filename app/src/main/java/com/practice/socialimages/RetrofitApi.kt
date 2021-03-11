package com.practice.socialimages

import com.practice.socialimages.data.UnSplashResponse
import com.practice.socialimages.BuildConfig
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface RetrofitApi {

    companion object {
        const val CLIENT_KEY = BuildConfig.UNSPLASH_ACCESS_KEY
    }
    @Headers("Accept-Version: v1", "Authorization: Client-ID $CLIENT_KEY")
    @GET("search/photos")
    suspend fun searchPhotos(@Query("query") query : String,
                             @Query("page") page: Int,
                             @Query("per_page") perPage: Int
                             ) : UnSplashResponse
}