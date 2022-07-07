package com.an7one.leetcode.lvl4.lc0124

import com.an7one.leetcode.util.Constant.Annotation.UNUSED
import com.an7one.leetcode.util.dataStructure.tree.TreeNode

/**
 * @author: Leon
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/
 *
 * Time Complexity:     O(H)
 * Space Complexity:    O(H)
 */
@Suppress(UNUSED)
class SolutionApproach0PostorderRecursive2 {
    private var maxPathSum = Int.MIN_VALUE

    fun maxPathSum(root: TreeNode?): Int {
        postorder(root)
        return maxPathSum
    }

    private fun postorder(node: TreeNode?): Int {
        if (node == null) return 0

        val leftPathSum = postorder(node.left)
        val rightPathSum = postorder(node.right)

        val value = node.`val`
        val sum = leftPathSum + rightPathSum + value
        maxPathSum = maxOf(maxPathSum, sum)

        return maxOf(0, value + leftPathSum, value + rightPathSum)
    }
}