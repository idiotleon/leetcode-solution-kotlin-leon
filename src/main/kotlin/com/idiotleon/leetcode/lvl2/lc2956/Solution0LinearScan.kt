package com.idiotleon.leetcode.lvl2.lc2956

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/find-common-elements-between-two-arrays/
 *
 * Time Complexity:     O(`nNums1` + `nNums2`) ~ O(max(`nNums1`, `nNums2`))
 */
@Suppress(UNUSED)
class Solution0LinearScan {
    fun findIntersectionValues(nums1: IntArray, nums2: IntArray): IntArray {
        val nNums1 = nums1.size
        val nNums2 = nums2.size

        val set1 = nums1.toHashSet()
        val set2 = nums2.toHashSet()

        var count1 = 0
        for (num in nums1) {
            if (set2.contains(num)) {
                ++count1
            }
        }

        var count2 = 0
        for (num in nums2) {
            if (set1.contains(num)) {
                ++count2
            }
        }

        return intArrayOf(count1, count2)
    }
}