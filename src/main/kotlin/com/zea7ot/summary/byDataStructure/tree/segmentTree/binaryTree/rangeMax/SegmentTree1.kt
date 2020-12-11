/**
 * Segment Tree, with lazy propagation,
 *  implemented as a binary tree,
 *  given input as a stream
 *
 * Time Complexities:
 *  `query()`:          O(lg(nTreeNodes))
 *  `update()`:         O(lg(nTreeNodes))
 *
 * Space Complexity:    O(nTreeNodes)
 *
 * References:
 *  https://leetcode.com/problems/my-calendar-ii/discuss/109528/nlogd-Java-solution-using-segment-tree-with-lazy-propagation-applicable-to-the-general-case-of-K-booking
 */
package com.zea7ot.summary.byDataStructure.tree.segmentTree.binaryTree.rangeMax

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SegmentTree1 {
    private companion object {
        private const val RANGE = 1e9.toInt() + 1
    }

    private val root = SegmentTreeNode(0, RANGE, 0)

    fun query(start: Int, end: Int) = query(start, end, root)
    fun update(start: Int, end: Int, value: Int) = update(start, end, value, root)

    private fun query(rangeLo: Int, rangeHi: Int, node: SegmentTreeNode?): Int {
        if (node == null || rangeLo > rangeHi || rangeLo > node.end || rangeHi < node.start) return 0
        if (rangeLo <= node.start && node.end <= rangeHi) return node.k

        normalize(node)

        val leftMax = query(rangeLo, rangeHi, node.left)
        val rightMax = query(rangeLo, rangeHi, node.right)

        return maxOf(leftMax, rightMax)
    }

    private fun update(rangeLo: Int, rangeHi: Int, value: Int, node: SegmentTreeNode?) {
        if (node == null || rangeLo > rangeHi || rangeLo > node.end || rangeHi < node.start) return

        if (rangeLo <= node.start && node.end <= rangeHi) {
            node.k += value
            node.lazy += value
            return
        }

        normalize(node)

        update(rangeLo, rangeHi, value, node.left)
        update(rangeLo, rangeHi, value, node.right)

        node.k = maxOf(node.left!!.k, node.right!!.k)
    }

    private fun normalize(node: SegmentTreeNode?) {
        if (node == null) return
        val (start, end, k, lazy, left, right) = node

        if (start < end) {
            if (left == null || right == null) {
                val mid = start + (end - start) / 2
                node.left = SegmentTreeNode(start, mid, k)
                node.right = SegmentTreeNode(mid + 1, end, k)

            } else if (node.lazy > 0) {
                left.k += lazy
                left.lazy += lazy

                right.k += lazy
                right.lazy += lazy
            }
        }

        node.lazy = 0
    }

    private data class SegmentTreeNode(val start: Int,
                                       val end: Int,
                                       var k: Int = 0,
                                       var lazy: Int = 0,
                                       var left: SegmentTreeNode? = null,
                                       var right: SegmentTreeNode? = null)
}