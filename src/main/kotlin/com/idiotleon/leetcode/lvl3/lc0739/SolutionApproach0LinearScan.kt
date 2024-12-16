package com.idiotleon.leetcode.lvl3.lc0739

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/daily-temperatures/
 *
 * Time Complexity:     O(`nTs`)
 * Space Complexity:    O(`nTs`) / O(1)
 *
 * Reference:
 * https://leetcode.com/problems/daily-temperatures/discuss/121787/C%2B%2B-Clean-code-with-explanation%3A-O(n)-time-and-O(1)-space-(beats-99.13)
 */
@Suppress(UNUSED)
class SolutionApproach0LinearScan {
    fun dailyTemperatures(temperatures: IntArray): IntArray {
        val nTemps = temperatures.size

        val ans = IntArray(nTemps) { 0 }

        for (lo in nTemps - 1 downTo 0) {
            var hi = lo + 1

            while (hi < nTemps && temperatures[lo] >= temperatures[hi]) {
                // to find the next warmer day based on previously established paths,
                // or simply move to the end if previously established path is 0,
                // meaning no greater element afterwards
                hi = if (ans[hi] > 0) hi + ans[hi] else nTemps
            }

            // either `hi == nTs` or `T[lo] < T[hi]`
            if (hi < nTemps) { // to abandon the situation where `hi == nTs`, leaving `ans[lo] == 0`
                ans[lo] = hi - lo
            }
        }

        return ans
    }
}