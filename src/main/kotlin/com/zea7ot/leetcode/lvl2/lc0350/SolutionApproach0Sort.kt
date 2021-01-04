/**
 * https://leetcode.com/problems/intersection-of-two-arrays-ii/
 *
 * Time Complexity:     O(`nNums1` * lg(`nNums1`) +`nNums2` * lg(`nNums2`))
 * Space Complexity:    O(1)
 *
 * References:
 *  https://leetcode.com/problems/intersection-of-two-arrays-ii/discuss/282372/Java-solution-with-all-3-follow-up-questions
 */
package com.zea7ot.leetcode.lvl2.lc0350

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0Sort {
    fun intersect(nums1: IntArray, nums2: IntArray): IntArray {
        val nNums1 = nums1.size
        val nNums2 = nums2.size

        nums1.sort()
        nums2.sort()

        var idx1 = 0
        var idx2 = 0

        val res = mutableListOf<Int>()

        while (idx1 < nNums1 && idx2 < nNums2) {
            when {
                nums1[idx1] < nums2[idx2] -> ++idx1
                nums1[idx1] > nums2[idx2] -> ++idx2
                else -> {
                    res.add(nums1[idx1])
                    ++idx1
                    ++idx2
                }
            }
        }

        return res.toIntArray()
    }
}