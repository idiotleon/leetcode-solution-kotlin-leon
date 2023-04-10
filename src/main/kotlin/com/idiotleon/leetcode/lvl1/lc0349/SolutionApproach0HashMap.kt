/**
 * @author: Leon
 * https://leetcode.com/problems/intersection-of-two-arrays/
 *
 * Time Complexity:     O(max(`nNums1`, `nNums2`))
 * Space Complexity:    O(min(`nNums1`, `nNums2`))
 */
package com.idiotleon.leetcode.lvl1.lc0349

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0HashMap {
    fun intersection(nums1: IntArray, nums2: IntArray): IntArray {
        val nNums1 = nums1.size
        val nNums2 = nums2.size

        if (nNums1 > nNums2)
            return intersection(nums2, nums1)

        val valToFreq = HashMap<Int, Int>()
        for (num in nums1) {
            valToFreq[num] = 1 + (valToFreq[num] ?: 0)
        }

        val res = HashSet<Int>()
        for (num in nums2) {
            if ((valToFreq[num] ?: 0) > 0)
                res.add(num)
        }

        return res.toIntArray()
    }
}