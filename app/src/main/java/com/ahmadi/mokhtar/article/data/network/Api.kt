package com.ahmadi.mokhtar.article.data.network

import com.ahmadi.mokhtar.article.data.models.emailed.Emailed
import com.ahmadi.mokhtar.article.data.models.shared.Shared
import com.ahmadi.mokhtar.article.data.models.viewed.Viewed
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
    @GET("emailed/1.json")
    fun getAllEmailed(@Query("api-key") apiKey: String): Observable<Emailed>

    @GET("shared/1/facebook.json")
    fun getAllShared(@Query("api-key") apiKey: String): Observable<Shared>

    @GET("viewed/1.json")
    fun getAllViewed(@Query("api-key") apiKey: String): Observable<Viewed>
}