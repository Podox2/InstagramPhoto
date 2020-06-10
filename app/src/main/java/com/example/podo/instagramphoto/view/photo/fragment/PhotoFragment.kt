package com.example.podo.instagramphoto.view.photo.fragment

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.example.podo.instagramphoto.R
import com.example.podo.instagramphoto.base.BaseVMFragment
import com.example.podo.instagramphoto.databinding.FragmentPhotoBinding
import com.example.podo.instagramphoto.view.photo.adapter.PhotoListAdapter
import com.example.podo.instagramphoto.view.photo.adapter.PhotoSliderAdapter
import com.example.podo.instagramphoto.view.photo.viewmodel.PhotoViewModel
import kotlin.reflect.KClass

class PhotoFragment : BaseVMFragment<PhotoViewModel, FragmentPhotoBinding>() {

    override fun getViewModelClass(): KClass<PhotoViewModel> = PhotoViewModel::class

    override val layoutId: Int
        get() = R.layout.fragment_photo

    private val photoListAdapter = PhotoListAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.fetchData()

        viewModel.instagramPhotoData.observe(viewLifecycleOwner, Observer {
            photoListAdapter.submitList(it)
        })

        binding.recViewPhotoList.adapter = photoListAdapter
    }
}