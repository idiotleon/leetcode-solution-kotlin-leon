package com.an7one.leetcode.lvl1.lc0700

import com.an7one.leetcode.util.Constant.Annotation.UNUSED
import com.an7one.leetcode.util.dataStructure.tree.TreeNode

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