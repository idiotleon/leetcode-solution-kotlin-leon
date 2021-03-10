/**
 *
 */
package com.an7one.leetcode.lvl2.lc0114

import com.an7one.leetcode.util.Constant.Annotation.UNUSED
import com.an7one.leetcode.util.dataStructure.tree.TreeNode

@Suppress(UNUSED)
class SolutionApproach0MorrisInorderTraversal {
    fun flatten(root: TreeNode?) {
        var cur = root
        while (cur != null) {
            if (cur.left != null) {
                var prev = cur.left
                while (prev!!.right != null) {
                    prev = prev.right
                }

                prev.right = cur.right
                cur.right = cur.left
                cur.left = null
            }

            cur = cur.right
        }
    }
}