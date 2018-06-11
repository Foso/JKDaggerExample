package de.jensklingenberg.jkdaggerexample.network

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import de.jensklingenberg.jkdaggerexample.model.Post
import io.reactivex.Single
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

interface TestApi {

    @GET("posts")
    fun getPostList(): Single<Response<List<Post>>>


}