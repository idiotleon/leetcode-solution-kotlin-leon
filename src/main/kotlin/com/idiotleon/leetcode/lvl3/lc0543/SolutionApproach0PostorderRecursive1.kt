/**
 * @author: Leon
 * https://leetcode.com/problems/diameter-of-binary-tree/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 */
package com.idiotleon.leetcode.lvl3.lc0543

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import com.idiotleon.leetcode.util.dataStructure.tree.TreeNode

@Suppress(UNUSED)
class SolutionApproach0PostorderRecursive1 {
    private var longest = 0

    fun diameterOfBinaryTree(root: TreeNode?): Int {
        postorder(root)

        return longest
    }

    private fun postorder(node: TreeNode?): Int {
        if (node == null)
            return 0

        val leftDepth = postorder(node.left)
        val rightDepth = postorder(node.right)

        longest = maxOf(longest, leftDepth + rightDepth)

        return maxOf(leftDepth, rightDepth) + 1
    }
}