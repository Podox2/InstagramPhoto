package com.example.podo.instagramphoto.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
                        toast(getString(R.string.home))
                        true
                    }
                    R.id.navigation_search -> {
                        toast(getString(R.string.search))
                        true
                    }
                    R.id.navigation_add_photo -> {
                        toast(getString(R.string.new_post))
                        true
                    }
                    R.id.navigation_likes -> {
                        toast(getString(R.string.likes))
                        true
                    }
                    R.id.navigation_profile -> {
                        toast(getString(R.string.profile))
                        true
                    }
                    else -> false
                }
            }
        }
    }

    private fun toast(text: String) = Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
}