package com.example.podo.instagramphoto.view.photo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.podo.instagramphoto.databinding.ItemPhotoBinding
import com.smarteist.autoimageslider.SliderViewAdapter


class PhotoSliderAdapter : SliderViewAdapter<PhotoSliderAdapter.PhotoViewHolder>() {

    private val photosList = mutableListOf<String>()

    fun setItems(list: List<String>) {
        photosList.clear()
        photosList.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup?): PhotoViewHolder =
        PhotoViewHolder(
            ItemPhotoBinding.inflate(LayoutInflater.from(parent?.context), parent, false)
        )

    override fun onBindViewHolder(viewHolder: PhotoViewHolder?, position: Int) {
        viewHolder!!.binding.apply {
            item = photosList[position]
            executePendingBindings()
        }
    }

    override fun getCount(): Int = photosList.size


    class PhotoViewHolder(val binding: ItemPhotoBinding) : ViewHolder(binding.root)
}