/**
 * https://leetcode.com/problems/invert-binary-tree/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 *
 * References:
 *  https://leetcode.com/problems/invert-binary-tree/discuss/62707/Straightforward-DFS-recursive-iterative-BFS-solutions
 */
package com.zea7ot.leetcode.lvl2.lc0226

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED
import com.zea7ot.leetcode.utils.dataStructure.tree.TreeNode

@Suppress(UNUSED)
class SolutionApproach0PostorderRecursive {
    fun invertTree(root: TreeNode?) = dfs(root)

    private fun dfs(node: TreeNode?): TreeNode? {
        if (node == null) return null

        val left = node.left
        val right = node.right

        node.left = dfs(right)
        node.right = dfs(left)

        return node
    }
}