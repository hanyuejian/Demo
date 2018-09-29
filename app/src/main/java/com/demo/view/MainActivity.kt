package com.demo.view

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.FragmentActivity
import com.demo.R
import com.demo.viewModel.UserViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : FragmentActivity() {

    private lateinit var userViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().add(R.id.firstFragment,FirstFragment()).add(R.id.secondFragment,SecondFragment()).commit()

        userViewModel = ViewModelProviders.of(this).get(UserViewModel::class.java)

        myText.setOnClickListener {
            userViewModel.setUserInfo("胡歌", 22, "男")
        }

        userViewModel.getUserInfo().observe(this, Observer {
            myText.text=it.toString()
        })
    }
}
