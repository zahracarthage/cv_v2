package com.example.cv_v2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.cv_v2.databinding.ActivityMainBinding
import com.example.cv_v2.databinding.FragmentHobbiesBinding

// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val arg_music = "music"
private const val arg_sport = "sport"
private const val arg_games = "games"
private lateinit var binding: FragmentHobbiesBinding



class HobbiesFrag : Fragment() {
    private var sport: Boolean? = false
    private var games = false
    private var music = false



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentHobbiesBinding.inflate(layoutInflater)
     //   setContentView(binding.root)

        arguments?.let {
            sport = it.getBoolean(arg_sport)
            music = it.getBoolean(arg_music)
            games = it.getBoolean(arg_games)


        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {


            if(arguments!=null)
        {

          

           if(arguments?.getBoolean(arg_music)==true)
            {
                true.let { binding.music.isChecked=it }
            }


            if(arguments?.getBoolean(arg_games)==true)
            {
                true.let { binding.games.isChecked=it }
            }

            if(arguments?.getBoolean(arg_sport)==true)
            {
                true.let { binding.sport.isChecked=it }
            }



        }
        binding.music.isEnabled=false
        binding.sport.isEnabled=false
        binding.games.isEnabled=false

        // Inflate the layout for this fragment
        return binding.root
    }

    companion object {

        @JvmStatic
        fun newInstance(
            param1: Boolean?,
            param2: Boolean?,
            param3: Boolean?
        ) =

            HobbiesFrag().apply {
                arguments = Bundle().apply {
                    param1?.let {putBoolean(arg_music, it)}
                    param2?.let {putBoolean(arg_games, it)}
                    param3?.let {putBoolean(arg_sport, it)}


                }
            }
    }
}