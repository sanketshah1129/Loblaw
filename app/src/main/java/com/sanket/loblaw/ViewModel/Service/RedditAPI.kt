package com.sanket.loblaw.ViewModel.Service

import com.sanket.loblaw.Model.RedditArticleResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RedditAPI
{
    @GET("/top.json")
    fun getTop(@Query("after") after: String,
               @Query("limit") limit: String): Call<RedditArticleResponse>

    @GET(".json")
    fun getKotlinNews() : Call<RedditArticleResponse>
}