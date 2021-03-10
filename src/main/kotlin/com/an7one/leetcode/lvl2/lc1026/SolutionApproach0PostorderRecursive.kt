/**
 * https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 */
package com.an7one.leetcode.lvl2.lc1026

import com.an7one.leetcode.util.Constant.Annotation.UNUSED
import com.an7one.leetcode.util.dataStructure.tree.TreeNode
import kotlin.math.abs

@Suppress(UNUSED)
class SolutionApproach0PostorderRecursive {
    fun maxAncestorDiff(root: TreeNode?): Int {
        if (root == null) return 0
        if (root.left == null && root.right == null) return root.`val`

        val maxDiff = intArrayOf(0)
        postorder(root, root, maxDiff)
        return maxDiff[0]
    }

    private fun postorder(node: TreeNode?, parent: TreeNode, maxDiff: IntArray): Res {
        if (node == null) return Res(parent.`val`, parent.`val`)

        val (leftMin, leftMax) = postorder(node.left, node, maxDiff)
        val (rightMin, rightMax) = postorder(node.right, node, maxDiff)

        val min = minOf(leftMin, rightMin)
        val max = maxOf(leftMax, rightMax)
        val value = node.`val`

        maxDiff[0] = maxOf(maxDiff[0], abs(min - value), abs(max - value))
        return Res(minOf(min, value), maxOf(max, value))
    }

    private data class Res(val min: Int, val max: Int)
}