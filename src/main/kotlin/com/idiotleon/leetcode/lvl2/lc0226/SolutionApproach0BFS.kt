package com.idiotleon.leetcode.lvl2.lc0226

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import com.idiotleon.leetcode.util.dataStructure.tree.TreeNode
import kotlin.collections.ArrayDeque

/**
 * @author: Leon
 * https://leetcode.com/problems/invert-binary-tree/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(W)
 *
 * References:
 *  https://leetcode.com/problems/invert-binary-tree/discuss/62707/Straightforward-DFS-recursive-iterative-BFS-solutions
 */
@Suppress(UNUSED)
class SolutionApproach0BFS {
    @OptIn(ExperimentalStdlibApi::class)
    fun invertTree(root: TreeNode?): TreeNode? {
        if (root == null) return null

        val queue = ArrayDeque<TreeNode>().also { it.addLast(root) }

        while (queue.isNotEmpty()) {
            val size = queue.size

            for (sz in 0 until size) {
                val cur = queue.removeFirst()

                val temp = cur.left
                cur.left = cur.right
                cur.right = temp

                cur.left?.let { queue.addLast(it) }
                cur.right?.let { queue.addLast(it) }
            }
        }

        return root
    }
}