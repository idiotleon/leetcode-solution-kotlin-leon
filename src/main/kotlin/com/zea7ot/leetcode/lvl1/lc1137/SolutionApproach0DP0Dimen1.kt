/**
 * https://leetcode.com/problems/n-th-tribonacci-number/
 *
 * Time Complexity:     O(`n`)
 * Space Complexity:    O(1)
 *
 * References:
 *  https://leetcode.com/problems/n-th-tribonacci-number/discuss/345236/JavaC++Python-Straight-Forward/394058
 */
package com.zea7ot.leetcode.lvl1.lc1137

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP0Dimen1 {
    private companion object {
        private const val MOD = 4
    }

    fun tribonacci(n: Int): Int {
        val tribo = intArrayOf(0, 1, 1, 2)
        for (i in 4..n) {
            tribo[i % MOD] = tribo[(i - 1) % MOD] + tribo[(i - 2) % MOD] + tribo[(i - 3) % MOD]
        }

        return tribo[n % MOD]
    }
}