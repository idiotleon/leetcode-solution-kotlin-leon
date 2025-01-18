package com.idiotleon.leetcode.lvl3.lc2385

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import com.idiotleon.leetcode.util.dataStructure.tree.TreeNode

/**
 * @author: Leon
 * https://leetcode.com/problems/amount-of-time-for-binary-tree-to-be-infected/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(W)
 *
 * Reference:
 * https://leetcode.com/problems/amount-of-time-for-binary-tree-to-be-infected/editorial/
 */
@Suppress(UNUSED)
class Solution0BfsWithGraph {
    fun amountOfTime(root: TreeNode?, start: Int): Int {
        if (root == null) {
            return 0
        }
        val graph = HashMap<Int, MutableList<Int>>().also {
            dfs(null, root, it)
        }

        val queue = ArrayDeque<Int>().also {
            it.addLast(start)
        }
        val seen = HashSet<Int>().also {
            it.add(start)
        }

        var minute = 0
        while (queue.isNotEmpty()) {
            val sizeQ = queue.size
            for (sz in 0 until sizeQ) {
                val cur = queue.removeFirst()
                for (next in graph[cur] ?: emptyList()) {
                    if (seen.add(next)) {
                        queue.addLast(next)
                    }
                }
            }
            ++minute
        }

        return minute - 1
    }

    private fun dfs(prev: TreeNode?, cur: TreeNode?, graph: HashMap<Int, MutableList<Int>>) {
        if (cur == null) {
            return
        }

        val value = cur.`val`
        cur.left?.let { graph.getOrPut(value) { mutableListOf() }.add(it.`val`) }
        cur.right?.let { graph.getOrPut(value) { mutableListOf() }.add(it.`val`) }
        prev?.let { graph.getOrPut(value) { mutableListOf() }.add(it.`val`) }

        dfs(cur, cur.left, graph)
        dfs(cur, cur.right, graph)
    }
}