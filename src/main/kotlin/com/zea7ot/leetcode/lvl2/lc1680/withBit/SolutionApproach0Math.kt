/**
 * https://leetcode.com/problems/concatenation-of-consecutive-binary-numbers/
 *
 * Time Complexity:     O(`n`)
 * Space Complexity:    O(1)
 *
 * References:
 *  https://leetcode.com/problems/concatenation-of-consecutive-binary-numbers/discuss/961350/C%2B%2B-O(N)-time-iterative
 */
package com.zea7ot.leetcode.lvl2.lc1680.withBit

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0Math {
    private companion object {
        private const val MOD = 1e9.toInt() + 7
    }

    fun concatenatedBinary(n: Int): Int {
        var decimal = 0L
        var len = 0

        for (num in 1..n) {
            if ((num and (num - 1)) == 0) ++len
            decimal = ((decimal shl len) % MOD + num) % MOD
        }

        return decimal.toInt()
    }
}