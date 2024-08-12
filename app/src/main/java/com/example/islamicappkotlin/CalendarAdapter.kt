package com.example.islamicappkotlin

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CalendarAdapter (var context: Context, var array : ArrayList<CalendarModel>)
    : RecyclerView.Adapter<CalendarAdapter.ViewHolderCalendar>() {

        class ViewHolderCalendar(itemView: View) : RecyclerView.ViewHolder(itemView){
            val georgianDate = itemView.findViewById<TextView>(R.id.gregorianDate)
            val hijriDate = itemView.findViewById<TextView>(R.id.hijriDate)
            val gregorianWeekday = itemView.findViewById<TextView>(R.id.georgianWeekday)
            val hijriWeekday = itemView.findViewById<TextView>(R.id.hijriWeekday)

            fun bind(calendarModel: CalendarModel){
                georgianDate.text = calendarModel.gregorianDate
                hijriDate.text = calendarModel.hijriDate
                gregorianWeekday.text = calendarModel.gregorianWeekday
                hijriWeekday.text = calendarModel.hijriWeekday
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderCalendar {
        val view =LayoutInflater.from(context).inflate(R.layout.calendarlayout, parent, false)
        return ViewHolderCalendar(view)
    }

    override fun getItemCount(): Int {
        return array.size
    }

    override fun onBindViewHolder(holder: ViewHolderCalendar, position: Int) {
        val item = array[position]
        holder.bind(item)

    }
}