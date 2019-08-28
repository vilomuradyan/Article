package com.ahmadi.mokhtar.article.di.component

import androidx.annotation.Keep
import com.ahmadi.mokhtar.article.di.modules.ApiModule
import com.ahmadi.mokhtar.article.di.modules.AppModule
import com.ahmadi.mokhtar.article.view.activities.MainActivity
import com.ahmadi.mokhtar.article.viewModels.EmailedViewModel
import com.ahmadi.mokhtar.article.viewModels.SharedViewModel
import com.ahmadi.mokhtar.article.viewModels.ViewedViewModel
import dagger.Component
import javax.inject.Singleton

@Keep
@Singleton
@Component(modules = [AppModule::class , ApiModule::class])
interface DIComponent {

    interface Injectable{
        fun inject(diComponent: DIComponent)
    }

    fun inject(mainActivity: MainActivity)
    fun inject(emailedViewModel: EmailedViewModel)
    fun inject(viewedViewModel: ViewedViewModel)
    fun inject(sharedViewModel: SharedViewModel)
}