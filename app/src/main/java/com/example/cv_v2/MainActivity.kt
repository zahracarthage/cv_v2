package com.example.cv_v2

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.cv_v2.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //get intent
        val intent = intent
        val arabic = intent.getStringExtra("Arabic")
        val fname=intent.getStringExtra("fullName")
        val email = intent.getStringExtra("Email")
        val age = intent.getStringExtra("Age")
        val gender = intent.getStringExtra("Gender")
        val Android = intent.getStringExtra("Android")
        val IOS = intent.getStringExtra("Ios")
        val Flutter = intent.getStringExtra("Flutter")
        val English = intent.getStringExtra("English")
        val French = intent.getStringExtra("French")
        val Music = intent.getStringExtra("Music")
        val Sport = intent.getStringExtra("Sport")
        val games = intent.getStringExtra("Games")



        //   binding.name.setText(arabic)
      //  binding.HF.setText(fname)

        binding.name.text="name : $fname"
        binding.email.text="Email : $email"
        binding.age.text="Age : $age"
        binding.HF.text="Gender : $gender"
        binding.languages.text="languages : $arabic"
        binding.AndroidSkill.text="Android skill : $Android"
        binding.IOsSkill.text="Ios skill : $IOS"
        binding.FlutterSkill.text="Flutter skill : $Flutter"
        binding.languages.text="Languages : $arabic $English $French"
        binding.hobbies.text="Hobbies : $Music $Sport $games"
    }




    }
