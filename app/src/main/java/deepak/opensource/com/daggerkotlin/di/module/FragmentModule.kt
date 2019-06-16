package deepak.opensource.com.daggerkotlin.di.module

import android.content.Context
import dagger.Module
import dagger.Provides
import deepak.opensource.com.daggerkotlin.di.qualifier.ActivityInfo
import deepak.opensource.com.daggerkotlin.ui.home.HomeFragment

/**
 * Created by Ajay Deepak on 14-06-2019.
 */

@Module
class FragmentModule(private  val fragment: HomeFragment) {

    @ActivityInfo
    @Provides
    fun provideContext(): Context = fragment.context!!
}