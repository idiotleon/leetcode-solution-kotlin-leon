package com.idiotleon.leetcode.lvl2.lc2248

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/intersection-of-multiple-arrays/
 *
 * Time Complexity:     O(`nRows` * `nCols`)
 * Space Complexity:    O(`RANGE`)
 */
@Suppress(UNUSED)
class Solution0LinearScan {
    private companion object {
        private const val RANGE = 1000 + 1
    }

    fun intersection(matrix: Array<IntArray>): List<Int> {
        val nRows = matrix.size
        val nCols = matrix[0].size

        val numToFreq = IntArray(RANGE) { 0 }.also {
            for (nums in matrix) {
                for (num in nums) {
                    ++it[num]
                }
            }
        }

        val ans = mutableListOf<Int>()
        for ((num, freq) in numToFreq.withIndex()) {
            if (freq == nRows) {
                ans.add(num)
            }
        }
        return ans
    }
}