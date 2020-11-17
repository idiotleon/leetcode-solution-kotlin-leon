/**
 * https://leetcode.com/problems/delete-node-in-a-bst/
 *
 * Time Complexity:     O(H)
 * Space Complexity:    O(H)
 *
 * References:
 *  https://leetcode.com/problems/delete-node-in-a-bst/discuss/93296/Recursive-Easy-to-Understand-Java-Solution/97795
 */
package com.zea7ot.leetcode.lvl3.lc0450

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED
import com.zea7ot.leetcode.utils.dataStructure.tree.TreeNode

@Suppress(UNUSED)
class SolutionApproach0Recursion {
    fun deleteNode(root: TreeNode?, key: Int) = dfs(root, key)

    private fun dfs(node: TreeNode?, key: Int): TreeNode? {
        if (node == null) return null

        val value = node.`val`

        when {
            value > key -> node.left = dfs(node.left, key)
            value < key -> node.right = dfs(node.right, key)
            else -> {
                if (node.left == null) return node.right
                if (node.right == null) return node.left

                var rightSmallest = node.right
                while (rightSmallest!!.left != null) {
                    rightSmallest = rightSmallest.left
                }
                rightSmallest.left = node.left

                return node.right
            }
        }

        return node
    }
}