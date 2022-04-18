package com.furqan.ilt_5_intermediate_android.unittest

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.furqan.ilt_5_intermediate_android.R

class CalculatorActivity : AppCompatActivity() {

    val calculatorViewModel: CalculatorViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)
    }
}