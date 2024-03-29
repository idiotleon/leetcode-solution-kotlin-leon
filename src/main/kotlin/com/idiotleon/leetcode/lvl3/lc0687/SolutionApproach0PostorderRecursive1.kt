/**
 * https://leetcode.com/problems/longest-univalue-path/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 */
package com.idiotleon.leetcode.lvl3.lc0687

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import com.idiotleon.leetcode.util.dataStructure.tree.TreeNode

@Suppress(UNUSED)
class SolutionApproach0PostorderRecursive1 {
    fun longestUnivaluePath(root: TreeNode?): Int {
        val longest = intArrayOf(0)
        postorder(root, longest)
        return longest[0]
    }

    private fun postorder(node: TreeNode?, longest: IntArray): Int {
        if (node == null) return 0

        val left = postorder(node.left, longest)
        val right = postorder(node.right, longest)

        var pathLeft = 0
        node.left?.let {
            if (it.`val` == node.`val`)
                pathLeft = left + 1
        }

        var pathRight = 0
        node.right?.let {
            if (it.`val` == node.`val`)
                pathRight = right + 1
        }

        longest[0] = maxOf(longest[0], pathLeft + pathRight)

        return maxOf(pathLeft, pathRight)
    }
}