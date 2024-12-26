package com.idiotleon.leetcode.lvl2.lc2121

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/intervals-between-identical-elements/
 *
 * Time Complexity:     O(`nNums`)
 * Space Complexity:    O(`nNums`)
 *
 * Reference:
 * https://leetcode.com/problems/intervals-between-identical-elements/solutions/1647454/c-prefix-suffix-array-with-explanation/
 */
@Suppress(UNUSED)
class Solution0LinearScan {
    fun getDistances(nums: IntArray): LongArray {
        val nNums = nums.size

        // TODO MutableList to List
        val numToIndices = HashMap<Int, MutableList<Int>>(nNums).also {
            for ((idx, num) in nums.withIndex()) {
                it.getOrPut(num) { mutableListOf() }.add(idx)
            }
        }

        val prefixSums = LongArray(nNums) { 0L }.also {
            for ((_, indices) in numToIndices) {
                for (idx in 1 until indices.size) {
                    it[indices[idx]] = it[indices[idx - 1]] + idx.toLong() * (indices[idx] - indices[idx - 1])
                }
            }
        }

        val suffixSums = LongArray(nNums) { 0 }.also {
            for ((_, indices) in numToIndices) {
                for (idx in indices.size - 2 downTo 0) {
                    it[indices[idx]] =
                        it[indices[idx + 1]] + (indices.size - 1 - idx).toLong() * (indices[idx + 1] - indices[idx])
                }
            }
        }

        val ans = LongArray(nNums) { 0L }.also {
            for (idx in 0 until nNums) {
                it[idx] += prefixSums[idx] + suffixSums[idx]
            }
        }
        return ans
    }
}