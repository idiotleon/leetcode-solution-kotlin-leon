package com.an7one.leetcode.lvl1.lc0671

import com.an7one.leetcode.util.Constant
import com.an7one.leetcode.util.dataStructure.tree.TreeNode

/**
 * https://leetcode.com/problems/second-minimum-node-in-a-binary-tree/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 *
 * Reference:
 * https://leetcode.com/problems/second-minimum-node-in-a-binary-tree/discuss/107233/Java-4-lines
 */
@Suppress(Constant.Annotation.UNUSED)
class SolutionApproach0DFSRecursive {
    private companion object{
        private const val IMPOSSIBLE = -1
    }

    fun findSecondMinimumValue(root: TreeNode?): Int = dfs(root)

    private fun dfs(node: TreeNode?): Int{
        if(node == null)
            return IMPOSSIBLE

        if(node.left == null)
            return IMPOSSIBLE

        val left = if(node.`val` == node!!.left!!.`val`) dfs(node.left) else node!!.left!!.`val`
        val right = if(node.`val` == node!!.right!!.`val`) dfs(node!!.right) else node.right!!.`val`

        return if(left == IMPOSSIBLE || right == IMPOSSIBLE) maxOf(left, right) else minOf(left, right)
    }
}