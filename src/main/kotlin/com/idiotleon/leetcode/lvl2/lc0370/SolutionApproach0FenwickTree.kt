package com.idiotleon.leetcode.lvl2.lc0370

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/range-addition/
 *
 * Time Complexity:     O(`nUpdates` * lg(`nUpdates`))
 * Space Complexity:    O(`nUpdates`)
 */
@Suppress(UNUSED)
class SolutionApproach0FenwickTree {
    fun getModifiedArray(
        length: Int, updates: Array<IntArray>
    ): IntArray {
        // not used
        // val nUpdates = updates.size

        val fenwick = IntArray(length) { 0 }

        for (update in updates) {
            val idxStart = update[0]
            val idxEnd = update[1]
            val value = update[2]

            update(idxEnd + 1, value, fenwick)
            update(idxStart, -value, fenwick)
        }

        for (idx in 0 until length) {
            fenwick[idx] = query(idx + 1, length, fenwick)
        }

        return fenwick
    }

    private fun update(index: Int, value: Int, bit: IntArray) {
        var idx = index
        while (idx > 0) {
            bit[idx - 1] += value
            idx -= (idx and -idx)
        }
    }

    private fun query(index: Int, range: Int, bit: IntArray): Int {
        var res = 0
        var idx = index
        while (idx <= range) {
            res += bit[idx - 1]
            idx += (idx and (-idx))
        }

        return res
    }
}