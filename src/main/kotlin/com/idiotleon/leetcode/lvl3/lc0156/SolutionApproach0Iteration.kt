package com.idiotleon.leetcode.lvl3.lc0156

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import com.idiotleon.leetcode.util.dataStructure.tree.TreeNode

/**
 * @author: Leon
 * https://leetcode.com/problems/binary-tree-upside-down/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 *
 * Reference:
 * https://leetcode.com/problems/binary-tree-upside-down/discuss/49406/Java-recursive-(O(logn)-space)-and-iterative-solutions-(O(1)-space)-with-explanation-and-figure
 */
@Suppress(UNUSED)
class SolutionApproach0Iteration {
    fun upsideDownBinaryTree(root: TreeNode?): TreeNode? {
        var cur = root
        var prev: TreeNode? = null
        var temp: TreeNode? = null

        while (cur != null) {
            val next = cur.left

            cur.left = temp
            temp = cur.right
            cur.right = prev

            prev = cur
            cur = next
        }

        return prev
    }
}