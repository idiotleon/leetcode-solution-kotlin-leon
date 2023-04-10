package com.idiotleon.leetcode.lvl3.lc1457.withBit

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import com.idiotleon.leetcode.util.dataStructure.tree.TreeNode
import java.util.*

/**
 * @author: Leon
 * https://leetcode.com/problems/pseudo-palindromic-paths-in-a-binary-tree/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(K + H)
 *
 * Reference:
 * https://leetcode.com/problems/pseudo-palindromic-paths-in-a-binary-tree/discuss/648534/JavaC++Python-At-most-one-odd-occurrence/662950
 * https://leetcode.com/problems/pseudo-palindromic-paths-in-a-binary-tree/discuss/648534/JavaC%2B%2BPython-At-most-one-odd-occurrence
 */
@Suppress(UNUSED)
class SolutionApproach0DFSRecursive1 {
    private companion object {
        private const val RANGE = 10
    }

    fun pseudoPalindromicPaths(root: TreeNode?): Int {
        return dfs(root, BitSet(RANGE))
    }

    private fun dfs(node: TreeNode?, oddCount: BitSet): Int {
        if (node == null) return 0

        oddCount.flip(node.`val`)
        var res = dfs(node.left, oddCount) + dfs(node.right, oddCount)
        if (node.left == null && node.right == null) {
            res += if (oddCount.cardinality() <= 1) 1 else 0
        }
        oddCount.flip(node.`val`)
        return res
    }
}