package com.zea7ot.leetcode.lvl1.lc0700

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED
import com.zea7ot.leetcode.util.dataStructure.tree.TreeNode

@Suppress(UNUSED)
class SolutionApproach0BinarySearchIterative {
    fun searchBST(root: TreeNode?, target: Int): TreeNode? {
        var cur = root

        while (cur != null) {
            val value = cur.`val`

            cur = when {
                value > target -> cur.left
                value < target -> cur.right
                else -> return cur
            }
        }

        return null
    }
}