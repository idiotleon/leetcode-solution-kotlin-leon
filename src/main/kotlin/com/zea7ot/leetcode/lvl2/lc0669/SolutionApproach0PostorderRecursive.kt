/**
 * https://leetcode.com/problems/trim-a-binary-search-tree/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 */
package com.zea7ot.leetcode.lvl2.lc0669

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED
import com.zea7ot.leetcode.util.dataStructure.tree.TreeNode

@Suppress(UNUSED)
class SolutionApproach0PostorderRecursive {
    fun trimBST(root: TreeNode?, low: Int, high: Int) = postorder(root, low, high)

    private fun postorder(node: TreeNode?, low: Int, high: Int): TreeNode? {
        if (node == null) return null

        node.left = postorder(node.left, low, high)
        node.right = postorder(node.right, low, high)

        val value = node.`val`
        if (value < low) return postorder(node.right, low, high)
        if (value > high) return postorder(node.left, low, high)

        return node
    }
}