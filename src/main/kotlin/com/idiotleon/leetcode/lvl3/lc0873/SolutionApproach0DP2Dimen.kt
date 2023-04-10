package com.idiotleon.leetcode.lvl3.lc0873

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/length-of-longest-fibonacci-subsequence/
 *
 * Time Complexity:     O(`nNums` ^ 2)
 * Space Complexity:    O(`nNums` ^ 2)
 *
 * dp[i][j] represents the longest fibonacci subsequence ending with `nums[i]` and `nums[j]`
 * dp[i][j] = (dp[j - i][i] + 1) or 2
 *
 * Reference:
 * https://leetcode.com/problems/length-of-longest-fibonacci-subsequence/discuss/165330/Java-beat-98-DP-%2B-2Sum
 */
@Suppress(UNUSED)
class SolutionApproach0DP2Dimen {
    fun lenLongestFibSubseq(nums: IntArray): Int {
        // sanity check
        if (nums.isEmpty()) return 0

        val nNums = nums.size

        val dp = Array(nNums) { IntArray(nNums) { 0 } }
        var longest = 0

        for (idx in 2 until nNums) {
            val target = nums[idx]

            var lo = 0
            var hi = idx - 1

            while (lo < hi) {
                val sum = nums[lo] + nums[hi]
                when {
                    sum > target -> --hi
                    sum < target -> ++lo
                    else -> {
                        dp[hi][idx] = 1 + dp[lo][hi]
                        longest = maxOf(longest, dp[hi][idx])
                        ++lo
                        --hi
                    }
                }
            }
        }

        if (longest > 0) longest += 2

        return longest
    }
}