package com.example.podo.instagramphoto.view.photo.fragment

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.example.podo.instagramphoto.R
import com.example.podo.instagramphoto.base.BaseVMFragment
import com.example.podo.instagramphoto.databinding.FragmentPhotoBinding
import com.example.podo.instagramphoto.view.photo.adapter.PhotoListAdapter
import com.example.podo.instagramphoto.view.photo.viewmodel.PhotoViewModel
import kotlin.reflect.KClass

class PhotoFragment : BaseVMFragment<PhotoViewModel, FragmentPhotoBinding>(),
    PhotoListAdapter.DefaultOnClickListener {

    override fun getViewModelClass(): KClass<PhotoViewModel> = PhotoViewModel::class

    override val layoutId: Int
        get() = R.layout.fragment_photo

    private val photoListAdapter = PhotoListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        photoListAdapter.defaultOnClickListener = this
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.fetchData()

        viewModel.instagramPhotoList.observe(viewLifecycleOwner, Observer {
            photoListAdapter.submitList(it)
        })

        binding.apply {
            recViewPhotoList.adapter = photoListAdapter
            imageCamera.setOnClickListener {
                toast(getString(R.string.add_post))
            }
            imageSendMessage.setOnClickListener {
                toast(getString(R.string.show_direct_messages))
            }
        }
    }

    override fun onViewClicked(view: String) = toast(view)
}