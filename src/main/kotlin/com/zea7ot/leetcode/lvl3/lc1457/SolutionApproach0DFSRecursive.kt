/**
 * https://leetcode.com/problems/pseudo-palindromic-paths-in-a-binary-tree/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(K + H)
 *
 * References:
 *  https://leetcode.com/problems/pseudo-palindromic-paths-in-a-binary-tree/discuss/648345/Java-DFS-%2B-Set-%2B-Recursion
 */
package com.zea7ot.leetcode.lvl3.lc1457

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED
import com.zea7ot.leetcode.util.dataStructure.tree.TreeNode

@Suppress(UNUSED)
class SolutionApproach0DFSRecursive {
    fun pseudoPalindromicPaths(root: TreeNode?): Int {
        return dfs(root, HashSet<Int>())
    }

    private fun dfs(node: TreeNode?, nums: HashSet<Int>): Int {
        if (node == null) return 0
        val value = node.`val`

        if (nums.contains(value)) {
            nums.remove(value)
        } else {
            nums.add(value)
        }

        if (node.left == null && node.right == null) {
            return if (nums.size <= 1) 1 else 0
        }

        val left = dfs(node.left, HashSet(nums))
        val right = dfs(node.right, HashSet(nums))
        return left + right
    }
}