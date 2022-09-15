package com.an7one.leetcode.lvl3.lc1457

import com.an7one.leetcode.util.Constant.Annotation.UNUSED
import com.an7one.leetcode.util.dataStructure.tree.TreeNode

/**
 * @author: Leon
 * https://leetcode.com/problems/pseudo-palindromic-paths-in-a-binary-tree/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(K + H)
 *
 * Reference:
 * https://leetcode.com/problems/pseudo-palindromic-paths-in-a-binary-tree/discuss/648345/Java-DFS-%2B-Set-%2B-Recursion
 */
@Suppress(UNUSED)
class SolutionApproach0DFSRecursive {
    fun pseudoPalindromicPaths(root: TreeNode?): Int {
        return dfs(root, HashSet())
    }

    private fun dfs(node: TreeNode?, distinct: HashSet<Int>): Int {
        if (node == null) return 0
        val value = node.`val`

        if (distinct.contains(value)) {
            distinct.remove(value)
        } else {
            distinct.add(value)
        }

        if (node.left == null && node.right == null) {
            return if (distinct.size <= 1) 1 else 0
        }

        val left = dfs(node.left, HashSet(distinct))
        val right = dfs(node.right, HashSet(distinct))
        return left + right
    }
}