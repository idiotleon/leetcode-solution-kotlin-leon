/**
 * @author: Leon
 * https://leetcode.com/problems/find-nearest-right-node-in-binary-tree/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(W)
 */
package com.an7one.leetcode.lvl2.lc1602

import com.an7one.leetcode.util.Constant.Annotation.UNUSED
import com.an7one.leetcode.util.dataStructure.tree.TreeNode
import java.util.*

@Suppress(UNUSED)
class SolutionApproach0BFS {
    fun findNearestRightNode(root: TreeNode?, u: TreeNode?): TreeNode? {
        if (u == null || root == null || u == root) return root

        val queue = LinkedList<TreeNode>().also {
            it.offer(root)
        }

        while (queue.isNotEmpty()) {
            val size = queue.size

            for (sz in 0 until size) {
                val cur = queue.poll()

                if (cur == u) {
                    return if (sz < size - 1) queue.peek()
                    else null
                }

                cur.left?.let { queue.offer(it) }
                cur.right?.let { queue.offer(it) }
            }
        }

        return null
    }
}