/**
 * https://leetcode.com/problems/leaf-similar-trees/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 *
 * References:
 *  https://leetcode.com/problems/leaf-similar-trees/discuss/152358/Simple-6-lines-Java-StringBuilder-%2B-traverse-with-explanation
 */
package com.zea7ot.leetcode.lvl2.lc0872

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED
import com.zea7ot.leetcode.util.dataStructure.tree.TreeNode

@Suppress(UNUSED)
class SolutionApproach0PreorderRecursive {
    fun leafSimilar(root1: TreeNode?, root2: TreeNode?): Boolean {
        val builder1 = StringBuilder()
        preorder(root1, builder1)

        val builder2 = StringBuilder()
        preorder(root2, builder2)


        return builder1.toString() == builder2.toString()
    }

    private fun preorder(node: TreeNode?, builder: StringBuilder) {
        if (node == null) return

        if (isLeaf(node)) {
            builder.append(node.`val`.toString() + "#")
        }

        preorder(node.left, builder)
        preorder(node.right, builder)
    }

    private fun isLeaf(node: TreeNode?): Boolean {
        if (node == null) return false

        return node.left == null && node.right == null
    }
}