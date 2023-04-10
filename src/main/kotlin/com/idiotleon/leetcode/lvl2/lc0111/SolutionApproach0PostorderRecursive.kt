package com.idiotleon.leetcode.lvl2.lc0111

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import com.idiotleon.leetcode.util.dataStructure.tree.TreeNode

/**
 * @author: Leon
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 *
 * References:
 *  https://leetcode.com/problems/minimum-depth-of-binary-tree/discuss/36045/My-4-Line-java-solution
 */
@Suppress(UNUSED)
class SolutionApproach0PostorderRecursive {
    fun minDepth(root: TreeNode?) = postorder(root)

    private fun postorder(node: TreeNode?): Int {
        if (node == null) return 0

        val leftHeight = postorder(node.left)
        val rightHeight = postorder(node.right)

        return if (leftHeight == 0 || rightHeight == 0) {
            1 + maxOf(leftHeight, rightHeight)
        } else {
            1 + minOf(leftHeight, rightHeight)
        }
    }
}