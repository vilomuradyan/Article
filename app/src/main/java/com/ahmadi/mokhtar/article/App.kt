package com.ahmadi.mokhtar.article

import android.app.Application
import com.ahmadi.mokhtar.article.di.component.DIComponent
import com.ahmadi.mokhtar.article.di.component.DaggerDIComponent
import com.ahmadi.mokhtar.article.di.modules.ApiModule
import com.ahmadi.mokhtar.article.di.modules.AppModule

class App : Application() {

    lateinit var di : DIComponent

    override fun onCreate() {
        super.onCreate()

        di = DaggerDIComponent
            .builder()
            .apiModule(ApiModule())
            .appModule(AppModule(this))
            .build()

    }
}