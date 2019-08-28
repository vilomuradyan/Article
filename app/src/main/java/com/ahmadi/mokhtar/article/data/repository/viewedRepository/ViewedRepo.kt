package com.ahmadi.mokhtar.article.data.repository.viewedRepository

import com.ahmadi.mokhtar.article.data.models.viewed.ResultView
import io.reactivex.Completable
import io.reactivex.Observable

interface ViewedRepo {
    fun getAllViewed(): Observable<List<ResultView>>
    fun getAllViewSaved(): Observable<List<ResultView>>
    fun saveItem(resultView: ResultView ,state:Boolean): Completable
}