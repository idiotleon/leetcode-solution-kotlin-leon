/**
 * https://leetcode.com/problems/maximum-size-subarray-sum-equals-k/
 *
 * Time Complexity:     O(`nNums`)
 * Space Complexity:    O(`nNums`)
 *
 * References:
 *  https://leetcode.com/problems/maximum-size-subarray-sum-equals-k/discuss/77778/Java-O(n)-explain-how-I-come-up-with-this-idea/82048
 *  https://leetcode.com/problems/maximum-size-subarray-sum-equals-k/discuss/77778/Java-O(n)-explain-how-I-come-up-with-this-idea
 */
package com.zea7ot.leetcode.lvl3.lc0325

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0PrefixSums {
    fun maxSubArrayLen(nums: IntArray, k: Int): Int {
        // sanity check
        if (nums.isEmpty()) return 0

        // not used
        // val nNums = nums.size

        val prefixSums = hashMapOf(0 to -1)
        var sum = 0
        var longest = 0

        for (idx in nums.indices) {
            sum += nums[idx]

            prefixSums[sum - k]?.let {
                val len = idx - it
                longest = maxOf(longest, len)
            }

            if (prefixSums[sum] == null) {
                prefixSums[sum] = idx
            }
        }

        return longest
    }
}