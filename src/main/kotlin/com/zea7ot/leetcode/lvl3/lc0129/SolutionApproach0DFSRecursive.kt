/**
 * https://leetcode.com/problems/sum-root-to-leaf-numbers/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 */
package com.zea7ot.leetcode.lvl3.lc0129

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED
import com.zea7ot.leetcode.util.dataStructure.tree.TreeNode

@Suppress(UNUSED)
class SolutionApproach0DFSRecursive {
    fun sumNumbers(root: TreeNode?) = dfs(root, 0)

    private fun dfs(node: TreeNode?, sum: Int): Int {
        if (node == null) return 0

        val value = node.`val`
        val newSum = sum * 10 + value

        if (node.left == null && node.right == null) {
            return newSum
        }

        val left = dfs(node.left, newSum)
        val right = dfs(node.right, newSum)

        return left + right
    }
}