/**
 * https://leetcode.com/problems/find-the-minimum-number-of-fibonacci-numbers-whose-sum-is-k/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * References:
 *  https://leetcode.com/problems/find-the-minimum-number-of-fibonacci-numbers-whose-sum-is-k/discuss/585741/Java-Iterative-and-Intuitive-solution
 */
package com.zea7ot.leetcode.lvl3.lc1414

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP0Dimen {
    fun findMinFibonacciNumbers(K: Int): Int {
        if (K < 2) return K

        var a = 1
        var b = 1
        while (b <= K) {
            val temp = a
            a = b
            b += temp
        }

        var count = 0
        var k = K
        while (k != 0) {
            if (k >= b) {
                k -= b
                ++count
            }

            val temp = a
            a = b - a
            b = temp
        }

        return count
    }
}