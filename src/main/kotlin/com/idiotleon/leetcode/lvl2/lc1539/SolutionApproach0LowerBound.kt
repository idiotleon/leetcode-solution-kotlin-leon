package com.idiotleon.leetcode.lvl2.lc1539

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/kth-missing-positive-number/
 *
 * Time Complexity:     O(lg(max(`nNums`, `k`)))
 * Space Complexity:    O(1)
 *
 * Reference:
 * https://leetcode.com/problems/kth-missing-positive-number/discuss/779999/JavaC%2B%2BPython-O(logN)
 */
@Suppress(UNUSED)
class SolutionApproach0LowerBound {
    fun findKthPositive(nums: IntArray, k: Int): Int {
        val nNums = nums.size

        var lo = 0
        var hi = nNums

        while (lo < hi) {
            val mid = lo + (hi - lo) / 2

            if (nums[mid] - mid - 1 >= k) {
                hi = mid
            } else {
                lo = mid + 1
            }
        }

        return lo + k
    }
}