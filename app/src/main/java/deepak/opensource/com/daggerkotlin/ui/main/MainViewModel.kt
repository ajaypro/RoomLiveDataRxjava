package deepak.opensource.com.daggerkotlin.ui.main

import android.util.Log
import androidx.lifecycle.MutableLiveData
import deepak.opensource.com.daggerkotlin.data.local.DataBaseService
import deepak.opensource.com.daggerkotlin.data.local.entity.Address
import deepak.opensource.com.daggerkotlin.data.local.entity.User
import deepak.opensource.com.daggerkotlin.data.remote.NetworkService
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import java.util.*
import javax.inject.Inject

/**
 * Created by Ajay Deepak on 06-06-2019.
 */

class MainViewModel @Inject constructor(
    private val networkService: NetworkService,
    private val dataBaseService: DataBaseService,
    private val compositeDisposable: CompositeDisposable
) {

    companion object {
        val TAG = "TAG"
    }

    val dummyData: String
        get() = "MainViewModel"

    val user = MutableLiveData<User>()
    val users = MutableLiveData<List<User>>()

    val addresses = MutableLiveData<List<Address>>()

    var allUsers: List<User> = emptyList()

    var allUserAddress: List<Address> = emptyList()

    init {
        compositeDisposable.add(
            dataBaseService.userDao()
                .count()
                .flatMap {
                    if (it == 0) {
                        dataBaseService.addressDao()
                            .insertMany(
                                Address(city = "amsterdam", country = "Netherlands", code = 10),
                                Address(city = "Bangalore", country = "India",code = 11),
                                Address(city = "Berlin", country = "Germany",code = 23),
                                Address(city = "Manchester", country = "London",code = 34),
                                Address(city = "Moscow", country = "Russia",code = 76)
                            )
                            .flatMap { addressIds ->
                                //after inserting address we insert users with address id's
                                dataBaseService.userDao()
                                    .insertMany(
                                        User(
                                            name = "User1",
                                            dateOfBirth = Date(23488),
                                            addressId = addressIds[0]
                                        ),
                                        User(
                                            name = "User2",
                                            dateOfBirth = Date(21693),
                                            addressId = addressIds[1]
                                        ),
                                        User(
                                            name = "User3",
                                            dateOfBirth = Date(13782),
                                            addressId = addressIds[2]
                                        ),
                                        User(
                                            name = "User4",
                                            dateOfBirth = Date(40978),
                                            addressId = addressIds[3]
                                        ),
                                        User(
                                            name = "User5",
                                            dateOfBirth = Date(10668),
                                            addressId = addressIds[4]
                                        )
                                    )
                            }


                    } else Single.just(0)
                }.subscribeOn(Schedulers.io())
                .subscribe(
                    {
                        Log.d(TAG, "users exist in table: $it")
                    },
                    {
                        Log.d(TAG, it.toString())
                    }
                )
        )
    }

    fun getAllUsers() {
        compositeDisposable.add(
            dataBaseService.userDao()
                .getAllUsers()
                .subscribeOn(Schedulers.io())
                .subscribe({
                    allUsers = it
                    users.postValue(it)
                },
                    {
                        Log.d(TAG, it.toString())
                    })
        )
    }

    fun getAllAddresses() {
        compositeDisposable.add(
            dataBaseService.addressDao()
                .getAllAddress()
                .subscribeOn(Schedulers.io())
                .subscribe({
                    allUserAddress = it
                    addresses.postValue(it)
                },
                    {
                        Log.d(TAG, it.toString())
                    })
        )
    }


    fun deleteUser() {
        if (allUsers.isNotEmpty()) {
            compositeDisposable.add(
                dataBaseService.userDao()
                    .delete(allUsers[0])
                    .flatMap {
                        dataBaseService.userDao().getAllUsers()
                    }
                    .subscribeOn(Schedulers.io())
                    .subscribe({
                        allUsers = it
                        users.postValue(it)
                    },
                        {
                            Log.d(TAG, it.toString())
                        })
            )

        }
    }

    fun deleteAddress() {
        if (allUserAddress.isNotEmpty()) {
            compositeDisposable.add(
                dataBaseService.addressDao()
                    .delete(allUserAddress[0])
                    .flatMap {
                        dataBaseService.addressDao().getAllAddress()
                    }
                    .subscribeOn(Schedulers.io())
                    .subscribe({
                        allUserAddress = it
                        addresses.postValue(it)
                    },
                        {
                            Log.d(TAG, it.toString())
                        })
            )

        }
    }

    // manual onDestroy() as its not a android arch component viewmodel
    fun onDestroy() {
        compositeDisposable.dispose()
    }
}