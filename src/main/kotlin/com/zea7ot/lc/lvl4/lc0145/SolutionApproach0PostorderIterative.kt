/**
 * https://leetcode.com/problems/binary-tree-postorder-traversal/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 *
 * References:
 *  https://leetcode.com/problems/binary-tree-postorder-traversal/discuss/45551/Preorder-Inorder-and-Postorder-Iteratively-Summarization/608296
 */
package com.zea7ot.lc.lvl4.lc0145

import com.zea7ot.lc.utils.Constant.Annotation.Companion.UNUSED
import com.zea7ot.lc.utils.data_structure.tree.TreeNode
import java.util.*

@Suppress(UNUSED)
class SolutionApproach0PostorderIterative {
    fun postorderTraversal(root: TreeNode?): List<Int> {
        val ans = arrayListOf<Int>()
        if (root == null) return ans

        val stack = LinkedList<TreeNode>()
        var cur = root

        while (cur != null || stack.isNotEmpty()) {
            while (cur != null) {
                stack.push(cur)
                cur = cur.left
            }

            cur = stack.peek()
            if (cur.right != null) {
                cur = cur.right
            } else {
                cur = stack.pop()
                ans.add(cur.`val`)

                while (stack.isNotEmpty() && cur == stack.peek().right) {
                    cur = stack.pop()
                    ans.add(cur.`val`)
                }

                cur = null
            }
        }

        return ans
    }
}