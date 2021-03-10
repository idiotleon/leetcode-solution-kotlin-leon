/**
 * https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/
 *
 * Time Complexity:     O(N) + O(K) ~ O(N)
 * Space Complexity:    O(N) + O(N) ~ O(N)
 *
 * to keep track of parent nodes in a HashMap
 */
package com.an7one.leetcode.lvl4.lc0863

import com.an7one.leetcode.util.Constant.Annotation.UNUSED
import com.an7one.leetcode.util.dataStructure.tree.TreeNode
import java.util.*
import kotlin.collections.HashMap
import kotlin.collections.HashSet

@Suppress(UNUSED)
class SolutionApproach0BFS {
    fun distanceK(root: TreeNode?, target: TreeNode?, K: Int): List<Int> {
        val ans = mutableListOf<Int>()
        if (root == null || target == null) return ans
        // required
        if (K == 0) return listOf(target.`val`)

        val childToParent = HashMap<TreeNode, TreeNode>()
        dfs(root, childToParent)

        val queue = LinkedList<TreeNode>().also {
            it.offer(target)
        }

        val seen = HashSet<TreeNode>().also {
            it.add(target)
        }

        var k = 0
        while (queue.isNotEmpty()) {
            val size = queue.size

            for (sz in 0 until size) {
                val cur = queue.poll()
                ans.add(cur.`val`)

                cur.left?.let { if (seen.add(it)) queue.offer(it) }
                cur.right?.let { if (seen.add(it)) queue.offer(it) }
                childToParent[cur]?.let { if (seen.add(it)) queue.offer(it) }

            }

            if (k++ == K) break
            ans.clear()
        }

        return ans
    }

    private fun dfs(
        node: TreeNode?,
        childToParent: HashMap<TreeNode, TreeNode>
    ) {
        if (node == null) return

        node.left?.let { childToParent[it] = node }
        node.right?.let { childToParent[it] = node }

        dfs(node.left, childToParent)
        dfs(node.right, childToParent)
    }
}