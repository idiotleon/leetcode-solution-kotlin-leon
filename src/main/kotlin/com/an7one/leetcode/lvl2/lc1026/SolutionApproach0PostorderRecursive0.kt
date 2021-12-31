package com.an7one.leetcode.lvl2.lc1026

import com.an7one.leetcode.util.Constant
import com.an7one.leetcode.util.dataStructure.tree.TreeNode
import kotlin.math.abs

/**
 * @author: Leon
 * https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 */
@Suppress(Constant.Annotation.UNUSED)
class SolutionApproach0PostorderRecursive0 {
    fun maxAncestorDiff(root: TreeNode?): Int = postorder(root).maxAbsDiff ?: 0

    private fun postorder(node: TreeNode?): Res {
        if (node == null)
            return Res(null, null, null)

        val (minValLeft, maxValLeft, absDiffLeft) = postorder(node.left)
        val (minValRight, maxValRight, absDiffRight) = postorder(node.right)

        val value = node.`val`
        val minVal = minOf(minValLeft ?: value, minValRight ?: value, value)
        val maxVal = maxOf(maxValLeft ?: value, maxValRight ?: value, value)
        val maxAbsDiff =
            maxOf(
                abs(value - minVal ?: value),
                abs(value - maxVal ?: value),
                maxOf(absDiffLeft ?: 0, absDiffRight ?: 0)
            )

        return Res(minVal, maxVal, maxAbsDiff)
    }

    private data class Res(val minVal: Int?, val maxVal: Int?, val maxAbsDiff: Int?)
}