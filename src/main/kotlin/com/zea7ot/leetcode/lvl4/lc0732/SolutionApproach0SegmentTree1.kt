/**
 * https://leetcode.com/problems/my-calendar-iii/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * References:
 *  https://leetcode.com/problems/my-calendar-iii/discuss/702154/Four-AC-Solution%3A-TreeMap-BST-Segment-Tree-with-Diagrams-Beats-100-time-and-space-8ms-39.4MB
 */
package com.zea7ot.leetcode.lvl4.lc0732

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0SegmentTree1 {
    private companion object {
        private const val RANGE = 1e9.toInt()
    }

    private val tree = HashMap<Int, Int>()
    private val lazyTree = HashMap<Int, Int>()

    fun book(start: Int, end: Int): Int {
        update(start, end - 1, 0, 0, RANGE)
        return (tree[0] ?: 0) + (lazyTree[0] ?: 0)
    }

    private fun update(fromIdx: Int, toIdx: Int, idx: Int, lo: Int, hi: Int) {
        if (lo > hi) return
        val idx1 = 2 * idx + 1
        val idx2 = 2 * idx + 2

        // to update the node of the Segment Tree
        if ((lazyTree[idx] ?: 0) != 0) {
            tree[idx] = (tree[idx] ?: 0) + (lazyTree[idx] ?: 0)
            if (lo != hi) {
                lazyTree[idx1] = (lazyTree[idx1] ?: 0) + (lazyTree[idx] ?: 0)
                lazyTree[idx2] = (lazyTree[idx2] ?: 0) + (lazyTree[idx] ?: 0)
            }

            lazyTree.remove(idx)
        }

        // no overlap
        if (hi < fromIdx || lo > toIdx) return

        // full/complete overlap
        if (fromIdx <= lo && hi <= toIdx) {
            tree[idx] = 1 + (tree[idx] ?: 0)

            if (lo != hi) {
                lazyTree[idx1] = (lazyTree[idx1] ?: 0) + 1
                lazyTree[idx2] = (lazyTree[idx2] ?: 0) + 1
            }

            return
        }

        val mid = lo + (hi - lo) / 2
        update(fromIdx, toIdx, idx1, lo, mid)
        update(fromIdx, toIdx, idx2, mid + 1, hi)

        val value = maxOf(tree[idx1] ?: 0, tree[idx2] ?: 0)
        tree[idx] = value
    }
}