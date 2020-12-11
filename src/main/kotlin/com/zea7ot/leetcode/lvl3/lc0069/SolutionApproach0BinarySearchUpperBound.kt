/**
 * https://leetcode.com/problems/sqrtx/
 *
 * Time Complexity:     O(lg(`x`))
 * Space Complexity:    O(1)
 *
 * References:
 *  https://leetcode.com/problems/sqrtx/
 *  https://leetcode.com/problems/sqrtx/discuss/25047/A-Binary-Search-Solution
 */
package com.zea7ot.leetcode.lvl3.lc0069

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0BinarySearchUpperBound {
    fun mySqrt(x: Int): Int {
        var lo = 1
        var hi = x

        while (lo <= hi) {
            val mid = lo + (hi - lo) / 2

            if (mid <= x / mid) {
                lo = mid + 1
            } else {
                hi = mid - 1
            }
        }

        return hi
    }
}