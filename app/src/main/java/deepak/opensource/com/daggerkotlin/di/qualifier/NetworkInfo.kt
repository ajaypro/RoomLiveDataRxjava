package deepak.opensource.com.daggerkotlin.di.qualifier

import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy
import javax.inject.Qualifier

/**
 * Created by Ajay Deepak on 06-06-2019.
 */

@Qualifier
@Retention(RetentionPolicy.SOURCE)
annotation class NetworkInfo {
}