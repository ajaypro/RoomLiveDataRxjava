package deepak.opensource.com.daggerkotlin.di.module

import android.app.Activity
import dagger.Module
import dagger.Provides
import deepak.opensource.com.daggerkotlin.di.qualifier.ActivityInfo
import deepak.opensource.com.daggerkotlin.ui.home.HomeFragment

/**
 * Created by Ajay Deepak on 06-06-2019.
 */

@Module
class ActivityModule(private val activity: Activity) {

   @ActivityInfo
   @Provides
   fun provideContext() = activity

   @Provides
   fun provideHomeFragment() = HomeFragment()


}