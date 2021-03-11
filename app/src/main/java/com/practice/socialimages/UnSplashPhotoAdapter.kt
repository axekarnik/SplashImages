package com.practice.socialimages

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.DrawableTransformation
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.practice.socialimages.data.UnSplashPhoto
import com.practice.socialimages.databinding.CellImageListBinding

class UnSplashPhotoAdapter :
    PagingDataAdapter<UnSplashPhoto, UnSplashPhotoAdapter.PhotoViewHolder>(PhotoDiffCallback()) {

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        val currentItem = getItem(position)
        if(currentItem != null)
            holder.bind(photo = currentItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val binding = CellImageListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PhotoViewHolder(binding)
    }

    class PhotoViewHolder(private val binding: CellImageListBinding ) : RecyclerView.ViewHolder(binding.root){
        val imageView = binding.imageView
        val tv_title = binding.tvTitle

        fun bind(photo: UnSplashPhoto) {
            Glide.with(itemView)
                .load(Uri.parse(photo.urls.regular))
                .centerCrop()
                .transition(DrawableTransitionOptions.withCrossFade())
                .error(R.drawable.ic_error)
                .into(imageView)
            tv_title.text = photo.user.username
        }
    }

    class PhotoDiffCallback : DiffUtil.ItemCallback<UnSplashPhoto>() {
        override fun areItemsTheSame(oldItem: UnSplashPhoto, newItem: UnSplashPhoto): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: UnSplashPhoto, newItem: UnSplashPhoto): Boolean {
            return oldItem == newItem
        }

    }
}
