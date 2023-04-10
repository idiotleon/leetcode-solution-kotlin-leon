package com.idiotleon.leetcode.lvl4.lc0222

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import com.idiotleon.leetcode.util.dataStructure.tree.TreeNode

/**
 * @author: Leon
 * https://leetcode.com/problems/count-complete-tree-nodes/
 *
 * Time Complexity:     O((lg(N)) ^ 2)
 * Space Complexity:    O(lg(N))
 *
 * Reference:
 * https://leetcode.com/problems/count-complete-tree-nodes/discuss/61958/Concise-Java-solutions-O(log(n)2)
 * https://leetcode.com/problems/count-complete-tree-nodes/discuss/61958/Concise-Java-solutions-O(log(n)2)/63523
 */
@Suppress(UNUSED)
class SolutionApproach0PreorderRecursive {
    fun countNodes(root: TreeNode?) = preorder(root)

    private fun preorder(node: TreeNode?): Int {
        if (node == null) return 0

        var left = node
        var right = node
        var height = 0

        while (right != null) {
            left = left!!.left
            right = right.right
            ++height
        }

        // if the height of the left subtree is equal to the height of the right subtree,
        // it means this is a complete binary tree
        if (left == null) return (1 shl height) - 1

        // otherwise, to recursively calculate the number of nodes in the left and right subtree,
        // and add 1 for the (very) root
        return 1 + preorder(node.left) + preorder(node.right)
    }
}