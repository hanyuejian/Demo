package com.demo.viewModel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import com.demo.model.User

class UserViewModel(application: Application) : AndroidViewModel(application) {

    private val userData = MutableLiveData<User>()

    fun setUserInfo(name: String, age: Int, sex: String) {
        userData.postValue(User(name, age, sex))
    }

    fun getUserInfo(): MutableLiveData<User> {
        return userData
    }

}