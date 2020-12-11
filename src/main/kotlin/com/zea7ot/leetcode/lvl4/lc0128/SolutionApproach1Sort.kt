package com.zea7ot.leetcode.lvl4.lc0128

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach1Sort {
    fun longestConsecutive(nums: IntArray): Int {
        // sanity check, required
        if (nums.isEmpty()) return 0

        val nNums = nums.size

        nums.sort()

        var longest = 1
        var len = 1

        loop@ for (idx in 1 until nNums) {
            when {
                nums[idx - 1] == nums[idx] -> continue@loop
                nums[idx - 1] + 1 == nums[idx] -> longest = maxOf(longest, ++len)
                else -> len = 1
            }
        }

        return longest
    }
}