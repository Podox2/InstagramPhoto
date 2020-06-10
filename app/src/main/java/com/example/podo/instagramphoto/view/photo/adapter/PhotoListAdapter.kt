package com.example.podo.instagramphoto.view.photo.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.podo.instagramphoto.base.BaseViewHolder
import com.example.podo.instagramphoto.data.model.InstagramPhotoData
import com.example.podo.instagramphoto.databinding.ItemPhotoDataBinding

class PhotoListAdapter :
    ListAdapter<InstagramPhotoData, BaseViewHolder<ItemPhotoDataBinding>>(PhotoDiffCallback) {

    companion object PhotoDiffCallback : DiffUtil.ItemCallback<InstagramPhotoData>() {
        override fun areItemsTheSame(
            oldItem: InstagramPhotoData,
            newItem: InstagramPhotoData
        ): Boolean {
            return oldItem === newItem
        }

        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(
            oldItem: InstagramPhotoData,
            newItem: InstagramPhotoData
        ): Boolean {
            return oldItem == newItem
        }
    }

    interface DefaultOnClickListener {
        fun onViewClicked(view: String)
    }

    lateinit var defaultOnClickListener: DefaultOnClickListener


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder<ItemPhotoDataBinding> = BaseViewHolder(
        ItemPhotoDataBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
    )

    override fun onBindViewHolder(holder: BaseViewHolder<ItemPhotoDataBinding>, position: Int) {

        val photoSliderAdapter = PhotoSliderAdapter()

        holder.binding.apply {
            item = getItem(position)
            photoSliderAdapter.setItems(getItem(position).images)
            imageSlider.setSliderAdapter(photoSliderAdapter)
            imageAvatar.setOnClickListener {
                defaultOnClickListener.onViewClicked("User's Profile Picture")
            }
            tvNickname.setOnClickListener {
                defaultOnClickListener.onViewClicked("User's Nickname")
            }
            tvLocation.setOnClickListener {
                defaultOnClickListener.onViewClicked("Location")
            }
            imageMore.setOnClickListener {
                defaultOnClickListener.onViewClicked("Options")
            }
            imageLike.setOnClickListener {
                defaultOnClickListener.onViewClicked("Like post")
            }
            imageComments.setOnClickListener {
                defaultOnClickListener.onViewClicked("Show comments")
            }
            imageSend.setOnClickListener {
                defaultOnClickListener.onViewClicked("Share post")
            }
            imageBookmark.setOnClickListener {
                defaultOnClickListener.onViewClicked("Add to bookmarks")
            }
            executePendingBindings()
        }
    }
}