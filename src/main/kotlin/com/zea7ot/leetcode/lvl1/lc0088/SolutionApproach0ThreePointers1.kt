/**
 * @author: Leon
 * https://leetcode.com/problems/merge-sorted-array/
 *
 * Time Complexity:     O(`m` + `n`)
 * Space Complexity:    O(1)
 */
package com.zea7ot.leetcode.lvl1.lc0088

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0ThreePointers1 {
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int) {
        var idx1 = m - 1
        var idx2 = n - 1
        var idx = m + n - 1

        while (idx1 >= 0 && idx2 >= 0) {
            nums1[idx] = if (nums1[idx1] < nums2[idx2]) {
                // to be careful with the order of the expressions, especially when `--idx2` is separate
                nums2[idx2--]
            } else {
                // to be careful with the order of the expressions, especially when `--idx1` is separate
                nums1[idx1--]
            }

            --idx
        }

        while (idx1 >= 0) {
            nums1[idx] = nums1[idx1]
            --idx
            --idx1
        }

        while (idx2 >= 0) {
            nums1[idx] = nums2[idx2]
            --idx
            --idx2
        }
    }
}