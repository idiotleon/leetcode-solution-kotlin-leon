/**
 * this is not yet correct solution, because str.split() generates empty string.
 * https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * References:
 *  https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247485871&idx=1&sn=bcb24ea8927995b585629a8b9caeed01&chksm=9bd7f7a7aca07eb1b4c330382a4e0b916ef5a82ca48db28908ab16563e28a376b5ca6805bec2&scene=21#wechat_redirect
 */
package com.an7one.leetcode.ood.lvl4.lc0297

import com.an7one.leetcode.util.Constant.Annotation.UNUSED
import com.an7one.leetcode.util.dataStructure.tree.TreeNode
import java.util.*

@Suppress(UNUSED)
class SolutionApproach0BFS {
    private companion object {
        private const val SPLITTER = ","
        private const val SEPARATOR = "#"
    }

    // Encodes a URL to a shortened URL.
    fun serialize(root: TreeNode?): String {
        if (root == null) return ""

        val builder = StringBuilder()

        val queue = LinkedList<TreeNode>().also { it.offer(root) }

        while (queue.isNotEmpty()) {
            val size = queue.size

            for (sz in 0 until size) {
                val cur = queue.poll()

                if (cur == null) {
                    builder.append(SEPARATOR).append(SPLITTER)
                    continue
                }

                builder.append(cur.`val`).append(SPLITTER)

                queue.offer(cur?.left)
                queue.offer(cur?.right)
            }
        }

        return builder.toString()
    }

    // Decodes your encoded data to tree.
    fun deserialize(data: String): TreeNode? {
        if (data.isEmpty()) return null
        val nodes = data.split(SPLITTER.toRegex(), limit = 0)
        val nNodes = nodes.size

        val root = TreeNode(nodes[0].toInt())

        val queue = LinkedList<TreeNode>().also { it.offer(root) }

        var idx = 1
        while (idx < nNodes) {
            val parent = queue.poll()

            val strLeft = nodes[idx++]
            if (strLeft != SEPARATOR) {
                parent.left = TreeNode(strLeft.toInt())
                queue.offer(parent.left)
            } else {
                parent.left = null
            }

            val strRight = nodes[idx++]
            if (strRight != SEPARATOR) {
                parent.right = TreeNode(strRight.toInt())
                queue.offer(parent.right)
            } else {
                parent.right = null
            }

            ++idx
        }

        return root
    }
}