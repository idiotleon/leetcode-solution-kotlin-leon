package com.an7one.leetcode.lvl2.lc0350

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/intersection-of-two-arrays-ii/
 *
 * Time Complexity:     O(max(`nNums1`, `nNums2`))
 * Space Complexity:    O(min(`nNums1`, `nNums2`))
 *
 * References:
 *  https://leetcode.com/problems/intersection-of-two-arrays-ii/discuss/282372/Java-solution-with-all-3-follow-up-questions
 */
@Suppress(UNUSED)
class SolutionApproach0HashMap {
    fun intersect(nums1: IntArray, nums2: IntArray): IntArray {
        val nNums1 = nums1.size
        val nNums2 = nums2.size

        if (nNums1 > nNums2) return intersect(nums2, nums1)

        val valToFreq = HashMap<Int, Int>()
        for (num in nums1) {
            valToFreq[num] = 1 + (valToFreq[num] ?: 0)
        }

        val res = mutableListOf<Int>()
        for (num in nums2) {
            if ((valToFreq[num] ?: 0) > 0) {
                res.add(num)
                valToFreq[num] = valToFreq[num]!! - 1
            }
        }

        return res.toIntArray()
    }
}