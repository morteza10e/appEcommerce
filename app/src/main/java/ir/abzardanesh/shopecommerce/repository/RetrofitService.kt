package ir.abzardanesh.shopecommerce.repository

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitService {

    // create url for baseUrl
    private const val url = "http://192.168.1.5:8080/shop/"

    //

    private val retrofit = Retrofit.Builder().baseUrl(url)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val apiService: Api = retrofit.create(Api::class.java)


}