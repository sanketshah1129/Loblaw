package com.sanket.loblaw.View

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sanket.loblaw.Model.RedditChildrenResponse
import com.sanket.loblaw.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.detail_activity.*

class DetailActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_activity)

        val articleDetails = intent.getParcelableExtra<RedditChildrenResponse>(MainActivity.INTENT_ARTICLE_DETAILS)

        init(articleDetails)
    }

    fun init(articleDetails : RedditChildrenResponse)
    {
        val title = articleDetails.data.title
        val details:String? = articleDetails.data.selftext
        val actionbar = supportActionBar
        actionbar!!.title = title
        actionbar.setDisplayHomeAsUpEnabled(true)

        tvArticleDetail.text = title
        val path = articleDetails.data.secure_media?.oembed?.thumbnail_url
        Picasso.get().load(path).resize(200, 200).centerCrop().into(ivArticle_new);
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}