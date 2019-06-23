package com.example.retrofit_with_kotlin

import retrofit2.Call
import retrofit2.http.GET

interface GetUserData {
    @get:GET("/posts")
    val allUser: Call<List<RetroUser>>
}