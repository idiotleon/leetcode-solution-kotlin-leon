/**
 * @author: Leon
 * https://leetcode.com/problems/n-th-tribonacci-number/
 *
 * Time Complexity:     O(`n`)
 * Space Complexity:    O(1)
 */
package com.zea7ot.leetcode.lvl1.lc1137

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP0Dimen {
    fun tribonacci(n: Int): Int {
        return when (n) {
            0 -> 0
            1 -> 1
            2 -> 1
            else -> {
                var t0 = 0
                var t1 = 1
                var t2 = 1

                for (i in 1 until n) {
                    val t3 = t0 + t1 + t2
                    t0 = t1
                    t1 = t2
                    t2 = t3
                }

                t1
            }
        }
    }
}