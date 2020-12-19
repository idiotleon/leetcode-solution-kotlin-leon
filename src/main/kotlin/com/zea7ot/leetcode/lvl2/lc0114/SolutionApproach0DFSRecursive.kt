/**
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 *
 * References:
 *  https://leetcode.com/problems/flatten-binary-tree-to-linked-list/discuss/36977/My-short-post-order-traversal-Java-solution-for-share
 *  https://leetcode.com/problems/flatten-binary-tree-to-linked-list/discuss/36977/My-short-post-order-traversal-Java-solution-for-share/146292
 */
package com.zea7ot.leetcode.lvl2.lc0114

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED
import com.zea7ot.leetcode.util.dataStructure.tree.TreeNode

@Suppress(UNUSED)
class SolutionApproach0DFSRecursive {
    private var prev: TreeNode? = null

    fun flatten(root: TreeNode?) = dfs(root)

    private fun dfs(node: TreeNode?) {
        if (node == null) return

        dfs(node.right)
        dfs(node.left)

        node.right = prev
        node.left = null
        prev = node
    }
}