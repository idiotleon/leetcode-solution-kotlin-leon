package com.zea7ot.lc.lvl3.lc0098

import com.zea7ot.lc.utils.Constant.Annotation.Companion.UNUSED
import com.zea7ot.lc.utils.data_structure.tree.TreeNode

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