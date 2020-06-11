package com.example.podo.instagramphoto.base

import android.graphics.Typeface
import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.text.TextUtils
import android.text.style.ForegroundColorSpan
import android.text.style.StyleSpan
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.podo.instagramphoto.R


object BindingAdapter {

    //Highlight text. If word begins with '#' or '@', method will highlight it
    @BindingAdapter("showHighlightText")
    @JvmStatic
    fun showHighlightText(view: TextView, text: String?) {
        val stringList = text?.split(" ") ?: listOf()
        val newString = SpannableStringBuilder()
        stringList.forEach {
            val string = SpannableString(it)
            if (it[0] == '#' || it[0] == '@') {
                string.setSpan(
                    ForegroundColorSpan(view.context.getColor(R.color.colorBlue)),
                    0,
                    it.length,
                    0
                )
            }
            newString.append(string).append(" ")
        }
        newString.trim()
        view.text = newString
    }

    //make bold first two users liked post and total number of likes without them
    @BindingAdapter("showLikes")
    @JvmStatic
    fun showLikes(view: TextView, likes: List<String>) {
        if (likes.isEmpty()) {
            view.text = view.context.getString(R.string.no_likes)
            return
        }

        var usersCounter = 0
        val spannableStringBuilder = SpannableStringBuilder()
        spannableStringBuilder.append("${view.context.getString(R.string.liked_by)} ")
            .append(makeBoldText(likes[0]))
        usersCounter++

        if (likes.size > 1) {
            spannableStringBuilder.append(", ")
                .append(makeBoldText(likes[1]))
            usersCounter++
        }

        if (usersCounter > 1) {
            spannableStringBuilder.append(" ${view.context.getString(R.string.and)} ")
                .append(makeBoldText((likes.size - usersCounter).toString()))
                .append(" ${view.context.getString(R.string.others)}")
        }

        view.text = spannableStringBuilder
    }

    private fun makeBoldText(text: String): SpannableString {
        val spannableString = SpannableString(text)
        spannableString.setSpan(
            StyleSpan(Typeface.BOLD),
            0,
            text.length,
            0
        )
        return spannableString
    }

    @BindingAdapter(value = ["drawImage"], requireAll = false)
    @JvmStatic
    fun drawImage(view: AppCompatImageView, url: String?) {
        var stringUrl = url
        if (TextUtils.isEmpty(stringUrl)) stringUrl = null
        Glide.with(view.context)
            .load(stringUrl)
            .placeholder(R.drawable.ic_image_placeholder)
            .into(view)
    }

}