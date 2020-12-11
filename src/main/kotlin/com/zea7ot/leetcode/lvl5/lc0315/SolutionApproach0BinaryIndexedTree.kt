/**
 * https://leetcode.com/problems/count-of-smaller-numbers-after-self/
 *
 * Time Complexity:     O(`totalNums` * lg(`totalNums`)) + O(`totalNums`) ~ O(`totalNums` * lg(`totalNums`))
 * Space Complexity:    O(`totalNums`) + O(`max`)
 *
 * References:
 *  https://leetcode.com/problems/count-of-smaller-numbers-after-self/discuss/76674/3-Ways-(Segment-Tree-Binary-Indexed-Tree-Merge-Sort)-clean-Java-code
 */
package com.zea7ot.leetcode.lvl5.lc0315

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0BinaryIndexedTree {
    fun countSmaller(nums: IntArray): List<Int> {
        val ans = mutableListOf<Int>()
        if (nums.isEmpty()) return ans

        var minNum = Int.MAX_VALUE
        for (num in nums) {
            minNum = minOf(minNum, num)
        }

        // to build up the ranks
        var maxRank = Int.MIN_VALUE
        for (idx in nums.indices) {
            nums[idx] -= (minNum - 1)
            maxRank = maxOf(maxRank, nums[idx])
        }

        val fenwick = IntArray(maxRank + 1) { 0 }

        for (idx in nums.indices.reversed()) {
            ans.add(query(nums[idx] - 1, fenwick))
            update(nums[idx], fenwick)
        }

        ans.reverse()
        return ans
    }

    private fun update(index: Int, fenwick: IntArray) {
        val nBits = fenwick.size
        var idx = index

        while (idx < nBits) {
            ++fenwick[idx]
            idx += (idx and -idx)
        }
    }

    private fun query(index: Int, fenwick: IntArray): Int {
        var sum = 0
        var idx = index
        while (idx > 0) {
            sum += fenwick[idx]
            idx -= (idx and -idx)
        }

        return sum
    }
}