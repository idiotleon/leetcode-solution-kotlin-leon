package com.idiotleon.leetcode.ood.lvl4.lc0297

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import com.idiotleon.leetcode.util.dataStructure.tree.TreeNode

/**
 * @author: Leon
 * this is not yet correct solution, because str.split() generates empty string.
 * https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * Reference:
 * https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247485871&idx=1&sn=bcb24ea8927995b585629a8b9caeed01&chksm=9bd7f7a7aca07eb1b4c330382a4e0b916ef5a82ca48db28908ab16563e28a376b5ca6805bec2&scene=21#wechat_redirect
 */
@Suppress(UNUSED)
class Solution0Bfs {
    private companion object {
        private const val SPLITTER = ","
        private const val SEPARATOR = "#"
    }

    // Encodes a URL to a shortened URL.
    fun serialize(root: TreeNode?): String {
        if (root == null) return ""

        val builder = StringBuilder()

        val queue = ArrayDeque<TreeNode?>().also { it.addLast(root) }

        while (queue.isNotEmpty()) {
            val size = queue.size

            for (sz in 0 until size) {
                val cur = queue.removeFirst()

                if (cur == null) {
                    builder.append(SEPARATOR).append(SPLITTER)
                    continue
                }

                builder.append(cur.`val`).append(SPLITTER)

                queue.addLast(cur.left)
                queue.addLast(cur.right)
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

        val queue = ArrayDeque<TreeNode?>().also { it.addLast(root) }

        var idx = 1
        while (idx < nNodes) {
            val parent = queue.removeFirst()

            val strLeft = nodes[idx++]
            if (strLeft != SEPARATOR) {
                parent?.left = TreeNode(strLeft.toInt())
                queue.addLast(parent?.left)
            } else {
                parent?.left = null
            }

            val strRight = nodes[idx++]
            if (strRight != SEPARATOR) {
                parent?.right = TreeNode(strRight.toInt())
                queue.addLast(parent?.right)
            } else {
                parent?.right = null
            }

            ++idx
        }

        return root
    }
}