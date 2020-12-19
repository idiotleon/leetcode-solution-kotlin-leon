/**
 * https://leetcode.com/problems/find-elements-in-a-contaminated-binary-tree/
 *
 *
 * Time Complexities:
 *  Initialization:     O(`size`)
 *  find():             O(1)
 *
 * Space Complexity:    O(H) + O(`size`)
 *
 * References:
 *  https://leetcode.com/problems/find-elements-in-a-contaminated-binary-tree/discuss/431107/JavaPython-3-DFS-clean-code-w-analysis./390121
 */
package com.zea7ot.leetcode.ood.lvl3.lc1261

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED
import com.zea7ot.leetcode.util.dataStructure.tree.TreeNode
import java.util.*

@Suppress(UNUSED)
class SolutionApproach0BFS(root: TreeNode?) {
    private val seen = hashSetOf<Int>()

    init {
        root?.let { bfs(it) }
    }

    fun find(target: Int): Boolean {
        return seen.contains(target)
    }

    private fun bfs(node: TreeNode) {
        node.`val` = 0
        val queue = LinkedList<TreeNode>(listOf(node))

        while (queue.isNotEmpty()) {
            val size = queue.size

            for (i in 0 until size) {
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