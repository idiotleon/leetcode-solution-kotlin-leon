/**
 * @author: Leon
 * https://leetcode.com/problems/falling-squares/
 *
 * Time Complexity:     O(`nPos` * lg(`nPos`)) + O(`nPos` * lg(`nPos`)) ~ O(`nPos` * lg(`nPos`))
 * Space Complexity:    O(`nPos`)
 */
package com.idiotleon.leetcode.lvl4.lc0699

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0SegmentTree1 {
    fun fallingSquares(positions: Array<IntArray>): List<Int> {
        val nPos = positions.size

        val coordSet = HashSet<Int>()
        for ((start, sideLen) in positions) {
            val end = start + sideLen - 1
            coordSet.add(start)
            coordSet.add(end)
        }
        val sortedCoords = coordSet.toMutableList().also { it.sort() }

        val ranksMap = HashMap<Int, Int>()
        var ranks = 0
        for (coord in sortedCoords) ranksMap[coord] = ranks++

        val root = SegmentTree()

        val ans = mutableListOf<Int>()
        var tallest = 0

        for ((start, sideLen) in positions) {
            val end = start + sideLen

            val height = root.query(start, end - 1) + sideLen

            root.update(start, end - 1, height)
            tallest = maxOf(tallest, height)

            ans.add(tallest)
        }

        return ans
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

            node.max = maxOf(node.left!!.max, node.right!!.max)
        }

        private fun query(rangeLo: Int, rangeHi: Int, node: SegmentTreeNode?): Int {
            if (node == null) return 0
            pushDown(node)

            // no overlap
            if (rangeLo > node.hi || rangeHi < node.lo) return 0

            // complete overlap
            if (rangeLo <= node.lo && node.hi <= rangeHi) return node.max

            val leftMax = query(rangeLo, rangeHi, node.left)
            val rightMax = query(rangeLo, rangeHi, node.right)

            return maxOf(leftMax, rightMax)
        }

        private fun pushDown(node: SegmentTreeNode) {
            node.max = maxOf(node.max, node.lazy)

            if (node.lo != node.hi) {
                val mid = node.lo + (node.hi - node.lo) / 2

                if (node.left == null) {
                    node.left = SegmentTreeNode(node.lo, mid)
                }

                if (node.right == null) {
                    node.right = SegmentTreeNode(mid + 1, node.hi)
                }
                node.left!!.lazy = maxOf(node.left!!.lazy, node.lazy)
                node.right!!.lazy = maxOf(node.right!!.lazy, node.lazy)
            }

            node.lazy = 0
        }
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