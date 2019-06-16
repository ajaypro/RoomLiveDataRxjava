package deepak.opensource.com.daggerkotlin.data.local.dao

import androidx.room.*
import deepak.opensource.com.daggerkotlin.data.local.entity.User
import io.reactivex.Single

/**
 * Created by Ajay Deepak on 15-06-2019.
 */

//This class is for querying db room uses this interface to provide concrete classes to run the queries

@Dao
interface UserDao {

    @Insert
    fun insert(user: User): Single<Long>

    @Delete
    fun delete(user: User): Single<Int>

    @Update // this will return no. of rows
    fun update(user: User): Single<Int>

    @Insert
    fun insertMany(vararg user: User) : Single<List<Long>>

    @Query("SELECT * FROM user")
    fun getAllUsers():Single<List<User>>

    @Query("SELECT * FROM user WHERE id = :id LIMIT 1")
    fun getUserById(id: Long): Single<User>

    @Query("SELECT count(*) FROM user")
    fun count(): Single<Int>

}