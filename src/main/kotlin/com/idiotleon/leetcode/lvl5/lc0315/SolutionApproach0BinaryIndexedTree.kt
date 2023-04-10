package com.idiotleon.leetcode.lvl5.lc0315

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/count-of-smaller-numbers-after-self/
 *
 * Time Complexity:     O(`nNums` * lg(`nNums`)) + O(`nNums`) ~ O(`nNums` * lg(`nNums`))
 * Space Complexity:    O(`nNums`) + O(`highestRank`)
 *
 * References:
 *  https://leetcode.com/problems/count-of-smaller-numbers-after-self/discuss/76674/3-Ways-(Segment-Tree-Binary-Indexed-Tree-Merge-Sort)-clean-Java-code
 */
@Suppress(UNUSED)
class SolutionApproach0BinaryIndexedTree {
    fun countSmaller(nums: IntArray): List<Int> {
        val nNums = nums.size

        val ans = MutableList(nNums) { 0 }
        // sanity check
        if (nums.isEmpty()) return ans

        val min = nums.minOrNull()!!
        var highestRank = Int.MIN_VALUE
        for (idx in nums.indices) {
            nums[idx] -= min - 1
            highestRank = maxOf(highestRank, nums[idx])
        }

        val fenwick = IntArray(highestRank + 1) { 0 }
        for (idx in nums.indices.reversed()) {
            ans[idx] = query(nums[idx] - 1, fenwick)
            update(nums[idx], fenwick)
        }

        return ans
    }

    private fun update(idx: Int, fenwick: IntArray) {
        val nBits = fenwick.size

        var idx = idx
        while (idx < nBits) {
            ++fenwick[idx]
            idx += (idx and -idx)
        }
    }

    private fun query(idx: Int, fenwick: IntArray): Int {
        var idx = idx
        var sum = 0

        while (idx > 0) {
            sum += fenwick[idx]
            idx -= (idx and -idx)
        }

        return sum
    }
}