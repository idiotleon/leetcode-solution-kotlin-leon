package com.idiotleon.leetcode.lvl3.lc0270

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import com.idiotleon.leetcode.util.dataStructure.tree.TreeNode
import kotlin.math.abs

/**
 * @author: Leon
 * https://leetcode.com/problems/closest-binary-search-tree-value/
 *
 * Time Complexity:     O(lg(N))
 * Space Complexity:    O(lg(N))
 */
@Suppress(UNUSED)
class SolutionApproach0BinarySearchRecursive {
    fun closestValue(root: TreeNode?, target: Double): Int {
        if (root == null) return 0

        val closest = intArrayOf(root.`val`)
        binarySearch(root, closest, target)
        return closest[0]
    }

    private fun binarySearch(node: TreeNode?, closest: IntArray, target: Double): Int {
        if (node == null) return 0

        val value = node.`val`

        if (abs(value - target) < abs(closest[0] - target)) closest[0] = value

        return if (value < target) binarySearch(node.right, closest, target)
        else binarySearch(node.left, closest, target)
    }
}