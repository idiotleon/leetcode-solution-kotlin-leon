package com.idiotleon.leetcode.lvl3.lc0253

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/meeting-rooms-ii/
 *
 * Time Complexity:     O(`nIntervals` * lg(range))
 *  range, the data range ever exists
 *
 * Space Complexity:    O(`nIntervals`)
 */
@Suppress(UNUSED)
class SolutionApproach0SegmentTree {
    fun minMeetingRooms(intervals: Array<IntArray>): Int {
        // not used
        // val nIntervals = intervals.size
        val root = SegmentTree()

        for (interval in intervals) {
            val (start, end) = interval

            root.update(start, end - 1, 1)
        }

        return root.queryAll()
    }

    private class SegmentTree {
        private companion object {
            private const val RANGE = 1e9.toInt() + 1
        }

        private val root = SegmentTreeNode(0, RANGE)

        fun query(rangeLo: Int, rangeHi: Int) = query(rangeLo, rangeHi, root)
        fun queryAll() = root.maxFreq
        fun update(rangeLo: Int, rangeHi: Int, freq: Int) = update(rangeLo, rangeHi, freq, root)

        private fun query(rangeLo: Int, rangeHi: Int, node: SegmentTreeNode?): Int {
            if (node == null) return 0
            pushDown(node)

            if (rangeLo > node.hi || rangeHi < node.lo) return 0
            if (rangeLo <= node.lo && node.hi <= rangeHi) return node.maxFreq

            val leftMaxFreq = query(rangeLo, rangeHi, node.left)
            val rightMaxFreq = query(rangeLo, rangeHi, node.right)

            return maxOf(leftMaxFreq, rightMaxFreq)
        }

        private fun update(rangeLo: Int, rangeHi: Int, value: Int, node: SegmentTreeNode?) {
            if (node == null) return

            if (rangeLo <= node.lo && node.hi <= rangeHi) {
                node.lazy += value
            }

            pushDown(node)

            if (rangeLo <= node.lo && node.hi <= rangeHi || rangeLo > node.hi || rangeHi < node.lo) return

            update(rangeLo, rangeHi, value, node.left)
            update(rangeLo, rangeHi, value, node.right)

            node.maxFreq = maxOf(node.left!!.maxFreq, node.right!!.maxFreq)
        }

        private fun pushDown(node: SegmentTreeNode) {
            node.maxFreq += node.lazy

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
    }

    private data class SegmentTreeNode(
        val lo: Int,
        val hi: Int,
        var maxFreq: Int = 0,
        var lazy: Int = 0,
        var left: SegmentTreeNode? = null,
        var right: SegmentTreeNode? = null
    )
}