package com.sanket.loblaw.Model


import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class RedditArticleResponse(val data: RedditDataResponse): Parcelable

@Parcelize
data class RedditDataResponse(
    val children: List<RedditChildrenResponse>,
    val after: String?,
    val before: String?
): Parcelable

@Parcelize
data class RedditChildrenResponse(val data: RedditNewsDataResponse) : Parcelable

@Parcelize
data class RedditNewsDataResponse(
    val author: String?,
    val title: String?,
    val num_comments: Int,
    val created: Long,
    val thumbnail_url: String?,
    val selftext: String?,
    val selftext_html: String?,
    val url: String?,
    val secure_media : MediaEmbedResponse?
): Parcelable

@Parcelize
data class MediaEmbedResponse(
    val oembed: OembdResponse?
): Parcelable

@Parcelize
data class OembdResponse(val thumbnail_url : String?)
    : Parcelable