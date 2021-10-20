/**
 * @author: Leon
 * https://leetcode.com/problems/intersection-of-two-arrays/
 *
 * Time Complexity:     O(`nNums1` * lg(`nNums1`)) + O(`nNums2` * lg(`nNums2`)) + O(max(distinct(`nums1`), distinct(`nums2`)))
 * Space Complexity:    O(1)
 */
package com.an7one.leetcode.lvl1.lc0349

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0TwoPointers {
    fun intersection(nums1: IntArray, nums2: IntArray): IntArray {
        // sanity check
        if (nums1.isEmpty() || nums2.isEmpty())
            return intArrayOf()

        val ans = ArrayList<Int>()

        val nNums1 = nums1.size
        val nNums2 = nums2.size

        nums1.sort()
        nums2.sort()

        var idx1 = 0
        var idx2 = 0

        while (idx1 < nNums1 && idx2 < nNums2) {
            when {
                nums1[idx1] > nums2[idx2] -> ++idx2
                nums1[idx1] < nums2[idx2] -> ++idx1
                else -> {
                    val same = nums1[idx1]
                    ans.add(same)

                    while (idx1 < nNums1 && nums1[idx1] == same) {
                        ++idx1
                    }

                    while (idx2 < nNums2 && nums2[idx2] == same) {
                        ++idx2
                    }
                }
            }
        }

        return ans.toIntArray()
    }
}