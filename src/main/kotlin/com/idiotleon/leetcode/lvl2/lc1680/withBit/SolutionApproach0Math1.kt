/**
 * https://leetcode.com/problems/concatenation-of-consecutive-binary-numbers/
 *
 * Time Complexity:     O(`n`)
 * Space Complexity:    O(1)
 *
 * References:
 *  https://leetcode.com/problems/concatenation-of-consecutive-binary-numbers/discuss/961446/Detailed-Thought-Process-with-Steps-Example-or-Java-8-1-Liner/784546
 *  https://leetcode.com/problems/concatenation-of-consecutive-binary-numbers/discuss/961446/Detailed-Thought-Process-with-Steps-Example-or-Java-8-1-Liner
 */
package com.idiotleon.leetcode.lvl2.lc1680.withBit

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import kotlin.math.log

@Suppress(UNUSED)
class SolutionApproach0Math1 {
    private companion object {
        private const val MOD = 1e9.toInt() + 7
    }

    fun concatenatedBinary(n: Int): Int {
        var decimalValue = 0L
        for (num in 1..n) {
            val bitLen = log(num.toDouble(), 2.0).toInt() + 1

            decimalValue = ((decimalValue shl bitLen) + num) % MOD
        }

        return decimalValue.toInt()
    }
}