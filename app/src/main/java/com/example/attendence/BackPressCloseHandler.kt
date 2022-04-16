package com.example.attendence

import android.app.Activity
import android.widget.Toast


class BackPressCloseHandler constructor (activity: MainActivity) {
    private var backKeyPressedTime: Long = 0
    private lateinit var guideToast:Toast

    private var activity: Activity =  activity

    fun onBackPressed() {
        if (System.currentTimeMillis() > backKeyPressedTime + 2000) {
            backKeyPressedTime = System.currentTimeMillis()
            showGuide()
            return
        }
        if (System.currentTimeMillis() <= backKeyPressedTime + 2000) {
            activity.finish()
            guideToast.cancel()
        }
    }

    fun showGuide() {
        guideToast = Toast.makeText(
            activity,
            "뒤로 가기를 한번 더 누르면 종료됩니다.", Toast.LENGTH_SHORT
        )
        guideToast.show()
    }
}