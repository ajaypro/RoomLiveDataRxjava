package deepak.opensource.com.daggerkotlin.di.component

import android.content.Context
import dagger.Component
import deepak.opensource.com.daggerkotlin.MyApplication
import deepak.opensource.com.daggerkotlin.data.local.DataBaseService
import deepak.opensource.com.daggerkotlin.data.remote.NetworkService
import deepak.opensource.com.daggerkotlin.di.module.ApplicationModule
import deepak.opensource.com.daggerkotlin.di.qualifier.ApplicationContext
import deepak.opensource.com.daggerkotlin.utils.NetworkHelper
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton

/**
 * Created by Ajay Deepak on 06-06-2019.
 */

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    fun inject(myApplication: MyApplication)

    @ApplicationContext
    fun getContext(): Context

    fun getNetworkService(): NetworkService

    fun getDatabaseService(): DataBaseService

    fun getNetworkHelper(): NetworkHelper

    fun getCompositeDisposable(): CompositeDisposable

}