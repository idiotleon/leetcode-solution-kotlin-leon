package com.idiotleon.leetcode.lvl4.lc0230

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import com.idiotleon.leetcode.util.dataStructure.tree.TreeNode
import kotlin.collections.ArrayDeque

/**
 * @author: Leon
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 */
@Suppress(UNUSED)
class SolutionApproach0InorderIterative {
    fun kthSmallest(root: TreeNode?, k: Int): Int {
        // sanity check
        if (root == null || k <= 0) {
            return -1
        }

        val stack = ArrayDeque<TreeNode>()
        pushLeft(root, stack)

        var ith = 0

        while (stack.isNotEmpty()) {
            val top = stack.removeFirst()
            if (++ith == k) {
                return top.`val`
            }
            pushLeft(top.right, stack)
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