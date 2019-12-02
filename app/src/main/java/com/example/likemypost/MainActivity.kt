package com.example.likemypost

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import java.util.prefs.AbstractPreferences

class MainActivity : AppCompatActivity() {
    var likeCount: Int = 0
    var dislikeCount: Int = 0
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("MainActivity", "onCreate")

        sharedPreferences = this.getPreferences(Context.MODE_PRIVATE)

        imageViewLike.setOnClickListener{
            likeCount++
            textViewLikeCount.text = likeCount.toString()
        }

        imageViewDislike.setOnClickListener{
            dislikeCount++
            textViewDislikeCount.text = dislikeCount.toString()
        }
    }

    override fun onStart() {
        Log.d("MainActivity", "onStart")
        super.onStart()
    }

    override fun onResume() {
        Log.d("MainActivity", "onResume")

        //read from shared preferences
        likeCount = sharedPreferences.getInt(getString(R.string.like), 0)
        dislikeCount = sharedPreferences.getInt(getString(R.string.dislike), 0)

        textViewLikeCount.text = likeCount.toString()
        textViewDislikeCount.text = dislikeCount.toString()

        super.onResume()
    }

    override fun onPause() {
        Log.d("MainActivity", "onPause")
        //write to shared preferences
        with(sharedPreferences.edit()){
            putInt(getString(R.string.like), likeCount)
            putInt(getString(R.string.dislike), dislikeCount)
            apply()
        }
        super.onPause()
    }

    override fun onStop() {
        Log.d("MainActivity", "onStop")
        super.onStop()
    }

    override fun onDestroy() {
        Log.d("MainActivity", "onDestroy")
        super.onDestroy()
    }
}
