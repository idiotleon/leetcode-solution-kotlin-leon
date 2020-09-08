package com.zea7ot.lc.lvl3.lc0169

import com.zea7ot.lc.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0MooreVotingAlgorithm {
    fun majorityElement(nums: IntArray): Int {
        // sanity check
        if (nums.isEmpty()) return 0;

        val size = nums.size

        var major = nums[0]
        var count = 1

        for (i in 1 until size) {
            when {
                count == 0 -> {
                    ++count
                    major = nums[i]
                }
                major == nums[i] -> ++count
                else -> --count
            }
        }

        return major
    }
}