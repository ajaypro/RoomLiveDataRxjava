package deepak.opensource.com.daggerkotlin.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import deepak.opensource.com.daggerkotlin.data.local.entity.Address
import deepak.opensource.com.daggerkotlin.data.local.entity.User
import deepak.opensource.com.daggerkotlin.di.qualifier.DatabaseInfo
import io.reactivex.Single

/**
 * Created by Ajay Deepak on 16-06-2019.
 */

@Dao
interface AddressDao{

    @Delete
    fun delete(address: Address): Single<Int>

    @Insert
    fun insertMany(vararg address: Address) : Single<List<Long>>

    @Query("SELECT * FROM addresses")
    fun getAllAddress():Single<List<Address>>
}