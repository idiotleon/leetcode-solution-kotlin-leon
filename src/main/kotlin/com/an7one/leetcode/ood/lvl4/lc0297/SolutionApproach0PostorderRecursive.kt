package com.an7one.leetcode.ood.lvl4.lc0297

import com.an7one.leetcode.util.Constant.Annotation.UNUSED
import com.an7one.leetcode.util.dataStructure.tree.TreeNode
import java.util.*

/**
 * @author: Leon
 * https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
 *
 * Time Complexities:
 *  serialize:      O(N)
 *  deserialize:    O(L) / O(N)
 *
 * Space Complexities:
 *  serialize:      O(H)
 *  deserialize:    O(lg(L)) / O(H)
 *
 * Reference:
 * https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247485871&idx=1&sn=bcb24ea8927995b585629a8b9caeed01&chksm=9bd7f7a7aca07eb1b4c330382a4e0b916ef5a82ca48db28908ab16563e28a376b5ca6805bec2&scene=21#wechat_redirect
 * https://leetcode.com/problems/serialize-and-deserialize-binary-tree/discuss/74253/Easy-to-understand-Java-Solution/77363
 * https://leetcode.com/problems/serialize-and-deserialize-binary-tree/discuss/74253/Easy-to-understand-Java-Solution
 */
@Suppress(UNUSED)
class SolutionApproach0PostorderRecursive {
    private companion object {
        private const val SPLITTER = ','
        private const val SEPARATOR = "#"
    }

    // Encodes a URL to a shortened URL.
    fun serialize(root: TreeNode?): String {
        val builder = StringBuilder()
        serialize(root, builder)
        return builder.toString()
    }

    private fun serialize(node: TreeNode?, builder: StringBuilder) {
        if (node == null) {
            builder.append(SEPARATOR).append(SPLITTER)
            return
        }

        serialize(node.left, builder)
        serialize(node.right, builder)
        builder.append(node.`val`).append(SPLITTER)
    }

    // Decodes your encoded data to tree.
    fun deserialize(data: String): TreeNode? {
        val queue = LinkedList<String>()
        for (str in data.split(SPLITTER)) {
            if (str.isNotEmpty()) {
                queue.addLast(str)
            }
        }

        return deserialize(queue)
    }

    private fun deserialize(queue: LinkedList<String>): TreeNode? {
        if (queue.isEmpty()) return null

        val last = queue.removeLast()
        if (last == SEPARATOR) return null
        val root = TreeNode(last.toInt())

        root.right = deserialize(queue)
        root.left = deserialize(queue)

        return root
    }
}