/**
 * https://leetcode.com/problems/count-different-palindromic-subsequences/
 *
 * Time Complexity:     O()
 * Space Complexity:    O(0
 *
 * References:
 *  https://leetcode.com/problems/count-different-palindromic-subsequences/discuss/109507/Java-96ms-DP-Solution-with-Detailed-Explanation
 */
package com.zea7ot.leetcode.lvl4.lc0730

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP2Dimen1 {
    private companion object {
        private const val MOD = 1e9.toInt() + 7
    }

    fun countPalindromicSubsequences(str: String): Int {
        val lenS = str.length

        val dp = Array(lenS) { IntArray(lenS) { 0 } }
        for (idx in str.indices) {
            dp[idx][idx] = 1
        }

        for (len in 1 until lenS) {
            for (low in 0 until lenS - len) {
                val high = low + len

                if (str[low] == str[high]) {
                    var lo = low + 1
                    var hi = high - 1

                    while (lo <= hi && str[lo] != str[high]) ++lo
                    while (lo <= hi && str[hi] != str[high]) --hi

                    when {
                        lo > hi -> dp[low][high] = dp[low + 1][high - 1] * 2 + 2
                        lo == hi -> dp[low][high] = dp[low + 1][high - 1] * 2 + 1
                        else -> dp[low][high] = dp[low + 1][high - 1] * 2 - dp[lo + 1][hi - 1]
                    }
                } else {
                    dp[low][high] = dp[low][high - 1] + dp[low + 1][high] - dp[low + 1][high - 1]
                }

                dp[low][high] = if (dp[low][high] < 0) dp[low][high] + MOD else dp[low][high] % MOD
            }
        }

        return dp[0][lenS - 1]
    }
}