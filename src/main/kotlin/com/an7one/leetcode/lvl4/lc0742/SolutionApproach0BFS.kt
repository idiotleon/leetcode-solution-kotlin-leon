package com.an7one.leetcode.lvl4.lc0742

import com.an7one.leetcode.util.Constant.Annotation.UNUSED
import com.an7one.leetcode.util.dataStructure.tree.TreeNode
import java.util.*
import kotlin.collections.HashMap
import kotlin.collections.HashSet

/**
 * @author: Leon
 * https://leetcode.com/problems/closest-leaf-in-a-binary-tree/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(H) + O(N) ~ O(N)
 *
 * Reference:
 * https://leetcode.com/problems/closest-leaf-in-a-binary-tree/discuss/109960/Java-DFS-%2B-BFS-27ms
 */
@Suppress(UNUSED)
class SolutionApproach0BFS {
    private var start: TreeNode? = null

    fun findClosestLeaf(root: TreeNode?, targetKey: Int): Int {
        // syntactically required
        if (root == null) return -1
        if (root.left == null && root.right == null) return root.`val`

        val childToParent = HashMap<TreeNode, TreeNode>()

        dfs(root, childToParent, targetKey)

        return bfs(childToParent)
    }

    private fun bfs(childToParent: HashMap<TreeNode, TreeNode>): Int {

        val queue = ArrayDeque<TreeNode>().also {
            it.addLast(start!!)
        }

        val seen = HashSet<TreeNode>().also {
            it.add(start!!)
        }

        while (queue.isNotEmpty()) {
            val sizeQ = queue.size

            for (sz in 0 until sizeQ) {
                val cur = queue.removeFirst()

                if (isLeaf(cur)) return cur.`val`

                cur.left?.let { if (seen.add(it)) queue.addLast(it) }
                cur.right?.let { if (seen.add(it)) queue.addLast(it) }
                childToParent[cur]?.let { if (seen.add(it)) queue.addLast(it) }
            }
        }

        return -1
    }

    private fun dfs(
        node: TreeNode?, map: HashMap<TreeNode, TreeNode>, targetKey: Int
    ) {
        if (node == null) return

        if (node.`val` == targetKey) start = node

        node.left?.let { map[it] = node }
        node.right?.let { map[it] = node }

        dfs(node.left, map, targetKey)
        dfs(node.right, map, targetKey)
    }

    private fun isLeaf(node: TreeNode?): Boolean {
        node?.let {
            if (it.left == null && it.right == null) return true
        }

        return false
    }
}