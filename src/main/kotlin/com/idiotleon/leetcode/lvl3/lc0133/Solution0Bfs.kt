package com.idiotleon.leetcode.lvl3.lc0133

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/clone-graph/
 *
 * Time Complexity:     O(V + E) ~ O(N + (N - 1)) ~ O(N)
 * Space Complexity:    O(V + E) ~ O(N + (N - 1)) ~ O(N)
 */
@Suppress(UNUSED)
class Solution0Bfs {
    fun cloneGraph(node: Node?): Node? {
        if (node == null) {
            return null
        }

        val queue = ArrayDeque<Node>().also {
            it.addLast(node)
        }

        val cloned = Node(node.`val`)
        val map: HashMap<Node, Node?> = hashMapOf(node to cloned)

        while (queue.isNotEmpty()) {
            val size = queue.size

            for (sz in 0 until size) {
                val cur = queue.removeFirst()

                for (neighbor in cur.neighbors) {
                    if (neighbor == null) {
                        continue
                    }

                    if (map[neighbor] == null) {
                        map[neighbor] = Node(neighbor.`val`)
                        queue.addLast(neighbor)
                    }

                    map[neighbor]?.let {
                        map[cur]?.neighbors?.add(it)
                    }
                }
            }
        }

        return cloned
    }
}