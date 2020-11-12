/**
 * https://leetcode.com/problems/sum-root-to-leaf-numbers/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 *
 * Tabulation vs Memoization
 * https://www.geeksforgeeks.org/tabulation-vs-memoization/
 */
package com.zea7ot.leetcode.lvl3.lc0129

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED
import com.zea7ot.leetcode.utils.dataStructure.tree.TreeNode

@Suppress(UNUSED)
class SolutionApproach0DFSRecursive {
    fun sumNumbers(root: TreeNode?) = dfs(root, 0)

    private fun dfs(node: TreeNode?, sum: Int): Int {
        if (node == null) return 0

        val value = node.`val`

        if (node.left == null && node.right == null) {
            return sum * 10 + value
        }

        val left = dfs(node.left, sum * 10 + value)
        val right = dfs(node.right, sum * 10 + value)

        return left + right
    }
}