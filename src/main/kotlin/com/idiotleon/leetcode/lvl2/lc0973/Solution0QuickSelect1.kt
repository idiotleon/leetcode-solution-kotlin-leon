package com.idiotleon.leetcode.lvl2.lc0973

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/k-closest-points-to-origin/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 */
@Suppress(UNUSED)
class Solution0QuickSelect1 {
    fun kClosest(points: Array<IntArray>, k: Int): Array<IntArray> {
        val nPoints = points.size
        var lo = 0
        var hi = nPoints - 1

        while (lo < hi) {
            val mid = partition(lo, hi, points)
            if (mid == k) {
                break;
            }

            if (mid < k) {
                lo = mid + 1
            } else {
                hi = mid
            }
        }

        return points.copyOfRange(0, k)
    }

    private fun partition(lo: Int, hi: Int, nums: Array<IntArray>): Int {
        var lo = lo
        var hi = hi

        val pivot = nums[lo]
        while (lo < hi) {
            while (lo < hi && compare(nums[hi], pivot) >= 0) --hi
            nums[lo] = nums[hi]
            while (lo < hi && compare(nums[lo], pivot) <= 0) ++lo
            nums[hi] = nums[lo]
        }

        var nums = nums
        nums[lo] = pivot
        return lo
    }

    private fun compare(point1: IntArray, point2: IntArray): Long {
        val (row1, col1) = point1
        val (row2, col2) = point2

        return row1.toLong() * row1.toLong() + col1.toLong() * col1.toLong() - (row2.toLong() * row2.toLong() + col2.toLong() * col2.toLong())
    }
}