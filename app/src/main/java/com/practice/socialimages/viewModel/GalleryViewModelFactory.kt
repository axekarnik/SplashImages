package com.practice.socialimages.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.practice.socialimages.repo.UnsplashRepo
import java.lang.IllegalArgumentException

class GalleryViewModelFactory(val repo : UnsplashRepo) :ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(GalleryViewModel::class.java)) {
            return GalleryViewModel(repo) as T
        }
        throw IllegalArgumentException("UNknown View model class")
    }


}