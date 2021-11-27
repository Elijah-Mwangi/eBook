package com.example.deved

import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_webview.*

class Webview : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_webview)
        mywebview.loadUrl("https://www.w3schools.com/html/default.asp")
        mywebview.webViewClient = object : WebViewClient(){
            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
//                when page is loading
                progressbar.visibility = View.VISIBLE
                super.onPageStarted(view, url, favicon)
            }
            override fun onPageFinished(view: WebView?, url: String?) {
//                when page is done/ finished loading the web page
                progressbar.visibility = View.GONE
                super.onPageFinished(view, url)
            }
        }
    }
    override fun onBackPressed() {
        if(mywebview.canGoBack()) {
//            True: user has a history of visited pages
            mywebview.goBack()
        }else run {
            //            False: user has not visited a page yet
            super.onBackPressed()
        }
    }
}