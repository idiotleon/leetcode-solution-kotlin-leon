package com.idiotleon.leetcode.lvl4.lc0926

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/flip-string-to-monotone-increasing/
 *
 * Time Complexity:     O(`lenS`)
 * Space Complexity:    O(1)
 *
 * Reference:
 * https://leetcode.com/problems/flip-string-to-monotone-increasing/discuss/189751/C++-one-pass-DP-solution-0ms-O(n)-or-O(1)-one-line-with-explaination./318321
 * https://leetcode.com/problems/flip-string-to-monotone-increasing/discuss/189751/C%2B%2B-one-pass-DP-solution-0ms-O(n)-or-O(1)-one-line-with-explaination.
 */
@Suppress(UNUSED)
class SolutionApproach0DP0Dimen {
    private companion object {
        private const val ONE: Char = '1';
        private const val ZERO: Char = '0';
    }

    fun minFlipsMonoIncr(str: String): Int {
        var cntOnes = 0
        var cntFlips = 0

        for (ch in str) {
            when (ch) {
                ONE -> ++cntOnes
                ZERO -> ++cntFlips
                else -> {}
            }

            cntFlips = minOf(cntFlips, cntOnes)
        }

        return cntFlips
    }
}