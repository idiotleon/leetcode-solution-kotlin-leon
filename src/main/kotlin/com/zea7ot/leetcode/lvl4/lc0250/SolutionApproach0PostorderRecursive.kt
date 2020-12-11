package com.zea7ot.leetcode.lvl4.lc0250

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED
import com.zea7ot.leetcode.util.dataStructure.tree.TreeNode

@Suppress(UNUSED)
class SolutionApproach0PostorderRecursive {
    fun countUnivalSubtrees(root: TreeNode?): Int {
        val count = intArrayOf(0)
        isUnivalueSubtree(root, count)
        return count[0]
    }

    private fun isUnivalueSubtree(node: TreeNode?, count: IntArray): Boolean {
        if (node == null) return true

        val left = isUnivalueSubtree(node.left, count)
        val right = isUnivalueSubtree(node.right, count)

        val value = node.`val`

        if (left && right) {
            node.left?.let {
                if (value != it.`val`) return false
            }

            node.right?.let {
                if (value != it.`val`) return false
            }

            ++count[0]
            return true
        }

        return false
    }
}