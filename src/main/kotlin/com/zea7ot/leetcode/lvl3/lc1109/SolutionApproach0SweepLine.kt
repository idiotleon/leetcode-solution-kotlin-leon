/**
 * https://leetcode.com/problems/corporate-flight-bookings/
 *
 * Time Complexity:     O(`n`)
 * Space Complexity:    O(1) / O(`n`)
 *
 * References:
 *  https://leetcode.com/problems/corporate-flight-bookings/discuss/328871/C%2B%2BJava-with-picture-O(n)
 */
package com.zea7ot.leetcode.lvl3.lc1109

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0SweepLine {
    fun corpFlightBookings(bookings: Array<IntArray>, n: Int): IntArray {
        val ans = IntArray(n) { 0 }

        for (booking in bookings) {
            val (i, j, seats) = booking

            ans[i - 1] += seats
            if (j < n) ans[j] -= seats
        }

        for (idx in 1 until n) {
            ans[idx] += ans[idx - 1]
        }

        return ans
    }
}