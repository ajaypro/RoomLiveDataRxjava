package deepak.opensource.com.daggerkotlin

import android.app.Application
import deepak.opensource.com.daggerkotlin.data.local.DataBaseService
import deepak.opensource.com.daggerkotlin.data.remote.NetworkService
import deepak.opensource.com.daggerkotlin.di.component.ApplicationComponent
import deepak.opensource.com.daggerkotlin.di.component.DaggerApplicationComponent
import deepak.opensource.com.daggerkotlin.di.module.ApplicationModule
import deepak.opensource.com.daggerkotlin.utils.NetworkHelper
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * Created by Ajay Deepak on 06-06-2019.
 */


class MyApplication: Application() {

    lateinit var  applicationComponent :ApplicationComponent

    @Inject
    lateinit  var networkService: NetworkService

    @Inject
    lateinit var databaseService: DataBaseService

    @Inject
    lateinit var networkHelper: NetworkHelper
    

    override fun onCreate() {
        super.onCreate()
        getDependencies()
    }

    fun getDependencies(){
     applicationComponent = DaggerApplicationComponent
          .builder()
          .applicationModule(ApplicationModule(this))
          .build()
        applicationComponent.inject(this)
    }
}