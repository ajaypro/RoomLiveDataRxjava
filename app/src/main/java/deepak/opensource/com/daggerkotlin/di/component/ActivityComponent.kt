package deepak.opensource.com.daggerkotlin.di.component

import dagger.Component
import deepak.opensource.com.daggerkotlin.di.module.ActivityModule
import deepak.opensource.com.daggerkotlin.di.scope.ActivityScope
import deepak.opensource.com.daggerkotlin.ui.main.MainActivity

/**
 * Created by Ajay Deepak on 06-06-2019.
 */

@ActivityScope
@Component(dependencies = [ApplicationComponent::class], modules = [ActivityModule::class])
interface ActivityComponent {

    fun inject(mainActivity: MainActivity)

}