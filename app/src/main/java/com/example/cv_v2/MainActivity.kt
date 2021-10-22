package com.example.cv_v2

import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.cv_v2.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
     //   setContentView(R.layout.activity_main)


        //get intent
        val intent = intent

        val ass = intent.getIntExtra("AndroidSkill",1)
        val ioss = intent.getIntExtra("iosSkill",1)
        val fss= intent.getIntExtra("flutterSkill",1)
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

        val pic = intent.getStringExtra("Image")
        println("pic : $pic")

        val myUri = Uri.parse(pic);
        println("myUri : $myUri")


        binding.profileImg.setImageURI(myUri)
        binding.name.text="$fname"
        binding.email.text="$email"



        /*   binding.age.text="Age : $age"
            binding.HF.text="Gender : $gender"
            binding.languages.text="languages : $arabic"
            binding.AndroidSkill.text="Android skill : $Android"
            binding.IOsSkill.text="Ios skill : $IOS"
            binding.FlutterSkill.text="Flutter skill : $Flutter"
            binding.languages.text="Languages : $arabic $English $French"
            binding.hobbies.text="Hobbies : $Music $Sport $games"
        */
        val bundle = intent.getBundleExtra("bundle")

        val androidskill = bundle?.getInt("Android")
        val flutterskill = bundle?.getInt("Flutter")
        val iosskill = bundle?.getInt("IOS")

        replaceFrag(Skillsfrag.newInstance(intent.getIntExtra("AndroidSkill",1),intent.getIntExtra("iosSkill",1),intent.getIntExtra("flutterSkill",1)))

    }


    private fun replaceFrag(fragment: Fragment)
    {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()

        fragmentTransaction.replace(R.id.fragmentContainer, fragment)
        fragmentTransaction.commit()

    }

    fun SkillsFrag(view: android.view.View) {
        replaceFrag(Skillsfrag.newInstance(intent.getIntExtra("AndroidSkill",1),intent.getIntExtra("iosSkill",1),intent.getIntExtra("flutterSkill",1)))

    }

    fun HobbiesFrag(view: android.view.View) {
        replaceFrag(HobbiesFrag.newInstance(intent.getBooleanExtra("MusicCheck",false),intent.getBooleanExtra("SportCheck",false),intent.getBooleanExtra("GamesCheck",false)))


    }
    fun LangFrag(view: android.view.View) {

        replaceFrag(LanguagesFrag.newInstance(intent.getBooleanExtra("ArabicCheck",false),intent.getBooleanExtra("EnglishCheck",false),intent.getBooleanExtra("FrenchCheck",false)))


    }



}

