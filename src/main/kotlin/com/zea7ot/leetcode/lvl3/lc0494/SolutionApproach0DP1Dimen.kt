/**
 * https://leetcode.com/problems/target-sum/
 *
 * Time Complexity:     O(`totalNums` * `range`)
 * Space Complexity:    O(`totalNums`)
 *
 * References:
 *  https://leetcode.com/problems/target-sum/discuss/97335/Short-Java-DP-Solution-with-Explanation
 *  https://leetcode.com/problems/target-sum/discuss/97335/Short-Java-DP-Solution-with-Explanation/239358
 */
package com.zea7ot.leetcode.lvl3.lc0494

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP1Dimen {
    fun findTargetSumWays(nums: IntArray, S: Int): Int {
        // not used
        // val totalNums = nums.size

        val sum = nums.sum()
        if (S > sum || S < -sum) return 0

        val range = 2 * sum + 1

        var dp = IntArray(range) { 0 }
        dp[0 + sum] = 1

        for (i in nums.indices) {
            val next = IntArray(range) { 0 }
            for (k in 0 until range) {
                if (dp[k] == 0) continue

                next[k + nums[i]] += dp[k]
                next[k - nums[i]] += dp[k]
            }

            dp = next
        }

        return dp[sum + S]
    }
}