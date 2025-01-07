package com.idiotleon.leetcode.lvl3.lc0938

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import com.idiotleon.leetcode.util.dataStructure.tree.TreeNode

/**
 * @author: Leon
 * https://leetcode.com/problems/range-sum-of-bst/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 *
 * Reference:
 * https://leetcode.com/problems/range-sum-of-bst/editorial/?envType=company&envId=facebook&favoriteSlug=facebook-thirty-days
 */
@Suppress(UNUSED)
class Solution0DfsIterative {
    fun rangeSumBST(root: TreeNode?, low: Int, high: Int): Int {
        if (root == null) {
            return 0
        }

        val stack = ArrayDeque<TreeNode>().also {
            it.addLast(root)
        }

        var ans = 0
        while (stack.isNotEmpty()) {
            val top = stack.removeLast()
            val value = top.`val`
            if (value in low..high) {
                ans += value
            }
            if (low <= value) {
                top.left?.let { stack.addLast(it) }
            }
            if (value <= high) {
                top.right?.let { stack.addLast(it) }
            }
        }

        return ans
    }
}