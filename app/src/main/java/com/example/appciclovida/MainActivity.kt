package com.example.appciclovida

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.appciclovida.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var mediaPlayer: MediaPlayer? = null
    private var posicion: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button1.setOnClickListener {
            startActivity(Intent(this, MainActivity2::class.java))
        }
        Toast.makeText(this, "onCreate", Toast.LENGTH_SHORT).show()
        Log.i("Ciclo de vida", "onCreate")
    }

    override fun onPause() {
        super.onPause()
        mediaPlayer?.pause()
        if (mediaPlayer != null)
            posicion = mediaPlayer!!.currentPosition
        Toast.makeText(this, "onPause", Toast.LENGTH_SHORT).show()
    }

    override fun onStart() {
        super.onStart()
        super.onStart()
        mediaPlayer = MediaPlayer.create(this, R.raw.bigban)
        mediaPlayer?.start()
        Toast.makeText(this, "onStart", Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()
        mediaPlayer?.seekTo(posicion)
        mediaPlayer?.start()
        Toast.makeText(this, "onResume", Toast.LENGTH_SHORT).show()
    }

    override fun onStop() {
        super.onStop()
        Toast.makeText(this, "onStop", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer?.stop()
        Toast.makeText(this, "onDestroy", Toast.LENGTH_SHORT).show()
    }
}