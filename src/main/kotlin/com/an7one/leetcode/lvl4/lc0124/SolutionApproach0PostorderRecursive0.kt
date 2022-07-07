package com.an7one.leetcode.lvl4.lc0124

import com.an7one.leetcode.util.Constant.Annotation.UNUSED
import com.an7one.leetcode.util.dataStructure.tree.TreeNode

/**
 * @author: Leon
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 */
@Suppress(UNUSED)
class SolutionApproach0PostorderRecursive0 {
    fun maxPathSum(root: TreeNode?) = postorder(root).maxSum

    private fun postorder(node: TreeNode?): Res {
        if (node == null) return Res(Int.MIN_VALUE, 0)

        val (leftMaxSum, leftPathSum) = postorder(node.left)
        val (rightMaxSum, rightPathSum) = postorder(node.right)

        val value = node.`val`
        val sum = leftPathSum + rightPathSum + value

        return Res(maxOf(leftMaxSum, rightMaxSum, sum), maxOf(0, value + maxOf(leftPathSum, rightPathSum)))
    }

    private data class Res(val maxSum: Int, val pathSum: Int)
}