/**
 * https://leetcode.com/problems/predict-the-winner/
 *
 * Time Complexity:     O(`totalNums` ^ 2)
 * Space Complexity:    O(`totalNums` ^ 2)
 *
 * `dp[start][end]`, the most scores player1 can achieve in the subarray from `start`(index) to `end`(index), both inclusive
 *
 * References:
 *  https://leetcode.com/problems/predict-the-winner/discuss/96828/JAVA-9-lines-DP-solution-easy-to-understand-with-improvement-to-O(N)-space-complexity.
 */
package com.zea7ot.leetcode.lvl4.lc0486

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP2Dimen {
    fun predictTheWinner(nums: IntArray): Boolean {
        val totalNums = nums.size

        val dp = Array(totalNums) { row -> IntArray(totalNums) { col -> if (row == col) nums[row] else 0 } }

        for (len in 1 until totalNums) {
            for (start in 0 until totalNums - len) {
                val end = start + len
                dp[start][end] = maxOf(nums[start] - dp[start + 1][end],
                        nums[end] - dp[start][end - 1])
            }
        }

        return dp[0][totalNums - 1] >= 0
    }
}