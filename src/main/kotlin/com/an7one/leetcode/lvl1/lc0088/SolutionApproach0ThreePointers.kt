package com.an7one.leetcode.lvl1.lc0088

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/merge-sorted-array/
 *
 * Time Complexity:     O(`m` + `n`)
 * Space Complexity:    O(1)
 */
@Suppress(UNUSED)
class SolutionApproach0ThreePointers {
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int) {
        var idx1 = m - 1
        var idx2 = n - 1
        var idx = m + n - 1

        while (idx >= 0) {
            val num1 = if (idx1 < 0) Int.MIN_VALUE else nums1[idx1]
            val num2 = if (idx2 < 0) Int.MIN_VALUE else nums2[idx2]

            nums1[idx] = if (num1 < num2) {
                // to be careful with the order (of expressions) here
                --idx2
                num2
            } else {
                // to be careful with the order (of expressions) here
                --idx1
                num1
            }
            --idx
        }
    }
}