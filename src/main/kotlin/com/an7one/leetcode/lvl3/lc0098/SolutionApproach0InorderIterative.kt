package com.an7one.leetcode.lvl3.lc0098

import com.an7one.leetcode.util.Constant.Annotation.UNUSED
import com.an7one.leetcode.util.dataStructure.tree.TreeNode
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
class SolutionApproach0InorderIterative {
    fun isValidBST(root: TreeNode?): Boolean {
        // sanity check
        if (root == null) return true

        var prev: Int? = null

        val stack = ArrayDeque<TreeNode>()
        pushLeft(root, stack)
        while (stack.isNotEmpty()) {
            val top = stack.pop()

            prev?.let { if (it >= top.`val`) return false }
            prev = top.`val`

            pushLeft(top.right, stack)
        }

        return true
    }

    private fun pushLeft(node: TreeNode?, stack: ArrayDeque<TreeNode>) {
        var cur = node
        while (cur != null) {
            stack.push(cur)
            cur = cur.left
        }
    }
}