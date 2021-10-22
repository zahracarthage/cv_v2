package com.example.cv_v2

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.provider.MediaStore
import android.text.TextUtils
import android.util.Patterns
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.cv_v2.databinding.Activity1Binding


class Activity1 : AppCompatActivity() {

    private lateinit var binding: Activity1Binding
    private var uri: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_1)
        binding = Activity1Binding.inflate(layoutInflater)
        setContentView(binding.root)
    }
    fun isValidEmail(target: CharSequence?): Boolean {
        return !TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches()
    }

    fun next(view: android.view.View) {

         if(check())
       {
            val intent = Intent(applicationContext,HobbiesActivity::class.java)

           intent.putExtra("fullName", binding.fullName.text.toString())
           intent.putExtra("Email", binding.email.text.toString())
           intent.putExtra("Age", binding.Age.text.toString())
           intent.putExtra("Gender", binding.gender.text.toString())
           intent.putExtra("Image", uri.toString())
           print(uri.toString())

           startActivity(intent)
            finish()
      }


    }
    private fun check(): Boolean {

        if(binding.fullName.text.isNullOrEmpty())
        {
            Toast.makeText(applicationContext,"please Enter your full name",Toast.LENGTH_SHORT).show()
            return false

        }
        if(binding.email.text.isNullOrEmpty() )
        {
            Toast.makeText(applicationContext, "Enter your E-mail",Toast.LENGTH_LONG).show()
            return false

        }


        if (!isValidEmail(binding.email.text))
        {
            Toast.makeText(getApplicationContext(),"invalid email address",Toast.LENGTH_SHORT).show()
            return false

        }
        if(binding.Age.text.isNullOrEmpty())
        {
            Toast.makeText(getApplicationContext(),"Invalid Age",Toast.LENGTH_SHORT).show()
            return false
        }
        else return true
    }

    private val pickImage = 100

    fun addImg(view: android.view.View) {
        val gallery = Intent(Intent.ACTION_OPEN_DOCUMENT, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
        startActivityForResult(gallery, pickImage)

    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK && data != null) {
            val imageUri:Uri? = data.data
            binding.acctImg.setImageURI(imageUri)
            uri = imageUri
        }
        else {binding.textButton.isEnabled=false
            Toast.makeText(getApplicationContext(),"choose an image", Toast.LENGTH_SHORT).show() }
    }

}