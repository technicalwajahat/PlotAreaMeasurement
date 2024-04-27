/*
 *     Created by Technical Wajahat on 3/20/22, 3:00 PM
 *     wajahat.awan.924@gmail.com
 *     Last modified 3/20/22, 2:57 PM
 *     Copyright © 2022
 *     All rights reserved.
 */

package com.example.plotareameasurement

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.plotareameasurement", appContext.packageName)
    }
}