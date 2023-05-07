package com.mesum.translatenow

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.mlkit.nl.translate.TranslateLanguage
import com.mesum.translatenow.databinding.FragmentLanguageBinding
import com.mesum.translatenow.databinding.FragmentLanguageSelectorBinding


private const val ARG_PARAM1 = "param1"

class LanguageSelectorFragment : Fragment() {
    private var param1: String? = null
    private lateinit var binding: FragmentLanguageSelectorBinding
    private var rvAdapter : LanguageListAdapter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLanguageSelectorBinding.inflate(inflater, container ,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val languages = TranslateLanguage.getAllLanguages()

        rvAdapter = LanguageListAdapter(languages)
        binding.rvLanguage.adapter = rvAdapter


    }

}