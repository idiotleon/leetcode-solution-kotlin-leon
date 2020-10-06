package com.zea7ot.leetcode.lvl3.lc0098

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED
import com.zea7ot.leetcode.utils.data_structure.tree.TreeNode

@Suppress(UNUSED)
class SolutionApproach0MorrisInorder {
    fun isValidBST(root: TreeNode?): Boolean {
        // sanity check
        if (root == null) return true

        var prev: Int? = null
        var cur = root;

        while (cur != null) {
            if (cur.left == null) {
                val curVal = cur.`val`
                prev?.let { if (it >= curVal) return false }
                prev = curVal
                cur = cur.right
            } else {
                var predecessor = cur.left
                while (predecessor?.right != cur && predecessor?.right != null) {
                    predecessor = predecessor.right
                }

                if (predecessor?.right == null) {
                    predecessor?.right = cur
                    cur = cur.left
                } else {
                    predecessor.right = null;
                    val curVal = cur.`val`
                    prev?.let { if (it >= curVal) return false }
                    prev = curVal
                    cur = cur.right
                }
            }
        }

        return true
    }
}