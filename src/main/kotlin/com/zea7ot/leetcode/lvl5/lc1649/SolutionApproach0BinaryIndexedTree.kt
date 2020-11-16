/**
 * https://leetcode.com/problems/create-sorted-array-through-instructions/
 *
 * Time Complexity:     O(`nInst` * lg(`nInst`))
 * Space Complexity:    O(`RANGE`)
 *
 * References:
 *  https://leetcode.com/problems/create-sorted-array-through-instructions/discuss/927531/JavaC%2B%2BPython-Binary-Indexed-Tree
 */
package com.zea7ot.leetcode.lvl5.lc1649

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0BinaryIndexedTree {
    private companion object {
        private const val MOD = 1e9.toInt() + 7

        private const val RANGE = 1e5.toInt() + 1
    }

    fun createSortedArray(instructions: IntArray): Int {
        // not used
        // val nInst = instructions.size

        var ans = 0

        val fenwick = IntArray(RANGE) { 0 }

        for (idx in instructions.indices) {
            ans += minOf(query(instructions[idx] - 1, fenwick),
                    idx - query(instructions[idx], fenwick)) % MOD
            ans %= MOD

            update(instructions[idx], fenwick)
        }

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