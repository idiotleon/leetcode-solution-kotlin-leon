package com.idiotleon.leetcode.ood.lvl4.lc0732

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/my-calendar-iii/
 *
 * Time Complexity:     O(`N` * lg(`N`))
 * Space Complexity:    O(`N`)
 *
 * Reference:
 * https://leetcode.com/problems/my-calendar-iii/discuss/702154/Four-AC-Solution%3A-TreeMap-BST-Segment-Tree-with-Diagrams-Beats-100-time-and-space-8ms-39.4MB
 */
@Suppress(UNUSED)
class SolutionApproach0BST() {
    private var root: TreeNode? = null
    private var max = 0

    fun book(start: Int, end: Int): Int {
        this.root = dfs(start, end, 1, root)
        return max
    }

    // to DFS recursively to build up the Binary Search Tree
    private fun dfs(
        start: Int, end: Int, count: Int, root: TreeNode?
    ): TreeNode? {
        var node = root
        when {
            node == null -> {
                node = TreeNode(start, end, count)
                max = maxOf(max, node.count)
            }

            start >= node.end -> {// no overlap, to add the node in the right subtree
                node.right = dfs(start, end, count, node.right)
            }

            end <= node.start -> { // no overlap, to add the node in the left subtree
                node.left = dfs(start, end, count, node.left)
            }

            else -> {
                // Overlap:
                // to put nodes into several groups
                val startMin = minOf(start, node.start)
                val startMax = maxOf(start, node.start)
                val endMin = minOf(end, node.end)
                val endMax = maxOf(end, node.end)

                if (startMin < startMax) {
                    // no need to add new TreeNode if both are equal
                    // to update the count of the current node instead
                    node.left = dfs(
                        startMin, startMax, if (start < node.start) count else node.count, node.left
                    )
                }

                if (endMin < endMax) {
                    // no need to add new TreeNode if both are equal
                    // to update the count of the current node instead
                    node.right = dfs(endMin, endMax, if (end > node.end) count else node.count, node.right)
                }

                node.start = startMax
                node.end = endMin
                node.count += count
                max = maxOf(max, node.count)
            }
        }

        return node
    }

    private data class TreeNode(var start: Int, var end: Int, var count: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}