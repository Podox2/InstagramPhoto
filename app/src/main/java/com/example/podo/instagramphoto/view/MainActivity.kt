package com.example.podo.instagramphoto.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.podo.instagramphoto.R
import com.example.podo.instagramphoto.databinding.ActivityMainBinding
import com.google.android.material.badge.BadgeDrawable.BOTTOM_END

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.bottomNav.apply {
            val badge = getOrCreateBadge(R.id.navigation_profile)
            badge.badgeGravity = BOTTOM_END
            setOnNavigationItemSelectedListener {
                when (it.itemId) {
                    R.id.navigation_home -> {
                        Toast.makeText(context, "navigation_home", Toast.LENGTH_SHORT).show()
                        true
                    }
                    R.id.navigation_search -> {
                        Toast.makeText(context, "navigation_search", Toast.LENGTH_SHORT).show()
                        true
                    }
                    R.id.navigation_add_photo -> {
                        Toast.makeText(context, "navigation_add_photo", Toast.LENGTH_SHORT).show()
                        true
                    }
                    R.id.navigation_likes -> {
                        Toast.makeText(context, "navigation_likes", Toast.LENGTH_SHORT).show()
                        true
                    }
                    R.id.navigation_profile -> {
                        Toast.makeText(context, "navigation_profile", Toast.LENGTH_SHORT).show()
                        true
                    }
                    else -> false
                }
            }
        }

    }
}