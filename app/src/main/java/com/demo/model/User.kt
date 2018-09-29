package com.demo.model

class User(var name: String, var age: Int, var sex: String) {

    override fun toString(): String {
        return "姓名：$name\n年龄：$age\n性别：$sex"
    }
}