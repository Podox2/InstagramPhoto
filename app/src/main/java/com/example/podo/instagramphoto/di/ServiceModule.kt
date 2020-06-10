package com.example.podo.instagramphoto.di

import com.example.podo.instagramphoto.data.service.LocalService
import com.example.podo.instagramphoto.data.service.LocalServiceImpl
import org.koin.dsl.module

val serviceModule = module {
    single<LocalService> {
        LocalServiceImpl(
            get()
        )
    }
}