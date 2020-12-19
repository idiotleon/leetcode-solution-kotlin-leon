/**
 * this is NOT yet correct solution
 */
package com.zea7ot.summary.byDataStructure.tree.segmentTree.binaryTree.rangeBoolean

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SegmentTree {
    private companion object {
        private const val RANGE = 1e9.toInt() + 1
    }

    private val root = SegmentTreeNode(0, RANGE, false)

    fun update(rangeLo: Int, rangeHi: Int, value: Boolean) = update(rangeLo, rangeHi, value, root)
    fun query(rangeLo: Int, rangeHi: Int) = query(rangeLo, rangeHi, root)

    private fun query(rangeLo: Int, rangeHi: Int, node: SegmentTreeNode?): Boolean {
        if (node == null) return true
        pushDown(node)

        // no overlap
        if (rangeLo > node.hi || rangeHi < node.lo) return false

        // complete overlap
        if (rangeLo <= node.lo && node.hi <= rangeHi) return node.state

        val leftState = query(rangeLo, rangeHi, node.left)
        val rightState = query(rangeLo, rangeHi, node.right)

        return leftState && rightState
    }

    private fun update(rangeLo: Int, rangeHi: Int,
                       value: Boolean,
                       node: SegmentTreeNode?) {
        if (node == null) return
        if (rangeLo <= node.lo && node.hi <= rangeHi) {
            node.lazy = value
        }

        pushDown(node)

        if (rangeLo <= node.lo && node.hi <= rangeHi || rangeHi < node.lo || rangeLo > node.hi) return

        update(rangeLo, rangeHi, value, node.left)
        update(rangeLo, rangeHi, value, node.right)

        node.state = node.left!!.state && node.right!!.state
    }

    private fun pushDown(node: SegmentTreeNode) {
        node.state = node.lazy

        if (node.lo != node.hi) {
            val mid = node.lo + (node.hi - node.lo) / 2

            if (node.left == null) {
                node.left = SegmentTreeNode(node.lo, mid)
            }

            if (node.right == null) {
                node.right = SegmentTreeNode(mid + 1, node.hi)
            }

            node.left!!.lazy = node.lazy
            node.right!!.lazy = node.lazy
        }

        node.lazy = false
    }

    private data class SegmentTreeNode(val lo: Int, val hi: Int,
                                       var state: Boolean = false,
                                       var lazy: Boolean = false,
                                       var left: SegmentTreeNode? = null,
                                       var right: SegmentTreeNode? = null)
}
