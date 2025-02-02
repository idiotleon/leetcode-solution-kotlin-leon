package com.idiotleon.leetcode.lvl3.lc0069

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/sqrtx/
 *
 * Time Complexity:     O(lg(`x`))
 * Space Complexity:    O(1)
 *
 * Reference:
 * https://leetcode.com/problems/sqrtx/discuss/25198/3-JAVA-solutions-with-explanation
 */
@Suppress(UNUSED)
class Solution0BinarySearch {
    fun mySqrt(x: Int): Int {
        if (x == 0) {
            return 0
        }

        var lo = 1
        var hi = x

        while (lo <= hi) {
            val mid = lo + (hi - lo) / 2

            if (mid <= x / mid && (mid + 1) > x / (mid + 1)) {
                return mid
            }

            if (mid > x / mid) {
                hi = mid - 1
            } else {
                lo = mid + 1
            }
        }

        return lo
    }
}