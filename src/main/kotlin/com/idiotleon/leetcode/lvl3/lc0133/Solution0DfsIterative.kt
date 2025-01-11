package com.idiotleon.leetcode.lvl3.lc0133

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/clone-graph/
 *
 * Time Complexity:     O(V + E) + O(N) ~ O(N + (N - 1)) ~ O(N)
 * Space Complexity:    O(V + E) + O(N) ~ O(N + (N - 1)) ~ O(N)
 */
@Suppress(UNUSED)
class Solution0DfsIterative {
    fun cloneGraph(node: Node?): Node? {
        if (node == null) {
            return null
        }

        val stack = ArrayDeque<Node>().also {
            it.addLast(node)
        }

        val cloned = Node(node.`val`)
        val map: HashMap<Node, Node> = hashMapOf(node to cloned)

        while (stack.isNotEmpty()) {
            val top = stack.removeLast()

            for (neighbor in top.neighbors) {
                if (neighbor == null) {
                    continue
                }

                if (map[neighbor] == null) {
                    map[neighbor] = Node(neighbor.`val`)
                    stack.addLast(neighbor)
                }

                map[neighbor]?.let {
                    map[top]?.neighbors?.add(it)
                }
            }

        }

        return cloned
    }
}