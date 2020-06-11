package com.example.podo.instagramphoto.view.photo.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.podo.instagramphoto.R
import com.example.podo.instagramphoto.base.BaseViewHolder
import com.example.podo.instagramphoto.data.model.InstagramPhotoModel
import com.example.podo.instagramphoto.databinding.ItemPhotoDataBinding

class PhotoListAdapter :
    ListAdapter<InstagramPhotoModel, BaseViewHolder<ItemPhotoDataBinding>>(PhotoDiffCallback) {

    companion object PhotoDiffCallback : DiffUtil.ItemCallback<InstagramPhotoModel>() {
        override fun areItemsTheSame(
            oldItem: InstagramPhotoModel,
            newItem: InstagramPhotoModel
        ): Boolean {
            return oldItem === newItem
        }

        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(
            oldItem: InstagramPhotoModel,
            newItem: InstagramPhotoModel
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
        val context = holder.binding.imageAvatar.context

        holder.binding.apply {
            item = getItem(position)
            photoSliderAdapter.setItems(getItem(position).images)
            imageSlider.setSliderAdapter(photoSliderAdapter)
            imageAvatar.setOnClickListener {
                defaultOnClickListener.onViewClicked(context.getString(R.string.users_profile_picture))
            }
            tvNickname.setOnClickListener {
                defaultOnClickListener.onViewClicked(context.getString(R.string.users_nickname))
            }
            tvLocation.setOnClickListener {
                defaultOnClickListener.onViewClicked(context.getString(R.string.location))
            }
            imageMore.setOnClickListener {
                defaultOnClickListener.onViewClicked(context.getString(R.string.options))
            }
            imageLike.setOnClickListener {
                defaultOnClickListener.onViewClicked(context.getString(R.string.like_post))
            }
            imageComments.setOnClickListener {
                defaultOnClickListener.onViewClicked(context.getString(R.string.show_comments))
            }
            imageSend.setOnClickListener {
                defaultOnClickListener.onViewClicked(context.getString(R.string.share_post))
            }
            imageBookmark.setOnClickListener {
                defaultOnClickListener.onViewClicked(context.getString(R.string.add_to_bookmarks))
            }
            executePendingBindings()
        }
    }
}