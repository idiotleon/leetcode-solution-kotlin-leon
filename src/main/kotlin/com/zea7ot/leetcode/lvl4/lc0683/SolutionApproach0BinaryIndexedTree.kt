/**
 * https://leetcode.com/problems/k-empty-slots/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * References:
 *  https://leetcode.com/problems/k-empty-slots/discuss/107948/Iterate-over-time-vs.-iterate-over-position
 */
package com.zea7ot.leetcode.lvl4.lc0683

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0BinaryIndexedTree {
    fun kEmptySlots(bulbs: IntArray, k: Int): Int {
        val nBulbs = bulbs.size

        val visited = BooleanArray(nBulbs + 1) { false }
        val fenwick = IntArray(nBulbs + 1) { 0 }

        for (idx in bulbs.indices) {
            val cur = bulbs[idx]
            val lo = cur - (k + 1)
            val hi = cur + (k + 1)

            insert(cur, fenwick)
            visited[cur] = true

            val cntCur = search(cur, fenwick)
            val cntLo = cntCur - 1
            val cntHi = cntCur + 1

            if (lo > 0 && visited[lo] && search(lo, fenwick) == cntLo) return idx + 1
            if (hi <= nBulbs && visited[hi] && search(hi, fenwick) == cntHi) return idx + 1
        }

        return -1
    }

    private fun insert(index: Int, bit: IntArray) {
        val nBits = bit.size

        var idx = index
        while (idx < nBits) {
            bit[idx] += 1
            idx += idx and -idx
        }
    }

    private fun search(index: Int, bit: IntArray): Int {
        var sum = 0
        var idx = index
        while (idx > 0) {
            sum += bit[idx]
            idx -= idx and -idx
        }

        return sum
    }
}