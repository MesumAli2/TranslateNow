package com.mesum.translatenow

import android.graphics.Color
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI


class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        supportActionBar?.hide()
        setToolbarTitle("Translate Now", toolbar);

        NavigationUI.setupWithNavController(toolbar, navController)

    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
    private fun setToolbarTitle(title: String, toolbar: Toolbar) {
        val spannableString = SpannableString(title)
        val startIndex = title.indexOf(" ")
        val endIndex = title.length
        spannableString.setSpan(
            ForegroundColorSpan(Color.parseColor("#999999")),
            0,
            startIndex,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        spannableString.setSpan(
            ForegroundColorSpan(Color.parseColor("#6e7276")),
            startIndex + 1,
            endIndex,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        toolbar!!.setTitle(spannableString)
    }

}