package com.an7one.leetcode.lvl3.lc0510

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/inorder-successor-in-bst-ii/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 */
@Suppress(UNUSED)
class SolutionApproach0Iteration {
    fun inorderSuccessor(node: Node?): Node? {
        if (node == null) return null
        var cur: Node?
        if (node.right == null) {
            cur = node.parent
            while (cur != null && cur.`val` < node.`val`) {
                cur = cur.parent
            }
        } else {
            cur = node.right
            while (cur?.left != null) {
                cur = cur.left
            }
        }
        return cur
    }
}