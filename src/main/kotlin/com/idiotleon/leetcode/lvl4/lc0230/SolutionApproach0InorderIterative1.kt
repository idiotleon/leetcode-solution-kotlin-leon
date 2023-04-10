package com.idiotleon.leetcode.lvl4.lc0230

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import com.idiotleon.leetcode.util.dataStructure.tree.TreeNode
import java.util.*

/**
 * @author: Leon
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 */
@Suppress(UNUSED)
class SolutionApproach0InorderIterative1 {
    fun kthSmallest(root: TreeNode?, k: Int): Int {
        // sanity check
        if (root == null || k <= 0) return -1

        val stack = ArrayDeque<TreeNode>()

        var ith = 0
        var cur = root

        while (cur != null || stack.isNotEmpty()) {
            pushLeft(cur, stack)

            cur = stack.removeLast()
            if (++ith == k) return cur.`val`
            cur = cur.right
        }

        return -1
    }

    private fun pushLeft(node: TreeNode?, stack: ArrayDeque<TreeNode>) {
        var cur = node
        while (cur != null) {
            stack.addLast(cur)
            cur = cur.left
        }
    }
}