package com.example.podo.instagramphoto

import android.content.Context
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.example.podo.instagramphoto.data.model.InstagramPhotoModel
import com.example.podo.instagramphoto.data.service.LocalService
import com.example.podo.instagramphoto.data.service.LocalServiceImpl
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class LocalServiceInstrumentedTest {
    private lateinit var appContext: Context
    private lateinit var localService: LocalService
    private lateinit var data: InstagramPhotoModel

    @Before
    fun initFields() {
        appContext = InstrumentationRegistry.getInstrumentation().targetContext
        localService = LocalServiceImpl(appContext)
        data = localService.getInstagramDataFromJson()
    }

    @Test
    fun checkIsProfileCorrect() {
        assertEquals("milena_thebrowbar", data.instagramPhotoData[0].profile)
    }

    @Test
    fun checkIsLocationCorrect() {
        assertEquals("Sky Beaty Room", data.instagramPhotoData[1].location)
    }
}