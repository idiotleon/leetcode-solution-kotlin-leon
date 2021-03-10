/**
 * https://leetcode.com/problems/symmetric-tree/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 *
 * this is very similar to an inorder traversal
 *
 * References:
 *  https://www.bilibili.com/video/BV19t411w7Ep around 40:26
 */
package com.an7one.leetcode.lvl3.lc0101

import com.an7one.leetcode.util.Constant.Annotation.UNUSED
import com.an7one.leetcode.util.dataStructure.tree.TreeNode
import java.util.*

@Suppress(UNUSED)
class SolutionApproach0DFSIterative {
    fun isSymmetric(root: TreeNode?): Boolean {
        if (root == null) return true

        val leftStack = LinkedList<TreeNode>()
        val rightStack = LinkedList<TreeNode>()
        var left = root.left
        var right = root.right

        while (left != null || right != null || leftStack.isNotEmpty() || rightStack.isNotEmpty()) {
            while (left != null && right != null) {
                leftStack.push(left)
                left = left.left
                rightStack.push(right)
                right = right.right
            }

            if (left != null || right != null)
                return false

            left = leftStack.pop()
            right = rightStack.pop()

            if (left!!.`val` != right!!.`val`) return false

            left = left.right
            right = right.left
        }

        return true
    }
}