/**
 * https://leetcode.com/problems/relative-sort-array/
 *
 * Time Complexity:     O(`nNums1` * lg(`nNums1`))
 * Space Complexity:    O(`nNums1`)
 *
 * References:
 *  https://leetcode.com/problems/relative-sort-array/discuss/335056/Java-in-place-solution-using-counting-sort
 */
package com.an7one.leetcode.lvl2.lc1122.followup.followup0

import com.an7one.leetcode.util.Constant.Annotation.UNUSED
import java.util.*

@Suppress(UNUSED)
class SolutionApproach0CountingSort {
    fun relativeSortArray(nums1: IntArray, nums2: IntArray): IntArray {
        // not used
        // val nNums1 = nums1.size

        val freqs = TreeMap<Int, Int>()
        for (num in nums1) freqs[num] = 1 + (freqs[num] ?: 0)

        var idx = 0
        for (num in nums2) {
            for (repeat in 0 until (freqs[num] ?: 0)) {
                nums1[idx++] = num
            }
            freqs.remove(num)
        }

        for ((num, freq) in freqs) {
            for (repeat in 0 until freq) {
                nums1[idx++] = num
            }
        }

        return nums1
    }
}