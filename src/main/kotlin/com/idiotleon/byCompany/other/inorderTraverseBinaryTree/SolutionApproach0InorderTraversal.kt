/**
 * Time Complexity:     O(H)
 * Space Complexity:    O(H)
 */
package com.idiotleon.byCompany.other.inorderTraverseBinaryTree

class SolutionApproach0InorderTraversal {
    fun findNthInorderTreeNode(n: Int, root: TreeNode?): TreeNode? {
        return dfs(n, root)
    }

    private fun dfs(n: Int, node: TreeNode?): TreeNode? {
        if (node == null) return null
        if (node.left == null && node.right == null) return node

        return when {
            node.left == null || node.left!!.childCount + 1 < n - 1 -> {
                val newN = if (node.left == null) n - 1 else n - (node.left!!.childCount + 1 + 1)
                dfs(newN, node.right)
            }

            node.left!!.childCount + 1 == n - 1 -> node

            else -> dfs(n, node.left)
        }
    }
}

data class TreeNode(
        val value: Int,
        val childCount: Int,
        var left: TreeNode? = null,
        var right: TreeNode? = null)