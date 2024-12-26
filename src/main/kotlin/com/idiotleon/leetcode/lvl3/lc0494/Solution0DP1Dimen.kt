package com.idiotleon.leetcode.lvl3.lc0494

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * https://leetcode.com/problems/target-sum/
 *
 * Time Complexity:     O(`nNums` * `range`)
 * Space Complexity:    O(`nNums`)
 *
 * Reference:
 * https://leetcode.com/problems/target-sum/discuss/97335/Short-Java-DP-Solution-with-Explanation
 * https://leetcode.com/problems/target-sum/discuss/97335/Short-Java-DP-Solution-with-Explanation/239358
 */
@Suppress(UNUSED)
class Solution0DP1Dimen {
    fun findTargetSumWays(nums: IntArray, target: Int): Int {
        val nNums = nums.size

        val totalSum = nums.sum()
        if (target > totalSum || target < -totalSum) {
            return 0
        }

        val range = 2 * totalSum + 1

        var dp = IntArray(range) { 0 }.also {
            it[0 + totalSum] = 1
        }

        for (idx in nums.indices) {
            val next = IntArray(range) { 0 }
            for (k in 0 until range) {
                if (dp[k] == 0) {
                    continue
                }

                next[k + nums[idx]] += dp[k]
                next[k - nums[idx]] += dp[k]
            }

            dp = next
        }

        return dp[totalSum + target]
    }
}