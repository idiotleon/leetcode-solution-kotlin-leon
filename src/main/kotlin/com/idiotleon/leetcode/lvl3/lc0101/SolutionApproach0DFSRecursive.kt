package com.idiotleon.leetcode.lvl3.lc0101

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import com.idiotleon.leetcode.util.dataStructure.tree.TreeNode

/**
 * @author: Leon
 * https://leetcode.com/problems/symmetric-tree/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 *
 * this is very similar to a preorder traversal
 *
 * Reference:
 * https://www.bilibili.com/video/BV19t411w7Ep
 */
@Suppress(UNUSED)
class SolutionApproach0DFSRecursive {
    fun isSymmetric(root: TreeNode?): Boolean {
        if (root == null) return true
        return preorder(root.left, root.right)
    }

    private fun preorder(node1: TreeNode?, node2: TreeNode?): Boolean {
        if (node1 == null || node2 == null) return node1 == null && node2 == null

        return node1.`val` == node2.`val` && preorder(node1.left, node2.right) && preorder(node1.right, node2.left)
    }
}