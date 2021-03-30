package com.practice.socialimages.viewModel

import android.os.CountDownTimer
import android.util.Log
import androidx.lifecycle.*
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.practice.socialimages.data.UnSplashPhoto
import com.practice.socialimages.repo.UnsplashRepo

class GalleryViewModel(val repo : UnsplashRepo) : ViewModel() {


    private val currentQuery = MutableLiveData(DEFAULT_QUERY)
    companion object {
        private const val DEFAULT_QUERY = "dogs"
    }

//    val photos : LiveData<PagingData<UnSplashPhoto>> = repo.getSearchResult(query = "landscape")

    val photos = currentQuery.switchMap {queryString : String ->
        repo.getSearchResult(queryString).cachedIn(viewModelScope)

    }



    fun searchPhoto(query: String) {
        currentQuery.value = query
//        Log.v("Akshay", "Inside search photo")
//        repo.getSearchResult(query = query)
    }


}