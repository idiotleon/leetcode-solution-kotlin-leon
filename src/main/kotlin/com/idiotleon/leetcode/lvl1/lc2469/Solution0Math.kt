package com.idiotleon.leetcode.lvl1.lc2469

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/convert-the-temperature/
 *
 * Time Complexity:     O(1)
 * Space Complexity:    O(1)
 */
@Suppress(UNUSED)
class Solution0Math {
    fun convertTemperature(celsius: Double): DoubleArray {
        val kelvin = celsius + 273.15
        val fahrenheit = celsius * 1.8 + 32.0

        return doubleArrayOf(kelvin, fahrenheit)
    }
}