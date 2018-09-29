package com.demo.view


import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.demo.R
import com.demo.viewModel.UserViewModel
import kotlinx.android.synthetic.main.fragment_second.*

/**
 * A simple [Fragment] subclass.
 *
 */
class SecondFragment : Fragment() {

    private lateinit var userViewModel: UserViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        userViewModel = activity?.let { ViewModelProviders.of(it).get(UserViewModel::class.java) }!!
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        secondText.setOnClickListener {
            userViewModel.setUserInfo("林月如", 30, "女")
        }

        userViewModel.getUserInfo().observe(this, Observer {
            secondText.text = it.toString()
        })
    }
}
