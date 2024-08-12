package com.example.islamicappkotlin

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject

class Calendar : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var array: ArrayList<CalendarModel>
    lateinit var adapter: CalendarAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_calendar)

        recyclerView = findViewById(R.id.recyclerView)
        array = ArrayList()
        adapter = CalendarAdapter(this, array)
        val linearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = linearLayoutManager
        recyclerView.adapter = adapter


        loadAPI()
    }

    private fun loadAPI() {
        val queue = Volley.newRequestQueue(this)
        val url = "https://api.aladhan.com/v1/gToHCalendar/8/2024"

        val jsonObjectRequest = JsonObjectRequest(Request.Method.GET, url, null,
            { response ->
                try {

                    val dataArray = response.getJSONArray("data")
                    for (i in 0 until dataArray.length()) {
                        val dataObject = dataArray.getJSONObject(i)

                        val id = dataObject.getJSONObject("gregorian").getString("day")
                        val title = dataObject.getJSONObject("hijri").getJSONObject("weekday").getString("ar")
                        val day = dataObject.getJSONObject("gregorian").getJSONObject("weekday").getString("en")
                        val description = dataObject.getJSONObject("hijri").getJSONObject("month").getString("ar")

                        array.add(CalendarModel(id, title, day, description))
                    }
                    adapter.notifyDataSetChanged()
                } catch (e: Exception) {
                    Toast.makeText(this, "Error catch: ", Toast.LENGTH_SHORT).show()
                }
            },
            { error ->
               Toast.makeText(this, "Error: Listner", Toast.LENGTH_SHORT).show()
            }
        )

        queue.add(jsonObjectRequest)
    }

}
