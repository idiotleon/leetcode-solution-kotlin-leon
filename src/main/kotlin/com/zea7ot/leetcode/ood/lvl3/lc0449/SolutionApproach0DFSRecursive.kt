/**
 * https://leetcode.com/problems/serialize-and-deserialize-bst/
 *
 * Time Complexity:     O(`nNodes`)
 * Space Complexity:    O(`nNodes`)
 *
 * References:
 *  https://leetcode.com/problems/serialize-and-deserialize-bst/discuss/177617/the-General-Solution-for-Serialize-and-Deserialize-BST-and-Serialize-and-Deserialize-BT
 */
package com.zea7ot.leetcode.ood.lvl3.lc0449

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED
import com.zea7ot.leetcode.util.dataStructure.tree.TreeNode
import java.util.*

@Suppress(UNUSED)
class SolutionApproach0DFSRecursive {
    private companion object {
        private const val SPLITTER = ","
    }

    // Encodes a URL to a shortened URL.
    fun serialize(root: TreeNode?): String {
        val builder = StringBuilder()
        serialize(root, builder)
        return builder.toString()
    }

    // preorder traversal
    private fun serialize(node: TreeNode?, builder: StringBuilder) {
        if (node == null) return

        builder.append(node.`val`.toString()).append(SPLITTER)
        serialize(node.left, builder)
        serialize(node.right, builder)
    }

    // Decodes your encoded data to tree.
    fun deserialize(data: String): TreeNode? {
        if (data.isEmpty()) return null

        val queue = LinkedList<String>()

        data.split(SPLITTER).also {
            for (str in it) {
                if (str.isNotEmpty())
                    queue.offer(str)
            }
        }

        return deserialize(Int.MIN_VALUE, Int.MAX_VALUE, queue)
    }

    private fun deserialize(
        lower: Int,
        upper: Int,
        queue: LinkedList<String>
    ): TreeNode? {
        if (queue.isEmpty()) return null

        val rootValue = queue.peek().toInt()
        if (rootValue < lower || rootValue > upper) return null
        queue.poll()

        val root = TreeNode(rootValue)
        root.left = deserialize(lower, rootValue, queue)
        root.right = deserialize(rootValue, upper, queue)
        return root
    }
}