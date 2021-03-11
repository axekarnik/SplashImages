package com.practice.socialimages.repo

import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.practice.socialimages.RetrofitApi
import com.practice.socialimages.data.UnSplashPagingSource
import com.practice.socialimages.data.UnSplashPhoto
import com.practice.socialimages.data.UnSplashResponse

class UnsplashRepo(private val unSplashApi : RetrofitApi) {

    fun getSearchResult(query: String) : LiveData<PagingData<UnSplashPhoto>>{
        return Pager(
            config = PagingConfig(
                pageSize = 20,
                maxSize = 100,
                enablePlaceholders = false
            ),
            pagingSourceFactory =   {
                UnSplashPagingSource(unSplashApi, query)
            }
        ).liveData
    }


}