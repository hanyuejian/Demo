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
import kotlinx.android.synthetic.main.fragment_first.*

/**
 * A simple [Fragment] subclass.
 *
 */
class FirstFragment : Fragment() {

    private var userViewModel: UserViewModel? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        userViewModel = activity?.let { ViewModelProviders.of(it).get(UserViewModel::class.java) }
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        firstText.setOnClickListener {
            userViewModel?.setUserInfo("刘亦菲", 20, "女")
        }

        userViewModel?.getUserInfo()?.observe(this, Observer {
            firstText.text = it.toString()
        })
    }
}
