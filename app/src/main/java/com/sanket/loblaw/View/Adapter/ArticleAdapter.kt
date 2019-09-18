package com.sanket.loblaw.View.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.sanket.loblaw.Model.RedditChildrenResponse
import com.sanket.loblaw.R
import com.sanket.loblaw.View.MainActivity
import com.squareup.picasso.Picasso

class ArticleAdapter(var articleList: ArrayList<RedditChildrenResponse>, var context: Context)
    : RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val view : View = LayoutInflater.from(context).inflate(R.layout.item, parent, false)
        return ArticleViewHolder(view)
    }

    override fun getItemCount(): Int {
        return articleList.size
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {

       val articleItem: RedditChildrenResponse = articleList.get(position)

        holder.clView.setOnClickListener(View.OnClickListener
          {
              val intent = MainActivity.newIntent(context, articleItem)
              context.startActivity(intent)
          })

        val path : String? = articleList.get(position).data.secure_media?.oembed?.thumbnail_url

        Picasso.get().load(path).resize(200, 200).centerCrop().into(holder.ivArticle);

        val title : String = articleItem.data.title.toString()
        holder.tvArticle.text = title
    }

    fun addArticles(articles: List<RedditChildrenResponse>) {
        val lastCount = articleList.size//itemCount
        articleList.addAll(articles)
        notifyItemRangeInserted(lastCount, articles.size)
    }


    class ArticleViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val clView : ConstraintLayout
        val ivArticle : ImageView
        val tvArticle : TextView

        init {
            clView = view.findViewById(R.id.itemView)
            ivArticle = view.findViewById(R.id.ivArticle_new)
            tvArticle = view.findViewById(R.id.tvArticleTitle_new)
        }
    }
}