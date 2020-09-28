/**
 * https://leetcode.com/problems/maximum-size-subarray-sum-equals-k/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 *
 * References:
 *  https://leetcode.com/problems/maximum-size-subarray-sum-equals-k/discuss/77778/Java-O(n)-explain-how-I-come-up-with-this-idea/82048
 *  https://leetcode.com/problems/maximum-size-subarray-sum-equals-k/discuss/77778/Java-O(n)-explain-how-I-come-up-with-this-idea
 */
package com.zea7ot.lc.lvl3.lc0325

import com.zea7ot.lc.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0PrefixSums {
    fun maxSubArrayLen(nums: IntArray, k: Int): Int {
        // sanity check
        if (nums.isEmpty()) return 0

        val totalNums = nums.size

        val prefixSums = hashMapOf(0 to -1)
        var sum = 0
        var longest = 0

        for (i in 0 until totalNums) {
            sum += nums[i]

            prefixSums[sum - k]?.let {
                val len = i - it
                longest = maxOf(longest, len)
            }

            if (prefixSums[sum] == null)
                prefixSums[sum] = i
        }

        return longest
    }
}