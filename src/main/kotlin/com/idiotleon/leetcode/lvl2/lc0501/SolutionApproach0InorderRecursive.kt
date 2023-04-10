package com.idiotleon.leetcode.lvl2.lc0501

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import com.idiotleon.leetcode.util.dataStructure.tree.TreeNode

/**
 * @author: Leon
 * https://leetcode.com/problems/find-mode-in-binary-search-tree/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 *
 * References:
 *  https://leetcode.com/problems/find-mode-in-binary-search-tree/discuss/98100/Java-4ms-Beats-100-Extra-O(1)-solution-No-Map
 */
@Suppress(UNUSED)
class SolutionApproach0InorderRecursive {
    private var prev: Int? = null
    private var max = 0
    private var count = 1

    fun findMode(root: TreeNode?): IntArray {
        val ans = mutableListOf<Int>()
        inorder(root, ans)
        return ans.toIntArray()
    }

    private fun inorder(node: TreeNode?, res: MutableList<Int>) {
        if (node == null) return

        inorder(node.left, res)

        val value = node.`val`
        prev?.let {
            if (value == it) {
                ++count
            } else {
                count = 1
            }
        }

        if (count > max) {
            max = count
            res.clear()
            res.add(value)
        } else if (count == max) {
            res.add(value)
        }

        prev = value
        inorder(node.right, res)
    }
}