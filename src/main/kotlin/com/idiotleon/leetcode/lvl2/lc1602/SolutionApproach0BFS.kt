/**
 * @author: Leon
 * https://leetcode.com/problems/find-nearest-right-node-in-binary-tree/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(W)
 */
package com.idiotleon.leetcode.lvl2.lc1602

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import com.idiotleon.leetcode.util.dataStructure.tree.TreeNode

@Suppress(UNUSED)
class SolutionApproach0BFS {
    @OptIn(ExperimentalStdlibApi::class)
    fun findNearestRightNode(root: TreeNode?, u: TreeNode?): TreeNode? {
        if (u == null || root == null || u == root) return root

        val queue = ArrayDeque<TreeNode>().also {
            it.addLast(root)
        }

        while (queue.isNotEmpty()) {
            val size = queue.size

            for (sz in 0 until size) {
                val cur = queue.removeFirst()

                if (cur == u) {
                    return if (sz < size - 1) queue.first()
                    else null
                }

                cur.left?.let { queue.addLast(it) }
                cur.right?.let { queue.addLast(it) }
            }
        }

        return null
    }
}