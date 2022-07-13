package com.hishd.tmdbcleanarchitecture.presentation.tvshow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hishd.tmdbcleanarchitecture.databinding.ActivityTvshowBinding

class TVShowActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTvshowBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTvshowBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}