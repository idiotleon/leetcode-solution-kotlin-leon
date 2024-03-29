/**
 * https://leetcode.com/problems/sum-root-to-leaf-numbers/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 */
package com.idiotleon.leetcode.lvl3.lc0129

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import com.idiotleon.leetcode.util.dataStructure.tree.TreeNode

@Suppress(UNUSED)
class SolutionApproach0DFSRecursive {
    fun sumNumbers(root: TreeNode?) = dfs(root, 0)

    private fun dfs(node: TreeNode?, prevNum: Int): Int {
        if (node == null) return 0

        val value = node.`val`
        val curNum = prevNum * 10 + value

        if (node.left == null && node.right == null) {
            return curNum
        }

        val leftNum = dfs(node.left, curNum)
        val rightNum = dfs(node.right, curNum)

        return leftNum + rightNum
    }
}