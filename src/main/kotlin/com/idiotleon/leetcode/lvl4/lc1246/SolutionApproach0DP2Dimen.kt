/**
 * https://leetcode.com/problems/palindrome-removal/
 *
 * Time Complexity:     O(`nNums` ^ 3)
 * Space Complexity:    O(`nNums` ^ 2)
 *
 * References:
 *  https://leetcode.com/problems/palindrome-removal/discuss/418881/C++-O(N3)-13-lines-DP-with-explanation/583904
 *  https://leetcode.com/problems/palindrome-removal/discuss/418881/C%2B%2B-O(N3)-13-lines-DP-with-explanation
 */
package com.idiotleon.leetcode.lvl4.lc1246

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP2Dimen {
    fun minimumMoves(nums: IntArray): Int {
        val nNums = nums.size

        val dp = Array(nNums) { IntArray(nNums) { 0 } }

        for (idx in nums.indices) {
            dp[idx][idx] = 1
        }

        for (idx in 0 until nNums - 1) {
            dp[idx][idx + 1] = if (nums[idx] == nums[idx + 1]) 1 else 2
        }

        for (len in 3..nNums) {
            for (lo in 0 until nNums - len + 1) {
                val hi = lo + len - 1

                dp[lo][hi] = Int.MAX_VALUE

                if (nums[lo] == nums[hi]) {
                    dp[lo][hi] = dp[lo + 1][hi - 1]
                }

                for (k in lo until hi) {
                    dp[lo][hi] = minOf(dp[lo][hi], dp[lo][k] + dp[k + 1][hi])
                }
            }
        }

        return dp[0].last()
    }
}