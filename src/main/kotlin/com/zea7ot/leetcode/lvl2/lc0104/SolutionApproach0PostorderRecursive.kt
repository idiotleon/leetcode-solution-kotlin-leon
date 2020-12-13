/**
 * @author: Leon
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 *
 * Time Complexity:     O(H)
 * Space Complexity:    O(H)
 */
package com.zea7ot.leetcode.lvl2.lc0104

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED
import com.zea7ot.leetcode.util.dataStructure.tree.TreeNode

@Suppress(UNUSED)
class SolutionApproach0PostorderRecursive {
    fun maxDepth(root: TreeNode?) = postorder(root, 0)

    private fun postorder(node: TreeNode?, curDepth: Int): Int {
        if (node == null) return curDepth

        val leftDepth = postorder(node.left, 1 + curDepth)
        val rightDepth = postorder(node.right, 1 + curDepth)

        return maxOf(leftDepth, rightDepth)
    }
}