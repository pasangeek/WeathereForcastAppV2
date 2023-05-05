package com.example.weathereforcastappv2.data

import com.example.weathereforcastappv2.data.db.network.response.CurrentWeatherResponse
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

//used by retrofit to fetch data from api

const val API_KEY = "71714f356ae50a51068715ef57fc6b91"

//https://api.weatherstack.com/current?access_key=71714f356ae50a51068715ef57fc6b91&query=New%20York

interface ApixuWeatherApiService {
@GET("current")
fun  getCurrentWeather(
    @Query("query") location: String

): Deferred<CurrentWeatherResponse>//fetch data to certain class

companion object
{

    operator fun invoke():ApixuWeatherApiService{

        val requestInterceptor = Interceptor {
           chain ->

       val url = chain.request()
           .url()
           .newBuilder()
           .addQueryParameter("access_key", API_KEY)
           .build()
val request = chain.request()
    .newBuilder()
    .url(url)
    .build()
            return@Interceptor chain.proceed(request)//request updated url
        }
val okHttpClient = OkHttpClient.Builder()
    .addInterceptor(requestInterceptor)
    .build()

        return  Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl("http://api.weatherstack.com/")
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApixuWeatherApiService::class.java)// add http client interceptor
    }
}


}