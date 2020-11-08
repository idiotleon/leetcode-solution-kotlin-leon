/**
 * https://leetcode.com/problems/strange-printer/
 *
 * Time Complexity:     O(`lenS` ^ 3)
 * Space Complexity:    O(`lenS` ^ 2)
 *
 * References:
 *  https://leetcode.com/problems/strange-printer/discuss/106810/Java-O(n3)-DP-Solution-with-Explanation-and-Simple-Optimization
 */
package com.zea7ot.leetcode.lvl4.lc0664

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP2Dimen {
    fun strangePrinter(str: String): Int {
        // sanity check, required
        if (str.isEmpty()) return 0

        val lenS = str.length

        val dp = Array(lenS) { IntArray(lenS) { 0 } }.also {
            for (idx in str.indices) {
                it[idx][idx] = 1

                if (idx < lenS - 1) {
                    it[idx][idx + 1] = if (str[idx] == str[idx + 1]) 1 else 2
                }
            }
        }

        for (len in 2 until lenS) {
            for (lo in 0 until lenS - len) {
                val hi = lo + len
                dp[lo][hi] = len + 1

                for (k in 0 until len) {
                    val turn = dp[lo][lo + k] + dp[lo + k + 1][hi]
                    dp[lo][hi] = minOf(dp[lo][hi],
                            if (str[lo + k] == str[hi]) turn - 1 else turn)
                }
            }
        }

        return dp[0][lenS - 1]
    }
}