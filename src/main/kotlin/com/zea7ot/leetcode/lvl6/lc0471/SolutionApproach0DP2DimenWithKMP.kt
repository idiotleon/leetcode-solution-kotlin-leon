/**
 * https://leetcode.com/problems/encode-string-with-shortest-length/
 *
 * Time Complexity:     O(`lenS` ^ 3)
 * Space Complexity:    O(`lenS` ^ 2)
 *
 * References:
 *  https://leetcode.com/problems/encode-string-with-shortest-length/discuss/95599/Accepted-Solution-in-Java/100040
 *  https://leetcode.com/problems/encode-string-with-shortest-length/discuss/95599/Accepted-Solution-in-Java
 */
package com.zea7ot.leetcode.lvl6.lc0471

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP2DimenWithKMP {
    fun encode(str: String): String {
        val lenS = str.length
        if (lenS <= 4) return str

        val dp = Array(lenS) { Array(lenS) { "" } }

        for (len in 0 until lenS) {
            for (lo in 0 until lenS - len) {
                val hi = lo + len
                val substr = str.substring(lo, hi + 1)
                dp[lo][hi] = substr
                if (len < 4) continue

                for (k in lo until hi) {
                    if (dp[lo][k].length + dp[k + 1][hi].length < dp[lo][hi].length) {
                        dp[lo][hi] = dp[lo][k] + dp[k + 1][hi]
                    }
                }

                val pattern = getWordPattern(substr)
                val lenP = pattern.length
                val lenSub = substr.length
                if (lenP == lenSub) continue // no repeated pattern found

                val patternEncoded = "${lenSub / lenP}[${dp[lo][lo + lenP - 1]}]"
                if (patternEncoded.length < dp[lo][hi].length) {
                    dp[lo][hi] = patternEncoded
                }
            }
        }

        return dp[0][lenS - 1]
    }

    private fun getWordPattern(str: String): String {
        val lenS = str.length
        val kmpTable = IntArray(lenS) { 0 }
        kmpTable[0] = 0

        var i = 1
        var j = 0

        while (i < lenS) {
            when {
                str[i] == str[j] -> kmpTable[i++] = ++j
                j == 0 -> kmpTable[j++] = 0
                else -> j = kmpTable[j - 1]
            }
        }

        val patternLen = lenS - kmpTable[lenS - 1]
        return if (patternLen != lenS && lenS % patternLen == 0) {
            str.substring(0, patternLen)
        } else {
            str
        }
    }
}