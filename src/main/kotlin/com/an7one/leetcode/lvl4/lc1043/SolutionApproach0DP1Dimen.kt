/**
 * https://leetcode.com/problems/partition-array-for-maximum-sum/
 *
 * Time Complexity:     O(`totalNums` * `K`)
 * Space Complexity:    O(`totalNums`)
 *
 * `dp[i]`, max sum of (nums[1] ~ nums[i])
 *
 * Transition
 * dp[i] = max{dp[i - k] + k * max(nums[i - (k - 1) ~ i])}, 1 <= k <= min(i, K)
 *
 * Answer: dp[`totalNums`]
 *
 * References:
 *  https://www.youtube.com/watch?v=3M8q-wB2tmw
 *  https://leetcode.com/problems/partition-array-for-maximum-sum/discuss/290863/JavaC%2B%2BPython-DP
 */
package com.an7one.leetcode.lvl4.lc1043

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP1Dimen {
    fun maxSumAfterPartitioning(nums: IntArray, K: Int): Int {
        // sanity check
        if (nums.isEmpty()) return 0

        val totalNums = nums.size
        val dp = IntArray(totalNums + 1)

        for (idx in 1..totalNums) {
            var curMax = Int.MIN_VALUE
            for (k in 1..minOf(idx, K)) {
                curMax = maxOf(curMax, nums[idx - k])
                dp[idx] = maxOf(dp[idx], dp[idx - k] + curMax * k)
            }
        }

        return dp[totalNums]
    }
}