package com.idiotleon.leetcode.lvl3.lc2385

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import com.idiotleon.leetcode.util.dataStructure.tree.TreeNode

/**
 * @author: Leon
 * https://leetcode.com/problems/amount-of-time-for-binary-tree-to-be-infected/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(W)
 */
@Suppress(UNUSED)
class Solution0BfsWithGraph1 {
    private var startNode: TreeNode? = null

    fun amountOfTime(root: TreeNode?, start: Int): Int {
        if (root == null) {
            return 0
        }

        val nodeToParent = HashMap<TreeNode, TreeNode>().also {
            dfs(root, it, start)
        }

        val queue = ArrayDeque<TreeNode>().also {
            it.addLast(startNode!!)
        }
        val seen = HashSet<TreeNode>().also {
            it.add(startNode!!)
        }

        var level = 0
        while (queue.isNotEmpty()) {
            val sizeQ = queue.size

            for (sz in 0 until sizeQ) {
                val cur = queue.removeFirst()

                cur.left?.let { if (seen.add(it)) queue.addLast(it) }
                cur.right?.let { if (seen.add(it)) queue.addLast(it) }
                nodeToParent[cur]?.let { if (seen.add(it)) queue.addLast(it) }
            }

            ++level
        }

        return level - 1
    }

    private fun dfs(node: TreeNode?, nodeToParent: HashMap<TreeNode, TreeNode>, start: Int) {
        if (node == null) {
            return
        }

        if (node.`val` == start) {
            startNode = node
        }

        node.left?.let { nodeToParent[it] = node }
        node.right?.let { nodeToParent[it] = node }

        dfs(node.left, nodeToParent, start)
        dfs(node.right, nodeToParent, start)
    }
}