/**
 * https://leetcode.com/problems/maximize-distance-to-closest-person/
 *
 * Time Complexity:     O(`totalSeats`)
 * Space Complexity:    O(1)
 *
 * References:
 *  https://leetcode.com/problems/maximize-distance-to-closest-person/discuss/137912/JavaC++Python-One-pass-Easy-Understood/468954
 *  https://leetcode.com/problems/maximize-distance-to-closest-person/discuss/137912/JavaC%2B%2BPython-One-pass-Easy-Understood
 */
package com.zea7ot.leetcode.lvl2.lc0849

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0TwoPointers {
    fun maxDistToClosest(seats: IntArray): Int {
        val totalSeats = seats.size

        var max = Int.MIN_VALUE
        var prev = -1

        for (idx in seats.indices) {
            if (seats[idx] == 1) {
                max = if (prev == -1) {
                    idx
                } else {
                    maxOf(max, (idx - prev) / 2)
                }

                prev = idx
            }
        }

        max = maxOf(max, totalSeats - 1 - prev)
        return max
    }
}