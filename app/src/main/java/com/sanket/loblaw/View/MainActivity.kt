package com.sanket.loblaw.View

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sanket.loblaw.View.Adapter.ArticleAdapter
import com.sanket.loblaw.Model.RedditChildrenResponse
import com.sanket.loblaw.R
import com.sanket.loblaw.ViewModel.ArticleViewModel

class MainActivity : AppCompatActivity() {

    lateinit var context : Context
    lateinit var adapter: ArticleAdapter
    lateinit var articleViewModel: ArticleViewModel
    internal var articleList: ArrayList<RedditChildrenResponse> = ArrayList<RedditChildrenResponse>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }

    fun init()
    {
        context = this

        val actionbar = supportActionBar
        actionbar!!.title = "Android News"

        val recylerView = findViewById<RecyclerView>(R.id.rvArticle)

        val gridLayoutManager = GridLayoutManager(context, 2)
        recylerView.layoutManager = gridLayoutManager

        articleViewModel = ViewModelProviders.of(this).get(ArticleViewModel::class.java)
        articleViewModel.init()

        articleViewModel.getArticleRepository().observe(this, Observer{RedditArticleResponse ->

            val newsArticleItems = RedditArticleResponse.data.children
           // articleList.clear()
            articleList.addAll(newsArticleItems)
            adapter.notifyDataSetChanged()
        })

        adapter = ArticleAdapter(articleList, context)

        recylerView.setAdapter(adapter)
        recylerView.setItemAnimator(DefaultItemAnimator())
        //recylerView.setLayoutManager(LinearLayoutManager(context))
    }

    companion object {

        val INTENT_ARTICLE_DETAILS = "article_details"

        fun newIntent(context: Context, articleDetail: RedditChildrenResponse): Intent {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(INTENT_ARTICLE_DETAILS, articleDetail)
            return intent
        }
    }
}
