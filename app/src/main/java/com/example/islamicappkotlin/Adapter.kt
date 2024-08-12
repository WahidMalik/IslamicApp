package com.example.islamicappkotlin

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adapter (var context: Context, var arrayList: ArrayList<QuranButtonModel>) : RecyclerView.Adapter<Adapter.ViewHolderClass>() {

   class ViewHolderClass(itemView: View) : RecyclerView.ViewHolder(itemView) {
       val number = itemView.findViewById<TextView>(R.id.paraNumber)
       val name = itemView.findViewById<TextView>(R.id.paraName)
       val main = itemView.findViewById<View>(R.id.main)

       fun bind(quranButtonModel: QuranButtonModel) {
           number.text = quranButtonModel.number
           name.text = quranButtonModel.name
           main.setOnClickListener {
               val intent = Intent(itemView.context, QuranShow::class.java)
               val btnNumber = number.text.toString()
               intent.putExtra("PDF_FILE_NAME", "P${btnNumber}" + ".pdf")
               itemView.context.startActivity(intent)
           }
       }

   }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderClass {
        val view = LayoutInflater.from(context).inflate(R.layout.parabuttons, parent, false)
        return ViewHolderClass(view)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: ViewHolderClass, position: Int) {
        val array = arrayList[position]
        holder.bind(array)
    }
}