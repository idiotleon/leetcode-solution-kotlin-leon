/**
 * https://leetcode.com/problems/numbers-at-most-n-given-digit-set/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * References:
 *  https://leetcode.com/problems/numbers-at-most-n-given-digit-set/discuss/168313/Java-Solution-with-explanation
 */
package com.zea7ot.leetcode.lvl4.lc0902

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED
import kotlin.math.pow

@Suppress(UNUSED)
class SolutionApproach0Dimen {
    fun atMostNGivenDigitSet(digits: Array<String>, n: Int): Int {
        val nDigits = digits.size
        val str = n.toString()
        val lenS = str.length

        var total = 0
        for (pow in 1 until lenS) {
            total += Math.pow(nDigits.toDouble(), pow.toDouble()).toInt()
        }

        for (idx in 0 until lenS) {
            var hasSameDigit = false

            for (digit in digits) {
                if (digit[0] < str[idx]) {
                    total += nDigits.toDouble().pow((lenS - idx - 1).toDouble()).toInt()
                } else if (digit[0] == str[idx]) {
                    hasSameDigit = true
                }
            }

            if (!hasSameDigit) return total
        }

        return 1 + total
    }
}