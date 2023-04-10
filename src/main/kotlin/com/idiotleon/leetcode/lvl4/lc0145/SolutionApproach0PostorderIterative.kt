package com.idiotleon.leetcode.lvl4.lc0145

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import com.idiotleon.leetcode.util.dataStructure.tree.TreeNode
import kotlin.collections.ArrayDeque

/**
 * @author: Leon
 * https://leetcode.com/problems/binary-tree-postorder-traversal/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 *
 * Reference:
 * https://leetcode.com/problems/binary-tree-postorder-traversal/discuss/45551/Preorder-Inorder-and-Postorder-Iteratively-Summarization/608296
 */
@Suppress(UNUSED)
class SolutionApproach0PostorderIterative {
    fun postorderTraversal(root: TreeNode?): List<Int> {
        val ans = arrayListOf<Int>()
        if (root == null) return ans

        val stack = ArrayDeque<TreeNode>()
        var cur = root

        while (cur != null || stack.isNotEmpty()) {
            while (cur != null) {
                stack.addLast(cur)
                cur = cur.left
            }

            cur = stack.last()
            if (cur.right != null) {
                cur = cur.right
            } else {
                cur = stack.removeLast()
                ans.add(cur.`val`)

                while (stack.isNotEmpty() && cur == stack.last().right) {
                    cur = stack.removeLast()
                    ans.add(cur.`val`)
                }

                cur = null
            }
        }

        return ans
    }
}