/**
 * https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 *
 * a bottom-up approach
 */
package com.zea7ot.lc.lvl2.lc1026

import com.zea7ot.lc.utils.Constant.Annotation.Companion.UNUSED
import com.zea7ot.lc.utils.data_structure.tree.TreeNode

@Suppress(UNUSED)
class SolutionApproach0DFSRecursive {
    fun maxAncestorDiff(root: TreeNode?): Int {
        return dfs(root, Int.MIN_VALUE, Int.MAX_VALUE)
    }

    private fun dfs(node: TreeNode?, max: Int, min: Int): Int {
        node?.let {
            val maxVal = maxOf(max, it.`val`)
            val minVal = minOf(min, it.`val`)

            val left = dfs(it.left, maxVal, minVal)
            val right = dfs(it.right, maxVal, minVal)

            return maxOf(maxVal - minVal, left, right)
        }

        return 0
    }
}