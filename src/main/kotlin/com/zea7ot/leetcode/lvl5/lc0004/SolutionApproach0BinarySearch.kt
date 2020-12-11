/**
 * https://leetcode.com/problems/median-of-two-sorted-arrays/
 *
 * Time Complexity:     O(lg(min(L1, L2)))
 * Space Complexity:    O(1)
 *
 *
 * to find such a partition (left and right parts, including both arrays):
 *  1. both parts have the same total elements
 *  2. every element on the left side is smaller or equal to the elements on the right side
 *
 *  x -> x1 x2 | x3 x4 x5 x6
 *  y -> y1 y2 y3 y4 y5 | y6 y7 y8
 *
 * if(x2 <= y6 && y5 <= x3),
 *  to return avg(max(x2, y5), min(x3, y6)) if `L1 + L2` is even, or
 *  to return max(x2, y5), if `L1 + L2` is odd
 *
 *
 * References:
 *  https://www.youtube.com/watch?v=KB9IcSCDQ9k
 *  https://zxi.mytechroad.com/blog/algorithms/binary-search/leetcode-4-median-of-two-sorted-arrays/
 *  https://www.youtube.com/watch?v=LPFhl65R7ww
 *  https://github.com/mission-peace/interview/blob/master/src/com/interview/binarysearch/MedianOfTwoSortedArrayOfDifferentLength.java
 */
package com.zea7ot.leetcode.lvl5.lc0004

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0BinarySearch {
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        val size1 = nums1.size
        val size2 = nums2.size
        if (size1 > size2) return findMedianSortedArrays(nums2, nums1)

        val size = size1 + size2
        val mid = (size + 1) / 2

        var lo = 0
        var hi = size1

        while (lo < hi) {
            val mid1 = lo + (hi - lo) / 2
            val mid2 = mid - mid1

            if (nums1[mid1] < nums2[mid2 - 1]) {
                lo = mid1 + 1
            } else hi = mid1
        }

        val mid1 = lo
        val mid2 = mid - mid1

        val num1 = maxOf(if (mid1 <= 0) Int.MIN_VALUE else nums1[mid1 - 1],
                if (mid2 <= 0) Int.MIN_VALUE else nums2[mid2 - 1])

        if (size % 2 == 1) return num1.toDouble()

        val num2 = minOf(if (mid1 >= size1) Int.MAX_VALUE else nums1[mid1],
                if (mid2 >= size2) Int.MAX_VALUE else nums2[mid2])

        return (num1 + num2).toDouble() / 2
    }
}