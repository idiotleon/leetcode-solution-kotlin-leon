/**
 * https://leetcode.com/problems/longest-increasing-subsequence/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 */
package com.zea7ot.leetcode.lvl3.lc0300.followup

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0BinaryIndexedTree {
    fun lengthOfLIS(nums: IntArray): Int {
        // not required
        // if(nums.isEmpty()) return 0

        val totalNums = nums.size

        // to build up the ranks (map)
        val sorted = nums.copyOf().also { it.sort() }
        val ranksMap = HashMap<Int, Int>()
        for (idx in nums.indices) {
            ranksMap[sorted[idx]] = 1 + idx
        }

        // to be initialized as 0, rather than 1
        // if there is no sanity check for empty input arrays
        var longest = 0
        val fenwick = BinaryIndexedTree(totalNums)
        for (idx in nums.indices) {
            ranksMap[nums[idx]]?.let { rankId ->
                val value = 1 + fenwick.query(rankId - 1)
                longest = maxOf(longest, value)
                fenwick.update(rankId, value)
            }
        }

        return longest
    }

    private class BinaryIndexedTree(size: Int) {
        private val lensBIT = IntArray(size + 1) { 0 }

        fun update(index: Int, value: Int) {
            val totalBits = lensBIT.size
            var idx = index
            while (idx < totalBits) {
                lensBIT[idx] = maxOf(lensBIT[idx], value)
                idx += idx and (-idx)
            }
        }

        fun query(index: Int): Int {
            var idx = index
            var longest = lensBIT[idx]
            while (idx > 0) {
                longest = maxOf(longest, lensBIT[idx])
                idx -= idx and (-idx)
            }

            return longest
        }
    }
}