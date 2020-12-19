/**
 * https://leetcode.com/problems/my-calendar-ii/
 *
 * Time Complexity:     O(nEvents * lg(duration))
 *  nEvents, number of events
 *  duration, total duration of events
 *
 * Space Complexity:    O(nEvents)
 */
package com.zea7ot.leetcode.ood.lvl3.lc0731

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0SegmentTree {
    private companion object {
        private const val RANGE = 1e9.toInt() + 1
    }

    private val root = SegmentTree()

    fun book(start: Int, end: Int): Boolean {
        val k = root.query(start, end - 1)
        if (k >= 2) return false

        root.update(start, end - 1, 1)
        return true
    }

    private class SegmentTree {
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
    }

    private data class SegmentTreeNode(val start: Int,
                                       val end: Int,
                                       var k: Int = 0,
                                       var lazy: Int = 0,
                                       var left: SegmentTreeNode? = null,
                                       var right: SegmentTreeNode? = null)
}