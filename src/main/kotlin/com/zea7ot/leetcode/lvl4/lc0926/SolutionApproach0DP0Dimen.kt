/**
 * https://leetcode.com/problems/flip-string-to-monotone-increasing/
 *
 * Time Complexity:     O(`lenS`)
 * Space Complexity:    O(1)
 *
 * References:
 * https://leetcode.com/problems/flip-string-to-monotone-increasing/discuss/189751/C++-one-pass-DP-solution-0ms-O(n)-or-O(1)-one-line-with-explaination./318321
 * https://leetcode.com/problems/flip-string-to-monotone-increasing/discuss/189751/C%2B%2B-one-pass-DP-solution-0ms-O(n)-or-O(1)-one-line-with-explaination.
 */
package com.zea7ot.leetcode.lvl4.lc0926

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP0Dimen {
    fun minFlipsMonoIncr(str: String): Int {
        var cntOnes = 0
        var cntFlips = 0

        for (ch in str) {
            when (ch) {
                '1' -> ++cntOnes
                else -> ++cntFlips
            }

            cntFlips = minOf(cntFlips, cntOnes)
        }

        return cntFlips
    }
}