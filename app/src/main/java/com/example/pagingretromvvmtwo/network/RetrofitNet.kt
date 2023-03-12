package com.example.pagingretromvvmtwo.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitNet {

    companion object{
        private const val BASE_URL="https://rickandmortyapi.com/api/"

        fun getRetrofit():Retrofit{
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

    }
}