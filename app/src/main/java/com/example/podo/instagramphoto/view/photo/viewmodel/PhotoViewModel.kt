package com.example.podo.instagramphoto.view.photo.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.podo.instagramphoto.base.BaseViewModel
import com.example.podo.instagramphoto.data.model.InstagramPhotoModel
import com.example.podo.instagramphoto.data.repository.InstagramRepo
import kotlinx.coroutines.launch

class PhotoViewModel(val instagramRepo: InstagramRepo) : BaseViewModel() {
    private val _instagramPhotoList = MutableLiveData<List<InstagramPhotoModel>>()
    val instagramPhotoList: LiveData<List<InstagramPhotoModel>>
        get() = _instagramPhotoList

    fun fetchData(){
        viewModelScope.launch {
            _instagramPhotoList.value = instagramRepo.getInstagramPhotoData().instagramPhotoModelList
        }
    }
}