/**
 * https://leetcode.com/problems/split-array-with-same-average/
 *
 * Time Complexity:     O((`nNums` ^ 2) * `totalSum`)
 * Space Complexity:    O(`nNums` * `totalSum`)
 *
 * References:
 *  https://leetcode.com/problems/split-array-with-same-average/discuss/120667/C++-Solution-with-explanation-early-termination-(Updated-for-new-test-case)/121321
 *  https://leetcode.com/problems/split-array-with-same-average/discuss/120667/C%2B%2B-Solution-with-explanation-early-termination-(Updated-for-new-test-case)
 */
package com.zea7ot.leetcode.lvl4.lc0805

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP2Dimen {
    fun splitArraySameAverage(nums: IntArray): Boolean {
        val nNums = nums.size
        val totalSum = nums.sum()

        val dp = Array(totalSum + 1) { BooleanArray(nNums / 2 + 1) { false } }
        dp[0][0] = true

        for (num in nums) {
            for (sum in totalSum downTo num) {
                for (k in 1..nNums / 2) {
                    dp[sum][k] = dp[sum][k] || dp[sum - num][k - 1]
                }
            }
        }

        for (idx in 1..nNums / 2) {
            if (totalSum * idx % nNums == 0 && dp[totalSum * idx / nNums][idx]) return true
        }

        return false
    }
}