package com.example.retrofit_with_kotlin

import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import android.os.Bundle
import android.util.Log
import android.widget.Toast

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private var adapter: CustomAdapter? = null

    private var recyclerView: RecyclerView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val service = RetroInstance.retrofitInstance.create(GetUserData::class.java)

        val call = service.allUser

        call.enqueue(object : Callback<List<RetroUser>> {

            override fun onResponse(call: Call<List<RetroUser>>, response: Response<List<RetroUser>>) {


                // Log.d("2", response.body()?.get(1)?.title)
               // var user : List<RetroUser>? = response.body()
                response.body()?.let { generateDataList(it) }
                /*  List<RetroUser> user=response.body();

                for(RetroUser el: user){
                    Log.d("1",el.getBody());
                }*/


            }


            override fun onFailure(call: Call<List<RetroUser>>, t: Throwable) {


                Toast.makeText(this@MainActivity, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show()

            }

        })


    }

    private fun generateDataList(photoList: List<RetroUser>) {


        Log.d("2", "this is !!!!!!!!!!!!!!!!!!")

        recyclerView = findViewById(R.id.customRecyclerView)

        adapter = CustomAdapter(this, photoList)

        val layoutManager = LinearLayoutManager(this@MainActivity)

        this.recyclerView!!.layoutManager = layoutManager

        recyclerView!!.adapter = adapter

    }
}

