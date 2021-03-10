/**
 * @author: Leon
 * https://leetcode.com/problems/path-sum/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 */
package com.an7one.leetcode.lvl2.lc0112

import com.an7one.leetcode.util.Constant.Annotation.UNUSED
import com.an7one.leetcode.util.dataStructure.tree.TreeNode

@Suppress(UNUSED)
class SolutionApproach0DFSRecursive {
    fun hasPathSum(root: TreeNode?, sum: Int): Boolean {
        return dfs(root, sum)
    }

    private fun dfs(node: TreeNode?, target: Int): Boolean {
        if (node == null) return false

        val value = node.`val`

        if (target == value && node.left == null && node.right == null) {
            return true
        }

        val left = dfs(node.left, target - value)
        val right = dfs(node.right, target - value)

        return left || right
    }
}