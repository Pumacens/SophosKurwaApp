package com.example.sophos.ARetrofitConfig

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitConfig {
    companion object {
        var URL_API = "https://6w33tkx4f9.execute-api.us-east-1.amazonaws.com/"

        fun getRetrofit(): Retrofit {
            var retrofit :Retrofit = Retrofit.Builder()
                .baseUrl(URL_API)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit
        }
    }
}