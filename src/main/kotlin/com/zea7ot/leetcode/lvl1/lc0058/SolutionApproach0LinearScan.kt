/**
 * https://leetcode.com/problems/length-of-last-word/
 *
 * Time Complexity:     O(L)
 * Space Complexity:    O(1)
 */
package com.zea7ot.leetcode.lvl1.lc0058

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0LinearScan {
    private companion object {
        private const val SPACE = ' '
    }

    fun lengthOfLastWord(s: String): Int {
        // sanity check
        if (s.isEmpty()) return 0

        val lenS = s.length
        var hi = lenS - 1

        while (hi >= 0 && s[hi] == SPACE) --hi

        var len = 0
        while (hi >= 0 && s[hi] != SPACE) {
            --hi
            ++len
        }

        return len
    }
}