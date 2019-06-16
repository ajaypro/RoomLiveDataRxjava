package deepak.opensource.com.daggerkotlin.ui.main

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.Observer
import deepak.opensource.com.daggerkotlin.MyApplication
import deepak.opensource.com.daggerkotlin.R
import deepak.opensource.com.daggerkotlin.di.component.DaggerActivityComponent
import deepak.opensource.com.daggerkotlin.di.module.ActivityModule
import deepak.opensource.com.daggerkotlin.ui.home.HomeFragment
import deepak.opensource.com.daggerkotlin.utils.Common
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_home.*
import javax.inject.Inject


class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var mainViewModel: MainViewModel

    @Inject
    lateinit var homeFragment: HomeFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getDependencies()
        setContentView(R.layout.activity_main)

        mainViewModel.users.observe(this, Observer {
            tvData.text = it.toString()
        })

        mainViewModel.addresses.observe( this, Observer {
            tvAddress.text = it.toString()
        })

        //Adding fragment
        supportFragmentManager.inTransaction {
            add(homeFragment, Common.TAG)
        }
    }

    inline fun FragmentManager.inTransaction(func: FragmentTransaction.() -> Unit) {
        val fragmentTransaction = beginTransaction()
        fragmentTransaction.func()
        fragmentTransaction.commit()
    }

    override fun onStart() {
        super.onStart()

        mainViewModel.getAllUsers()
        mainViewModel.getAllAddresses()
    }

    /**
     * Dispatch onPause() to fragments.
     */
    override fun onPause() {
        super.onPause()
        Log.i("main actvity", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i("main actvity", "onStop")
        mainViewModel.deleteAddress()
    }

    fun getDependencies(){

          DaggerActivityComponent
              .builder()
              .applicationComponent((application as MyApplication).applicationComponent)
              .activityModule(ActivityModule(this))
              .build()
              .inject(this)
    }

    override fun onDestroy() {
        super.onDestroy()

        mainViewModel.onDestroy()
    }
}
