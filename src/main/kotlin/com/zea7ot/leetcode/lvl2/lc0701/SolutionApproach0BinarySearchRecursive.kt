/**
 * https://leetcode.com/problems/insert-into-a-binary-search-tree/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 *
 * References:
 *  https://leetcode.com/problems/insert-into-a-binary-search-tree/discuss/150757/java-iterative-100/253274
 */
package com.zea7ot.leetcode.lvl2.lc0701

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED
import com.zea7ot.leetcode.util.dataStructure.tree.TreeNode

@Suppress(UNUSED)
class SolutionApproach0BinarySearchRecursive {
    fun insertIntoBST(root: TreeNode?, newValue: Int) = insert(root, newValue)

    private fun insert(node: TreeNode?, newValue: Int): TreeNode {
        if (node == null) return TreeNode(newValue)

        val value = node.`val`

        when {
            value < newValue -> node.right = insert(node.right, value)
            value > newValue -> node.left = insert(node.left, value)
            else -> {
                // ineligible: curValue == value
            }
        }

        return node
    }
}