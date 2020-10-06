/**
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
 * References:
 *  https://leetcode.com/problems/serialize-and-deserialize-binary-tree/discuss/74253/Easy-to-understand-Java-Solution/77363
 *  https://leetcode.com/problems/serialize-and-deserialize-binary-tree/discuss/74253/Easy-to-understand-Java-Solution
 */
package com.zea7ot.leetcode.ood.lvl4.lc0297

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED
import com.zea7ot.leetcode.utils.data_structure.tree.TreeNode
import java.util.*

@Suppress(UNUSED)
class SolutionApproach0DFSRecursive {
    private companion object {
        private const val SPLITTER = ",";
        private const val SEPARATOR = "#";
    }

    // Encodes a URL to a shortened URL.
    fun serialize(root: TreeNode?): String {
        return serialize(root, StringBuilder()).toString()
    }

    // Decodes your encoded data to tree.
    fun deserialize(data: String): TreeNode? {
        return deserialize(LinkedList(data.split(SPLITTER)))
    }

    private fun serialize(node: TreeNode?, builder: StringBuilder): StringBuilder {
        node?.let {
            builder.append(it.`val`).append(SPLITTER)
            serialize(it.left, builder).append(SPLITTER)
            serialize(it.right, builder)
            return builder
        }

        return builder.append(SEPARATOR)
    }

    private fun deserialize(queue: Deque<String>): TreeNode? {
        val cur = queue.poll()
        if (cur == SEPARATOR) return null

        // to construct the tree
        val left = deserialize(queue)
        val right = deserialize(queue)

        return TreeNode(cur.toInt(), left, right)
    }
}