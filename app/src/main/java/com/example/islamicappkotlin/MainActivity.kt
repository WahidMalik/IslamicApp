package com.example.islamicappkotlin

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var prayerImageButton : ImageButton
    lateinit var quranImageButton : ImageButton
    lateinit var calendarImageButton : ImageButton
    lateinit var duaImageButton : ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        prayerImageButton = findViewById(R.id.prayerTime)
        quranImageButton = findViewById(R.id.quran)
        calendarImageButton = findViewById(R.id.calendar)
        duaImageButton = findViewById(R.id.dua)

        prayerImageButton.setOnClickListener {
            val intent = Intent(this, PrayerActivity::class.java)
            startActivity(intent)
        }
        quranImageButton.setOnClickListener {
            val intent = Intent(this, Quran::class.java)
            startActivity(intent)
        }
        duaImageButton.setOnClickListener {
            val intent = Intent(this, Duas::class.java)
            intent.putExtra("DuaPdf", "dua.pdf")
            startActivity(intent)
        }
        calendarImageButton.setOnClickListener {
            val intent = Intent(this, Calendar::class.java)
            startActivity(intent)
        }



    }
}