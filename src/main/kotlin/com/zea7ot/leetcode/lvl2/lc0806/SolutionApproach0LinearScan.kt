/**
 * https://leetcode.com/problems/number-of-lines-to-write-string/
 *
 * Time Complexity:     O(`lenS`)
 * Space Complexity:    O(1)
 *
 * References:
 *  https://leetcode.com/problems/number-of-lines-to-write-string/discuss/120666/Easy-Solution-6-lines-C%2B%2BJavaPython
 */
package com.zea7ot.leetcode.lvl2.lc0806

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0LinearScan {
    fun numberOfLines(widths: IntArray, str: String): IntArray {
        // not used
        // val lenS = str.length

        var lines = 1
        var cur = 0

        for (ch in str) {
            val width = widths[ch - 'a']
            lines = if (cur + width > 100) lines + 1 else lines
            cur = if (cur + width > 100) width else cur + width
        }

        return intArrayOf(lines, cur)
    }
}