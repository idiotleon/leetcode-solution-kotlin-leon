/**
 * https://leetcode.com/problems/di-string-match/
 *
 * Time Complexity:     O(`lenS`)
 * Space Complexity:    O(`lenS`) / O(1)
 *
 * References:
 *  https://leetcode.com/problems/di-string-match/discuss/194904/C%2B%2BJavaPython-Straight-Forward
 */
package com.zea7ot.leetcode.lvl2.lc0942

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0HighLowPointers {
    private companion object {
        private const val INC = 'I'
        private const val DEC = 'D'
    }

    fun diStringMatch(str: String): IntArray {
        val lenS = str.length
        val ans = IntArray(lenS + 1) { 0 }

        var lo = 0
        var hi = lenS
        var idx = 0

        for (ch in str) {
            ans[idx++] = if (ch == INC) lo++ else hi--
        }

        ans[lenS] = lo

        return ans
    }
}