package com.an7one.leetcode.ood.lvl4.lc0732

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/my-calendar-iii/
 *
 * Time Complexity:     O(`nEvents` * lg(`duration`))
 * Space Complexity:    O(`nEvents`)
 *
 * Reference:
 * https://leetcode.com/problems/my-calendar-iii/discuss/702154/Four-AC-Solution%3A-TreeMap-BST-Segment-Tree-with-Diagrams-Beats-100-time-and-space-8ms-39.4MB
 * https://leetcode.com/problems/my-calendar-iii/discuss/288928/Lazy-Dynamic-Segment-Tree-A-general-template
 */
@Suppress(UNUSED)
class SolutionApproach0SegmentTree {
    private val root = SegmentTree()

    fun book(start: Int, end: Int): Int {
        root.update(start, end - 1)

        return root.getRootMax()
    }

    private class SegmentTree {
        private companion object {
            private const val RANGE = 1e9.toInt() + 1
        }

        private val root = SegmentTreeNode(0, RANGE)

        fun update(rangeLo: Int, rangeHi: Int) = update(rangeLo, rangeHi, 1, root)
        fun getRootMax() = root.max

        // not used
        // fun query(rangeLo: Int, rangeHi: Int) = query(rangeLo, rangeHi, root)


        private fun update(rangeLo: Int, rangeHi: Int, value: Int, node: SegmentTreeNode?) {
            if (node == null) return
            if (rangeLo <= node.lo && node.hi <= rangeHi) {
                node.lazy += value
            }

            pushDown(node)

            // completely overlap or no overlap at all
            if (rangeLo <= node.lo && node.hi <= rangeHi || rangeLo > node.hi || rangeHi < node.lo) return

            update(rangeLo, rangeHi, value, node.left)
            update(rangeLo, rangeHi, value, node.right)

            node.max = maxOf(node.left!!.max, node.right!!.max)
        }

        // not used
        /*        private fun query(rangeLo: Int, rangeHi: Int, node: SegmentTreeNode?): Int {
                    if (node == null) return 0
                    pushDown(node)

                    // no overlap
                    if (rangeLo > node.hi || rangeHi < node.lo) return 0

                    // complete overlap
                    if (rangeLo <= node.lo && node.hi <= rangeHi) return node.max

                    val leftMax = query(rangeLo, rangeHi, node.left)
                    val rightMax = query(rangeLo, rangeHi, node.right)
                    return maxOf(leftMax, rightMax)
                }*/

        private fun pushDown(node: SegmentTreeNode) {
            node.max += node.lazy

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
            var max: Int = 0,
            var lazy: Int = 0,
            var left: SegmentTreeNode? = null,
            var right: SegmentTreeNode? = null
        )
    }
}