/**
 * if it is n-plets, instead of triplets, how to solve this problem?
 * https://leetcode.com/problems/triples-with-bitwise-and-equal-to-zero/
 *
 * Time Complexity:     O(`nplets` * (2 ^ 16))
 * Space Complexity:    O(`range` * `nplets`) ~ O(`nplets`)
 *
 * References:
 *  https://leetcode.com/problems/triples-with-bitwise-and-equal-to-zero/discuss/226721/Java-DP-O(3-*-216-*-n)-time-O(216)-space
 */
package com.zea7ot.leetcode.lvl4.lc0982.followups.followup0

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP2Dimen {
    fun countTriplets(nums: IntArray, nplets: Int): Int {
        val range = 1 shl 16

        val dp = Array(nplets + 1) { IntArray(range) { 0 } }.also {
            it[0][range - 1] = 1
        }

        for (n in 0 until nplets) {
            for (k in 0 until range) {
                for (num in nums) {
                    dp[n + 1][k and num] += dp[n][k]
                }
            }
        }

        return dp[nplets][0]
    }
}