/**
 * @author: Leon
 *
 * References:
 *  Paid Course: https://www.acwing.com/video/27/
 */
package com.an7one.summary.math.primeNumber

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class IsPrimeNumber {

    /**
     * Time Complexity:     O(`num`)
     * Space Complexity:    O(1)
     */
    fun isPrimeNumLinear(num: Int): Boolean {
        if (num < 2) return false
        for (factor in 2 until num) {
            if (num % factor == 0) {
                return false
            }
        }

        return true
    }

    /**
     * Time Complexity:     O(sqrt(`num`)), strictly
     * Space Complexity:    O(1)
     */
    fun isPrimeNumLinearOptimized(num: Int): Boolean {
        if (num < 2) return false

        var factor = 2
        while (factor <= num / factor) {
            if (num % factor == 0) {
                return false
            }

            ++factor
        }

        return true
    }
}