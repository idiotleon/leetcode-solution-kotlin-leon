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

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED
import com.zea7ot.leetcode.utils.dataStructure.tree.TreeNode

@Suppress(UNUSED)
class SolutionApproach0Recursion {
    fun insertIntoBST(root: TreeNode?, newValue: Int) = dfs(root, newValue)

    private fun dfs(node: TreeNode?, newValue: Int): TreeNode? {
        if (node == null) return TreeNode(newValue)

        val value = node.`val`
        if (value < newValue) {
            node.right = dfs(node.right, newValue)
        } else {
            node.left = dfs(node.left, newValue)
        }

        return node
    }
}