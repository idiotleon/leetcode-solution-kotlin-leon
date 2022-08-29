package com.an7one.leetcode.lvl4.lc0486

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/predict-the-winner/
 *
 * Time Complexity:     O(`nNums` ^ 2)
 * Space Complexity:    O(`nNums`)
 *
 * Reference:
 * https://leetcode.com/problems/predict-the-winner/discuss/96828/JAVA-9-lines-DP-solution-easy-to-understand-with-improvement-to-O(N)-space-complexity./101342
 * https://leetcode.com/problems/predict-the-winner/discuss/96828/JAVA-9-lines-DP-solution-easy-to-understand-with-improvement-to-O(N)-space-complexity.
 */
@Suppress(UNUSED)
class SolutionApproach0DP1Dimen {
    fun predictTheWinner(nums: IntArray): Boolean {
        val nNums = nums.size
        if ((nNums and 1) == 0) return true

        val dp = IntArray(nNums) { 0 }

        for (lo in nums.indices.reversed()) {
            for (hi in lo until nNums) {
                if (lo == hi) dp[lo] = nums[lo]
                else dp[hi] = maxOf(nums[lo] - dp[hi], nums[hi] - dp[hi - 1])
            }
        }

        return dp.last() >= 0
    }
}