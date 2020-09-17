/**
 * https://leetcode.com/problems/clone-graph/
 *
 * Time Complexity:     O(V + E) ~ O(N + (N - 1)) ~ O(N)
 * Space Complexity:    O(V + E) ~ O(N + (N - 1)) ~ O(N)
 */
package com.zea7ot.lc.lvl3.lc0133

import com.zea7ot.lc.utils.Constant.Annotation.Companion.UNUSED
import java.util.*

@Suppress(UNUSED)
class SolutionApproach0BFS {
    fun cloneGraph(node: Node?): Node? {
        // sanity check
        if (node == null) return node

        val queue = LinkedList<Node>(listOf(node))
        // or equivalently
        // queue.offer(node)

        val map = hashMapOf(node to Node(node.`val`))

        while (queue.isNotEmpty()) {
            val sizeQ = queue.size

            for (i in 0 until sizeQ) {
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

        return map[node]
    }
}