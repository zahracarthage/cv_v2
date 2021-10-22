package com.example.cv_v2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.cv_v2.databinding.FragmentLanguagesBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val arg_arabic = "Arabic"
private const val arg_english = "English"
private const val arg_french = "French"
private lateinit var binding: FragmentLanguagesBinding


class LanguagesFrag : Fragment() {
    private var arabic: Boolean =false
    private var english: Boolean = false
    private var french: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentLanguagesBinding.inflate(layoutInflater)

        arguments?.let {
            arabic = it.getBoolean(arg_arabic)
            english = it.getBoolean(arg_english)
            french = it.getBoolean(arg_french)


        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if(arguments!=null)
            if (arguments?.getBoolean(arg_arabic)==true)
            {
                true.let { binding.arabic.isChecked=it }
            }

            if (arguments?.getBoolean(arg_english)==true)
            {
                true.let { binding.english.isChecked=it }
            }

            if (arguments?.getBoolean(arg_french)==true)
            {
                true.let { binding.french.isChecked=it }
            }

        binding.french.isEnabled=false
        binding.english.isEnabled=false
        binding.arabic.isEnabled=false

        // Inflate the layout for this fragment
        return binding.root
    }

    companion object {

        @JvmStatic
        fun newInstance(
            param1: Boolean, param2: Boolean, param3: Boolean) =
            LanguagesFrag().apply {
                arguments = Bundle().apply {
                    putBoolean(arg_arabic, param1)
                    putBoolean(arg_english, param2)
                    putBoolean(arg_french, param3)
                }
            }
    }
}