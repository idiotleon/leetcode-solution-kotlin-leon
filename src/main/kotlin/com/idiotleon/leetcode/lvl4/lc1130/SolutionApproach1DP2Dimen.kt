/**
 * https://leetcode.com/problems/minimum-cost-tree-from-leaf-values/
 *
 * Time Complexity:     O(`nNums` ^ 3)
 * Space Complexity:    O(`nNums` ^ 2)
 *
 * dp[i, j] = dp[i, k] + dp[k + 1, j] + max(nums[i, k]) * max(nums[k + 1, j])
 *
 * References:
 *  https://leetcode.com/problems/minimum-cost-tree-from-leaf-values/discuss/340027/Java-DP-easy-to-understand
 *  https://leetcode.com/problems/minimum-cost-tree-from-leaf-values/discuss/340489/Summary-and-reasoning-of-different-solutions
 */
package com.idiotleon.leetcode.lvl4.lc1130

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach1DP2Dimen {
    fun mctFromLeafValues(nums: IntArray): Int {
        val nNums = nums.size
        val dp = Array(nNums) { IntArray(nNums) { 0 } }

        for (level in 2..nNums) {
            for (lo in 0..nNums - level) {
                val hi = lo + level - 1

                for (k in lo until hi) {
                    dp[lo][hi] = if (dp[lo][hi] != 0) {
                        minOf(dp[lo][hi], dp[lo][k] + dp[k + 1][hi] + (getMax(lo, k, nums) * getMax(k + 1, hi, nums)))
                    } else {
                        dp[lo][k] + dp[k + 1][hi] + (getMax(lo, k, nums) * getMax(k + 1, hi, nums))
                    }
                }
            }
        }

        return dp[0][nNums - 1]
    }

    private fun getMax(lo: Int, hi: Int, nums: IntArray): Int {
        var max = Int.MIN_VALUE
        for (k in lo..hi) {
            max = maxOf(max, nums[k])
        }
        return max
    }
}