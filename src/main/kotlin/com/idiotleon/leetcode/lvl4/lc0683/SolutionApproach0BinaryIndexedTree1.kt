/**
 * https://leetcode.com/problems/k-empty-slots/
 *
 * Time Complexity:     O(`nBulbs` * lg(`nBulbs`))
 * Space Complexity:    O(`nBulbs`)
 *
 * References:
 *  https://leetcode.com/problems/k-empty-slots/discuss/107978/Python-O(nlog(n))-solution-using-binary-index-tree/154134
 *  https://leetcode.com/problems/k-empty-slots/discuss/107978/Python-O(nlog(n))-solution-using-binary-index-tree
 */
package com.idiotleon.leetcode.lvl4.lc0683

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0BinaryIndexedTree1 {
    fun kEmptySlots(bulbs: IntArray, k: Int): Int {
        val nBulbs = bulbs.size
        if (k >= nBulbs) return -1

        val fenwick = IntArray(nBulbs + 1) { 0 }
        val seen = HashSet<Int>()

        for ((idx, bulb) in bulbs.withIndex()) {
            update(bulb - 1, fenwick)

            if (seen.contains(bulb - k - 1)) {
                if (query(bulb - 1, fenwick) - query(bulb - k - 2, fenwick) == 1) {
                    return idx + 1
                }
            }

            if (seen.contains(bulb + k + 1)) {
                if (query(bulb + k, fenwick) - query(bulb - 1, fenwick) == 1) {
                    return idx + 1
                }
            }

            seen.add(bulb)
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

    private fun query(index: Int, fenwick: IntArray): Int {
        var sum = 0
        var idx = index + 1

        while (idx > 0) {
            sum += fenwick[idx]
            idx -= idx and -idx
        }

        return sum
    }
}