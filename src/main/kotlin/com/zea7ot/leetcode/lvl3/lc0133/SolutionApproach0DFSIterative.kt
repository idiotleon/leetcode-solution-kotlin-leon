/**
 * https://leetcode.com/problems/clone-graph/
 *
 * Time Complexity:     O(V + E) + O(N) ~ O(N + (N - 1)) ~ O(N)
 * Space Complexity:    O(V + E) + O(N) ~ O(N + (N - 1)) ~ O(N)
 */
package com.zea7ot.leetcode.lvl3.lc0133

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED
import java.util.*

@Suppress(UNUSED)
class SolutionApproach0DFSIterative {
    fun cloneGraph(node: Node?): Node? {
        if (node == null) return node

        val stack = LinkedList<Node>()
        stack.push(node)

        val cloned = Node(node.`val`)
        val map = hashMapOf(node to cloned)

        while (stack.isNotEmpty()) {
            val top = stack.pop()

            for (nei in top.neighbors) {
                if (nei == null) continue

                if (map[nei] == null) {
                    map[nei] = Node(nei.`val`)
                    stack.push(nei)
                }

                map[nei]?.let {
                    map[top]?.neighbors?.add(it)
                }
            }

        }

        return cloned
    }
}