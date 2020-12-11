/**
 *
 */
package com.zea7ot.leetcode.lvl2.lc0114

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED
import com.zea7ot.leetcode.util.dataStructure.tree.TreeNode

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