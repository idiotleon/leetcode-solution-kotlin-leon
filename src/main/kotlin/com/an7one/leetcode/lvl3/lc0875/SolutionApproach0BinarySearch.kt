/**
 * https://leetcode.com/problems/koko-eating-bananas/
 *
 * Time Complexity:     O(`nPiles` * lg(`range`))
 * Space Complexity:    O(1)
 */
package com.an7one.leetcode.lvl3.lc0875

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0BinarySearch {
    fun minEatingSpeed(piles: IntArray, H: Int): Int {
        // not used
        // val nPiles = piles.size

        val max = piles.max() ?: 0
        val range = max + 1

        var lo = 1
        var hi = range

        while (lo < hi) {
            val mid = lo + (hi - lo) / 2

            var hours = 0
            for (pile in piles) {
                hours += (pile + mid - 1) / mid
            }

            if (hours <= H) {
                hi = mid
            } else {
                lo = mid + 1
            }
        }

        return lo
    }
}