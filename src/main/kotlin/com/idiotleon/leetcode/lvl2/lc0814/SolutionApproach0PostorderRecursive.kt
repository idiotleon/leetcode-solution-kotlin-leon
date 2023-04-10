package com.idiotleon.leetcode.lvl2.lc0814

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import com.idiotleon.leetcode.util.dataStructure.tree.TreeNode

/**
 * @author: Leon
 * https://leetcode.com/problems/binary-tree-pruning/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 *
 * Reference:
 * https://leetcode.com/problems/binary-tree-pruning/discuss/122730/C%2B%2BJavaPython-Self-Explaining-Solution-and-2-lines
 */
@Suppress(UNUSED)
class SolutionApproach0PostorderRecursive {
    fun pruneTree(root: TreeNode?) = postorder(root)

    private fun postorder(node: TreeNode?): TreeNode? {
        if (node == null) return null
        node.left = postorder(node.left)
        node.right = postorder(node.right)

        if (node.left == null && node.right == null && node.`val` == 0) return null
        return node
    }
}