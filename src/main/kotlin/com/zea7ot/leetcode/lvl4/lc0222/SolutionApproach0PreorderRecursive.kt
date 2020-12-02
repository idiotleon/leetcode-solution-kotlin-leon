/**
 * https://leetcode.com/problems/count-complete-tree-nodes/
 *
 * Time Complexity:     O((lg(N)) ^ 2)
 * Space Complexity:    O(lg(N))
 *
 * References:
 *  https://leetcode.com/problems/count-complete-tree-nodes/discuss/61958/Concise-Java-solutions-O(log(n)2)
 *  https://leetcode.com/problems/count-complete-tree-nodes/discuss/61958/Concise-Java-solutions-O(log(n)2)/63523
 */
package com.zea7ot.leetcode.lvl4.lc0222

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED
import com.zea7ot.leetcode.utils.dataStructure.tree.TreeNode

@Suppress(UNUSED)
class SolutionApproach0PreorderRecursive {
    fun countNodes(root: TreeNode?) = preorder(root)

    private fun preorder(node: TreeNode?): Int {
        if (node == null) return 0

        var left = node
        var right = node
        var height = 0

        while (right != null) {
            left = left!!.left
            right = right.right
            ++height
        }

        // if the height of the left subtree is equal to the height of the right subtree,
        // it means this is a complete binary tree
        if (left == null) return (1 shl height) - 1

        // otherwise, to recursively calculate the number of nodes in the left and right subtree,
        // and add 1 for the (very) root
        return 1 + preorder(node.left) + preorder(node.right)
    }
}