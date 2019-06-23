package com.example.retrofit_with_kotlin

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(private val context: Context, private val dataList: List<RetroUser>) :
    RecyclerView.Adapter<CustomAdapter.CustomViewHolder>() {


    inner class CustomViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {


        var txtTitle: TextView


        init {


            txtTitle = mView.findViewById(R.id.title)


        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)

        val view = layoutInflater.inflate(R.layout.custom_row, parent, false)

        return CustomViewHolder(view)

    }


    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {

        holder.txtTitle.setText(dataList[position].title)

    }


    override fun getItemCount(): Int {

        return dataList.size

    }

}
