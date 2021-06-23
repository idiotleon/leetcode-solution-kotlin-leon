/**
 * @author: Leon
 * https://leetcode.com/problems/diameter-of-binary-tree/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 */
package com.an7one.leetcode.lvl3.lc0543

import com.an7one.leetcode.util.Constant.Annotation.UNUSED
import com.an7one.leetcode.util.dataStructure.tree.TreeNode

@Suppress(UNUSED)
class SolutionApproach0PostorderRecursive {
    fun diameterOfBinaryTree(root: TreeNode?) = postorder(root).longest

    private fun postorder(node: TreeNode?): Res {
        if (node == null)
            return Res(0, 0)

        val (leftLongest, leftPath) = postorder(node.left)
        val (rightLongest, rightPath) = postorder(node.right)

        val longest = maxOf(leftLongest, rightLongest, leftPath + rightPath)

        return Res(longest, 1 + maxOf(leftPath, rightPath))
    }

    private data class Res(val longest: Int, val path: Int)
}