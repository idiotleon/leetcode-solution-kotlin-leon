/**
 * https://leetcode.com/problems/lowest-common-ancestor-of-deepest-leaves
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 *
 * Reference:
 *  https://leetcode.com/problems/lowest-common-ancestor-of-deepest-leaves/discuss/334577/JavaC%2B%2BPython-Two-Recursive-Solution
 */
package com.idiotleon.leetcode.lvl3.lc1123

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import com.idiotleon.leetcode.util.dataStructure.tree.TreeNode

@Suppress(UNUSED)
class SolutionApproach0DFSRecursive {
    private var deepest = 0
    private var lca: TreeNode? = null

    fun lcaDeepestLeaves(root: TreeNode?): TreeNode? {
        dfs(root, 0)
        return lca
    }

    private fun dfs(node: TreeNode?, curDepth: Int): Int {
        deepest = maxOf(deepest, curDepth)
        if (node == null) return curDepth

        val leftDepth = dfs(node.left, 1 + curDepth)
        val rightDepth = dfs(node.right, 1 + curDepth)

        if (leftDepth == deepest && rightDepth == deepest) {
            lca = node
        }

        return maxOf(leftDepth, rightDepth)
    }
}