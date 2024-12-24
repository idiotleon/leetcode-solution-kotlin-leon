package com.idiotleon.leetcode.lvl3.lc0236

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import com.idiotleon.leetcode.util.dataStructure.tree.TreeNode

/**
 * @author: Leon
 * https://leetcode.com/problems/lowest-common-ancestor-of-deepest-leaves
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 *
 * Reference:
 * https://leetcode.com/problems/lowest-common-ancestor-of-deepest-leaves/discuss/334577/JavaC%2B%2BPython-Two-Recursive-Solution
 */
@Suppress(UNUSED)
class Solution0DfsRecursive {
    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        return dfs(root, p, q)
    }

    private fun dfs(node: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        if (node == null || node == p || node == q) {
            return node
        }

        val left = dfs(node.left, p, q)
        val right = dfs(node.right, p, q)

        if (left == null) {
            return right
        }

        if (right == null) {
            return left
        }

        return node
    }
}