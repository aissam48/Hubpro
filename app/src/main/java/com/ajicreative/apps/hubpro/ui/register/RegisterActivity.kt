package com.ajicreative.apps.hubpro.ui.register

import android.content.ActivityNotFoundException
import android.content.Intent
import android.content.pm.ActivityInfo
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.text.InputType
import android.view.View
import com.ajicreative.apps.hubpro.R
import com.ajicreative.apps.hubpro.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    lateinit var binding: ActivityRegisterBinding
    private var passwordVisibility = false
    private var passwordConfirmerVisibility = false
    private val REQUEST_IMAGE_CAPTURE = 1
    private var choose = true


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
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

        binding.passwordConfirmerVisibility.setOnClickListener {

            if (!passwordConfirmerVisibility){
                passwordConfirmerVisibility = true
                binding.passwordConfirmerVisibility.setImageResource(R.drawable.ic_password_visibile_off)
                binding.materialConfirmPassword.inputType = InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
                binding.materialConfirmPassword.setSelection(binding.materialConfirmPassword.text.length)

            }else{
                passwordConfirmerVisibility = false
                binding.passwordConfirmerVisibility.setImageResource(R.drawable.ic_password_visible)
                binding.materialConfirmPassword.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
                binding.materialConfirmPassword.setSelection(binding.materialConfirmPassword.text.length)

            }
        }


        binding.contraintExtraitDeKbis.setOnClickListener {
            dispatchTakePictureIntent()
        }

        binding.carteCameraImg.setOnClickListener {
            dispatchTakePictureIntent()
        }

        binding.functionChoose.setOnClickListener {

            if (choose){
                binding.listChoose.visibility = View.GONE
                binding.functionChoose.rotation = -90F
                choose = false
            }else{
                binding.listChoose.visibility = View.VISIBLE
                binding.functionChoose.rotation = 90F
                choose = true
            }
        }


    }

    private fun dispatchTakePictureIntent() {
        val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        try {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
        } catch (e: ActivityNotFoundException) {
            // display error state to the user
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            val imageBitmap = data?.extras?.get("data") as Bitmap
        }
    }
}