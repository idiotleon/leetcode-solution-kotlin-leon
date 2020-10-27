/**
 * https://leetcode.com/problems/my-calendar-iii/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * References:
 *  https://leetcode.com/problems/my-calendar-iii/discuss/702154/Four-AC-Solution%3A-TreeMap-BST-Segment-Tree-with-Diagrams-Beats-100-time-and-space-8ms-39.4MB
 *  https://leetcode.com/problems/my-calendar-iii/discuss/288928/Lazy-Dynamic-Segment-Tree-A-general-template
 */
package com.zea7ot.leetcode.lvl4.lc0732

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0SegmentTree {
    private companion object {
        private const val RANGE = 1e9.toInt()
    }

    private val root = SegmentTreeNode(0, RANGE)

    fun book(start: Int, end: Int): Int {
        update(start, end - 1, root)
        return root.value
    }

    private fun update(fromIdx: Int, toIdx: Int, node: SegmentTreeNode) {
        if (fromIdx <= node.lo && node.hi <= toIdx) {
            ++node.lazyValue
        }

        // to update the node value
        node.value += node.lazyValue
        if (node.lo != node.hi) {
            val mid = node.lo + (node.hi - node.lo) / 2
            if (node.left == null) {
                node.left = SegmentTreeNode(node.lo, mid)
            }

            if (node.right == null) {
                node.right = SegmentTreeNode(mid + 1, node.hi)
            }

            node.left?.let { it.lazyValue += node.lazyValue }
            node.right?.let { it.lazyValue += node.lazyValue }
        }

        node.lazyValue = 0

        // no overlap, or full/complete overlap
        if (fromIdx > node.hi || toIdx < node.lo || fromIdx <= node.lo && node.hi <= toIdx) return

        // partial overlap
        node.left?.let { update(fromIdx, toIdx, it) }
        node.right?.let { update(fromIdx, toIdx, it) }

        node.value = maxOf(node.left?.value ?: 0, node.right?.value ?: 0)
    }

    private data class SegmentTreeNode(val lo: Int, val hi: Int) {
        var value = 0
        var lazyValue = 0
        var left: SegmentTreeNode? = null
        var right: SegmentTreeNode? = null
    }
}