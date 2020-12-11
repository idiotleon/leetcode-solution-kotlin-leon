/**
 * https://leetcode.com/problems/clone-graph/
 *
 * Time Complexity:     O(V + E) ~ O(N + (N - 1)) ~ O(N)
 * Space Complexity:    O(V + E) ~ O(N + (N - 1)) ~ O(N)
 */
package com.zea7ot.leetcode.lvl3.lc0133

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED
import java.util.*

@Suppress(UNUSED)
class SolutionApproach0BFS {
    fun cloneGraph(node: Node?): Node? {
        // sanity check
        if (node == null) return node

        val queue = LinkedList<Node>()
        queue.offer(node)

        val cloned = Node(node.`val`)
        val map = hashMapOf(node to cloned)

        while (queue.isNotEmpty()) {
            val size = queue.size

            for (sz in 0 until size) {
                val cur = queue.poll()

                for (nei in cur.neighbors) {
                    if (nei == null) continue

                    if (map[nei] == null) {
                        map[nei] = Node(nei.`val`)
                        queue.offer(nei)
                    }

                    map[nei]?.let {
                        map[cur]?.neighbors?.add(it)
                    }
                }
            }
        }

        return cloned
    }
}