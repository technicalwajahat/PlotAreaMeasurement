/*
 *     Created by Technical Wajahat on 7/6/22, 12:33 PM
 *     wajahat.awan.924@gmail.com
 *     Last modified 7/6/22, 12:33 PM
 *     Copyright © 2022
 *     All rights reserved.
 */

package com.example.plotareameasurement

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.plotareameasurement.databinding.ActivityDashboardBinding

class DashboardActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDashboardBinding

    override fun onResume() {
        super.onResume()

        val side = intent.getStringExtra("Side").apply {
            chooseSide(this)
        }

        binding.BottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.calculate_page -> {
                    this.chooseSide(side)
                    true
                }
                R.id.info_page -> {
                    replaceFragment(InfoFragment())
                    true
                }
                else -> false
            }
        }
    }

    private fun chooseSide(side: String?) {
        if (side.equals("2")) {
            replaceFragment(Calculate2Fragment())
        }

        if (side.equals("3")) {
            replaceFragment(CalculateFragment())
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.dashboardToolBar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager: FragmentManager = supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.layout_fragment, fragment)
        fragmentTransaction.commit()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.option_menu, menu)
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