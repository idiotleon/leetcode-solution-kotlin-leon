/**
 * https://leetcode.com/problems/shortest-distance-to-a-character/
 *
 * Time Complexity:     O(`lenS`)
 * Space Complexity:    O(`lenS`) / O(1)
 *
 * 2 passes
 *
 * References:
 *  https://leetcode.com/problems/shortest-distance-to-a-character/discuss/125788/C%2B%2BJavaPython-2-Pass-with-Explanation
 */
package com.zea7ot.leetcode.lvl2.lc0821

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0LinearScan {
    fun shortestToChar(str: String, ch: Char): IntArray {
        val lenS = str.length

        val ans = IntArray(lenS)
        var pos = -lenS

        // from low/left to high/right,
        // to find the shortest distances
        for (idx in 0 until lenS) {
            if (str[idx] == ch) pos = idx
            ans[idx] = idx - pos
        }

        // from high/right to low/left,
        // to find the shortest distances,
        // starting with the highest/rightmost `ch`
        for (idx in pos - 1 downTo 0) {
            if (str[idx] == ch) pos = idx
            ans[idx] = minOf(ans[idx], pos - idx)
        }

        return ans
    }
}