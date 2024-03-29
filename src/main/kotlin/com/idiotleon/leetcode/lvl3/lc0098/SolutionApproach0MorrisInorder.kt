package com.idiotleon.leetcode.lvl3.lc0098

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import com.idiotleon.leetcode.util.dataStructure.tree.TreeNode

/**
 * @author: Leon
 * https://leetcode.com/problems/validate-binary-search-tree/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 */
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