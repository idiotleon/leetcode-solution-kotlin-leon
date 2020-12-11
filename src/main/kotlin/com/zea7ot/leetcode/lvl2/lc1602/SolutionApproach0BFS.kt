/**
 * @author: Leon
 * https://leetcode.com/problems/find-nearest-right-node-in-binary-tree/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(W)
 */
package com.zea7ot.leetcode.lvl2.lc1602

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED
import com.zea7ot.leetcode.util.dataStructure.tree.TreeNode
import java.util.*

@Suppress(UNUSED)
class SolutionApproach0BFS {
    fun findNearestRightNode(root: TreeNode?, u: TreeNode?): TreeNode? {
        if (u == null || root == null || u == root) return null

        val queue = LinkedList<TreeNode>()
        queue.offer(root)

        while (queue.isNotEmpty()) {
            val size = queue.size

            for (i in 0 until size) {
                val cur = queue.poll()

                if (cur == u) {
                    return if (i < size - 1) queue.peek()
                    else null
                }

                cur.left?.let { queue.offer(it) }
                cur.right?.let { queue.offer(it) }
            }
        }

        return null
    }
}