package com.rammy.pricepridict.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class retrofitinstance {
    companion object{
        private val retrofit by lazy {
            Retrofit.Builder()
                .baseUrl("http://192.168.194.86:8000/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        val api by lazy {
            retrofit.create(apiinterface::class.java)
        }
    }
}