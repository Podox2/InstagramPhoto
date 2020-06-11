package com.example.podo.instagramphoto.data.model

import com.google.gson.annotations.SerializedName

data class InstagramPhotoData(
    @SerializedName("data")
    val instagramPhotoModelList: List<InstagramPhotoModel>
)

data class InstagramPhotoModel(
    val profile: String,
    val location: String,
    val images: List<String>,
    val thumbnail: String,
    val likes: List<String>,
    val description: String,
    val date: String
)