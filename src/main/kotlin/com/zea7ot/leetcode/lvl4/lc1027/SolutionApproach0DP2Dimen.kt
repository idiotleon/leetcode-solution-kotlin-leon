/**
 * https://leetcode.com/problems/longest-arithmetic-sequence/
 *
 * Time Complexity:     O(`totalNums` ^ 2)
 * Space Complexity:    O(`totalNums` * (`RANGE` + `OFFSET`))
 *
 * References:
 *  https://leetcode.com/problems/longest-arithmetic-sequence/discuss/332097/JAVA-DP-O(n2)-no-HashMap-77ms-(beat-91.66)
 */
package com.zea7ot.leetcode.lvl4.lc1027

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP2Dimen {
    private companion object {
        private const val RANGE = 1e4.toInt()
        private const val OFFSET = 1e4.toInt()
    }

    fun longestArithSeqLength(nums: IntArray): Int {
        // sanity check
        if (nums.isEmpty()) return 0

        val totalNums = nums.size

        val dp = Array(totalNums) { IntArray(RANGE + OFFSET) { 1 } }

        var longest = 2

        for (hi in 1 until totalNums) {
            for (lo in 0 until hi) {
                val diff = nums[hi] - nums[lo] + OFFSET
                dp[hi][diff] = maxOf(dp[hi][diff], dp[lo][diff] + 1)

                longest = maxOf(longest, dp[hi][diff])
            }
        }

        return longest
    }
}