package com.practice.socialimages.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagingData
import com.practice.socialimages.data.UnSplashPhoto
import com.practice.socialimages.repo.UnsplashRepo

class GalleryViewModel(val repo : UnsplashRepo) : ViewModel() {

    private val currentQuery = MutableLiveData(DEFAULT_QUERY)
    companion object {
        private const val DEFAULT_QUERY = "dogs"
    }

    val photos : LiveData<PagingData<UnSplashPhoto>> = repo.getSearchResult(query = "cats")

    fun searchPhoto(query: String) {
        currentQuery.value = query
    }
}