/**
 * https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 *
 * a top-down approach
 */
package com.idiotleon.leetcode.lvl2.lc1026

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import com.idiotleon.leetcode.util.dataStructure.tree.TreeNode

@Suppress(UNUSED)
class SolutionApproach0PreorderRecursive {
    fun maxAncestorDiff(root: TreeNode?): Int {
        val maxDiff = intArrayOf(0)
        preorder(root, Int.MIN_VALUE, Int.MAX_VALUE, maxDiff)
        return maxDiff[0]
    }

    private fun preorder(node: TreeNode?, max: Int, min: Int, maxDiff: IntArray) {
        node?.let {
            val maxVal = maxOf(max, it.`val`)
            val minVal = minOf(min, it.`val`)

            maxDiff[0] = maxOf(maxDiff[0], maxVal - minVal)

            preorder(it.left, maxVal, minVal, maxDiff)
            preorder(it.right, maxVal, minVal, maxDiff)
        }
    }
}