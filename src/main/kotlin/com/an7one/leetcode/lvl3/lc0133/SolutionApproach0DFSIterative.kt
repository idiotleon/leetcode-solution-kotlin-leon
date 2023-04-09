package com.an7one.leetcode.lvl3.lc0133

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/clone-graph/
 *
 * Time Complexity:     O(V + E) + O(N) ~ O(N + (N - 1)) ~ O(N)
 * Space Complexity:    O(V + E) + O(N) ~ O(N + (N - 1)) ~ O(N)
 */
@Suppress(UNUSED)
class SolutionApproach0DFSIterative {
    fun cloneGraph(node: Node?): Node? {
        if (node == null) return null

        val stack = ArrayDeque<Node>()
        stack.addLast(node)

        val cloned = Node(node.`val`)
        val map: HashMap<Node, Node> = hashMapOf(node to cloned)

        while (stack.isNotEmpty()) {
            val top = stack.removeLast()

            for (nei in top.neighbors) {
                if (nei == null) continue

                if (map[nei] == null) {
                    map[nei] = Node(nei.`val`)
                    stack.addLast(nei)
                }

                map[nei]?.let {
                    map[top]?.neighbors?.add(it)
                }
            }

        }

        return cloned
    }
}