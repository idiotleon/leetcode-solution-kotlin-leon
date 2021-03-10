/**
 * https://leetcode.com/problems/invert-binary-tree/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(W)
 *
 * References:
 *  https://leetcode.com/problems/invert-binary-tree/discuss/62707/Straightforward-DFS-recursive-iterative-BFS-solutions
 */
package com.an7one.leetcode.lvl2.lc0226

import com.an7one.leetcode.util.Constant.Annotation.UNUSED
import com.an7one.leetcode.util.dataStructure.tree.TreeNode
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

                val temp = cur.left
                cur.left = cur.right
                cur.right = temp

                cur.left?.let { queue.offer(it) }
                cur.right?.let { queue.offer(it) }
            }
        }

        return root
    }
}