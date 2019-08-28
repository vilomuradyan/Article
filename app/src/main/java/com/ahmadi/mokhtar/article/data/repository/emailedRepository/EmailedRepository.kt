package com.ahmadi.mokhtar.article.data.repository.emailedRepository

import android.content.Context
import com.ahmadi.mokhtar.article.data.database.AppDatabase
import com.ahmadi.mokhtar.article.data.models.emailed.ResultEmail
import com.ahmadi.mokhtar.article.data.network.Api
import com.ahmadi.mokhtar.article.utils.AppConstants
import com.ahmadi.mokhtar.article.utils.iomain
import com.ahmadi.mokhtar.article.utils.isNetworkConnected
import io.reactivex.Completable
import io.reactivex.Observable
import timber.log.Timber
import javax.inject.Inject

class EmailedRepository@Inject constructor(private val context: Context, private val dataBase: AppDatabase, private val api: Api) : EmailedRepo {
    override fun saveItem(resultEmail: ResultEmail, state: Boolean):Completable =
        Completable.create { dataBase.emailedDao.updateById(resultEmail.id!!,state) }

    override fun getAllEmailSaved(): Observable<List<ResultEmail>> {
        return dataBase.emailedDao.getAllResultEmailSaved(true).iomain().toObservable()
    }

    override fun getAllEmailed(): Observable<List<ResultEmail>> {
        val hasConnection = isNetworkConnected(context)
        var observableFromApi : Observable<List<ResultEmail>>? = null


        if (hasConnection){
            observableFromApi = getEmailedFromApi()
        }
        var observableFromDb = getEmailedFromDb()


        return if (hasConnection) Observable.concat(observableFromDb ,observableFromApi)
        else observableFromDb
    }


    private fun getEmailedFromApi():Observable<List<ResultEmail>>?{
        return  api.getAllEmailed(AppConstants.API_KEY).doOnNext{
            for (item:ResultEmail in it.results!!) {
                item?.apply {
                    dataBase.emailedDao.insert(item)
                }
            }
        }.map{ it?.results }
    }

    private fun getEmailedFromDb():Observable<List<ResultEmail>> {
        return dataBase.emailedDao.getAllResultEmail(true).toObservable()
    }

}