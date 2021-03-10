/**
 * https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/
 *
 * Time Complexity:     O(`totalDays` * lg(`RANGE`))
 * Space Complexity:    O(1)
 *
 * References:
 *  https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/discuss/686316/JavaC%2B%2BPython-Binary-Search
 */
package com.an7one.leetcode.lvl3.lc1482

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0BinarySearch {
    private companion object {
        private const val RANGE = 1e9.toInt()
    }

    fun minDays(bloomDay: IntArray, m: Int, k: Int): Int {
        val totalDays = bloomDay.size
        if (m * k > totalDays) return -1

        var lo = 1
        var hi = RANGE

        while (lo < hi) {
            val mid = lo + (hi - lo) / 2
            val bouquet = getCount(mid, k, bloomDay)

            if (bouquet < m) lo = mid + 1
            else hi = mid
        }

        return lo
    }

    private fun getCount(dayLimit: Int, k: Int, bloomDay: IntArray): Int {
        var bouquet = 0
        var flow = 0

        for (day in bloomDay) {
            if (day > dayLimit) {
                flow = 0
            } else if (++flow >= k) {
                ++bouquet
                flow = 0
            }
        }

        return bouquet
    }
}