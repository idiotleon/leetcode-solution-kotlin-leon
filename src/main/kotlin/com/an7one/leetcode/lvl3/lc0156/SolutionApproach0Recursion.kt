package com.an7one.leetcode.lvl3.lc0156

import com.an7one.leetcode.util.Constant.Annotation.UNUSED
import com.an7one.leetcode.util.dataStructure.tree.TreeNode

/**
 * @author: Leon
 * https://leetcode.com/problems/binary-tree-upside-down/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 *
 * Reference:
 * https://leetcode.com/problems/binary-tree-upside-down/discuss/49412/Clean-Java-solution/49658
 *  https://leetcode.com/problems/binary-tree-upside-down/discuss/49412/Clean-Java-solution
 */
@Suppress(UNUSED)
class SolutionApproach0Recursion {
    fun upsideDownBinaryTree(root: TreeNode?) = dfs(root)

    private fun dfs(node: TreeNode?): TreeNode? {
        if (node?.left == null) return node

        val newRoot = dfs(node.left)
        node.left!!.left = node.right
        node.left!!.right = node
        node.left = null
        node.right = null

        return newRoot
    }
}