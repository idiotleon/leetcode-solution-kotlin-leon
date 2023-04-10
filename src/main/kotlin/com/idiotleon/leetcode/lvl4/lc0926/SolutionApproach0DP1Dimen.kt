package com.idiotleon.leetcode.lvl4.lc0926

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/flip-string-to-monotone-increasing/
 *
 * Time Complexity:     O(`lenS`)
 * Space Complexity:    O(`lenS`)
 *
 * Reference:
 * https://zxi.mytechroad.com/blog/dynamic-programming/leetcode-926-flip-string-to-monotone-increasing/
 */
@Suppress(UNUSED)
class SolutionApproach0DP1Dimen {
    private companion object {
        private const val ONE: Char = '1';
        private const val ZERO: Char = '0';
    }

    fun minFlipsMonoIncr(str: String): Int {
        val lenS = str.length

        val loOnes = IntArray(lenS + 1) { 0 }
        loOnes[0] = str[0] - ZERO
        for (idx in 1 until lenS) {
            loOnes[idx] = loOnes[idx - 1] + (str[idx] - ZERO)
        }

        val hiZeros = IntArray(lenS + 1) { 0 }
        hiZeros[lenS - 1] = ONE - str[lenS - 1]
        for (idx in lenS - 2 downTo 0) {
            hiZeros[idx] = hiZeros[idx + 1] + (ONE - str[idx])
        }

        var minFlips = hiZeros[0]
        for (idx in 1..lenS) {
            minFlips = minOf(minFlips, loOnes[idx - 1] + hiZeros[idx])
        }
        return minFlips
    }
}