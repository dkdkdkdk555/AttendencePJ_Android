package com.example.attendence

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import java.security.Key


class MainActivity : AppCompatActivity() {

    private lateinit var webView:WebView
    private lateinit var backPressHandler:BackPressCloseHandler
    private var nowUrl:String = KeyInfo.LOCAL_URL

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // WebView의 참조값 얻어오기
        webView = findViewById<WebView>(R.id.webView)
        // WebView 설정 객체 얻어오기
        val webViewSetter:WebSettings = webView.settings
        // 자바스크립트 해석 가능하도록 설정
        webViewSetter.javaScriptEnabled = true
        // WebView클라이언트 객체를 생성해서 넣어주기
        webView.webViewClient = WebViewClient()

        /*
        * 화면비율
         */
        // wid viewport를 사용하도록 설정
//        webView.settings.useWideViewPort = true
        //  zoom 미허용
//        webView.settings.builtInZoomControls = false

        webView.settings.useWideViewPort = false

        // 원하는 url 로딩시키기
        webView.loadUrl(nowUrl)

        backPressHandler = BackPressCloseHandler(this)
    }

    //
    override fun onBackPressed() {

        var webUrl = webView.url
        var list = webUrl?.split('?')
        var url = list?.get(0)

        if (url != null) {
            Log.d("splitedUrl : ", url)
        }

        if (url.equals(nowUrl + "user/main.do", true)) { // 메인페이지에서는 종료여부를 묻는다.
            backPressHandler.onBackPressed()
        } else if(url.equals(nowUrl, true) || url.equals(nowUrl + "home.do", true)){
            backPressHandler.onBackPressed()
        } else if(webView.canGoBack()){ // 현재페이지의 이전 페이지가 존재하면 true 반환
            webView.goBack()
        }

      // 출석탭내 페이지에서 뒤로가기시 메인페이지로 통일시키는건 파라미터를 받아와야하기 때문에 나중에 하자
//    } else if(webView.url.equals(nowUrl + "user/attend.do",true)){
//    } else if(webView.url.equals(nowUrl + "user/table_view.do", true)){
//    } else if(webView.url.equals(nowUrl + "/user/statistics.do", true)){
//    } else if(webView.url.equals(nowUrl + "/user/management.do", true)){}
    }
}