/**
 * https://leetcode.com/problems/strange-printer/
 *
 * Time Complexity:     O(`lenS` ^ 3)
 * Space Complexity:    O(`lenS` ^ 2)
 *
 * References:
 *  https://leetcode.com/problems/strange-printer/discuss/106810/Java-O(n3)-DP-Solution-with-Explanation-and-Simple-Optimization/198971
 *  https://leetcode.com/problems/strange-printer/discuss/106810/Java-O(n3)-DP-Solution-with-Explanation-and-Simple-Optimization
 */
package com.idiotleon.leetcode.lvl4.lc0664

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP2Dimen1 {
    fun strangePrinter(str: String): Int {
        // sanity check, required
        if (str.isEmpty()) return 0

        val lenS = str.length

        val dp = Array(lenS) { idx1 -> IntArray(lenS) { idx2 -> if (idx1 == idx2) 1 else lenS } }

        for (hi in str.indices) {
            for (lo in hi downTo 0) {
                for (mid in lo until hi) {
                    val localMin = dp[lo][mid] + dp[mid + 1][hi] - if (str[mid] == str[hi]) 1 else 0
                    dp[lo][hi] = minOf(dp[lo][hi], localMin)
                }
            }
        }

        return dp[0][lenS - 1]
    }
}