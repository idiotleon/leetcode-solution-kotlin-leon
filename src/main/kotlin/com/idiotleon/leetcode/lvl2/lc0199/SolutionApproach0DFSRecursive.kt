package com.idiotleon.leetcode.lvl2.lc0199

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import com.idiotleon.leetcode.util.dataStructure.tree.TreeNode

/**
 * @author: Leon
 * https://leetcode.com/problems/binary-tree-right-side-view/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 */
@Suppress(UNUSED)
class SolutionApproach0DFSRecursive {
    fun rightSideView(root: TreeNode?): List<Int> {
        val ans = mutableListOf<Int>()
        if (root == null)
            return ans

        dfs(root, 0, ans)

        return ans
    }

    private fun dfs(node: TreeNode?, curDepth: Int, res: MutableList<Int>) {
        if (node == null)
            return

        val value = node.`val`

        if (curDepth == res.size)
            res.add(value)

        dfs(node.right, 1 + curDepth, res)
        dfs(node.left, 1 + curDepth, res)
    }
}