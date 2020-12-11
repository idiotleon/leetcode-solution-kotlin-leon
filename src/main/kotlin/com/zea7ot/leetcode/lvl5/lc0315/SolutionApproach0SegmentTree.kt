/**
 * https://leetcode.com/problems/count-of-smaller-numbers-after-self/
 *
 * Time Complexity:     O(`nNums` * lg(`nNums`))
 * Space Complexity:    O(`nNums`)
 *
 * References:
 *  https://leetcode.com/problems/count-of-smaller-numbers-after-self/discuss/76674/3-Ways-(Segment-Tree-Binary-Indexed-Tree-Merge-Sort)-clean-Java-code
 */
package com.zea7ot.leetcode.lvl5.lc0315

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0SegmentTree {
    fun countSmaller(nums: IntArray): List<Int> {
        // not used
        // val nNums = nums.size

        val ans = mutableListOf<Int>()
        if (nums.isEmpty()) return ans

        var min = Int.MAX_VALUE
        var max = Int.MIN_VALUE
        for (num in nums) {
            min = minOf(min, num)
            max = maxOf(max, num)
        }

        val root = SegmentTreeNode(min, max)

        for (idx in nums.indices.reversed()) {
            ans.add(query(nums[idx] - 1, root))
            update(nums[idx], root)
        }

        ans.reverse()
        return ans
    }

    private fun query(value: Int, node: SegmentTreeNode?): Int {
        if (node == null) return 0

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
        if (node == null) return
        if (value < node.min || value > node.max) return

        ++node.count
        if (node.max == node.min) return

        val mid = node.getMid()
        if (value < mid) {
            if (node.left == null) {
                node.left = SegmentTreeNode(node.min, mid - 1)
            }

            update(value, node.left)
        } else {
            if (node.right == null) {
                node.right = SegmentTreeNode(mid, node.max)
            }

            update(value, node.right)
        }
    }

    private data class SegmentTreeNode(val min: Int,
                                       val max: Int,
                                       var count: Int = 0,
                                       var left: SegmentTreeNode? = null,
                                       var right: SegmentTreeNode? = null) {
        fun getMid() = ((max + 1 - min) / 2 + min)
    }
}