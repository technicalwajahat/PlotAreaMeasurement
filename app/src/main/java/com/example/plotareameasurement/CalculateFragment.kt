/*
 *     Created by Technical Wajahat on 5/20/22, 8:41 PM
 *     wajahat.awan.924@gmail.com
 *     Last modified 5/20/22, 8:41 PM
 *     Copyright © 2022
 *     All rights reserved.
 */

package com.example.plotareameasurement

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment
import com.example.plotareameasurement.databinding.FragmentCalculate3Binding
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar
import java.text.DecimalFormat
import kotlin.math.ceil
import kotlin.math.sqrt

class CalculateFragment : Fragment() {

    private lateinit var binding: FragmentCalculate3Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCalculate3Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnSubmit.setOnClickListener { calculateMeasurement(); hideKeyboard() }
    }

    private fun Fragment.hideKeyboard() {
        view?.let { activity?.hideKeyboard(it) }
    }

    private fun Context.hideKeyboard(view: View) {
        val inputMethodManager =
            getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }

    private fun calculateMeasurement() {

        val stringInput1 = binding.textInputEdit1.text.toString()
        val doubleInput1 = stringInput1.toDoubleOrNull()

        val stringInput2 = binding.textInputEdit2.text.toString()
        val doubleInput2 = stringInput2.toDoubleOrNull()

        val stringInput3 = binding.textInputEdit3.text.toString()
        val doubleInput3 = stringInput3.toDoubleOrNull()

        if (doubleInput1 == null || doubleInput2 == null || doubleInput3 == null) {
            displayValues(0.0, 0.0, 0.0, 0.0)
            return
        }

        var squareFeet = findSquareFeet(doubleInput1, doubleInput2, doubleInput3)
        var kanal = findKanal(squareFeet)
        var marla = findMarla(squareFeet)
        var acre = findAcre(squareFeet)

        if (squareFeet.isNaN() || kanal.isNaN() || marla.isNaN() || acre.isNaN()) {
            displaySnackbar()
            displayValues(0.0, 0.0, 0.0, 0.0)
            return
        }

        val roundUp = binding.switchRoundUp.isChecked
        if (roundUp) {
            squareFeet = ceil(squareFeet)
            kanal = ceil(kanal)
            marla = ceil(marla)
            acre = ceil(acre)
        }

        displayValues(squareFeet, marla, kanal, acre)
    }

    private fun displaySnackbar() {
        Snackbar.make(
            binding.mainLayout,
            "One side is bigger than the other two combined",
            Snackbar.LENGTH_SHORT
        ).setDuration(2000)
            .setAction("OK") {}
            .setAnimationMode(BaseTransientBottomBar.ANIMATION_MODE_SLIDE)
            .setTextColor(resources.getColor(R.color.white))
            .setBackgroundTint(resources.getColor(R.color.secondaryLightColor))
            .setActionTextColor(resources.getColor(R.color.warning))
            .show()
    }

    private fun displayValues(squareFeet: Double, marla: Double, kanal: Double, acre: Double) {
        val precision = DecimalFormat("##,##,###.##")

        binding.squareFeetAns.text = (precision.format(squareFeet)).toString()
        binding.marlaAns.text = (precision.format(marla)).toString()
        binding.kanalAns.text = (precision.format(kanal)).toString()
        binding.acreAns.text = (precision.format(acre)).toString()
    }

    private fun findAcre(squareFeet: Double): Double {
        return squareFeet / 43560
    }

    private fun findMarla(squareFeet: Double): Double {
        return squareFeet / 272.251
    }

    private fun findKanal(squareFeet: Double): Double {
        return squareFeet / 5445
    }

    private fun findSquareFeet(
        doubleInput1: Double,
        doubleInput2: Double,
        doubleInput3: Double
    ): Double {
        val s = (doubleInput1 + doubleInput2 + doubleInput3) / 2
        return sqrt(s * (s - doubleInput1) * (s - doubleInput2) * (s - doubleInput3))
    }
}