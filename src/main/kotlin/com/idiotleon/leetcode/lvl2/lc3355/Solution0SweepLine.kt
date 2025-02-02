package com.idiotleon.leetcode.lvl2.lc3355

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/zero-array-transformation-i/
 *
 * Time Complexity:     O(`nNums` + `nQueries`) ~ O(`nNums`)
 * Space Complexity:    O(`nNums`)
 */
@Suppress(UNUSED)
class Solution0SweepLine {
    fun isZeroArray(nums: IntArray, queries: Array<IntArray>): Boolean {
        val nNums = nums.size
        val nQueries = queries.size

        val freqs = IntArray(1 + nNums) { 0 }
        for ((start, end) in queries) {
            ++freqs[start]
            --freqs[end + 1]
        }

        // count of operations
        var count = 0
        for (idx in 0 until nNums) {
            count += freqs[idx]
            if (count < nums[idx]) {
                return false
            }
        }

        return true

    }
}