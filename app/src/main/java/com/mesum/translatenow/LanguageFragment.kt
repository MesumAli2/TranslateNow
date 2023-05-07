package com.mesum.translatenow

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.fragment.app.Fragment

import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController

import com.google.mlkit.common.model.DownloadConditions
import com.google.mlkit.nl.languageid.LanguageIdentification
import com.google.mlkit.nl.translate.TranslateLanguage
import com.google.mlkit.nl.translate.Translation
import com.google.mlkit.nl.translate.TranslatorOptions
import com.mesum.translatenow.databinding.FragmentLanguageBinding

class LanguageFragment : Fragment() {

    private lateinit var binding: FragmentLanguageBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLanguageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listofLanguages = TranslateLanguage.getAllLanguages()

        for (i in listofLanguages){
            Log.d("LanguagesList", LanguageHelper().getLanguageName(i))
        }

        binding.translateFromTv.setOnClickListener {
            findNavController().navigate(R.id.languageSelectorFragment)
        }


        val languageIdentifier = LanguageIdentification.getClient()
        languageIdentifier.identifyLanguage("Hey you")
            .addOnSuccessListener { languageCode ->
                if (languageCode == "und") {
                    Log.i("TranlatedLanguage", "Can't identify language.")
                } else {
                    Log.i("TranlatedLanguage", "Language: $languageCode")

                    // Create an English-German translator:
                    val options = TranslatorOptions.Builder()
                        .setSourceLanguage(languageCode)
                        .setTargetLanguage(TranslateLanguage.ARABIC)
                        .build()
                    val englishGermanTranslator = Translation.getClient(options)

                    var conditions = DownloadConditions.Builder()
                        .requireWifi()
                        .build()
                    englishGermanTranslator.downloadModelIfNeeded(conditions)
                        .addOnSuccessListener {
                            // Model downloaded successfully. Okay to start translating.
                            // (Set a flag, unhide the translation UI, etc.)
                        }
                        .addOnFailureListener { exception ->
                            // Model couldn’t be downloaded or other internal error.
                            // ...
                        }

                    englishGermanTranslator.translate("")
                        .addOnSuccessListener { translatedText ->
                            // Translation successful.
                        }
                        .addOnFailureListener { exception ->
                            // Error.
                            // ...
                        }
                }
            }
            .addOnFailureListener {
                // Model couldn’t be loaded or other internal error.
                // ...
            }
    }
}
