package com.an7one.leetcode.ood.lvl3.lc0449

import com.an7one.leetcode.util.Constant.Annotation.UNUSED
import com.an7one.leetcode.util.dataStructure.tree.TreeNode
import java.util.*

/**
 * @author: Leon
 * https://leetcode.com/problems/serialize-and-deserialize-bst/
 *
 * Time Complexities:
 *  `serialize()`:          O(nTreeNodes)
 *  `deserialize()`:        O(nTreeNodes)
 *
 * Space Complexity:        O(nTreeNodes)
 *
 * Reference:
 * https://leetcode.com/problems/serialize-and-deserialize-bst/discuss/177617/the-General-Solution-for-Serialize-and-Deserialize-BST-and-Serialize-and-Deserialize-BT
 */
@Suppress(UNUSED)
class SolutionApproach0DFSRecursive1 {
    private companion object {
        private const val SPLITTER = ","
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

        builder.append(node.`val`.toString()).append(SPLITTER)
        serialize(node.left, builder)
        serialize(node.right, builder)
    }

    // Decodes your encoded data to tree.
    fun deserialize(data: String): TreeNode? {
        val queue = LinkedList<String>()
        data.split(SPLITTER).also {
            for (str in it) queue.offer(str)
        }

        return deserialize(queue)
    }

    private fun deserialize(queue: LinkedList<String>): TreeNode? {
        val str = queue.poll()
        if (str == SEPARATOR) return null

        val root = TreeNode(str.toInt())
        root.left = deserialize(queue)
        root.right = deserialize(queue)
        return root
    }
}