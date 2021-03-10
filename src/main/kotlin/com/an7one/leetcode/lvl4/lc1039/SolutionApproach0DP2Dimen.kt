/**
 * https://leetcode.com/problems/minimum-score-triangulation-of-polygon/
 *
 * Time Complexity:     O(`nNums` ^ 3)
 * Space Complexity:    O(`nNums` ^ 2)
 *
 * References:
 *  https://leetcode.com/problems/minimum-score-triangulation-of-polygon/discuss/286705/JavaC%2B%2BPython-DP
 *  https://leetcode.com/problems/minimum-score-triangulation-of-polygon/discuss/286753/C%2B%2B-with-picture
 */
package com.an7one.leetcode.lvl4.lc1039

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP2Dimen {
    fun minScoreTriangulation(nums: IntArray): Int {
        val nNums = nums.size

        val dp = Array(nNums) { IntArray(nNums) { 0 } }
        for (lo in nums.indices.reversed()) {
            for (hi in lo + 2 until nNums) {
                dp[lo][hi] = Int.MAX_VALUE
                for (k in lo + 1 until hi) {
                    dp[lo][hi] = minOf(
                        dp[lo][hi],
                        dp[lo][k] + nums[lo] * nums[k] * nums[hi] + dp[k][hi]
                    )
                }
            }
        }

        return dp[0].last()
    }
}