/*
 *     Created by Technical Wajahat on 7/6/22, 3:51 PM
 *     wajahat.awan.924@gmail.com
 *     Last modified 7/6/22, 3:50 PM
 *     Copyright © 2022
 *     All rights reserved.
 */

package com.example.plotareameasurement

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.ViewTreeObserver
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.ViewModelProvider
import com.example.plotareameasurement.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val splashViewModel = ViewModelProvider(this)[SplashScreenViewModel::class.java]
        val content: View = findViewById(android.R.id.content)
        content.viewTreeObserver.addOnPreDrawListener(
            object : ViewTreeObserver.OnPreDrawListener {
                override fun onPreDraw(): Boolean {
                    if (splashViewModel.isDataLoaded.value == true) {
                        content.viewTreeObserver.removeOnPreDrawListener(this)
                    }
                    return false
                }
            }
        )

        setSupportActionBar(binding.mainToolBar)

        val listNumber: ArrayList<String> = ArrayList()
        listNumber.add("2")
        listNumber.add("3")

        val arrayAdapter = ArrayAdapter(
            this, R.layout.dropdown_item, listNumber
        )
        binding.AutoCompleteText.setAdapter(arrayAdapter)

        binding.AutoCompleteText.setOnItemClickListener { _, view, position, _ ->
            binding.btnGo.setOnClickListener {
                if (position == 0) Intent(this, DashboardActivity::class.java).also {
                    it.putExtra(
                        "Side", (view as TextView).text.toString()
                    )
                    startActivity(it)
                }
                if (position == 1) Intent(this, DashboardActivity::class.java).also {
                    it.putExtra(
                        "Side", (view as TextView).text.toString()
                    )
                    startActivity(it)
                }
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        (menuInflater).apply {
            inflate(R.menu.option_menu, menu)
        }
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.settings -> {
                val settingIntent = Intent(this, Setting::class.java)
                startActivity(settingIntent)
                true
            }
            R.id.feedback -> {
                true
            }
            R.id.about -> {
                val aboutIntent = Intent(this, About::class.java)
                startActivity(aboutIntent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
