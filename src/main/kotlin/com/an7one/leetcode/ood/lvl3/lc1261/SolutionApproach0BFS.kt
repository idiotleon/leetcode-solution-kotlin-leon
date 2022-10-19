package com.an7one.leetcode.ood.lvl3.lc1261

import com.an7one.leetcode.util.Constant.Annotation.UNUSED
import com.an7one.leetcode.util.dataStructure.tree.TreeNode
import java.util.*
import kotlin.collections.HashSet

/**
 * @author: Leon
 * https://leetcode.com/problems/find-elements-in-a-contaminated-binary-tree/
 *
 *
 * Time Complexities:
 *  Initialization:     O(`size`)
 *  find():             O(1)
 *
 * Space Complexity:    O(H) + O(`size`)
 *
 * Reference:
 * https://leetcode.com/problems/find-elements-in-a-contaminated-binary-tree/discuss/431107/JavaPython-3-DFS-clean-code-w-analysis./390121
 */
@Suppress(UNUSED)
class SolutionApproach0BFS(root: TreeNode?) {
    private val seen = HashSet<Int>()

    init {
        bfs(root)
    }

    fun find(target: Int) = seen.contains(target)

    private fun bfs(root: TreeNode?) {
        if (root == null) return

        root.`val` = 0
        val queue = LinkedList<TreeNode>().also {
            it.offer(root)
        }

        while (queue.isNotEmpty()) {
            val size = queue.size

            for (sz in 0 until size) {
                val cur = queue.poll()
                val nodeVal = cur.`val`
                seen.add(nodeVal)

                cur.left?.let {
                    it.`val` = nodeVal * 2 + 1
                    queue.offer(it)
                }

                cur.right?.let {
                    it.`val` = nodeVal * 2 + 2
                    queue.offer(it)
                }
            }
        }
    }
}