package com.an7one.leetcode.lvl5.lc0004

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/median-of-two-sorted-arrays/
 *
 * Time Complexity:     O(lg(min(`nNums1`, `nNums2`)))
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
@Suppress(UNUSED)
class SolutionApproach0BinarySearch {
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        val nNums1 = nums1.size
        val nNums2 = nums2.size
        if (nNums1 > nNums2) return findMedianSortedArrays(nums2, nums1)

        val nNums = nNums1 + nNums2
        val mid = (nNums + 1) / 2

        var lo = 0
        var hi = nNums1

        while (lo < hi) {
            val mid1 = lo + (hi - lo) / 2
            val mid2 = mid - mid1

            if (nums1[mid1] < nums2[mid2 - 1]) {
                lo = mid1 + 1
            } else {
                hi = mid1
            }
        }

        val mid1 = lo
        val mid2 = mid - mid1

        val num1 = maxOf(
            if (mid1 <= 0) Int.MIN_VALUE else nums1[mid1 - 1],
            if (mid2 <= 0) Int.MIN_VALUE else nums2[mid2 - 1]
        )

        if (nNums % 2 == 1) return num1.toDouble()

        val num2 = minOf(
            if (mid1 >= nNums1) Int.MAX_VALUE else nums1[mid1],
            if (mid2 >= nNums2) Int.MAX_VALUE else nums2[mid2]
        )

        return (num1 + num2).toDouble() / 2
    }
}