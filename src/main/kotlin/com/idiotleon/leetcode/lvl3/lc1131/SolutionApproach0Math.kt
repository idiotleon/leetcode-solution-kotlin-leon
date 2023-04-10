/**
 * https://leetcode.com/problems/maximum-of-absolute-value-expression/
 *
 * Time Complexity:     O(`nNums`)
 * Space Complexity:    O(1)
 *
 * References:
 *  https://leetcode.com/problems/maximum-of-absolute-value-expression/discuss/340075/c++-beats-100-(both-time-and-memory)-with-algorithm-and-image/310761
 *  https://leetcode.com/problems/maximum-of-absolute-value-expression/discuss/340075/c%2B%2B-beats-100-(both-time-and-memory)-with-algorithm-and-image
 */
package com.idiotleon.leetcode.lvl3.lc1131

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0Math {
    fun maxAbsValExpr(nums1: IntArray, nums2: IntArray): Int {
        // not used
        // val nNums = nums1.size

        var max1 = Int.MIN_VALUE
        var max2 = Int.MIN_VALUE
        var max3 = Int.MIN_VALUE
        var max4 = Int.MIN_VALUE

        var min1 = Int.MAX_VALUE
        var min2 = Int.MAX_VALUE
        var min3 = Int.MAX_VALUE
        var min4 = Int.MAX_VALUE

        // or equivalently
        // var (max1, max2, max3, max4) = IntArray(4){ Int.MIN_VALUE }
        // var (min1, min2, min3, min4) = IntArray(4){ Int.MAX_VALUE }

        for (idx in nums1.indices) {
            max1 = maxOf(max1, nums1[idx] + nums2[idx] + idx)
            min1 = minOf(min1, nums1[idx] + nums2[idx] + idx)

            max2 = maxOf(max2, nums1[idx] + nums2[idx] - idx)
            min2 = minOf(min2, nums1[idx] + nums2[idx] - idx)

            max3 = maxOf(max3, nums1[idx] - nums2[idx] - idx)
            min3 = minOf(min3, nums1[idx] - nums2[idx] - idx)

            max4 = maxOf(max4, nums1[idx] - nums2[idx] + idx)
            min4 = minOf(min4, nums1[idx] - nums2[idx] + idx)
        }

        val diff1 = max1 - min1
        val diff2 = max2 - min2
        val diff3 = max3 - min3
        val diff4 = max4 - min4

        return maxOf(maxOf(diff1, diff2), maxOf(diff3, diff4))
    }
}