package com.idiotleon.leetcode.lvl3.lc0069

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/sqrtx/
 *
 * Time Complexity:     O(lg(`x`))
 * Space Complexity:    O(1)
 *
 * References:
 * https://leetcode.com/problems/sqrtx/
 * https://leetcode.com/problems/sqrtx/discuss/25047/A-Binary-Search-Solution
 */
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