package com.example.podo.instagramphoto.data.service

import com.example.podo.instagramphoto.data.model.InstagramPhotoData

interface LocalService {
    fun getInstagramDataFromJson() : InstagramPhotoData
}