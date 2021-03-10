/**
 * https://leetcode.com/problems/daily-temperatures/
 *
 * Time Complexity:     O(`totalTs`)
 * Space Complexity:    O(`totalTs`) / O(1)
 *
 * References:
 *  https://leetcode.com/problems/daily-temperatures/discuss/121787/C%2B%2B-Clean-code-with-explanation%3A-O(n)-time-and-O(1)-space-(beats-99.13)
 */
package com.an7one.leetcode.lvl3.lc0739

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0LinearScan {
    fun dailyTemperatures(T: IntArray): IntArray {
        val totalTs = T.size

        val ans = IntArray(totalTs) { 0 }

        for (lo in totalTs - 1 downTo 0) {
            var hi = lo + 1

            while (hi < totalTs && T[lo] >= T[hi]) {
                // to find the next warmer day based on previous established paths,
                // or simply move to the end if previously established path is 0,
                // meaning no greater element afterwards
                hi = if (ans[hi] > 0) hi + ans[hi] else totalTs
            }

            // either `hi == totalTs` or `T[lo] < T[hi]`
            if (hi < totalTs) { // to abandon the situation where `hi == totalTs`, leaving `ans[lo] == 0`
                ans[lo] = hi - lo
            }
        }

        return ans
    }
}