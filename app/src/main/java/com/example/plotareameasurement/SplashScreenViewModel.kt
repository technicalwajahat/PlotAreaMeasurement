/*
 *     Created by Technical Wajahat on 7/12/22, 5:19 PM
 *     wajahat.awan.924@gmail.com
 *     Last modified 7/12/22, 5:19 PM
 *     Copyright © 2022
 *     All rights reserved.
 */

package com.example.plotareameasurement

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashScreenViewModel : ViewModel() {
    private val _isDataLoaded = MutableLiveData<Boolean>(false)
    val isDataLoaded: LiveData<Boolean> = _isDataLoaded

    init {
        viewModelScope.launch {
            delay(2500)
            _isDataLoaded.value = true
        }
    }
}