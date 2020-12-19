/**
 * https://leetcode.com/problems/binary-tree-upside-down/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 *
 * References:
 *  https://leetcode.com/problems/binary-tree-upside-down/discuss/49406/Java-recursive-(O(logn)-space)-and-iterative-solutions-(O(1)-space)-with-explanation-and-figure
 */
package com.zea7ot.leetcode.lvl3.lc0156

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED
import com.zea7ot.leetcode.util.dataStructure.tree.TreeNode

@Suppress(UNUSED)
class SolutionApproach0Iteration {
    fun upsideDownBinaryTree(root: TreeNode?): TreeNode? {
        var cur = root
        var prev: TreeNode? = null
        var temp: TreeNode? = null

        while (cur != null) {
            val next = cur.left

            cur.left = temp
            temp = cur.right
            cur.right = prev

            prev = cur
            cur = next
        }

        return prev
    }
}