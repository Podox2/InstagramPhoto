package com.example.podo.instagramphoto.data.repository

import com.example.podo.instagramphoto.data.model.InstagramPhotoModel
import com.example.podo.instagramphoto.data.service.LocalService

class InstagramRepoImpl(val localService: LocalService) : InstagramRepo {
    override suspend fun getInstagramPhotoData(): InstagramPhotoModel = localService.getInstagramDataFromJson()
}