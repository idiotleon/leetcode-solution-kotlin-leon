/**
 * https://leetcode.com/problems/relative-sort-array/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * References:
 *  https://leetcode.com/problems/relative-sort-array/discuss/335056/Java-in-place-solution-using-counting-sort
 */
package com.zea7ot.leetcode.lvl2.lc1122

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0CountingSort {
    private companion object {
        private const val RANGE = 1000 + 1
    }

    fun relativeSortArray(nums1: IntArray, nums2: IntArray): IntArray {
        val freqs = IntArray(RANGE) { 0 }
        for (num in nums1) ++freqs[num]

        var idx = 0
        for (num in nums2) {
            while (--freqs[num] >= 0) {
                nums1[idx++] = num
            }
        }

        for (n in freqs.indices) {
            while (--freqs[n] >= 0) {
                nums1[idx++] = n
            }
        }

        return nums1
    }
}