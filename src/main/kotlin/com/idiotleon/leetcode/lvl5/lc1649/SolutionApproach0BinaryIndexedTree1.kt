package com.idiotleon.leetcode.lvl5.lc1649

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/create-sorted-array-through-instructions/
 *
 * Time Complexity:     O(`nInsts` * lg(`nInsts`))
 * Space Complexity:    O(`DATA_RANGE`)
 *
 * Reference:
 * https://youtu.be/v2Q4ZjPeFuc?t=1615
 * https://leetcode.com/problems/create-sorted-array-through-instructions/discuss/927531/JavaC%2B%2BPython-Binary-Indexed-Tree
 */
@Suppress(UNUSED)
class SolutionApproach0BinaryIndexedTree1 {
    private companion object {
        private const val MOD = 1e9.toInt() + 7
        private const val DATA_RANGE = 1e5.toInt() + 7
    }

    fun createSortedArray(instructions: IntArray): Int {
        // not used
        // val nInsts = instructions.size

        var minCost = 0
        val fenwick = IntArray(DATA_RANGE) { 0 }

        for (idx in instructions.indices) {
            minCost += minOf(
                query(instructions[idx] - 1, fenwick), idx - query(instructions[idx], fenwick)
            ) % MOD
            minCost %= MOD

            update(instructions[idx], fenwick)
        }

        return minCost
    }

    private fun update(index: Int, fenwick: IntArray) {
        val nBits = fenwick.size
        var idx = index + 1

        while (idx < nBits) {
            ++fenwick[idx]
            idx += (idx and -idx)
        }
    }

    private fun query(index: Int, fenwick: IntArray): Int {
        var sum = 0

        var idx = index + 1

        while (idx > 0) {
            sum += fenwick[idx]
            idx -= (idx and -idx)
        }

        return sum
    }
}