/**
 * https://leetcode.com/problems/ways-to-make-a-fair-array/
 *
 * Time Complexity:     O(`nNums`)
 * Space Complexity:    O(`nNums`)
 *
 * References:
 *  https://leetcode.com/problems/ways-to-make-a-fair-array/discuss/944355/C%2B%2B-O(N)-Time-O(1)-Space-PrefixSuffix-Sum
 */
package com.zea7ot.leetcode.lvl3.lc1664

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0SuffixSums {
    fun waysToMakeFair(nums: IntArray): Int {
        val nNums = nums.size

        val oddSuffixSums = IntArray(nNums + 1) { 0 }
        val evenSuffixSums = IntArray(nNums + 1) { 0 }

        for (idx in nums.indices.reversed()) {
            if (idx % 2 == 0) evenSuffixSums[idx] += nums[idx]
            else oddSuffixSums[idx] += nums[idx]

            evenSuffixSums[idx] += evenSuffixSums[idx + 1]
            oddSuffixSums[idx] += oddSuffixSums[idx + 1]
        }

        var count = 0
        var evenPrefixSum = 0
        var oddPrefixSum = 0
        for (idx in nums.indices) {
            if (evenPrefixSum + oddSuffixSums[idx + 1] == oddPrefixSum + evenSuffixSums[idx + 1]) {
                ++count
            }

            if (idx % 2 == 0) evenPrefixSum += nums[idx]
            else oddPrefixSum += nums[idx]
        }

        return count
    }
}