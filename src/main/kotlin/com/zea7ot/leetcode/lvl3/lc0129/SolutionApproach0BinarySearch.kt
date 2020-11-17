/**
 * https://leetcode.com/problems/closest-binary-search-tree-value/
 *
 * Time Complexity:     O(H)
 * Space Complexity:    O(1)
 */
package com.zea7ot.leetcode.lvl3.lc0129

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED
import com.zea7ot.leetcode.utils.dataStructure.tree.TreeNode
import kotlin.math.abs

@Suppress(UNUSED)
class SolutionApproach0BinarySearch {
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