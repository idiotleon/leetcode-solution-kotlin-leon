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

            update(cur, fenwick)
            visited[cur] = true

            val cntCur = querySum(cur, fenwick)
            val cntLo = cntCur - 1
            val cntHi = cntCur + 1

            if (lo > 0 && visited[lo] && querySum(lo, fenwick) == cntLo) return idx + 1
            if (hi <= nBulbs && visited[hi] && querySum(hi, fenwick) == cntHi) return idx + 1
        }

        return -1
    }

    private fun update(index: Int, fenwick: IntArray) {
        val nBits = fenwick.size

        var idx = index
        while (idx < nBits) {
            fenwick[idx] += 1
            idx += idx and -idx
        }
    }

    private fun querySum(index: Int, fenwick: IntArray): Int {
        var sum = 0
        var idx = index
        while (idx > 0) {
            sum += fenwick[idx]
            idx -= idx and -idx
        }

        return sum
    }
}