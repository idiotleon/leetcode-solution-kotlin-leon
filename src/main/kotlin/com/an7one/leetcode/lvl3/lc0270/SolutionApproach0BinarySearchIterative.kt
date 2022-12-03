package com.an7one.leetcode.lvl3.lc0270

import com.an7one.leetcode.util.Constant.Annotation.UNUSED
import com.an7one.leetcode.util.dataStructure.tree.TreeNode
import kotlin.math.abs

/**
 * @author: Leon
 * https://leetcode.com/problems/closest-binary-search-tree-value/
 *
 * Time Complexity:     O(H)
 * Space Complexity:    O(1)
 */
@Suppress(UNUSED)
class SolutionApproach0BinarySearchIterative {
    fun closestValue(root: TreeNode?, target: Double): Int {
        if (root == null) return 0

        var closest = root.`val`
        var cur = root

        while (cur != null) {
            val value = cur.`val`

            closest = if (abs(value - target) < abs(closest - target)) value else closest

            cur = if (target < value) cur.left else cur.right
        }

        return closest
    }
}