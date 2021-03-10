/**
 * https://leetcode.com/problems/combination-sum-iv/
 *
 * Time Complexity:     O(`nNums` * `target`)
 * Space Complexity:    O(`target`)
 *
 * References:
 *  https://leetcode.com/problems/combination-sum-iv/discuss/111860/Coin-change-AND-this-problem
 *  https://leetcode.com/problems/combination-sum-iv/discuss/85036/1ms-Java-DP-Solution-with-Detailed-Explanation
 *
 * Almost the same Problems:
 *  https://leetcode.com/problems/coin-change-2/
 */
package com.an7one.leetcode.lvl3.lc0377

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0Knapsack {
    fun combinationSum4(nums: IntArray, target: Int): Int {
        // not used
        // val nNums = nums.size

        val dp = IntArray(target + 1) { 0 }
        dp[0] = 1

        for (sum in 1..target) {
            for (num in nums) {
                if (sum >= num) {
                    dp[sum] += dp[sum - num]
                }
            }
        }

        return dp[target]
    }
}