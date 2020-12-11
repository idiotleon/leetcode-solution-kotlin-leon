/**
 * https://leetcode.com/problems/flip-string-to-monotone-increasing/
 *
 * Time Complexity:     O(`lenS`)
 * Space Complexity:    O(`lenS`)
 *
 * References:
 *  https://zxi.mytechroad.com/blog/dynamic-programming/leetcode-926-flip-string-to-monotone-increasing/
 */
package com.zea7ot.leetcode.lvl4.lc0926

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP1Dimen {
    fun minFlipsMonoIncr(str: String): Int {
        val lenS = str.length

        val loOnes = IntArray(lenS + 1) { 0 }
        loOnes[0] = str[0] - '0'
        for (idx in 1 until lenS) {
            loOnes[idx] = loOnes[idx - 1] + (str[idx] - '0')
        }

        val hiZeros = IntArray(lenS + 1) { 0 }
        hiZeros[lenS - 1] = '1' - str[lenS - 1]
        for (idx in lenS - 2 downTo 0) {
            hiZeros[idx] = hiZeros[idx + 1] + ('1' - str[idx])
        }

        var minFlips = hiZeros[0]
        for (idx in 1..lenS) {
            minFlips = minOf(minFlips, loOnes[idx - 1] + hiZeros[idx])
        }
        return minFlips
    }
}