/*
 *     Created by Technical Wajahat on 5/18/22, 5:52 PM
 *     wajahat.awan.924@gmail.com
 *     Last modified 5/18/22, 5:51 PM
 *     Copyright © 2022
 *     All rights reserved.
 */

package com.example.plotareameasurement

import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.method.LinkMovementMethod
import android.text.style.URLSpan
import androidx.appcompat.app.AppCompatActivity
import com.example.plotareameasurement.databinding.ActivityAboutBinding


class About : AppCompatActivity() {

    private lateinit var binding: ActivityAboutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val versionName: String = applicationContext.packageManager.getPackageInfo(
            applicationContext.packageName,
            0
        ).versionName

        "Version: $versionName".also { binding.textVersion.text = it }

        val string = SpannableString("More About")
        string.setSpan(
            URLSpan("https://facebook.com/TechnicalWajahat"),
            0,
            string.length,
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )

        binding.textMoreAbout.text = string
        binding.textMoreAbout.movementMethod = LinkMovementMethod.getInstance()
    }
}