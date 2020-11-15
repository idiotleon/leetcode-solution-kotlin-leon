/**
 * https://leetcode.com/problems/my-calendar-iii/
 *
 * Time Complexity:     O(nEvents * lg(duration))
 * Space Complexity:    O(nEvents)
 *
 * References:
 *  https://leetcode.com/problems/my-calendar-iii/discuss/702154/Four-AC-Solution%3A-TreeMap-BST-Segment-Tree-with-Diagrams-Beats-100-time-and-space-8ms-39.4MB
 *  https://leetcode.com/problems/my-calendar-iii/discuss/288928/Lazy-Dynamic-Segment-Tree-A-general-template
 */
package com.zea7ot.leetcode.lvl4.lc0732

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0SegmentTree1 {
    private companion object {
        private const val RANGE = 1e9.toInt()
    }

    private val root = SegmentTreeNode(0, RANGE)

    fun book(start: Int, end: Int): Int {
        update(start, end - 1, root)
        return root.value
    }

    private fun update(rangeLo: Int, rangeHi: Int, node: SegmentTreeNode) {
        if (rangeLo <= node.start && node.end <= rangeHi) {
            ++node.lazy
        }

        // to update the node value
        node.value += node.lazy
        if (node.start != node.end) {
            val mid = node.start + (node.end - node.start) / 2
            if (node.left == null) {
                node.left = SegmentTreeNode(node.start, mid)
            }

            if (node.right == null) {
                node.right = SegmentTreeNode(mid + 1, node.end)
            }

            node.left?.let { it.lazy += node.lazy }
            node.right?.let { it.lazy += node.lazy }
        }

        node.lazy = 0

        // no overlap, or full/complete overlap
        if (rangeLo > node.end || rangeHi < node.start || rangeLo <= node.start && node.end <= rangeHi) return

        // partial overlap
        node.left?.let { update(rangeLo, rangeHi, it) }
        node.right?.let { update(rangeLo, rangeHi, it) }

        node.value = maxOf(node.left!!.value, node.right!!.value)
    }

    private data class SegmentTreeNode(val start: Int,
                                       val end: Int,
                                       var value: Int = 0,
                                       var lazy: Int = 0,
                                       var left: SegmentTreeNode? = null,
                                       var right: SegmentTreeNode? = null)

}