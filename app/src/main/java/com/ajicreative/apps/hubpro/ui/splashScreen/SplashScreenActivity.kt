package com.ajicreative.apps.hubpro.ui.splashScreen

import android.content.Intent
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ajicreative.apps.hubpro.R
import com.ajicreative.apps.hubpro.databinding.ActivitySplashScreenBinding
import com.ajicreative.apps.hubpro.ui.welcome.WelcomeActivity
import java.util.*

class SplashScreenActivity : AppCompatActivity() {

    lateinit var binding : ActivitySplashScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        Timer().schedule(object : TimerTask() {
            override fun run() {
                val intent = Intent(this@SplashScreenActivity, WelcomeActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(intent)
            }
        }, 2000)


    }
}