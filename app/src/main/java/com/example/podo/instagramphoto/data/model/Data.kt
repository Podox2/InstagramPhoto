package com.example.podo.instagramphoto.data.model

import com.google.gson.annotations.SerializedName

data class InstagramPhotoModel(
    @SerializedName("data")
    val instagramPhotoData: InstagramPhotoData
)

data class InstagramPhotoData(
    val profile: String,
    val location: String,
    val images: List<String>,
    val thumbnail: String,
    val likes: List<String>,
    val description: String,
    val date: String
)