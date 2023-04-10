/**
 * https://leetcode.com/problems/convert-binary-search-tree-to-sorted-doubly-linked-list/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 *
 * Reference:
 * https://leetcode.com/problems/convert-binary-search-tree-to-sorted-doubly-linked-list/discuss/154659/Divide-and-Conquer-without-Dummy-Node-Java-Solution
 */
package com.idiotleon.leetcode.lvl3.lc0426

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DFSRecursive {
    fun treeToDoublyList(root: Node?): Node? = dfs(root)

    private fun dfs(node: Node?): Node? {
        if (node == null)
            return null

        val leftHead = dfs(node.left)
        val rightHead = dfs(node.right)
        node.left = node
        node.right = node
        return connect(connect(leftHead, node), rightHead)
    }

    private fun connect(node1: Node?, node2: Node?): Node? {
        if (node1 == null)
            return node2

        if (node2 == null)
            return node1

        val tail1 = node1.left!!
        val tail2 = node2.left!!

        tail1.right = node2
        node2.left = tail1
        tail2.right = node1
        node1.left = tail2

        return node1
    }
}