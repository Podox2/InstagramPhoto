package com.example.podo.instagramphoto.data.service

import android.content.Context
import com.example.podo.instagramphoto.data.model.InstagramPhotoData
import com.google.gson.Gson
import java.io.IOException
import java.io.InputStream
import java.nio.charset.Charset

class LocalServiceImpl(private val context: Context) : LocalService {

    companion object {
        const val JSON_FILE = "inst.json"
    }

    override fun getInstagramDataFromJson(): InstagramPhotoData {
        val jsonFileString = getJsonFromAssets(context, JSON_FILE)
        val instagramModel: InstagramPhotoData =
            Gson().fromJson(jsonFileString, InstagramPhotoData::class.java)
        return instagramModel
    }

    private fun getJsonFromAssets(context: Context, fileName: String?): String? {
        return try {
            val inputStream: InputStream = context.assets.open(fileName!!)
            val size: Int = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()
            String(buffer, Charset.forName("UTF-8"))
        } catch (e: IOException) {
            e.printStackTrace()
            return ""
        }
    }
}