package com.idiotleon.leetcode.lvl3.lc0416

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/partition-equal-subset-sum/
 *
 * Time Complexity:     O(`nNums` * `sumAll`)
 * Space Complexity:    O(`sumAll`)
 *
 * the characteristic of Knapsack problems is that
 *  its time and space complexity is highly related
 *  to the range, in this case the `sumAll`, of the actual problem
 *
 * Reference:
 * https://youtu.be/r6I-ikllNDM
 * http://zxi.mytechroad.com/blog/dynamic-programming/leetcode-416-partition-equal-subset-sum/
 */
@Suppress(UNUSED)
class SolutionApproach0Knapsack {
    fun canPartition(nums: IntArray): Boolean {
        // not used
        // val nNums = nums.size

        val sumAll = nums.sum()
        if (sumAll % 2 != 0) return false

        val sumTarget = sumAll / 2
        val dp = BooleanArray(1 + sumTarget) { false }.also {
            it[0] = true
        }

        for (num in nums) {
            for (sumCur in sumTarget downTo 0) {
                if (dp[sumCur]) {
                    val sumNew = sumCur + num
                    if (sumNew > sumTarget) continue
                    dp[sumNew] = true
                }

                if (dp.last()) return true
            }
        }

        return false
    }
}