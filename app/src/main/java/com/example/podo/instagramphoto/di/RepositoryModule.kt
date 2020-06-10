package com.example.podo.instagramphoto.di

import com.example.podo.instagramphoto.data.repository.InstagramRepo
import com.example.podo.instagramphoto.data.repository.InstagramRepoImpl
import org.koin.dsl.module

val repositoryModule = module {
    single<InstagramRepo> {
        InstagramRepoImpl(
            get()
        )
    }
}