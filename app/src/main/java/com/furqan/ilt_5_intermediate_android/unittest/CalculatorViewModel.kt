package com.furqan.ilt_5_intermediate_android.unittest

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CalculatorViewModel : ViewModel() {

    // list of calculation
    private val mutableListCalculation = MutableLiveData<MutableList<String>>()
    val listCalculation: LiveData<MutableList<String>>
        get() = mutableListCalculation

    fun addNewCalculationData(data: String) {
        val existedList = mutableListCalculation.value ?: mutableListOf()
        existedList.add(data)
        mutableListCalculation.value = existedList
    }

    fun calculateData(): Float {
        var result: Float = 0f

        mutableListCalculation.value?.let {
            var lastOperation = ""
            for (item in it) {
                when (item) {
                    Symbol.PLUS.value, Symbol.MINUS.value, Symbol.MULTIPLY.value, Symbol.DIVIDE.value -> {
                        lastOperation = item
                    }
                    else -> {
                        if (lastOperation.isNotEmpty()) {
                            when (lastOperation) {
                                Symbol.PLUS.value -> {
                                    result += item.toFloat()
                                }
                                Symbol.MINUS.value -> {
                                    result -= item.toFloat()
                                }
                                Symbol.MULTIPLY.value-> {
                                    result *= item.toFloat()
                                }
                                Symbol.DIVIDE.value -> {
                                    result /= item.toFloat()
                                }
                            }
                        } else {
                            result = item.toFloat()
                        }
                    }
                }
            }
        }

        return result
    }

    enum class Symbol(val value: String) {
        PLUS("+"),
        MINUS("-"),
        MULTIPLY("*"),
        DIVIDE("/")
    }

}