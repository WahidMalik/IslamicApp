package com.example.islamicappkotlin

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.SearchView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.google.android.material.textfield.TextInputEditText
import org.json.JSONArray
import org.json.JSONObject
import java.text.SimpleDateFormat
import java.util.*

class PrayerActivity : AppCompatActivity() {

    lateinit var search: SearchView
    lateinit var fajr: TextView
    lateinit var zohar: TextView
    lateinit var asar: TextView
    lateinit var maghrib: TextView
    lateinit var isha: TextView
    lateinit var simpleDateFormat: SimpleDateFormat
    lateinit var okButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_prayer)

        search = findViewById(R.id.search)
        fajr = findViewById(R.id.fajarTimeDisplay)
        zohar = findViewById(R.id.zoharTimeDisplay)
        asar = findViewById(R.id.asarTimeDisplay)
        maghrib = findViewById(R.id.maghribTimeDisplay)
        isha = findViewById(R.id.ishaTimeDisplay)
        okButton = findViewById(R.id.ok)


        simpleDateFormat = SimpleDateFormat("HH:mm", Locale.getDefault())


        okButton.setOnClickListener {
            val cityName = search.query.toString()
            if (cityName.isNotEmpty()) {
                loadPrayer(cityName)
            } else {
                Toast.makeText(this, "Please enter a city name", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun loadPrayer(cityName: String) {
        val queue = Volley.newRequestQueue(this)
        val url = "https://muslimsalat.com/" +cityName +".json?key=1e696b61c4ef577e576bf5afa12a320d"


        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET, url, null,
            { response ->
                try {
                    val fajrTime = response.getJSONArray("items").getJSONObject(0).getString("fajr")
                    val zoharTime = response.getJSONArray("items").getJSONObject(0).getString("dhuhr")
                    val asarTime = response.getJSONArray("items").getJSONObject(0).getString("asr")
                    val maghribTime = response.getJSONArray("items").getJSONObject(0).getString("maghrib")
                    val ishaTime = response.getJSONArray("items").getJSONObject(0).getString("isha")
                    fajr.text = formatTime(fajrTime)
                    zohar.text = formatTime(zoharTime)
                    asar.text = formatTime(asarTime)
                    maghrib.text = formatTime(maghribTime)
                    isha.text = formatTime(ishaTime)

                } catch (e: Exception) {
                    Log.e("PrayerActivity", "JSON Parsing Error: ${e.message}", e)
                    Toast.makeText(this, "Error: JSON Parsing Error", Toast.LENGTH_SHORT).show()
                }
            },
            { error ->
                val errorMessage = when {
                    error.networkResponse != null -> "Network Response Error: ${error.networkResponse.statusCode}"
                    error.cause != null -> "Error Cause: ${error.cause?.message}"
                    else -> "Error: ${error.message}"
                }
                Log.e("PrayerActivity", "Volley Error: $errorMessage", error)
                Toast.makeText(this, "Volley Error: $errorMessage", Toast.LENGTH_SHORT).show()
            }
        )
        queue.add(jsonObjectRequest)
    }

    private fun formatTime(timeString: String): String {
        return try {
            val time = SimpleDateFormat("HH:mm", Locale.getDefault()).parse(timeString)
            simpleDateFormat.format(time)
        } catch (e: Exception) {
            "Invalid time"
        }
    }
}
