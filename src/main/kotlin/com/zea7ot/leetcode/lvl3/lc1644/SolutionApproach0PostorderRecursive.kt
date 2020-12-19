/**
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree-ii/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 *
 * References:
 *  https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree-ii/discuss/933835/Java.-Difference-from-236-is-you-need-to-search-the-entire-tree.
 */
package com.zea7ot.leetcode.lvl3.lc1644

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED
import com.zea7ot.leetcode.util.dataStructure.tree.TreeNode

@Suppress(UNUSED)
class SolutionApproach0PostorderRecursive {
    private var count = 0

    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode, q: TreeNode): TreeNode? {
        val lca = postorder(root, p, q)
        return if (count == 2) lca else null
    }

    private fun postorder(node: TreeNode?, p: TreeNode, q: TreeNode): TreeNode? {
        if (node == null) return null

        val left = postorder(node.left, p, q)
        val right = postorder(node.right, p, q)
        if (node == p || node == q) {
            ++count
            return node
        }

        return when {
            left == null -> right
            right == null -> left
            else -> node
        }
    }
}