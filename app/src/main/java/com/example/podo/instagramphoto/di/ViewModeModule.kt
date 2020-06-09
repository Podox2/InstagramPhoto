package com.example.podo.instagramphoto.di

import com.example.podo.instagramphoto.view.photo.viewmodel.PhotoViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel { PhotoViewModel() }

}