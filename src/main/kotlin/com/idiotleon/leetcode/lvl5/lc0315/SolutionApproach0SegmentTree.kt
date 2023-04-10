package com.idiotleon.leetcode.lvl5.lc0315

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/count-of-smaller-numbers-after-self/
 *
 * Time Complexity:     O(`nNums` * lg(`nNums`))
 * Space Complexity:    O(`nNums`)
 *
 * References:
 *  https://leetcode.com/problems/count-of-smaller-numbers-after-self/discuss/76674/3-Ways-(Segment-Tree-Binary-Indexed-Tree-Merge-Sort)-clean-Java-code
 */
@Suppress(UNUSED)
class SolutionApproach0SegmentTree {
    fun countSmaller(nums: IntArray): List<Int> {
        val nNums = nums.size

        val ans = MutableList(nNums) { 0 }
        // sanity check
        if (nums.isEmpty())
            return ans

        val min = nums.minOrNull()!!
        val max = nums.maxOrNull()!!

        val root = SegmentTreeNode(min, max)

        for (idx in nums.indices.reversed()) {
            ans[idx] = query(nums[idx] - 1, root)
            update(nums[idx], root)
        }

        return ans
    }

    private fun query(value: Int, node: SegmentTreeNode?): Int {
        if (node == null)
            return 0

        return if (value >= node.max) {
            node.count
        } else {
            val mid = node.getMid()

            if (value < mid) {
                query(value, node.left)
            } else {
                query(value, node.left) + query(value, node.right)
            }
        }
    }

    private fun update(value: Int, node: SegmentTreeNode?) {
        if (node == null)
            return

        if (value < node.min || value > node.max)
            return

        ++node.count
        if (node.max == node.min)
            return

        val mid = node.getMid()
        if (value < mid) {
            if (node.left == null)
                node.left = SegmentTreeNode(node.min, mid - 1)

            update(value, node.left)
        } else {
            if (node.right == null)
                node.right = SegmentTreeNode(mid, node.max)

            update(value, node.right)
        }
    }

    private data class SegmentTreeNode(
        val min: Int,
        val max: Int,
        var count: Int = 0,
        var left: SegmentTreeNode? = null,
        var right: SegmentTreeNode? = null
    ) {
        fun getMid() = (max + 1 - min) / 2 + min
    }
}