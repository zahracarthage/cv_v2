package com.example.cv_v2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import androidx.fragment.app.Fragment

private const val arg_android_skill = "Android"
private const val arg_Ios_skill = "IOS"
private const val arg_flutter_skill= "Flutter"

class Skillsfrag : Fragment() {
    private var androidskill: Int? = null
    private var iosskill: Int? = null
    private var flutterksill: Int? =null


   // public static myfrag

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            androidskill = it.getInt(arg_android_skill)
            iosskill = it.getInt(arg_Ios_skill)
            flutterksill= it.getInt(arg_flutter_skill)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        val view = inflater.inflate(R.layout.fragment_skillsfrag, container, false)
        val androidSkill = view.findViewById<SeekBar>(R.id.androidBar)
        val IosSkill = view.findViewById<SeekBar>(R.id.IosBar)
        val flutterSkill= view.findViewById<SeekBar>(R.id.FlutterSkill)

        if(arguments!=null)
        {
            androidskill=arguments?.getInt(arg_android_skill)
            iosskill=arguments?.getInt(arg_Ios_skill)
            flutterksill= arguments?.getInt(arg_flutter_skill)


        }

        androidSkill.progress = androidskill ?:0
        IosSkill.progress = iosskill ?:0
        flutterSkill.progress = flutterksill ?:0



        return view
    }


    companion object {
        @JvmStatic
        fun newInstance(
             param1: Int?,
             param2: Int?,
             param3:Int?
        ) =
            Skillsfrag().apply {
                arguments = Bundle().apply {
                    param1?.let {putInt(arg_android_skill, it)}
                    param2?.let {putInt(arg_Ios_skill, it)}
                    param3?.let {putInt(arg_flutter_skill, it)}

                }
            }
    }

}