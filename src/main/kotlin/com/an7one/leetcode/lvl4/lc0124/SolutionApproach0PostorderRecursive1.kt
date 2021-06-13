/**
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 *
 * a top-down approach
 *
 * References:
 *  https://leetcode.com/problems/binary-tree-maximum-path-sum/discuss/39775/Accepted-short-solution-in-Java
 */
package com.an7one.leetcode.lvl4.lc0124

import com.an7one.leetcode.util.Constant.Annotation.UNUSED
import com.an7one.leetcode.util.dataStructure.tree.TreeNode

@Suppress(UNUSED)
class SolutionApproach0PostorderRecursive1 {
    fun maxPathSum(root: TreeNode?): Int {
        val maxSum = intArrayOf(Int.MIN_VALUE)
        postorder(root, maxSum)
        return maxSum[0]
    }

    private fun postorder(node: TreeNode?, maxSum: IntArray): Int {
        if (node == null) return 0

        val leftPathSum = postorder(node.left, maxSum)
        val rightPathSum = postorder(node.right, maxSum)

        val value = node.`val`
        maxSum[0] = maxOf(maxSum[0], leftPathSum + rightPathSum + value)

        return maxOf(0, maxOf(leftPathSum, rightPathSum) + value)
    }
}