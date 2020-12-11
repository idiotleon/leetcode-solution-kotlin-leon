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
package com.zea7ot.leetcode.lvl4.lc0124

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED
import com.zea7ot.leetcode.util.dataStructure.tree.TreeNode

@Suppress(UNUSED)
class SolutionApproach0DFSRecursive {
    fun maxPathSum(root: TreeNode?): Int {
        val maxSum = intArrayOf(Int.MIN_VALUE)
        dfs(root, maxSum)
        return maxSum[0]
    }

    private fun dfs(node: TreeNode?, maxSum: IntArray): Int {
        if (node == null) return 0

        val value = node.`val`

        val left = dfs(node.left, maxSum)
        val right = dfs(node.right, maxSum)

        maxSum[0] = maxOf(maxSum[0], left + right + value)

        return maxOf(0, maxOf(left, right) + value)
    }
}