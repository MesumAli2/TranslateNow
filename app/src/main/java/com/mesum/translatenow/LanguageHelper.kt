package com.mesum.translatenow

import android.graphics.Color
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan


class LanguageHelper {

    fun getLanguageName(languageCode: String): String {
        return when (languageCode) {
            "af" -> "Afrikaans"
            "sq" -> "Albanian"
            "ar" -> "Arabic"
            "be" -> "Belarusian"
            "bg" -> "Bulgarian"
            "bn" -> "Bengali"
            "ca" -> "Catalan"
            "zh" -> "Chinese"
            "hr" -> "Croatian"
            "cs" -> "Czech"
            "da" -> "Danish"
            "nl" -> "Dutch"
            "en" -> "English"
            "eo" -> "Esperanto"
            "et" -> "Estonian"
            "fi" -> "Finnish"
            "fr" -> "French"
            "gl" -> "Galician"
            "ka" -> "Georgian"
            "de" -> "German"
            "el" -> "Greek"
            "gu" -> "Gujarati"
            "ht" -> "Haitian Creole"
            "he" -> "Hebrew"
            "hi" -> "Hindi"
            "hu" -> "Hungarian"
            "is" -> "Icelandic"
            "id" -> "Indonesian"
            "ga" -> "Irish"
            "it" -> "Italian"
            "ja" -> "Japanese"
            "kn" -> "Kannada"
            "ko" -> "Korean"
            "lt" -> "Lithuanian"
            "lv" -> "Latvian"
            "mk" -> "Macedonian"
            "mr" -> "Marathi"
            "ms" -> "Malay"
            "mt" -> "Maltese"
            "no" -> "Norwegian"
            "fa" -> "Persian"
            "pl" -> "Polish"
            "pt" -> "Portuguese"
            "ro" -> "Romanian"
            "ru" -> "Russian"
            "sk" -> "Slovak"
            "sl" -> "Slovenian"
            "es" -> "Spanish"
            "sv" -> "Swedish"
            "sw" -> "Swahili"
            "tl" -> "Tagalog"
            "ta" -> "Tamil"
            "te" -> "Telugu"
            "th" -> "Thai"
            "tr" -> "Turkish"
            "uk" -> "Ukrainian"
            "ur" -> "Urdu"
            "vi" -> "Vietnamese"
            "cy" -> "Welsh"
            else -> ""
        }
    }




}