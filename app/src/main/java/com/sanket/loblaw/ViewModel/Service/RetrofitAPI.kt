package com.sanket.loblaw.ViewModel.Service

import com.sanket.loblaw.Utility.CommonClass.Companion.BASE_URL
import com.sanket.loblaw.Model.RedditArticleResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class RetrofitAPI
{
    private val redditApi: RedditAPI
    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
        redditApi = retrofit.create(RedditAPI::class.java)
    }

    fun getArticles(after: String, limit: String): Call<RedditArticleResponse> {
        return redditApi.getTop(after, limit)
    }

    fun getArticleNews() : Call<RedditArticleResponse>
    {
        return redditApi.getKotlinNews()
    }
}