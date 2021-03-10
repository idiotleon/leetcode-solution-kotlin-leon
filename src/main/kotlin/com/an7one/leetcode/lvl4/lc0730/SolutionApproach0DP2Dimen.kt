/**
 * https://leetcode.com/problems/count-different-palindromic-subsequences/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * References:
 *  https://leetcode.com/problems/count-different-palindromic-subsequences/discuss/109507/Java-96ms-DP-Solution-with-Detailed-Explanation/573658
 *  https://leetcode.com/problems/count-different-palindromic-subsequences/discuss/109507/Java-96ms-DP-Solution-with-Detailed-Explanation
 *  https://leetcode.com/problems/count-different-palindromic-subsequences/discuss/259568/Java-Simple-Code-just-rewrite-from-a-very-good-solution
 */
package com.an7one.leetcode.lvl4.lc0730

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP2Dimen {
    private companion object {
        private const val MOD = 1e9.toInt() + 7

        private const val RANGE_LETTER = 4
    }

    fun countPalindromicSubsequences(str: String): Int {
        val lenS = str.length

        val leftNext = getLeftNext(str)
        val rightNext = getRightNext(str)

        val dp = Array(lenS) { row -> IntArray(lenS) { col -> if (row == col) 1 else 0 } }

        for (len in 1 until lenS) {
            for (lo in 0 until lenS - len) {
                val hi = lo + len

                if (str[lo] != str[hi]) {
                    dp[lo][hi] = dp[lo][hi - 1] + dp[lo + 1][hi] - dp[lo + 1][hi - 1]
                } else {
                    val idxLeft = rightNext[lo]
                    val idxRight = leftNext[hi]

                    dp[lo][hi] = dp[lo + 1][hi - 1] * 2
                    if (idxLeft < idxRight) {
                        dp[lo][hi] -= dp[idxLeft + 1][idxRight - 1]
                    } else {
                        dp[lo][hi] += if (idxLeft == idxRight) 1 else 2
                    }
                }

                dp[lo][hi] = if (dp[lo][hi] < 0) dp[lo][hi] + MOD else dp[lo][hi] % MOD
            }
        }

        return dp[0][lenS - 1]
    }

    private fun getLeftNext(str: String): IntArray {
        val lenS = str.length

        val rec = IntArray(RANGE_LETTER) { -1 }
        val leftNext = IntArray(lenS) { 0 }
        for (idx in str.indices) {
            leftNext[idx] = rec[str[idx] - 'a']
            rec[str[idx] - 'a'] = idx
        }

        return leftNext
    }

    private fun getRightNext(str: String): IntArray {
        val lenS = str.length

        val rec = IntArray(RANGE_LETTER) { lenS }
        val rightNext = IntArray(lenS) { 0 }
        for (idx in str.indices.reversed()) {
            rightNext[idx] = rec[str[idx] - 'a']
            rec[str[idx] - 'a'] = idx
        }

        return rightNext
    }
}