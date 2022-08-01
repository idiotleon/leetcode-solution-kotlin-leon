package com.an7one.leetcode.ood.lvl4.lc0307

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/range-sum-query-mutable/
 *
 * Time Complexities:
 *  initialization:     O(`nNums` * lg(`nNums`))
 *  `update()`:         O(lg(`nNums`))
 *  `sumRange()`:       O(lg(`nNums`))
 *
 * Space Complexity:    O(`nNums`)
 *
 * Reference:
 * https://leetcode.com/problems/range-sum-query-mutable/discuss/75724/17-ms-Java-solution-with-segment-tree
 * https://www.geeksforgeeks.org/segment-tree-set-1-sum-of-given-range/
 */
@Suppress(UNUSED)
class SolutionApproach0SegmentTree(nums: IntArray) {
    private val root = SegmentTree(nums)

    fun update(idx: Int, value: Int) {
        root.update(idx, value)
    }

    fun sumRange(i: Int, j: Int): Int {
        return root.query(i, j)
    }

    private class SegmentTree(private val nums: IntArray) {
        private val root = buildTree(0, nums.lastIndex)

        fun update(idx: Int, value: Int) = update(idx, value, root)
        fun query(rangeLo: Int, rangeHi: Int) = query(rangeLo, rangeHi, root)

        private fun query(rangeLo: Int, rangeHi: Int, node: SegmentTreeNode?): Int {
            if (node == null) return 0
            val (start, end, sum, left, right) = node
            if (start == rangeLo && end == rangeHi) return sum

            val mid = start + (end - start) / 2
            return when {
                rangeHi <= mid -> query(rangeLo, rangeHi, left)
                rangeLo >= mid + 1 -> query(rangeLo, rangeHi, right)
                else -> query(rangeLo, mid, left) + query(mid + 1, rangeHi, right)
            }
        }

        private fun update(idx: Int, value: Int, node: SegmentTreeNode?) {
            if (node == null) return
            val (start, end, _, left, right) = node
            if (start == end) {
                node.sum = value
                return
            }

            val mid = start + (end - start) / 2
            if (idx <= mid) {
                update(idx, value, left)
            } else {
                update(idx, value, right)
            }

            node.sum = left!!.sum + right!!.sum
        }

        private fun buildTree(start: Int, end: Int): SegmentTreeNode? {
            if (start > end) return null

            val root = SegmentTreeNode(start, end)

            if (start == end) {
                root.sum = nums[start]
            } else {
                val mid = start + (end - start) / 2
                root.left = buildTree(start, mid)
                root.right = buildTree(mid + 1, end)
                root.sum = root.left!!.sum + root.right!!.sum
            }

            return root
        }

        private data class SegmentTreeNode(
            val start: Int,
            val end: Int,
            var sum: Int = 0,
            var left: SegmentTreeNode? = null,
            var right: SegmentTreeNode? = null
        )
    }
}