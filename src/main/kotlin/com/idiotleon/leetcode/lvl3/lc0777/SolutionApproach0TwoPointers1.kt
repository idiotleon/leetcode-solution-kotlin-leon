package com.idiotleon.leetcode.lvl3.lc0777

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/swap-adjacent-in-lr-string/
 *
 * Time Complexity:     O(`lenS`)
 * Space Complexity:    O(1)
 *
 * Reference:
 * https://leetcode.com/problems/swap-adjacent-in-lr-string/discuss/114737/Simple-Java-Solution/216997
 * https://leetcode.com/problems/swap-adjacent-in-lr-string/discuss/114737/Simple-Java-Solution
 * https://leetcode.com/problems/swap-adjacent-in-lr-string/discuss/114737/Simple-Java-Solution/238126
 */
@Suppress(UNUSED)
class SolutionApproach0TwoPointers1 {
    private companion object {
        private const val L = 'L'
        private const val R = 'R'
        private const val X = 'X'
    }

    fun canTransform(start: String, end: String): Boolean {
        // not used
        // val lenS = start.length
        // val lenE = end.length

        var cntL = 0
        var cntR = 0

        for (i in start.indices) {
            if (end[i] == L) ++cntL
            if (start[i] == R) ++cntR
            if (cntL * cntR != 0) return false
            if (start[i] == L) --cntL
            if (end[i] == R) --cntR
            if (cntL < 0 || cntR < 0) return false
        }

        return cntL == 0 && cntR == 0
    }
}