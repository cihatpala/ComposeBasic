package com.example.composebasic.unit2.pathway3

import junit.framework.TestCase.assertEquals
import org.junit.Test
import java.text.NumberFormat

//Local Test
class TipCalculatorTests {
    @Test
    fun calculateTip_20PercentNoRoundup() {
        val amount = 10.00
        val tipPercent = 20.00
        val expectedTip = NumberFormat.getCurrencyInstance().format(2)
        val actualTip = calculateTipX(amount = amount, tipPercent = tipPercent, false)
        assertEquals(expectedTip, actualTip)
    }
}