/**
 * @author: Leon
 * https://leetcode.com/problems/diameter-of-binary-tree/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 */
package com.zea7ot.leetcode.lvl3.lc0543

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED
import com.zea7ot.leetcode.util.dataStructure.tree.TreeNode

@Suppress(UNUSED)
class SolutionApproach0PostorderRecursive {
    private var maxDiameter = 0

    fun diameterOfBinaryTree(root: TreeNode?): Int {
        postorder(root)
        return maxDiameter
    }

    private fun postorder(node: TreeNode?): Int {
        if (node == null) return 0

        val leftDepth = postorder(node.left)
        val rightDepth = postorder(node.right)

        maxDiameter = maxOf(maxDiameter, leftDepth + rightDepth)

        return 1 + maxOf(leftDepth, rightDepth)
    }
}