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
class Solution0DfsRecursive {
    fun cloneGraph(node: Node?): Node? {
        val map = HashMap<Node, Node>()
        return dfs(node, map)
    }

    private fun dfs(cur: Node?, map: HashMap<Node, Node>): Node? {
        if (cur == null) {
            return null
        }

        map[cur]?.let { return it }

        val cloned = Node(cur.`val`)
        map[cur] = cloned

        for (neighbor in cur.neighbors) {
            dfs(neighbor, map)?.let {
                cloned.neighbors.add(it)
            }
        }

        return cloned
    }
}