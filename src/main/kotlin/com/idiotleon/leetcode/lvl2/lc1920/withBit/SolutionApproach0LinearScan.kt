/**
 * https://leetcode.com/problems/build-array-from-permutation/
 *
 * Time Complexity:     O(`nNums`)
 * Space Complexity:    O(1)
 *
 * Reference:
 *  https://leetcode.com/problems/build-array-from-permutation/discuss/1314616/Java-streams-one-line.-What's-the-point-of-this-question/997757
 */
package com.idiotleon.leetcode.lvl2.lc1920.withBit

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0LinearScan {
    private companion object {
        private const val MASK = 1023
    }

    fun buildArray(nums: IntArray): IntArray {
        // not used
        // val nNums = nums.size

        for (idx in nums.indices) {
            nums[idx] = nums[idx] or ((nums[nums[idx]] and MASK) shl 10)
        }

        for (idx in nums.indices) {
            nums[idx] = nums[idx] shr 10
        }

        return nums
    }
}