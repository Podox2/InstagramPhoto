package com.example.podo.instagramphoto.data.service

import com.example.podo.instagramphoto.data.model.InstagramPhotoModel

interface LocalService {
    fun getInstagramDataFromJson() : InstagramPhotoModel
}