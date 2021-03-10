/**
 * https://leetcode.com/problems/longest-univalue-path/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 */
package com.an7one.leetcode.lvl3.lc0687

import com.an7one.leetcode.util.Constant.Annotation.UNUSED
import com.an7one.leetcode.util.dataStructure.tree.TreeNode

@Suppress(UNUSED)
class SolutionApproach0PostorderRecursive {
    private var longest = 0

    fun longestUnivaluePath(root: TreeNode?): Int {
        postorder(root)
        return longest
    }

    private fun postorder(node: TreeNode?): Int {
        if (node == null) return 0

        val leftLen = postorder(node.left)
        val rightLen = postorder(node.right)

        var leftPathLen = 0
        node.left?.let {
            if (it.`val` == node.`val`) {
                leftPathLen = 1 + leftLen
            }
        }

        var rightPathLen = 0
        node.right?.let {
            if (it.`val` == node.`val`) {
                rightPathLen = 1 + rightLen
            }
        }

        longest = maxOf(longest, leftPathLen + rightPathLen)
        return maxOf(leftPathLen, rightPathLen)
    }
}