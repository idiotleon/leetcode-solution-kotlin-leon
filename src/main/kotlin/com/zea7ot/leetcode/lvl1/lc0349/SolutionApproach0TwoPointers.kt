/**
 * @author: Leon
 * https://leetcode.com/problems/intersection-of-two-arrays/
 *
 * Time Complexity:     O(`totalNums1` * lg(`totalNums1`)) + O(`totalNums2` * lg(`totalNums2`)) + O(max(distinct(`nums1`), distinct(`nums2`)))
 * Space Complexity:    O(1)
 */
package com.zea7ot.leetcode.lvl1.lc0349

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0TwoPointers {
    fun intersection(nums1: IntArray, nums2: IntArray): IntArray {
        // sanity check
        if (nums1.isEmpty() || nums2.isEmpty()) return intArrayOf()

        val ans = ArrayList<Int>()

        val totalNums1 = nums1.size
        val totalNums2 = nums2.size

        nums1.sort()
        nums2.sort()

        var idx1 = 0
        var idx2 = 0

        while (idx1 < totalNums1 && idx2 < totalNums2) {
            when {
                nums1[idx1] > nums2[idx2] -> ++idx2
                nums1[idx1] < nums2[idx2] -> ++idx1
                else -> {
                    val same = nums1[idx1]
                    ans.add(same)

                    while (idx1 < totalNums1 && nums1[idx1] == same) {
                        ++idx1
                    }

                    while (idx2 < totalNums2 && nums2[idx2] == same) {
                        ++idx2
                    }
                }
            }
        }

        return ans.toIntArray()
    }
}