package com.example.retrofit_with_kotlin

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetroInstance {



    private const val BASE_URL = "https://jsonplaceholder.typicode.com"


    val retrofitInstance: Retrofit
        get() {



                var retrofit:Retrofit = retrofit2.Retrofit.Builder()

                    .baseUrl(BASE_URL)

                    .addConverterFactory(GsonConverterFactory.create())

                    .build()



            return retrofit

        }
}
