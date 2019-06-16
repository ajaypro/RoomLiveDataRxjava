package deepak.opensource.com.daggerkotlin.data.remote

import android.content.Context
import deepak.opensource.com.daggerkotlin.di.qualifier.ApplicationContext
import deepak.opensource.com.daggerkotlin.di.qualifier.NetworkInfo
import javax.inject.Inject

/**
 * Created by Ajay Deepak on 06-06-2019.
 */
class NetworkService @Inject constructor(@ApplicationContext val context: Context,
                                         @NetworkInfo val apiKey: String) {

    fun getDummyData() = "DUMMY DATA"

}