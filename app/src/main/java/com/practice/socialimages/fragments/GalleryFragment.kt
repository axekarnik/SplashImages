package com.practice.socialimages.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.practice.socialimages.R
import com.practice.socialimages.RetrofitApi
import com.practice.socialimages.RetrofitInstance
import com.practice.socialimages.UnSplashPhotoAdapter
import com.practice.socialimages.databinding.FragmentMainImagesBinding
import com.practice.socialimages.repo.UnsplashRepo
import com.practice.socialimages.viewModel.GalleryViewModel
import com.practice.socialimages.viewModel.GalleryViewModelFactory

class GalleryFragment : Fragment(R.layout.fragment_main_images) {

    lateinit var viewModel: GalleryViewModel
    lateinit var binding: FragmentMainImagesBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMainImagesBinding.bind(view)

        val unsplashApi = RetrofitInstance.getInstance().create(RetrofitApi::class.java)
        val repo = UnsplashRepo(unsplashApi)

        val adapter = UnSplashPhotoAdapter()

        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = adapter

        val factory = GalleryViewModelFactory(repo)
        viewModel = ViewModelProvider(this, factory).get(GalleryViewModel::class.java)

        viewModel.photos.observe(viewLifecycleOwner, Observer {
            adapter.submitData(viewLifecycleOwner.lifecycle , it)
        })
    }
}