package com.example.attendence

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // WebView의 참조값 얻어오기
        val webView = findViewById<WebView>(R.id.webView)
        // WebView 설정 객체 얻어오기
        val webViewSetter:WebSettings = webView.settings
        // 자바스크립트 해석 가능하도록 설정
        webViewSetter.javaScriptEnabled = true
        // WebView클라이언트 객체를 생성해서 넣어주기
        webView.webViewClient = WebViewClient()
        // 원하는 url 로딩시키기
        webView.loadUrl("http://dkdkdkdk555.cafe24.com/")

    }
}