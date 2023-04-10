package com.idiotleon.summary.byAlgorithm.search.breadthFirstSearch.binaryTree

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import com.idiotleon.leetcode.util.dataStructure.tree.TreeNode
import java.util.*

@Suppress(UNUSED)
class BreadthFirstSearch {
    fun bfs(root: TreeNode?): Int {
        if (root == null) return 0

        val queue = LinkedList<TreeNode>().also {
            it.offer(root)
        }

        // 0-indexed
        var level = 0
        while (queue.isNotEmpty()) {
            val size = queue.size

            for (sz in 0 until size) {
                val cur = queue.poll()

                cur.left?.let { queue.offer(it) }
                cur.right?.let { queue.offer(it) }
            }

            ++level
        }

        return level
    }
}