package deepak.opensource.com.daggerkotlin.di.module

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import dagger.Module
import dagger.Provides
import deepak.opensource.com.daggerkotlin.MyApplication
import deepak.opensource.com.daggerkotlin.data.local.DataBaseService
import deepak.opensource.com.daggerkotlin.data.local.MIGRATIONS1_2
import deepak.opensource.com.daggerkotlin.di.qualifier.ApplicationContext
import deepak.opensource.com.daggerkotlin.di.qualifier.DatabaseInfo
import deepak.opensource.com.daggerkotlin.di.qualifier.NetworkInfo
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton

/**
 * Created by Ajay Deepak on 06-06-2019.
 */

@Module
class ApplicationModule(val application: MyApplication) {

    @ApplicationContext
    @Provides
    fun provideContext(): Context = application

    @DatabaseInfo
    @Provides
    fun provideDatabseName() = "dummy_db"

    @DatabaseInfo
    @Provides
    fun provideDatabaseVersion() = 1

    @NetworkInfo
    @Provides
    fun provideApiKey() = "SOME_API_KEY"

    @Singleton
    @Provides
    fun providesDataBaseService(): DataBaseService = Room.databaseBuilder(
        application,
        DataBaseService::class.java,
        "bootcamp-database").addMigrations(MIGRATIONS1_2)
        .build()

    @Provides // Should not be singleton becuase each disposable would need a instance of composite disposable
    fun providesCompositeDispoable(): CompositeDisposable = CompositeDisposable()
}