/**
 * @author: Leon
 * https://leetcode.com/problems/diameter-of-binary-tree/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 */
package com.an7one.leetcode.lvl3.lc0543

import com.an7one.leetcode.util.Constant.Annotation.UNUSED
import com.an7one.leetcode.util.dataStructure.tree.TreeNode

@Suppress(UNUSED)
class SolutionApproach0PostorderRecursive1 {
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