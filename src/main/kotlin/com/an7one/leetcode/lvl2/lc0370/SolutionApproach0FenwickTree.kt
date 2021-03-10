/**
 *
 */
package com.an7one.leetcode.lvl2.lc0370

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0FenwickTree {
    fun getModifiedArray(
        length: Int,
        updates: Array<IntArray>
    ): IntArray {
        val fenwick = IntArray(length) { 0 }

        for (update in updates) {
            val startIdx = update[0]
            val endIdx = update[1]
            val value = update[2]

            update(endIdx + 1, value, fenwick)
            update(startIdx, -value, fenwick)
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