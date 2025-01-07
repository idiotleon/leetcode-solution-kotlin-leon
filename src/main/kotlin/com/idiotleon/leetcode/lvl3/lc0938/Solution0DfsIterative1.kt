package com.idiotleon.leetcode.lvl3.lc0938

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import com.idiotleon.leetcode.util.dataStructure.tree.TreeNode

/**
 * @author: Leon
 * https://leetcode.com/problems/range-sum-of-bst/
 *
 * Time Complexity:  O(N)
 * Space Complexity:  O(H)
 */
@Suppress(UNUSED)
class Solution0DfsIterative1 {
    fun rangeSumBST(root: TreeNode?, low: Int, high: Int): Int {
        if (root == null) {
            return 0
        }

        var sum = 0

        val stack = ArrayDeque<TreeNode>()
        stack.addLast(root)

        while (stack.isNotEmpty()) {
            val top = stack.removeLast()

            val value = top.`val`

            if (value >= low) {
                top.left?.let { stack.addLast(it) }
            }

            if (value <= high) {
                top.right?.let { stack.addLast(it) }
            }

            if (value in low..high) {
                sum += value
            }
        }

        return sum
    }
}