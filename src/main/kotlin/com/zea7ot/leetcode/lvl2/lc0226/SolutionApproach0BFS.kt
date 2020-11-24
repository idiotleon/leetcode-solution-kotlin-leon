/**
 * https://leetcode.com/problems/invert-binary-tree/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(W)
 *
 * References:
 *  https://leetcode.com/problems/invert-binary-tree/discuss/62707/Straightforward-DFS-recursive-iterative-BFS-solutions
 */
package com.zea7ot.leetcode.lvl2.lc0226

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED
import com.zea7ot.leetcode.utils.dataStructure.tree.TreeNode
import java.util.*

@Suppress(UNUSED)
class SolutionApproach0BFS {
    fun invertTree(root: TreeNode?): TreeNode? {
        if (root == null) return null

        val queue = LinkedList<TreeNode>().also { it.offer(root) }

        while (queue.isNotEmpty()) {
            val size = queue.size

            for (sz in 0 until size) {
                val cur = queue.poll()

                val left = cur.left
                cur.left = cur.right
                cur.right = left

                cur.left?.let { queue.offer(it) }
                cur.right?.let { queue.offer(it) }

            }

        }

        return root
    }
}