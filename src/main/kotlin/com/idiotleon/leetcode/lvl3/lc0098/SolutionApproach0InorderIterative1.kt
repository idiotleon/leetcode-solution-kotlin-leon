package com.idiotleon.leetcode.lvl3.lc0098

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import com.idiotleon.leetcode.util.dataStructure.tree.TreeNode
import java.util.*

/**
 * @author: Leon
 * https://leetcode.com/problems/validate-binary-search-tree/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 *
 * Reference:
 * https://leetcode.com/problems/validate-binary-search-tree/discuss/32112/Learn-one-iterative-inorder-traversal-apply-it-to-multiple-tree-questions-(Java-Solution)
 */
@Suppress(UNUSED)
class SolutionApproach0InorderIterative1 {
    fun isValidBST(root: TreeNode?): Boolean {
        // sanity check
        if (root == null) return true

        var prev: Int? = null

        val stack = LinkedList<TreeNode>()
        var cur: TreeNode? = root

        while (cur != null || stack.isNotEmpty()) {
            pushLeft(cur, stack)

            cur = stack.pop()
            val curVal = cur.`val`
            prev?.let { if (it >= curVal) return false }
            prev = curVal
            cur = cur.right
        }

        return true
    }

    private fun pushLeft(node: TreeNode?, stack: LinkedList<TreeNode>) {
        var cur = node
        while (cur != null) {
            stack.push(cur)
            cur = cur.left
        }
    }
}