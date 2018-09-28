package com.example.demo.demo

import android.app.Activity
import android.os.Bundle
import android.webkit.JsPromptResult
import android.webkit.WebChromeClient
import android.webkit.WebView
import com.example.demo.demo.R.id.myWeb
import kotlinx.android.synthetic.main.activity_main.*

class BestActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myWeb.webChromeClient = object : WebChromeClient() {
            override fun onJsPrompt(view: WebView, url: String, message: String, defaultValue: String, result: JsPromptResult): Boolean {
                result.confirm()
                return super.onJsPrompt(view, url, message, defaultValue, result)
            }
        }

        /**
         * 我是合并测试数据啊
         */


        myWeb.contentHeight

    }


}
