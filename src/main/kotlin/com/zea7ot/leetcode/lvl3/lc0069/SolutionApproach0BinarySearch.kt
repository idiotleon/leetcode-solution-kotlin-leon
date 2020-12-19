/**
 * https://leetcode.com/problems/sqrtx/
 *
 * Time Complexity:     O(lg(`x`))
 * Space Complexity:    O(1)
 *
 * References:
 *  https://leetcode.com/problems/sqrtx/discuss/25198/3-JAVA-solutions-with-explanation
 */
package com.zea7ot.leetcode.lvl3.lc0069

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0BinarySearch {
    fun mySqrt(x: Int): Int {
        if (x == 0) return 0

        var lo = 1
        var hi = x

        while (lo <= hi) {
            val mid = lo + (hi - lo) / 2

            if (mid <= x / mid && (mid + 1) > x / (mid + 1))
                return mid

            if (mid > x / mid) hi = mid - 1
            else lo = mid + 1
        }

        return lo
    }
}