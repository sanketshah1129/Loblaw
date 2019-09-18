package com.sanket.loblaw.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sanket.loblaw.Model.RedditArticleResponse
import com.sanket.loblaw.ViewModel.Service.RetrofitAPI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ArticleViewModel : ViewModel()
{
  //  lateinit var retrofitApi: RetrofitAPI
   var articleData : MutableLiveData<RedditArticleResponse> = MutableLiveData<RedditArticleResponse>()

    fun init()
    {
       val retrofitApi = RetrofitAPI()
     /*   retrofitApi.getArticles("kotlin",LIMIT).enqueue(object : Callback<RedditArticleResponse>
        {
            override fun onResponse(call: Call<RedditArticleResponse>, response: Response<RedditArticleResponse>) {
                if (response.isSuccessful()) {
                    articleData.setValue(response.body())
                }
            }

            override fun onFailure(call: Call<RedditArticleResponse>, t: Throwable) {
                articleData.setValue(null)
            }
        })*/

        retrofitApi.getArticleNews().enqueue(object : Callback<RedditArticleResponse>
        {
            override fun onResponse(call: Call<RedditArticleResponse>, response: Response<RedditArticleResponse>) {
                if (response.isSuccessful()) {
                    articleData.setValue(response.body())
                }
            }

            override fun onFailure(call: Call<RedditArticleResponse>, t: Throwable) {
                articleData.setValue(null)
            }
        })

    }

    fun getArticleRepository() : MutableLiveData <RedditArticleResponse>
    {
        return articleData
    }
}