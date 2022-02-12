package com.an7one.leetcode.lvl4.lc0041

import com.an7one.leetcode.util.Constant.Annotation.UNUSED
import kotlin.math.abs

/**
 * @author: Leon
 * https://leetcode.com/problems/first-missing-positive/
 *
 * Time Complexity:     O(`nNums`)
 * Space Complexity:    O(1)
 *
 * References:
 *  https://leetcode.com/problems/first-missing-positive/discuss/17214/Java-simple-solution-with-documentation
 */
@Suppress(UNUSED)
class SolutionApproach0LinearScan {
    fun firstMissingPositive(nums: IntArray): Int {
        // sanity check
        if (nums.isEmpty()) return 1

        val nNums = nums.size

        for (i in 0 until nNums){
            if (nums[i] > nNums || nums[i] <= 0)
                nums[i] = nNums + 1
        }

        for (i in 0 until nNums) {
            val num = abs(nums[i])
            if (num > nNums) continue

            val idx = num - 1
            if (nums[idx] > 0)
                nums[idx] *= -1
        }

        for (i in 0 until nNums){
            if (nums[i] > 0)
                return i + 1
        }

        return nNums + 1
    }
}