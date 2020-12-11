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

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED
import com.zea7ot.leetcode.util.dataStructure.tree.TreeNode

@Suppress(UNUSED)
class SolutionApproach0PostorderRecursive {
    fun invertTree(root: TreeNode?) = postorder(root)

    private fun postorder(node: TreeNode?): TreeNode? {
        if (node == null) return null

        val left = node.left
        val right = node.right

        node.left = postorder(right)
        node.right = postorder(left)

        return node
    }
}