package com.idiotleon.leetcode.lvl1.lc1422

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/maximum-score-after-splitting-a-string/
 *
 * Time Complexity:     O(`lenS`)
 * Space Complexity:    O(1)
 */
@Suppress(UNUSED)
class Solution0LinearScan {
    private companion object {
        private const val ZERO = '0'
        private const val ONE = '1'
    }

    fun maxScore(s: String): Int {
        val lenS = s.length
        val totalOnes = s.count { it == ONE }

        var countZero = 0
        var countOne = totalOnes

        var max = 0

        for (idx in 0 until lenS - 1) {
            val ch = s[idx]
            when (ch) {
                ZERO -> {
                    ++countZero
                }

                ONE -> {
                    --countOne
                }
            }
            max = maxOf(max, countZero + countOne)
        }

        return max
    }
}