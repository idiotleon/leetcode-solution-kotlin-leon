/**
 * https://leetcode.com/problems/lowest-common-ancestor-of-deepest-leaves
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 *
 * Reference:
 *  https://leetcode.com/problems/lowest-common-ancestor-of-deepest-leaves/discuss/334577/JavaC%2B%2BPython-Two-Recursive-Solution
 */
package com.zea7ot.leetcode.lvl3.lc1123

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED
import com.zea7ot.leetcode.utils.dataStructure.tree.TreeNode

@Suppress(UNUSED)
class SolutionApproach0DFSRecursive {
    private var lca: TreeNode? = null

    fun lcaDeepestLeaves(root: TreeNode?): TreeNode? {
        val deepest = IntArray(1) { 0 }
        dfs(root, 0, deepest)
        return this.lca
    }

    private fun dfs(node: TreeNode?, depth: Int, deepest: IntArray): Int {
        deepest[0] = maxOf(depth, deepest[0])
        node?.let {
            val left = dfs(it.left, depth + 1, deepest)
            val right = dfs(it.right, depth + 1, deepest)

            if (left == deepest[0] && right == deepest[0])
                this.lca = it

            return maxOf(left, right)
        }

        return depth
    }
}