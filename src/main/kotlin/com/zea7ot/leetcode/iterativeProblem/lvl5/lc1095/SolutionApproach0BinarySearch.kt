/**
 * https://leetcode.com/problems/find-in-mountain-array/
 *
 * Time Complexity:     O(lg(`lenM`))
 * Space Complexity:    O(1)
 *
 * References:
 *  https://leetcode.com/problems/find-in-mountain-array/discuss/378052/Binary-Search-Thinking-Process
 *  https://leetcode.com/problems/find-in-mountain-array/discuss/317607/JavaC%2B%2BPython-Triple-Binary-Search
 */
package com.zea7ot.leetcode.iterativeProblem.lvl5.lc1095

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0BinarySearch {
    fun findInMountainArray(target: Int, mountainArr: FakeMountainArrayAPI): Int {
        val lenM = mountainArr.length()

        var lo = 0
        var hi = lenM - 1

        // to find the peak
        while (lo < hi) {
            val mid = lo + (hi - lo) / 2
            if (mountainArr.get(mid) < mountainArr.get(mid + 1)) {
                lo = mid + 1
            } else {
                hi = mid
            }
        }

        val peak = lo

        // to binary search on the left, increasing slope
        lo = 0
        hi = peak
        while (lo <= hi) {
            val mid = lo + (hi - lo) / 2
            if (mountainArr.get(mid) < target) {
                lo = mid + 1
            } else if (mountainArr.get(mid) > target) {
                hi = mid - 1
            } else return mid
        }

        // to binary search on the right, decreasing slop
        lo = peak
        hi = lenM - 1
        while (lo <= hi) {
            val mid = lo + (hi - lo) / 2
            if (mountainArr.get(mid) < target) {
                hi = mid - 1
            } else if (mountainArr.get(mid) > target) {
                lo = mid + 1
            } else return mid
        }

        return -1
    }
}