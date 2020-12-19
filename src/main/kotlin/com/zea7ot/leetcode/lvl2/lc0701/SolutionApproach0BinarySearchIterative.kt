/**
 * https://leetcode.com/problems/insert-into-a-binary-search-tree/
 *
 * Time Complexity:     O(lg(N))
 * Space Complexity:    O(1)
 *
 * References:
 *  https://leetcode.com/problems/insert-into-a-binary-search-tree/discuss/150757/java-iterative-100/486467
 */
package com.zea7ot.leetcode.lvl2.lc0701

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED
import com.zea7ot.leetcode.util.dataStructure.tree.TreeNode

@Suppress(UNUSED)
class SolutionApproach0BinarySearchIterative {
    fun insertIntoBST(root: TreeNode?, newValue: Int): TreeNode {
        // sanity check
        if (root == null) return TreeNode(newValue)

        var cur = root
        var prev: TreeNode? = null

        while (cur != null) {
            prev = cur

            val value = cur.`val`
            cur = when {
                value < newValue ->
                    cur.right
                value > newValue ->
                    cur.left
                else -> {
                    // illegal: curValue == value
                    cur
                }
            }
        }

        prev?.let {
            if (it.`val` < newValue) {
                it.right = TreeNode(newValue)
            } else {
                it.left = TreeNode(newValue)
            }
        }

        return root
    }
}