package com.furqan.ilt_5_intermediate_android.unittest

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class CalculatorViewModelTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    private lateinit var viewModel: CalculatorViewModel

    @Before
    fun setUp() {
        viewModel = CalculatorViewModel()
    }

    @Test
    fun whenAddCalculationCalled_ShouldUpdateListCalculation() {
        val number1 = "1"
        val plus = "+"
        val number3 = "3"

        // when
        viewModel.addNewCalculationData(number1)
        viewModel.addNewCalculationData(plus)
        viewModel.addNewCalculationData(number3)

        // verify
        val data = viewModel.listCalculation.value
        assert(data != null)
        assert(data!![0] == number1)
        assert(data[1] == plus)
        assert(data[2] == number3)
    }

    @Test
    fun whenCalculateData_ShouldReturnCorrectValue() {
        viewModel.addNewCalculationData("1")
        viewModel.addNewCalculationData("+")
        viewModel.addNewCalculationData("3")

        // when
        val result = viewModel.calculateData()

        // verify
        assert(result == 4f)
    }

    @After
    fun tearDown() {
    }
}