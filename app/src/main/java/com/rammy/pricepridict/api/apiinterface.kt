package com.rammy.pricepridict.api

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface apiinterface {
    @POST("predict/")
    fun pridict(
        @Body sendResponce: sendResponce
    ): Call<List<responce>>
}