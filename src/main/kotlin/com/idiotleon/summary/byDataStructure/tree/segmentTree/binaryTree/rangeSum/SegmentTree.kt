package com.idiotleon.summary.byDataStructure.tree.segmentTree.binaryTree.rangeSum

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SegmentTree(private val nums: IntArray) {
    private val root = buildTree(0, nums.lastIndex)

    fun update(idx: Int, value: Int) = update(idx, value, root)
    fun query(start: Int, end: Int) = query(start, end, root)

    private fun query(rangeLo: Int, rangeHi: Int, node: SegmentTreeNode?): Int {
        if (node == null || rangeLo > rangeHi || rangeLo > node.end || rangeHi < node.start) return 0
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