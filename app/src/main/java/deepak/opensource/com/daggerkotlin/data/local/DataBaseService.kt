package deepak.opensource.com.daggerkotlin.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import deepak.opensource.com.daggerkotlin.data.local.convertors.Convertor
import deepak.opensource.com.daggerkotlin.data.local.dao.AddressDao
import deepak.opensource.com.daggerkotlin.data.local.dao.UserDao
import deepak.opensource.com.daggerkotlin.data.local.entity.Address
import deepak.opensource.com.daggerkotlin.data.local.entity.User

/**
 * Created by Ajay Deepak on 06-06-2019.
 */

@Database(
    entities = [ User::class,
                 Address::class],
    version = 1,
    exportSchema = false)
@TypeConverters(Convertor::class)
abstract class DataBaseService: RoomDatabase() {

    // abstract method dao to implement and access the query methods of db
    abstract fun userDao(): UserDao

    abstract fun addressDao(): AddressDao

    fun dummyData() = "Dummy data"

}