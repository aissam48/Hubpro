package com.ajicreative.apps.hubpro.ui.welcome

import android.content.Intent
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ajicreative.apps.hubpro.R
import com.ajicreative.apps.hubpro.databinding.ActivityWelcomeBinding
import com.ajicreative.apps.hubpro.ui.login.LoginActivity
import com.ajicreative.apps.hubpro.ui.register.RegisterActivity

class WelcomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityWelcomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT


        binding.btnSeCreer.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        binding.btnSeConnect.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}