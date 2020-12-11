/**
 * https://leetcode.com/problems/first-missing-positive/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 *
 * References:
 *  https://leetcode.com/problems/first-missing-positive/discuss/17214/Java-simple-solution-with-documentation
 */
package com.zea7ot.leetcode.lvl4.lc0041

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0LinearScan {
    fun firstMissingPositive(nums: IntArray): Int {
        // sanity check
        if (nums.isEmpty()) return 1

        val size = nums.size

        for (i in 0 until size)
            if (nums[i] > size || nums[i] <= 0)
                nums[i] = size + 1

        for (i in 0 until size) {
            val num = Math.abs(nums[i])
            if (num > size) continue

            val idx = num - 1
            if (nums[idx] > 0)
                nums[idx] *= -1
        }

        for (i in 0 until size)
            if (nums[i] > 0)
                return i + 1

        return size + 1
    }
}