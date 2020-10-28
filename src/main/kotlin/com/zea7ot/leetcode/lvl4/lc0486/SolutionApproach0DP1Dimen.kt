/**
 * https://leetcode.com/problems/predict-the-winner/
 *
 * Time Complexity:     O(`totalNums` ^ 2)
 * Space Complexity:    O(`totalNums`)
 *
 * References:
 *  https://leetcode.com/problems/predict-the-winner/discuss/96828/JAVA-9-lines-DP-solution-easy-to-understand-with-improvement-to-O(N)-space-complexity./101342
 *  https://leetcode.com/problems/predict-the-winner/discuss/96828/JAVA-9-lines-DP-solution-easy-to-understand-with-improvement-to-O(N)-space-complexity.
 */
package com.zea7ot.leetcode.lvl4.lc0486

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP1Dimen {
    fun predictTheWinner(nums: IntArray): Boolean {
        val totalNums = nums.size
        if ((totalNums and 1) == 0) return true

        val dp = IntArray(totalNums) { 0 }

        for (lo in nums.indices.reversed()) {
            for (hi in lo until totalNums) {
                if (lo == hi) dp[lo] = nums[lo]
                else dp[hi] = maxOf(nums[lo] - dp[hi], nums[hi] - dp[hi - 1])
            }
        }

        return dp.last() >= 0
    }
}