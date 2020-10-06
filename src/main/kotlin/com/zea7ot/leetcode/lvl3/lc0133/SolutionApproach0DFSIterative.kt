/**
 * https://leetcode.com/problems/clone-graph/
 *
 * Time Complexity:     O(V + E) + O(N) ~ O(N + (N - 1)) ~ O(N)
 * Space Complexity:    O(V + E) + O(N) ~ O(N + (N - 1)) ~ O(N)
 */
package com.zea7ot.leetcode.lvl3.lc0133

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED
import java.util.*

@Suppress(UNUSED)
class SolutionApproach0DFSIterative {
    fun cloneGraph(node: Node?): Node? {
        if (node == null) return node

        val stack = LinkedList<Node>(listOf(node))
        // or equivalently
        // stack.push(node)

        val map = hashMapOf(node to Node(node.`val`))

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

        return map[node]
    }
}