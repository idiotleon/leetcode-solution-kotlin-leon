package com.idiotleon.leetcode.lvl2.lc0897

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import com.idiotleon.leetcode.util.dataStructure.tree.TreeNode

/**
 * @author: Leon
 * https://leetcode.com/problems/increasing-order-search-tree/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 *
 * Reference:
 * https://leetcode.com/problems/increasing-order-search-tree/solutions/165885/c-java-python-self-explained-5-line-o-n/
 */
@Suppress(UNUSED)
class Solution0InorderRecursive {
    fun increasingBST(root: TreeNode?): TreeNode? {
        return inorder(root, null)
    }

    private fun inorder(node: TreeNode?, tail: TreeNode?): TreeNode? {
        if (node == null) {
            return tail
        }

        val res = inorder(node.left, node)
        node.left = null
        node.right = inorder(node.right, tail)
        return res
    }
}