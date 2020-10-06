/**
 * https://leetcode.com/problems/subarray-sums-divisible-by-k/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(K)
 *
 * If sum[0, i] % K == sum[0, j] % K, sum[i + 1, j] is divisible by by K.
 * So for current index j, we need to find out how many index i (i < j) exit
 * that has the same mod of K.
 *
 * References:
 *  https://leetcode.com/problems/subarray-sums-divisible-by-k/
 */
package com.zea7ot.leetcode.lvl3.lc0974

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0PrefixSums {
    fun subarraysDivByK(nums: IntArray, K: Int): Int {
        val prefixSums = IntArray(K)
        prefixSums[0] = 1

        var count = 0
        var sum = 0

        for (num in nums) {
            sum += num
            sum %= K

            if (sum < 0) sum += K

            count += prefixSums[sum]
            ++prefixSums[sum]
        }

        return count
    }
}