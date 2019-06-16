package deepak.opensource.com.daggerkotlin.di.component

import dagger.Component
import deepak.opensource.com.daggerkotlin.di.module.FragmentModule
import deepak.opensource.com.daggerkotlin.di.scope.FragmentScope
import deepak.opensource.com.daggerkotlin.ui.home.HomeFragment

/**
 * Created by Ajay Deepak on 14-06-2019.
 */

@FragmentScope
@Component(dependencies = [ApplicationComponent::class], modules = [FragmentModule::class])
interface FragmentComponent {

      fun inject(fragment: HomeFragment)
}