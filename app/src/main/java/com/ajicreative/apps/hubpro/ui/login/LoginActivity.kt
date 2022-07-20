package com.ajicreative.apps.hubpro.ui.login


import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.text.InputType
import androidx.appcompat.app.AppCompatActivity
import com.ajicreative.apps.hubpro.R
import com.ajicreative.apps.hubpro.databinding.ActivityLoginBinding
import com.ajicreative.apps.hubpro.ui.forgetpassword.ForgetPasswordActivity
import com.ajicreative.apps.hubpro.ui.home.HomeActivity

class LoginActivity : AppCompatActivity() {

    private var passwordVisibility = false
    lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        binding.back.setOnClickListener {
            finish()
        }


        binding.passwordVisibility.setOnClickListener {
            if (!passwordVisibility){
                passwordVisibility = true
                binding.passwordVisibility.setImageResource(R.drawable.ic_password_visibile_off)
                binding.materialPassword.inputType = InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
                binding.materialPassword.setSelection(binding.materialPassword.text.length)
            }else{
                passwordVisibility = false
                binding.passwordVisibility.setImageResource(R.drawable.ic_password_visible)
                binding.materialPassword.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
                binding.materialPassword.setSelection(binding.materialPassword.text.length)
            }
        }

        binding.txtMotdepasseOublie.setOnClickListener {
            val intent = Intent(this, ForgetPasswordActivity::class.java)
            startActivity(intent)
        }

        binding.btnSeConnect.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }

    }
}