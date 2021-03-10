/**
 * https://leetcode.com/problems/strange-printer/
 *
 * Time Complexity:     O(`lenS` ^ 3)
 * Space Complexity:    O(`lenS` ^ 2)
 *
 * References:
 *  https://leetcode.com/problems/strange-printer/discuss/106793/Java-solution-DP/109124
 *  https://leetcode.com/problems/strange-printer/discuss/106793/Java-solution-DP
 *  https://leetcode.com/problems/strange-printer/discuss/106810/Java-O(n3)-DP-Solution-with-Explanation-and-Simple-Optimization
 *  https://leetcode.com/problems/strange-printer/discuss/152758/Clear-Logical-Thinking-with-Code
 */
package com.an7one.leetcode.lvl4.lc0664

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP2Dimen {
    fun strangePrinter(str: String): Int {
        if (str.isEmpty()) return 0

        val lenS = str.length

        val dp = Array(lenS) { IntArray(lenS) { lenS } }
        for (idx in 0 until lenS) {
            dp[idx][idx] = 1
        }

        for (len in 1..lenS) {
            for (lo in 0 until lenS - len + 1) {
                val hi = lo + len - 1

                dp[lo][hi] = len

                for (mid in lo until hi) {
                    val localMin =
                        dp[lo][mid] + dp[mid + 1][hi] - if (str[lo] == str[mid + 1] || str[mid] == str[hi]) 1 else 0

                    dp[lo][hi] = minOf(dp[lo][hi], localMin)
                }
            }
        }

        return dp[0][lenS - 1]
    }
}