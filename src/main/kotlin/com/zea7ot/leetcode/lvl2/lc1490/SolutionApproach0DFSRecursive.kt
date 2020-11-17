/**
 * @author: Leon
 * https://leetcode.com/problems/clone-n-ary-tree/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 */
package com.zea7ot.leetcode.lvl2.lc1490

class SolutionApproach0DFSRecursive {
    fun cloneTree(root: Node?): Node? {
        val map = HashMap<Node, Node>()
        return dfs(root, map)
    }

    private fun dfs(node: Node?, map: HashMap<Node, Node>): Node? {
        if (node == null) return null

        map[node]?.let { return it }

        val value = node.`val`
        val cloned = Node(value)
        map[node] = cloned

        val children = mutableListOf<Node?>()
        for (child in node.children) {
            children.add(dfs(child, map))
            cloned.children = children
        }

        return cloned
    }
}