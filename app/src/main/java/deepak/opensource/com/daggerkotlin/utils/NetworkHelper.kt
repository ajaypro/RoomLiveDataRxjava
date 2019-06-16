package deepak.opensource.com.daggerkotlin.utils

import android.content.Context
import deepak.opensource.com.daggerkotlin.di.qualifier.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Ajay Deepak on 06-06-2019.
 */

@Singleton
class NetworkHelper @Inject constructor(@ApplicationContext val context: Context) {

    fun isNetworkConnected(): Boolean{
        return false
    }
}