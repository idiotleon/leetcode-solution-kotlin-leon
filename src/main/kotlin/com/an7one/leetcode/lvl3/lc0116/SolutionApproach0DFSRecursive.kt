/**
 *
 */
package com.an7one.leetcode.lvl3.lc0116

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DFSRecursive {
    fun connect(root: Node?): Node? {
        if (root == null) return null

        dfs(root.left, root.right)
        return root
    }

    private fun dfs(node1: Node?, node2: Node?) {
        if (node1 == null || node2 == null) return

        node1.next = node2

        // for the same parent node
        dfs(node1.left, node1.right)
        dfs(node2.left, node2.right)
        // for different parent nodes
        dfs(node1.right, node2.left)
    }
}