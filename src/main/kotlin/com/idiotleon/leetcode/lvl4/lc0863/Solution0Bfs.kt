package com.idiotleon.leetcode.lvl4.lc0863

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import com.idiotleon.leetcode.util.dataStructure.tree.TreeNode

/**
 * @author: Leon
 * https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/
 *
 * Time Complexity:     O(N) + O(K) ~ O(N)
 * Space Complexity:    O(N) + O(N) ~ O(N)
 *
 * to keep track of parent nodes in a HashMap
 */
@Suppress(UNUSED)
class Solution0Bfs {
    fun distanceK(root: TreeNode?, target: TreeNode?, kDistance: Int): List<Int> {
        val ans = mutableListOf<Int>()
        if (root == null || target == null) {
            return ans
        }

        // required
        if (kDistance == 0) {
            return listOf(target.`val`)
        }

        val childToParent = HashMap<TreeNode, TreeNode>().also {
            dfs(root, it)
        }

        val queue = ArrayDeque<TreeNode>().also {
            it.addLast(target)
        }

        val seen = HashSet<TreeNode>().also {
            it.add(target)
        }

        var k = 0
        while (queue.isNotEmpty()) {
            val size = queue.size

            for (sz in 0 until size) {
                val cur = queue.removeFirst()
                ans.add(cur.`val`)

                cur.left?.let { if (seen.add(it)) queue.addLast(it) }
                cur.right?.let { if (seen.add(it)) queue.addLast(it) }
                childToParent[cur]?.let { if (seen.add(it)) queue.addLast(it) }
            }

            if (k++ == kDistance) {
                break
            }

            ans.clear()
        }

        return ans
    }

    private fun dfs(
        node: TreeNode?, childToParent: HashMap<TreeNode, TreeNode>
    ) {
        if (node == null) {
            return
        }

        node.left?.let { childToParent[it] = node }
        node.right?.let { childToParent[it] = node }

        dfs(node.left, childToParent)
        dfs(node.right, childToParent)
    }
}