/**
 * https://leetcode.com/problems/triples-with-bitwise-and-equal-to-zero/
 *
 * Time Complexity:     O(3 * (2 ^ 16) * `range`) ~ O(2 ^ 16)
 * Space Complexity:    O(2 ^ 16)
 *
 * References:
 *  https://leetcode.com/problems/triples-with-bitwise-and-equal-to-zero/discuss/226721/Java-DP-O(3-*-216-*-n)-time-O(216)-space
 */
package com.an7one.leetcode.lvl4.lc0982

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP1Dimen {
    fun countTriplets(nums: IntArray): Int {
        val range = 1 shl 16

        var dp = IntArray(range) { 0 }.also { it[range - 1] = 1 }

        for (n in 0 until 3) {
            val next = IntArray(range) { 0 }
            for (k in 0 until range) {
                for (num in nums) {
                    next[k and num] += dp[k]
                }
            }

            dp = next
        }

        return dp[0]
    }
}