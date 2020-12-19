/**
 * https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * References:
 *  https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/discuss/935935/Java-Detailed-Explanation-O(N)-Prefix-SumMap-Longest-Target-Sub-Array
 */
package com.zea7ot.leetcode.lvl3.lc1658

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0PrefixSums {
    fun minOperations(nums: IntArray, x: Int): Int {
        val nNums = nums.size

        var target = -x
        for (num in nums) target += num
        if (target == 0) return nNums

        val prefixSums = hashMapOf(0 to -1)
        var sum = 0
        var longest = Int.MIN_VALUE

        for (idx in nums.indices) {
            sum += nums[idx]

            prefixSums[sum - target]?.let {
                longest = maxOf(longest, idx - it)
            }

            prefixSums[sum] = idx
        }

        return if (longest == Int.MIN_VALUE) -1 else nNums - longest
    }
}