/**
 * https://leetcode.com/problems/binary-tree-longest-consecutive-sequence/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 *
 * References:
 *  https://leetcode.com/problems/binary-tree-longest-consecutive-sequence/discuss/74468/Easy-Java-DFS-is-there-better-time-complexity-solution
 */
package com.an7one.leetcode.lvl4.lc0298

import com.an7one.leetcode.util.Constant.Annotation.UNUSED
import com.an7one.leetcode.util.dataStructure.tree.TreeNode

@Suppress(UNUSED)
class SolutionApproach0PreorderRecursive {
    private var longest = 0

    fun longestConsecutive(root: TreeNode?): Int {
        if (root == null) return 0

        preorder(root, 1, root.`val` + 1)
        return longest
    }

    private fun preorder(node: TreeNode?, seqLen: Int, target: Int) {
        if (node == null) return

        val value = node.`val`

        val len = if (value == target) seqLen + 1
        else 1

        longest = maxOf(longest, len)
        preorder(node.left, len, value + 1)
        preorder(node.right, len, value + 1)
    }
}