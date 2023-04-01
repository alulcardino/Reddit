package com.romanmikhailenko.reddit

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar
import com.romanmikhailenko.reddit.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            Snackbar.make(
                binding.root.rootView,
            "Button is clicked", Snackbar.LENGTH_LONG).show()
        }
    }

    override fun onStart() {
        super.onStart()
        getScreenOrientation()
    }

    private fun getScreenOrientation() {
        val color = when(resources.configuration.orientation) {
            Configuration.ORIENTATION_LANDSCAPE -> R.color.white
            else -> R.color.black
        }
        binding.root.rootView.setBackgroundColor(getColor(color))

    }


}