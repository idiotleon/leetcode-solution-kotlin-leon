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
        val deepest = intArrayOf(0)
        postorder(root, deepest, 0)
        return lca
    }

    private fun postorder(node: TreeNode?, deepest: IntArray, curDepth: Int): Int {
        deepest[0] = maxOf(deepest[0], curDepth)
        if (node == null) return curDepth

        val left = postorder(node.left, deepest, curDepth + 1)
        val right = postorder(node.right, deepest, curDepth + 1)

        if (left == deepest[0] && right == deepest[0]) {
            lca = node
        }

        return maxOf(left, right)
    }
}