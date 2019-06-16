package deepak.opensource.com.daggerkotlin.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import deepak.opensource.com.daggerkotlin.MyApplication
import deepak.opensource.com.daggerkotlin.R
import deepak.opensource.com.daggerkotlin.di.component.DaggerFragmentComponent
import deepak.opensource.com.daggerkotlin.di.module.FragmentModule
import javax.inject.Inject

/**
 * Created by Ajay Deepak on 06-06-2019.
 */

class HomeFragment: Fragment() {

    companion object {

        val TAG = "Home Fragment"

        fun newInstance(): HomeFragment {
            val args = Bundle()
            val fragment = HomeFragment()
            fragment.arguments = args
            return fragment
        }
    }

    @Inject
    lateinit var homeViewModel: HomeViewModel


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        getDependencies()
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
                val tvmessage = view.findViewById<TextView>(R.id.tv_message)
        tvmessage.text = homeViewModel.dummyData
    }

    fun getDependencies(){

        DaggerFragmentComponent
            .builder()
            .applicationComponent((context!!.applicationContext as MyApplication).applicationComponent)
            .fragmentModule(FragmentModule(this))
            .build()
            .inject(this)
    }
}