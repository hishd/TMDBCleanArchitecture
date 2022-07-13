package com.hishd.tmdbcleanarchitecture.presentation

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.hishd.tmdbcleanarchitecture.databinding.ActivityHomeBinding
import com.hishd.tmdbcleanarchitecture.presentation.artist.ArtistActivity
import com.hishd.tmdbcleanarchitecture.presentation.movie.MovieActivity
import com.hishd.tmdbcleanarchitecture.presentation.tvshow.TVShowActivity

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupListeners()
    }

    private fun setupListeners() {
        binding.btnArtists.setOnClickListener {
            startActivity(Intent(this, ArtistActivity::class.java))
        }
        binding.btnMovies.setOnClickListener {
            startActivity(Intent(this, MovieActivity::class.java))
        }
        binding.btnTVShows.setOnClickListener {
            startActivity(Intent(this, TVShowActivity::class.java))
        }
    }
}