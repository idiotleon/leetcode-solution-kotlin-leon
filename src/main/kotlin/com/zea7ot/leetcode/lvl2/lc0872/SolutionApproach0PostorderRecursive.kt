/**
 * https://leetcode.com/problems/leaf-similar-trees/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 */
package com.zea7ot.leetcode.lvl2.lc0872

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED
import com.zea7ot.leetcode.util.dataStructure.tree.TreeNode

@Suppress(UNUSED)
private class SolutionApproach0PostorderRecursive {
    fun leafSimilar(root1: TreeNode?, root2: TreeNode?): Boolean {
        val builder1 = StringBuilder()
        postorder(root1, builder1)

        val builder2 = StringBuilder()
        postorder(root2, builder2)

        return builder1.toString() == builder2.toString()
    }

    private fun postorder(node: TreeNode?, builder: StringBuilder) {
        if (node == null) return

        postorder(node.left, builder)
        postorder(node.right, builder)

        if (isLeaf(node)) {
            builder.append(node.`val`.toString() + "#")
        }
    }

    private fun isLeaf(node: TreeNode?): Boolean {
        if (node == null) return false

        return node.left == null && node.right == null
    }
}