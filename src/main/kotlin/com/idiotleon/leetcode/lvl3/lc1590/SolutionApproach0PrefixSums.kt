/**
 * https://leetcode.com/problems/make-sum-divisible-by-p/
 *
 * Time Complexity:     O(`nNums`)
 * Space Complexity:    O(`nNums`)
 *
 * References:
 *  https://leetcode.com/problems/make-sum-divisible-by-p/discuss/854166/JavaPython-3-O(n)-code-w-brief-explanation-analysis-and-similar-problems.
 */
package com.idiotleon.leetcode.lvl3.lc1590

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0PrefixSums {
    fun minSubarray(nums: IntArray, p: Int): Int {
        val nNums = nums.size

        // to prevent integer overflow
        var remainder = 0
        for (num in nums) {
            remainder = (remainder + num) % p
        }

        var shortest = nNums

        // the prefix sum to the last index
        val map = hashMapOf(0 to -1)

        var sum = 0
        for (idx in nums.indices) {
            sum = (sum + nums[idx]) % p
            map[sum] = idx

            map[(sum - remainder + p) % p]?.let {
                shortest = minOf(shortest, idx - it)
            }
        }

        return if (shortest == nNums) -1 else shortest
    }
}