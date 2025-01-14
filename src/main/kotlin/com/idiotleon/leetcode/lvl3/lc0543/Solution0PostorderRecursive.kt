package com.idiotleon.leetcode.lvl3.lc0543

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import com.idiotleon.leetcode.util.dataStructure.tree.TreeNode

/**
 * @author: Leon
 * https://leetcode.com/problems/diameter-of-binary-tree/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 */
@Suppress(UNUSED)
class Solution0PostorderRecursive {
    fun diameterOfBinaryTree(root: TreeNode?): Int = postorder(root).longest

    private fun postorder(node: TreeNode?): Node {
        if (node == null) {
            return Node()
        }

        val (leftLongest, leftPath) = postorder(node.left)
        val (rightLongest, rightPath) = postorder(node.right)

        val longest = maxOf(leftLongest, rightLongest, leftPath + rightPath)

        return Node(longest, 1 + maxOf(leftPath, rightPath))
    }

    private data class Node(val longest: Int = 0, val path: Int = 0)
}