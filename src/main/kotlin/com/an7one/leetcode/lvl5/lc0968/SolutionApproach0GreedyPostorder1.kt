/**
 * https://leetcode.com/problems/binary-tree-cameras/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 *
 * References:
 *  https://leetcode.com/problems/binary-tree-cameras/discuss/211966/Super-Clean-Java-solution-beat-100-DFS-O(n)-time-complexity
 */
package com.an7one.leetcode.lvl5.lc0968

import com.an7one.leetcode.util.Constant.Annotation.UNUSED
import com.an7one.leetcode.util.dataStructure.tree.TreeNode

@Suppress(UNUSED)
private class SolutionApproach0GreedyPostorder1 {
    private companion object {
        // the tree node is null or adjacent to nodes with `MONITORED_WITH_CAM`
        private const val NOT_MONITORED = 0

        // the node whose children are `NOT_MONITORED`
        private const val MONITORED_NO_CAM = 1

        // the node any of the whose children is `MONITORED_NO_CAM`
        private const val MONITORED_WITH_CAM = 2
    }

    fun minCameraCover(root: TreeNode?): Int {
        val cameras = intArrayOf(0)

        val top = postorder(root, cameras)
        return cameras[0] + if (top == NOT_MONITORED) 1 else 0
    }

    private fun postorder(node: TreeNode?, cameras: IntArray): Int {
        if (node == null) return MONITORED_NO_CAM

        val left = postorder(node.left, cameras)
        val right = postorder(node.right, cameras)

        return when {
            left == MONITORED_NO_CAM && right == MONITORED_NO_CAM -> NOT_MONITORED
            left == NOT_MONITORED || right == NOT_MONITORED -> {
                ++cameras[0]
                MONITORED_WITH_CAM
            }
            else -> MONITORED_NO_CAM
        }
    }
}