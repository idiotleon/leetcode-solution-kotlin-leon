/**
 * @author: Leon
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 */
package com.zea7ot.lc.lvl4.lc0230

import com.zea7ot.lc.utils.Constant.Annotation.Companion.UNUSED
import com.zea7ot.lc.utils.data_structure.tree.TreeNode
import java.util.*

@Suppress(UNUSED)
class SolutionApproach0InorderIterative1 {
    fun kthSmallest(root: TreeNode?, k: Int): Int {
        // sanity check
        if (root == null || k <= 0) return -1

        val stack = LinkedList<TreeNode>()

        var ith = 0
        var cur = root

        while (cur != null || stack.isNotEmpty()) {
            pushLeft(cur, stack)

            cur = stack.pop()
            if (++ith == k) return cur.`val`
            cur = cur.right
        }

        return -1
    }

    private fun pushLeft(node: TreeNode?, stack: LinkedList<TreeNode>) {
        var cur = node
        while (cur != null) {
            stack.push(cur)
            cur = cur.left
        }
    }
}