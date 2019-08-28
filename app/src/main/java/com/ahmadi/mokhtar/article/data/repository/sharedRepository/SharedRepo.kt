package com.ahmadi.mokhtar.article.data.repository.sharedRepository

import com.ahmadi.mokhtar.article.data.models.shared.ResultShare
import com.ahmadi.mokhtar.article.data.models.viewed.ResultView
import io.reactivex.Completable
import io.reactivex.Observable

interface SharedRepo {

    fun getAllShared(): Observable<List<ResultShare>>
    fun getAllShareSaved(): Observable<List<ResultShare>>
    fun saveItem(resultShare: ResultShare, state:Boolean): Completable

}