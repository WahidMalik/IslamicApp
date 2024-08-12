package com.example.islamicappkotlin

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.github.barteksc.pdfviewer.PDFView

class Duas : AppCompatActivity() {

    lateinit var pdfView : PDFView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_duas)

        val duapdf = intent.getStringExtra("DuaPdf")
        pdfView = findViewById(R.id.duapdf)
        pdfView.fromAsset(duapdf).load()



    }
}