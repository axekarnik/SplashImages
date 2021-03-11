package com.practice.socialimages.data

import com.practice.socialimages.RetrofitApi
import androidx.paging.PagingSource
import java.lang.Exception

private val STARTING_PAGE_INDEX = 1


class UnSplashPagingSource(
        val unsplashApi: RetrofitApi,
        val query: String
) : PagingSource<Int, UnSplashPhoto>() {


    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, UnSplashPhoto> {
        // Gets the current page
        var position = params.key ?: STARTING_PAGE_INDEX

        try {
            var response = unsplashApi.searchPhotos(query, position, params.loadSize)
            var photos = response.results
            return LoadResult.Page(
               data = photos,
                prevKey = if(position == STARTING_PAGE_INDEX) null else position-1,
                nextKey = if(photos.isEmpty()) null else position+1
             )
        }catch (e: Exception) {
            return LoadResult.Error(e)
        }

    }

}