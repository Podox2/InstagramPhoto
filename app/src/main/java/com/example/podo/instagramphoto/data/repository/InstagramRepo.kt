package com.example.podo.instagramphoto.data.repository

import com.example.podo.instagramphoto.data.model.InstagramPhotoModel

interface InstagramRepo {
    suspend fun getInstagramPhotoData(): InstagramPhotoModel
}