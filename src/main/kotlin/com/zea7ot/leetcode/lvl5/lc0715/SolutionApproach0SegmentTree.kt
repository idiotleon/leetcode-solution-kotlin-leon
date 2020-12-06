package com.zea7ot.leetcode.lvl5.lc0715

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0SegmentTree {
    private val root = SegmentTree()

    fun addRange(left: Int, right: Int) {
        root.update(left, right - 1, 1)
    }

    fun queryRange(left: Int, right: Int): Boolean {
        val freq = root.query(left, right - 1)
        return freq > 0
    }

    fun removeRange(left: Int, right: Int) {
        root.update(left, right - 1, 1)
    }

    private class SegmentTree {
        private companion object {
            private const val RANGE = 1e9.toInt() + 1
        }

        private val root = SegmentTreeNode(0, RANGE)

        fun update(rangeLo: Int, rangeHi: Int, value: Int) = update(rangeLo, rangeHi, value, root)
        fun query(rangeLo: Int, rangeHi: Int) = query(rangeLo, rangeHi, root)

        private fun update(rangeLo: Int, rangeHi: Int, value: Int, node: SegmentTreeNode?) {
            if (node == null) return
            if (rangeLo <= node.lo && node.hi <= rangeHi) {
                node.lazy += value
            }

            pushDown(node)

            // complete overlap or no overlap at all
            if (rangeLo <= node.lo && node.hi <= rangeHi || rangeHi < node.lo || rangeLo > node.hi) return

            update(rangeLo, rangeHi, value, node.left)
            update(rangeLo, rangeHi, value, node.right)

            node.min = minOf(node.left!!.min, node.right!!.min)
        }

        private fun query(rangeLo: Int, rangeHi: Int, node: SegmentTreeNode?): Int {
            if (node == null) return 0
            pushDown(node)

            // no overlap
            if (rangeLo > node.hi || rangeHi < node.lo) return RANGE

            // complete overlap
            if (rangeLo <= node.lo && node.hi <= rangeHi) return node.min

            val leftMin = query(rangeLo, rangeHi, node.left)
            val rightMin = query(rangeLo, rangeHi, node.right)

            return minOf(leftMin, rightMin)
        }

        private fun pushDown(node: SegmentTreeNode) {
            node.min += node.lazy

            if (node.lo != node.hi) {
                val mid = node.lo + (node.hi - node.lo) / 2

                if (node.left == null) {
                    node.left = SegmentTreeNode(node.lo, mid)
                }

                if (node.right == null) {
                    node.right = SegmentTreeNode(mid + 1, node.hi)
                }


                node.left!!.lazy += node.lazy
                node.right!!.lazy += node.lazy
            }

            node.lazy = 0
        }

        private data class SegmentTreeNode(
            val lo: Int,
            val hi: Int,
            var min: Int = 0,
            var lazy: Int = 0,
            var left: SegmentTreeNode? = null,
            var right: SegmentTreeNode? = null
        )
    }
}