package com.idiotleon.leetcode.ood.lvl4.lc0307

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/range-sum-query-mutable/
 *
 * Time Complexities:
 *  initialization:     O(`nNums`)
 *  update():           O(lg(`nNums`))
 *  sumRange():         O(lg(`nNums`))
 *
 * Space Complexity:    O(`nNums`)
 *
 * Reference:
 * https://youtu.be/e_bK-dgPvfM
 */
@Suppress(UNUSED)
class SolutionApproach0SegmentTree1(nums: IntArray) {
    private val root = SegmentTree(nums)

    fun update(idx: Int, value: Int) {
        root.update(idx, value)
    }

    fun sumRange(i: Int, j: Int): Int {
        return root.query(i, j)
    }

    private class SegmentTree(private val nums: IntArray) {
        private val nNums = nums.size
        private val tree = IntArray(1e6.toInt()) { 0 }

        init {
            if (nums.isNotEmpty()) {
                buildTree(0, 0, nNums - 1)
            }
        }

        fun update(idx: Int, value: Int) {
            if (nums.isNotEmpty()) {
                update(idx, value, 0, 0, nNums - 1)
            }
        }

        fun query(rangeLo: Int, rangeHi: Int) = query(rangeLo, rangeHi, 0, 0, nNums - 1)

        fun update(idx: Int, value: Int, node: Int, start: Int, end: Int) {
            if (start == end) {
                nums[idx] = value
                tree[node] = value
                return
            }

            val mid = start + (end - start) / 2
            val leftNode = 2 * node + 1
            val rightNode = 2 * node + 2

            if (idx in start..mid) {
                update(idx, value, leftNode, start, mid)
            } else {
                update(idx, value, rightNode, mid + 1, end)
            }

            tree[node] = tree[leftNode] + tree[rightNode]
        }

        fun query(
            rangeLo: Int, rangeHi: Int, node: Int, start: Int, end: Int
        ): Int {
            if (rangeHi < start || rangeLo > end) return 0
            if (start == end) return nums[start]

            val mid = start + (end - start) / 2
            val leftNode = node * 2 + 1
            val rightNode = node * 2 + 2

            val leftSum = query(rangeLo, rangeHi, leftNode, start, mid)
            val rightSum = query(rangeLo, rangeHi, rightNode, mid + 1, end)

            return leftSum + rightSum
        }

        private fun buildTree(node: Int, start: Int, end: Int) {
            if (start == end) {
                tree[node] = nums[start]
            } else {
                val mid = start + (end - start) / 2
                val leftNode = 2 * node + 1
                val rightNode = 2 * node + 2

                buildTree(leftNode, start, mid)
                buildTree(rightNode, mid + 1, end)
                tree[node] = tree[leftNode] + tree[rightNode]
            }
        }
    }
}