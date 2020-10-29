/**
 * https://leetcode.com/problems/guess-number-higher-or-lower-ii/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * `dp[lo][hi]`, minimum money required (to cover the ever max expenses) in [lo, hi], both ends inclusive
 *
 * References:
 *  https://leetcode.com/problems/guess-number-higher-or-lower-ii/discuss/84764/Simple-DP-solution-with-explanation~~/89349
 *  https://img-blog.csdnimg.cn/20190831084454102.JPG
 *  https://leetcode.com/problems/guess-number-higher-or-lower-ii/discuss/84764/Simple-DP-solution-with-explanation~~
 *  https://leetcode.com/problems/guess-number-higher-or-lower-ii/discuss/84807/Java-commented-DP-solution
 */
package com.zea7ot.leetcode.lvl4.lc0375

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP2Dimen {
    fun getMoneyAmount(n: Int): Int {
        val dp = Array(n + 1) { IntArray(n + 1) { 0 } }
        for (hi in 2..n) {
            for (lo in hi - 1 downTo 0) {
                if (lo + 1 == hi) dp[lo][hi] = lo
                else {
                    var globalMin = Int.MAX_VALUE
                    for (k in lo + 1 until hi) {
                        // to pick `k`
                        // the max cost
                        val localMaxCost = k + maxOf(dp[lo][k - 1], dp[k + 1][hi])
                        // `globalMin` should be more than the local max cost
                        globalMin = minOf(globalMin, localMaxCost)
                    }
                    dp[lo][hi] = globalMin
                }
            }
        }

        return dp[1][n]
    }
}