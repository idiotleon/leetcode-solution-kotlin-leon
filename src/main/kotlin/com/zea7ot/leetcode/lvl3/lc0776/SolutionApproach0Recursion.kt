/**
 * https://leetcode.com/problems/split-bst/
 *
 * Time Complexity:     O(H)
 * Space Complexity:    O(H)
 *
 * References:
 *  https://leetcode.com/problems/split-bst/discuss/114861/Java-Recursion-in-O(logn)/115833
 *  https://leetcode.com/problems/split-bst/discuss/114861/Java-Recursion-in-O(logn)
 */
package com.zea7ot.leetcode.lvl3.lc0776

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED
import com.zea7ot.leetcode.util.dataStructure.tree.TreeNode

@Suppress(UNUSED)
class SolutionApproach0Recursion {
    fun splitBST(root: TreeNode?, target: Int) = dfs(root, target)

    private fun dfs(node: TreeNode?, target: Int): Array<TreeNode?> {
        var split = arrayOf<TreeNode?>(null, null)
        if (node == null) return split

        val value = node.`val`
        if (value <= target) {
            split = dfs(node.right, target)
            node.right = split[0]
            split[0] = node
        } else {
            split = dfs(node.left, target)
            node.left = split[1]
            split[1] = node
        }

        return split
    }
}