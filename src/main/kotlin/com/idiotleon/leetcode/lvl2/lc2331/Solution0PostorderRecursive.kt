package com.idiotleon.leetcode.lvl2.lc2331

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import com.idiotleon.leetcode.util.dataStructure.tree.TreeNode

/**
 * @author: Leon
 *https://leetcode.com/problems/evaluate-boolean-binary-tree/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 *
 * Reference:
 * https://leetcode.com/problems/evaluate-boolean-binary-tree/editorial/
 */
@Suppress(UNUSED)
class Solution0PostorderRecursive {
    fun evaluateTree(root: TreeNode?): Boolean {
        return postorder(root)
    }

    private fun postorder(node: TreeNode?): Boolean {
        if (node == null) {
            return false
        }

        val value = node.`val`
        val booleanValue = value != 0
        if (node.left == null && node.right == null) {
            return booleanValue
        }

        val left = postorder(node.left)
        val right = postorder(node.right)

        return when (value) {
            1 -> booleanValue
            2 -> left || right
            else -> left && right
        }
    }
}