/**
 * https://leetcode.com/problems/partition-equal-subset-sum/
 *
 * Time Complexity:     O(`nNums` * `volume`)
 * Space Complexity:    O(`volume`)
 *
 * the characteristic of Knapsack problems is that
 *  its time and space complexity is highly related
 *  to the range, in this case the `volume`, of the actual problem
 *
 * References:
 *  https://youtu.be/r6I-ikllNDM
 *  http://zxi.mytechroad.com/blog/dynamic-programming/leetcode-416-partition-equal-subset-sum/
 */
package com.zea7ot.leetcode.lvl3.lc0416

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0Knapsack {
    fun canPartition(nums: IntArray): Boolean {
        // not used
        // val nNums = nums.size

        val volume = nums.sum()
        if (volume % 2 == 1) return false

        val targetSum = volume / 2
        val dp = BooleanArray(targetSum + 1) { idx -> idx == 0 }

        for (num in nums) {
            for (sum in targetSum downTo 0) {
                if (dp[sum]) {
                    val newSum = sum + num
                    if (newSum > targetSum) continue
                    dp[newSum] = true
                }

                if (dp.last()) return true
            }
        }

        return false
    }
}