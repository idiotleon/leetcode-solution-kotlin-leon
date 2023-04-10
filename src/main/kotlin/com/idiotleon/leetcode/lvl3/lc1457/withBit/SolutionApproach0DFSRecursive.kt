package com.idiotleon.leetcode.lvl3.lc1457.withBit

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import com.idiotleon.leetcode.util.dataStructure.tree.TreeNode

/**
 * @author: Leon
 * https://leetcode.com/problems/pseudo-palindromic-paths-in-a-binary-tree/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(K + H)
 *
 * Reference:
 * https://leetcode.com/problems/pseudo-palindromic-paths-in-a-binary-tree/discuss/648534/JavaC%2B%2BPython-At-most-one-odd-occurrence
 */
@Suppress(UNUSED)
class SolutionApproach0DFSRecursive {
    fun pseudoPalindromicPaths(root: TreeNode?): Int {
        return dfs(root, 0)
    }

    private fun dfs(node: TreeNode?, oddCnt: Int): Int {
        if (node == null) return 0

        var oddCount = oddCnt
        // to toggle the corresponding bit
        oddCount = oddCount xor (1 shl (node.`val` - 1))
        var res = dfs(node.left, oddCount) + dfs(node.right, oddCount)
        if (node.left == node.right && (oddCount and (oddCount - 1)) == 0) ++res
        return res
    }
}