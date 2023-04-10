package com.idiotleon.leetcode.lvl2.lc0226

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import com.idiotleon.leetcode.util.dataStructure.tree.TreeNode

/**
 * @author: Leon
 * https://leetcode.com/problems/invert-binary-tree/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 *
 * References:
 *  https://leetcode.com/problems/invert-binary-tree/discuss/62707/Straightforward-DFS-recursive-iterative-BFS-solutions
 */
@Suppress(UNUSED)
class SolutionApproach0PostorderRecursive {
    fun invertTree(root: TreeNode?) = postorder(root)

    private fun postorder(node: TreeNode?): TreeNode? {
        if (node == null)
            return null

        val left = node.left
        val right = node.right

        node.left = postorder(right)
        node.right = postorder(left)

        return node
    }
}