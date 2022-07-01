package com.an7one.leetcode.lvl3.lc0098

import com.an7one.leetcode.util.Constant.Annotation.UNUSED
import com.an7one.leetcode.util.dataStructure.tree.TreeNode

/**
 * @author: Leon
 * https://leetcode.com/problems/validate-binary-search-tree/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 */
@Suppress(UNUSED)
class SolutionApproach0InorderRecursive {
    fun isValidBST(root: TreeNode?): Boolean {
        // sanity check
        if (root == null) return true

        val prev = arrayOfNulls<Int?>(1)
        return inorder(root, prev)
    }

    private fun inorder(node: TreeNode?, prev: Array<Int?>): Boolean {
        if (node == null) return true

        val left = inorder(node.left, prev)
        val curVal = node.`val`
        prev[0]?.let {
            if (it >= curVal) return false
        }
        prev[0] = curVal
        val right = inorder(node.right, prev)

        return left && right
    }
}