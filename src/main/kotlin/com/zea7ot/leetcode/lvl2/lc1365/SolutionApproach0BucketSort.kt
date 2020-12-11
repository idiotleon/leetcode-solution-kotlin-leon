/**
 * https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/
 *
 * Time Complexity:     O(`totalNums`) + O(`RANGE`)
 * Space Complexity:    O(`RANGE`)
 *
 * References:
 *  https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/discuss/575760/Java-simple-to-complex-explained-0-ms-faster-than-100-less-space-than-100-5-lines-of-code
 */
package com.zea7ot.leetcode.lvl2.lc1365

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0BucketSort {
    private companion object {
        private const val RANGE = 100 + 2
    }

    fun smallerNumbersThanCurrent(nums: IntArray): IntArray {
        // not used
        // val totalNums = nums.size

        val buckets = IntArray(RANGE) { 0 }
        for (num in nums) {
            ++buckets[num + 1]
        }

        for (num in 1 until RANGE) {
            buckets[num] += buckets[num - 1]
        }

        for (idx in nums.indices) {
            nums[idx] = buckets[nums[idx]]
        }

        return nums
    }
}