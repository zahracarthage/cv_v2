package com.example.cv_v2

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.cv_v2.databinding.ActivityHobbiesBinding

class HobbiesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHobbiesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_hobbies)
        binding = ActivityHobbiesBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun next(view: android.view.View) {


        val intent = Intent(applicationContext,MainActivity::class.java)
        val bundle = getIntent().extras
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        intent.putExtra("Android", binding.androidBar.progress.toString())
        intent.putExtra("Ios", binding.IosBar.progress.toString())
        intent.putExtra("Flutter", binding.FlutterSkill.progress.toString())
        if(binding.arabic.isChecked)
        {
            intent.putExtra("Arabic", binding.arabic.text.toString()    )

        }
        else             intent.putExtra("Arabic", "")

        if(binding.english.isChecked)
        {
            intent.putExtra("English", binding.english.text.toString())

        }
        else             intent.putExtra("English", "")

        if(binding.french.isChecked)
        {
            intent.putExtra("French", binding.french.text.toString())

        }
        else             intent.putExtra("French", "")

        if(binding.music.isChecked)
        {
            intent.putExtra("Music", binding.music.text.toString())

        }
        else             intent.putExtra("Music", "")

        if(binding.sport.isChecked)
        {
            intent.putExtra("Sport", binding.sport.text.toString())

        }
        else             intent.putExtra("Sport", "")

        if(binding.games.isChecked)
        {
            intent.putExtra("Games", binding.games.text.toString())

        }
        else             intent.putExtra("Games", "")

        startActivity(intent)
        finish()


    }
}