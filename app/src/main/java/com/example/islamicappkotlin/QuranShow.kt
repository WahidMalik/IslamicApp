package com.example.islamicappkotlin

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.github.barteksc.pdfviewer.PDFView

class QuranShow : AppCompatActivity() {

    lateinit var pdfView: PDFView
    lateinit var prev: Button
    lateinit var menu: Button
    lateinit var next: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quran_show)


        pdfView = findViewById(R.id.pdfviewer)
        prev = findViewById(R.id.prev)
        menu = findViewById(R.id.menu)
        next = findViewById(R.id.next)


        val pdfFileName = intent.getStringExtra("PDF_FILE_NAME")
        val startPage = intent.getIntExtra("START_PAGE", 0)




        pdfView.fromAsset(pdfFileName)
            .enableSwipe(true)
            .swipeHorizontal(false)
            .enableDoubletap(true)
            .defaultPage(startPage)
            .load()


        prev.setOnClickListener {
            pdfView.jumpTo(pdfView.currentPage - 1)
        }

        next.setOnClickListener {
            pdfView.jumpTo(pdfView.currentPage + 1)
        }

        menu.setOnClickListener {
            onBackPressed()
        }
    }
}
