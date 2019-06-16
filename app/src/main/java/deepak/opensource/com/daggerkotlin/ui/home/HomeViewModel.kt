package deepak.opensource.com.daggerkotlin.ui.home

import deepak.opensource.com.daggerkotlin.data.local.DataBaseService
import deepak.opensource.com.daggerkotlin.data.remote.NetworkService
import deepak.opensource.com.daggerkotlin.di.scope.FragmentScope
import deepak.opensource.com.daggerkotlin.utils.NetworkHelper
import javax.inject.Inject

/**
 * Created by Ajay Deepak on 06-06-2019.
 */

@FragmentScope
class HomeViewModel @Inject constructor(private val networkService: NetworkService,
                                        private val networkHelper: NetworkHelper,
                                        private val dataBaseService: DataBaseService) {

     val dummyData: String get() = (dataBaseService.dummyData() +
             networkService.getDummyData() +
             networkHelper.isNetworkConnected())
}