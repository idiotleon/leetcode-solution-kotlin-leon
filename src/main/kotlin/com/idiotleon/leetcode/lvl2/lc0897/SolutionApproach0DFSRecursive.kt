/**
 * https://leetcode.com/problems/increasing-order-search-tree/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 */
package com.idiotleon.leetcode.lvl2.lc0897

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import com.idiotleon.leetcode.util.dataStructure.tree.TreeNode

@Suppress(UNUSED)
class SolutionApproach0DFSRecursive {
    fun increasingBST(root: TreeNode?): TreeNode? {
        return inorder(root, null)
    }

    private fun inorder(node: TreeNode?, tail: TreeNode?): TreeNode?{
        if(node == null) return tail

        val res = inorder(node.left, node)
        node.left = null
        node.right = inorder(node.right, tail)
        return res
    }
}