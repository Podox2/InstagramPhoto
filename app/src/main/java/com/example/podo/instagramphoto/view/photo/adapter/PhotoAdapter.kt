package com.example.podo.instagramphoto.view.photo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.podo.instagramphoto.databinding.ItemPhotoBinding
import com.smarteist.autoimageslider.SliderViewAdapter


class PhotoAdapter : SliderViewAdapter<PhotoAdapter.PhotoViewHolder>() {

    private val topNewsList = mutableListOf<String>()

    fun setItems(list: List<String>) {
        topNewsList.clear()
        topNewsList.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup?): PhotoViewHolder =
        PhotoViewHolder(
            ItemPhotoBinding.inflate(LayoutInflater.from(parent?.context), parent, false)
        )

    override fun onBindViewHolder(viewHolder: PhotoViewHolder?, position: Int) {
        viewHolder!!.binding.apply {
            item = topNewsList[position]
            executePendingBindings()
        }
    }

    override fun getCount(): Int = topNewsList.size


    class PhotoViewHolder(val binding: ItemPhotoBinding) : ViewHolder(binding.root)
}