package com.an7one.leetcode.lvl2.lc0669

import com.an7one.leetcode.util.Constant.Annotation.UNUSED
import com.an7one.leetcode.util.dataStructure.tree.TreeNode

/**
 * @author: Leon
 * https://leetcode.com/problems/trim-a-binary-search-tree/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 */
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