package com.an7one.leetcode.lvl4.lc0486

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/predict-the-winner/
 *
 * Time Complexity:     O(`nNums` ^ 2)
 * Space Complexity:    O(`nNums` ^ 2)
 *
 * `dp[lo][hi]`, the most scores player1 can achieve in the subarray from `lo`(index) to `hi`(index), both inclusive
 *
 * References:
 *  https://leetcode.com/problems/predict-the-winner/discuss/96828/JAVA-9-lines-DP-solution-easy-to-understand-with-improvement-to-O(N)-space-complexity.
 */
@Suppress(UNUSED)
class SolutionApproach0DP2Dimen {
    fun predictTheWinner(nums: IntArray): Boolean {
        val nNums = nums.size

        val dp = Array(nNums) { row -> IntArray(nNums) { col -> if (row == col) nums[row] else 0 } }

        for (len in 1 until nNums) {
            for (lo in 0 until nNums - len) {
                val hi = lo + len
                dp[lo][hi] = maxOf(
                    nums[lo] - dp[lo + 1][hi], nums[hi] - dp[lo][hi - 1]
                )
            }
        }

        return dp[0][nNums - 1] >= 0
    }
}