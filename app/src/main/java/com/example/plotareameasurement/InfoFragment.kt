/*
 *     Created by Technical Wajahat on 5/20/22, 8:41 PM
 *     wajahat.awan.924@gmail.com
 *     Last modified 5/20/22, 8:41 PM
 *     Copyright © 2022
 *     All rights reserved.
 */

package com.example.plotareameasurement

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.plotareameasurement.databinding.FragmentInfoBinding


class InfoFragment : Fragment() {

    private lateinit var binding: FragmentInfoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View {
        binding = FragmentInfoBinding.inflate(inflater, container, false)
        return binding.root
    }
}