/**
 * https://leetcode.com/problems/merge-two-binary-trees/
 *
 * Time Complexity:     O(N(`t1`) + N(`t2`)) ~ O(max(N(`t1`), N(`t2`)))
 * Space Complexity:    O(H(`t1`) + H(`t2`)) ~ O(max(H(`t1`), H(`t2`)))
 */
package com.an7one.leetcode.lvl2.lc0617

import com.an7one.leetcode.util.Constant.Annotation.UNUSED
import com.an7one.leetcode.util.dataStructure.tree.TreeNode

@Suppress(UNUSED)
class SolutionApproach0Recursion {
    fun mergeTrees(t1: TreeNode?, t2: TreeNode?) = dfs(t1, t2)

    private fun dfs(t1: TreeNode?, t2: TreeNode?): TreeNode? {
        if (t1 == null && t2 == null) return null
        if (t1 == null) return t2
        if (t2 == null) return t1

        val root = TreeNode(t1.`val` + t2.`val`)

        root.left = dfs(t1.left, t2.left)
        root.right = dfs(t1.right, t2.right)

        return root
    }
}