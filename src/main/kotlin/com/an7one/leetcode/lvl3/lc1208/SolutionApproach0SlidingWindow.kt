/**
 * https://leetcode.com/problems/get-equal-substrings-within-budget/
 *
 * Time Complexity:     O(`lenS`)
 * Space Complexity:    O(`lenS`) / O(1)
 *
 * References:
 *  https://leetcode.com/problems/get-equal-substrings-within-budget/discuss/392837/JavaC%2B%2BPython-Sliding-Window
 *  https://leetcode.com/problems/get-equal-substrings-within-budget/discuss/392857/C%2B%2BJava-Sliding-Window-O(n)-or-O(1)
 */
package com.an7one.leetcode.lvl3.lc1208

import com.an7one.leetcode.util.Constant.Annotation.UNUSED
import kotlin.math.abs

@Suppress(UNUSED)
class SolutionApproach0SlidingWindow {
    fun equalSubstring(s: String, t: String, maxCost: Int): Int {
        val lenS = s.length

        var lo = 0
        var hi = 0
        var cost = 0

        while (hi < lenS) {
            cost += abs(s[hi] - t[hi])

            if (cost > maxCost) {
                cost -= abs(s[lo] - t[lo])
                ++lo
            }

            ++hi
        }

        return hi - lo
    }
}