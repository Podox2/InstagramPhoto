package com.example.podo.instagramphoto.view.photo.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.podo.instagramphoto.base.BaseViewModel
import com.example.podo.instagramphoto.data.model.InstagramPhotoData
import com.example.podo.instagramphoto.data.repository.InstagramRepo
import kotlinx.coroutines.launch

class PhotoViewModel(val instagramRepo: InstagramRepo) : BaseViewModel() {
    private val _instagramPhotoData = MutableLiveData<InstagramPhotoData>()
    val instagramPhotoData: LiveData<InstagramPhotoData>
        get() = _instagramPhotoData

    fun fetchData(){
        viewModelScope.launch {
            _instagramPhotoData.value = instagramRepo.getInstagramPhotoData().instagramPhotoData
        }
    }
}