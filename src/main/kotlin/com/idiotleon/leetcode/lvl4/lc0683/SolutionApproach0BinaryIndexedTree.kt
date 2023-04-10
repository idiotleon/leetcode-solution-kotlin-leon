/**
 * https://leetcode.com/problems/k-empty-slots/
 *
 * Time Complexity:     O(`nBulbs` * lg(`nBulbs`))
 * Space Complexity:    O(`nBulbs`)
 *
 * References:
 *  https://leetcode.com/problems/k-empty-slots/discuss/107948/Iterate-over-time-vs.-iterate-over-position
 */
package com.idiotleon.leetcode.lvl4.lc0683

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0BinaryIndexedTree {
    fun kEmptySlots(bulbs: IntArray, k: Int): Int {
        val nBulbs = bulbs.size

        val visited = BooleanArray(nBulbs + 1) { false }
        val fenwick = IntArray(nBulbs + 1) { 0 }

        for ((idx, bulb) in bulbs.withIndex()) {
            val lo = bulb - (k + 1)
            val hi = bulb + (k + 1)

            update(bulb - 1, fenwick)
            visited[bulb] = true

            val cntCur = querySum(bulb - 1, fenwick)
            val cntLo = cntCur - 1
            val cntHi = cntCur + 1

            if (lo > 0 && visited[lo] && querySum(lo - 1, fenwick) == cntLo) return idx + 1
            if (hi <= nBulbs && visited[hi] && querySum(hi - 1, fenwick) == cntHi) return idx + 1
        }

        return -1
    }

    private fun update(index: Int, fenwick: IntArray) {
        val nBits = fenwick.size

        var idx = index + 1
        while (idx < nBits) {
            ++fenwick[idx]
            idx += idx and -idx
        }
    }

    private fun querySum(index: Int, fenwick: IntArray): Int {
        var sum = 0
        var idx = index + 1
        while (idx > 0) {
            sum += fenwick[idx]
            idx -= idx and -idx
        }

        return sum
    }
}