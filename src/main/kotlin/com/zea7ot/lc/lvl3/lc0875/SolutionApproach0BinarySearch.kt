/**
 * https://leetcode.com/problems/koko-eating-bananas/
 *
 * Time Complexity:     O(N * lg(RANGE))
 * Space Complexity:    O(1)
 */
package com.zea7ot.lc.lvl3.lc0875

import com.zea7ot.lc.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0BinarySearch {
    private companion object {
        private const val RANGE = (1e9).toInt() + 1
    }

    fun minEatingSpeed(piles: IntArray, H: Int): Int {
        var lo = 1
        var hi = RANGE

        while (lo < hi) {
            var totalHours = 0
            val mid = lo + (hi - lo) / 2

            for (pile in piles) {
                totalHours += (pile + mid - 1) / mid
            }

            if (totalHours > H) lo = mid + 1
            else hi = mid
        }

        return lo
    }
}