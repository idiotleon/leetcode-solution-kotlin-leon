/**
 * Time Complexities:
 *  `query()`:              O(lg(nTreeNodes))
 *  `update()`:             O(lg(nTreeNodes))
 *
 * Space Complexity:        O(nTreeNodes)
 *
 * References:
 *  https://leetcode.com/problems/range-module/discuss/495876/Clean-And-Concise-Lazy-Propagation-Segment-Tree
 */
package com.zea7ot.summary.byDataStructure.tree.segmentTree.binaryTree.rangeBoolean.withoutLazyPropagation

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SegmentTree {
    private companion object {
        private const val RANGE = 1e9.toInt() + 1
    }

    private val root = SegmentTreeNode(0, RANGE, false)

    fun update(rangeLo: Int, rangeHi: Int, value: Boolean) = update(rangeLo, rangeHi, value, root)
    fun queryRange(rangeLo: Int, rangeHi: Int) = query(rangeLo, rangeHi, root)

    private fun query(rangeLo: Int, rangeHi: Int, node: SegmentTreeNode?): Boolean {
        if (node == null) return true
        if (rangeLo >= node.hi || rangeHi <= node.lo) return true

        if (rangeLo <= node.lo && node.hi <= rangeHi || (node.left == null)) return node.state

        val mid = node.lo + (node.hi - node.lo) / 2

        return when {
            rangeHi <= mid -> query(rangeLo, rangeHi, node.left)
            rangeLo >= mid -> query(rangeLo, rangeHi, node.right)
            else -> query(rangeLo, rangeHi, node.left) && query(rangeLo, rangeHi, node.right)
        }
    }

    private fun update(rangeLo: Int, rangeHi: Int,
                       value: Boolean,
                       node: SegmentTreeNode?) {
        if (node == null) return

        if (rangeLo <= node.lo && node.hi <= rangeHi) {
            node.state = value
            node.left = null
            node.right = null
            return
        }

        if (rangeLo >= node.hi || rangeHi <= node.lo) return

        val mid = node.lo + (node.hi - node.lo) / 2
        if (node.left == null) {
            node.left = SegmentTreeNode(node.lo, mid, node.state)
            node.right = SegmentTreeNode(mid, node.hi, node.state)
        }

        update(rangeLo, rangeHi, value, node.left)
        update(rangeLo, rangeHi, value, node.right)
        node.state = node.left!!.state && node.right!!.state
    }

    private data class SegmentTreeNode(val lo: Int, val hi: Int,
                                       var state: Boolean = false,
                                       var left: SegmentTreeNode? = null,
                                       var right: SegmentTreeNode? = null)
}
