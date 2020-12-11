/**
 * https://leetcode.com/problems/binary-tree-cameras/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 *
 * References:
 *  https://leetcode.com/problems/binary-tree-cameras/discuss/211412/C%2B%2B-DFS-simplest
 *  https://leetcode.com/problems/binary-tree-cameras/discuss/211966/Super-Clean-Java-solution-beat-100-DFS-O(n)-time-complexity
 */
package com.zea7ot.leetcode.lvl5.lc0968

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED
import com.zea7ot.leetcode.util.dataStructure.tree.TreeNode

@Suppress(UNUSED)
private class SolutionApproach0GreedyPostorder {
    private companion object {
        private const val NO_CAMERA = 0
        private const val HAS_CAMERA = 1
        private const val NOT_NEEDED = 2
    }

    fun minCameraCover(root: TreeNode?): Int {
        val cameras = intArrayOf(0)

        val top = postorder(root, cameras)
        return cameras[0] + if (top == NO_CAMERA) 1 else 0
    }

    private fun postorder(node: TreeNode?, cameras: IntArray): Int {
        if (node == null) return NOT_NEEDED

        val left = postorder(node.left, cameras)
        val right = postorder(node.right, cameras)

        return when {
            left == NO_CAMERA || right == NO_CAMERA -> {
                ++cameras[0]
                HAS_CAMERA
            }

            left == HAS_CAMERA || right == HAS_CAMERA -> {
                NOT_NEEDED
            }

            else -> NO_CAMERA
        }
    }
}