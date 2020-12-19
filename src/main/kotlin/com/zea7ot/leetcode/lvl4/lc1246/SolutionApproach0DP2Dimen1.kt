/**
 * https://leetcode.com/problems/palindrome-removal/
 *
 * Time Complexity:     O(`nNums` ^ 3)
 * Space Complexity:    O(`nNums` ^ 2)
 *
 * References:
 *  https://leetcode.com/problems/palindrome-removal/discuss/418835/JavaC%2B%2BPython3-DP-with-Details-Comments
 */
package com.zea7ot.leetcode.lvl4.lc1246

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP2Dimen1 {
    fun minimumMoves(nums: IntArray): Int {
        val nNums = nums.size

        val dp = Array(nNums + 1) { IntArray(nNums + 1) { 0 } }

        for (len in 1..nNums) {
            for (lo in 0 until nNums - len + 1) {
                val hi = lo + len - 1

                if (len == 1) {
                    dp[lo][hi] = 1
                } else {
                    dp[lo][hi] = 1 + dp[lo + 1][hi]

                    if (nums[lo] == nums[lo + 1]) {
                        dp[lo][hi] = minOf(dp[lo][hi], dp[lo + 2][hi] + 1)
                    }

                    for (k in lo + 2..hi) {
                        if (nums[lo] == nums[k]) {
                            dp[lo][hi] = minOf(dp[lo][hi], dp[lo + 1][k - 1] + dp[k + 1][hi])
                        }
                    }
                }
            }
        }

        return dp[0][nNums - 1]
    }
}