/**
 * https://leetcode.com/problems/balanced-binary-tree/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 */
package com.an7one.leetcode.lvl2.lc0110

import com.an7one.leetcode.util.Constant.Annotation.UNUSED
import com.an7one.leetcode.util.dataStructure.tree.TreeNode
import kotlin.math.abs

@Suppress(UNUSED)
class SolutionApproach0Postorder {
    fun isBalanced(root: TreeNode?) = postorder(root) != -1

    private fun postorder(node: TreeNode?): Int {
        if (node == null)
            return 0

        val leftHeight = postorder(node.left)
        val rightHeight = postorder(node.right)

        if (leftHeight == -1 || rightHeight == -1 || abs(leftHeight - rightHeight) > 1)
            return -1

        return maxOf(leftHeight, rightHeight) + 1
    }
}