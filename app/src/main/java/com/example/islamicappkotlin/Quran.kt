package com.example.islamicappkotlin

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Quran : AppCompatActivity() {

    lateinit var recycleView : RecyclerView
    lateinit var array : ArrayList<QuranButtonModel>
    lateinit var adapter : Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quran)

        recycleView = findViewById(R.id.recyclerView)
        array = ArrayList()
        array.add(QuranButtonModel("1", "الم"))
        array.add(QuranButtonModel("2", "سيقول"))
        array.add(QuranButtonModel("3", "تلك الرسل"))
        array.add(QuranButtonModel("4", "لن تنالوا"))
        array.add(QuranButtonModel("5", "والمحصنات"))
        array.add(QuranButtonModel("6", "لا يحب الله"))
        array.add(QuranButtonModel("7", "وإذا سمعوا"))
        array.add(QuranButtonModel("8", "ولو أننا"))
        array.add(QuranButtonModel("9", "قال الملا"))
        array.add(QuranButtonModel("10", "واعلموا"))
        array.add(QuranButtonModel("11", "يا أيها الذين"))
        array.add(QuranButtonModel("12", "وما من دابة"))
        array.add(QuranButtonModel("13", "وما أبرئ نفسي"))
        array.add(QuranButtonModel("14", "ربما يود"))
        array.add(QuranButtonModel("15", "سبحان الذي"))
        array.add(QuranButtonModel("16", "قال ألم"))
        array.add(QuranButtonModel("17", "اقترب للناس"))
        array.add(QuranButtonModel("18", "قد أفلح"))
        array.add(QuranButtonModel("19", "وقال الذين"))
        array.add(QuranButtonModel("20", "أمن خلق"))
        array.add(QuranButtonModel("21", "اتل ما أوحي"))
        array.add(QuranButtonModel("22", "ومن يقنت"))
        array.add(QuranButtonModel("23", "ومالي"))
        array.add(QuranButtonModel("24", "فمن أظلم"))
        array.add(QuranButtonModel("25", "إليه يرد"))
        array.add(QuranButtonModel("26", "حم"))
        array.add(QuranButtonModel("27", "قال فما"))
        array.add(QuranButtonModel("28", "قد سمع الله"))
        array.add(QuranButtonModel("29", "تبارك الذي"))
        array.add(QuranButtonModel("30", "عم"))


        adapter = Adapter(this, array)
        val gridLayoutManager = GridLayoutManager(this, 2)
        recycleView.layoutManager = gridLayoutManager
        recycleView.adapter= adapter

    }

}
