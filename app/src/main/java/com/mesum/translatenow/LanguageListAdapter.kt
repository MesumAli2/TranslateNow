package com.mesum.translatenow

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class LanguageListAdapter(private val languageList: List<String>) : RecyclerView.Adapter<LanguageListAdapter.LanguageViewHolder>() {

    inner class LanguageViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

        private val languageCodeTextView: TextView = view.findViewById(R.id.language_code_textview)
        private val languageNameTextView: TextView = view.findViewById(R.id.language_name_textview)

        fun bind(language: String) {
            languageCodeTextView.text = language
            languageNameTextView.text = LanguageHelper().getLanguageName(language)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LanguageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.language_item, parent, false)
        return LanguageViewHolder(view)
    }

    override fun onBindViewHolder(holder: LanguageViewHolder, position: Int) {
        val language = languageList[position]
        holder.bind(language)
    }


    override fun getItemCount(): Int {
        return languageList.size
    }
}
