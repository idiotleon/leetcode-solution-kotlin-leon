package com.zea7ot.lc.lvl3.lc0133

import com.zea7ot.lc.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DFSRecusive {
    fun cloneGraph(node: Node?): Node? {
        val map = hashMapOf<Node, Node>()
        return dfs(node, map)
    }

    private fun dfs(cur: Node?, map: HashMap<Node, Node>): Node? {
        if (cur == null) return cur
        map[cur]?.let { return it }

        val cloned = Node(cur.`val`)
        map[cur] = cloned

        for (neighbor in cur.neighbors) {
            dfs(neighbor, map)?.let {
                cloned.neighbors.add(it)
            }
        }

        return map[cur]
    }
}