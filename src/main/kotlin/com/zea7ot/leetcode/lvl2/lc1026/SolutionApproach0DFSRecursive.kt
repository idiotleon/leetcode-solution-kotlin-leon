/**
 * https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 *
 * a combination of preorder(top-down) and postorder(bottom-up) traversals
 *
 * References:
 *  https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/discuss/274610/JavaC++Python-Top-Down/262349
 *  https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/discuss/274610/JavaC%2B%2BPython-Top-Down
 */
package com.zea7ot.leetcode.lvl2.lc1026

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED
import com.zea7ot.leetcode.util.dataStructure.tree.TreeNode

@Suppress(UNUSED)
class SolutionApproach0DFSRecursive {
    fun maxAncestorDiff(root: TreeNode?): Int {
        return dfs(root, Int.MAX_VALUE, Int.MIN_VALUE)
    }

    private fun dfs(node: TreeNode?, min: Int, max: Int): Int {
        if (node == null) return 0

        val maxVal = maxOf(max, node.`val`)
        val minVal = minOf(min, node.`val`)

        val leftMaxDiff = dfs(node.left, minVal, maxVal)
        val rightMaxDiff = dfs(node.right, minVal, maxVal)

        return maxOf(maxVal - minVal, leftMaxDiff, rightMaxDiff)
    }
}