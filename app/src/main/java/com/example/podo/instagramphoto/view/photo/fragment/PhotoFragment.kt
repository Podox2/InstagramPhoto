package com.example.podo.instagramphoto.view.photo.fragment

import com.example.podo.instagramphoto.R
import com.example.podo.instagramphoto.base.BaseVMFragment
import com.example.podo.instagramphoto.databinding.FragmentPhotoBinding
import com.example.podo.instagramphoto.view.photo.viewmodel.PhotoViewModel
import kotlin.reflect.KClass

class PhotoFragment : BaseVMFragment<PhotoViewModel, FragmentPhotoBinding>() {

    override fun getViewModelClass(): KClass<PhotoViewModel> = PhotoViewModel::class

    override val layoutId: Int
        get() = R.layout.fragment_photo
}