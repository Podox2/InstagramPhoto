package com.example.podo.instagramphoto.data.repository

import com.example.podo.instagramphoto.data.model.InstagramPhotoData

interface InstagramRepo {
    suspend fun getInstagramPhotoData(): InstagramPhotoData
}