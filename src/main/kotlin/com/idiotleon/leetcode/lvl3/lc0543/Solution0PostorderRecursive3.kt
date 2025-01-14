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
class Solution0PostorderRecursive3 {
    fun diameterOfBinaryTree(root: TreeNode?): Int {
        val longest = intArrayOf(0)
        postorder(root, longest)
        return longest[0]
    }

    private fun postorder(node: TreeNode?, longest: IntArray): Int {
        if (node == null) return 0

        val left = postorder(node.left, longest)
        val right = postorder(node.right, longest)

        longest[0] = maxOf(longest[0], left + right)

        return maxOf(left, right) + 1
    }
}