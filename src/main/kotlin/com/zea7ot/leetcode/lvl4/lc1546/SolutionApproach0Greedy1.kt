/**
 * https://leetcode.com/problems/maximum-number-of-non-overlapping-subarrays-with-sum-equals-target/
 *
 * Time Complexity:     O(`nNums`)
 * Space Complexity:    O(`nNums`)
 *
 * References:
 *  https://leetcode.com/problems/maximum-number-of-non-overlapping-subarrays-with-sum-equals-target/discuss/780882/Java-14-lines-Greedy-PrefixSum-with-line-by-line-explanation-easy-to-understand
 *  https://leetcode.com/problems/maximum-number-of-non-overlapping-subarrays-with-sum-equals-target/discuss/781047/Java-Greedy-Approach-Explained-HashMap-and-Prefix-Sum
 */
package com.zea7ot.leetcode.lvl4.lc1546

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0Greedy1 {
    fun maxNonOverlapping(nums: IntArray, target: Int): Int {
        // not used
        // val nNums = nums.size

        val freqs = hashMapOf(0 to -1)

        var count = 0
        var sum = 0
        var prevIdx = -1

        for (idx in nums.indices) {
            sum += nums[idx]

            freqs[sum - target]?.let {
                if (it >= prevIdx) {
                    ++count
                    prevIdx = idx
                }
            }

            freqs[sum] = idx
        }

        return count
    }
}