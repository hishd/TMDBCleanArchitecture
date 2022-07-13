package com.hishd.tmdbcleanarchitecture.presentation.artist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hishd.tmdbcleanarchitecture.databinding.ActivityArtistBinding

class ArtistActivity : AppCompatActivity() {

    private lateinit var binding: ActivityArtistBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityArtistBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}