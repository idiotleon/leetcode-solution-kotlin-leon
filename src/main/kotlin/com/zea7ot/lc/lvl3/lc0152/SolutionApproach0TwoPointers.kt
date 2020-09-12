package com.zea7ot.lc.lvl3.lc0152

import com.zea7ot.lc.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0TwoPointers {
    fun maxProduct(nums: IntArray): Int {
        // sanity check
        if (nums.isEmpty()) return 0

        val size = nums.size

        var ans = nums[0]
        var lo = 0
        var hi = 0

        for (i in 0 until size) {
            lo = (if (lo == 0) 1 else lo) * nums[i]
            hi = (if (hi == 0) 1 else hi) * nums[size - 1 - i]

            ans = maxOf(ans, lo, hi);
        }

        return ans
    }
}