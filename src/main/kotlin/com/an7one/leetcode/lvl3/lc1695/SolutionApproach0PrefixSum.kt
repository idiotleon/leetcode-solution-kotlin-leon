/**
 * https://leetcode.com/problems/maximum-erasure-value/
 *
 * Time Complexity:     O(`nNums`)
 * Space Complexity:    O(`nNums`)
 *
 * References:
 *  https://leetcode.com/problems/maximum-erasure-value/discuss/978487/Prefix-Sum-Easy-Sol-with-video/794236
 *  https://leetcode.com/problems/maximum-erasure-value/discuss/978487/Prefix-Sum-Easy-Sol-with-video
 */
package com.an7one.leetcode.lvl3.lc1695

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0PrefixSum {
    fun maximumUniqueSubarray(nums: IntArray): Int {
        val nNums = nums.size

        val prefixSums = IntArray(nNums + 1) { 0 }
        for (idx in nums.indices) {
            prefixSums[idx + 1] = prefixSums[idx] + nums[idx]
        }

        // to keep track of the latest/nearest index till/to the current index
        val numToIdx = HashMap<Int, Int>()

        var maxValue = 0
        var prevIdx = 0

        for (idx in nums.indices) {
            prevIdx = maxOf(prevIdx, 1 + (numToIdx[nums[idx]] ?: -1))

            maxValue = maxOf(maxValue, prefixSums[idx + 1] - prefixSums[prevIdx])

            numToIdx[nums[idx]] = idx
        }

        return maxValue
    }
}