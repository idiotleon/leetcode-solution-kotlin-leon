/**
 * https://leetcode.com/problems/largest-bst-subtree/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 *
 * References:
 *  https://leetcode.com/problems/largest-bst-subtree/discuss/78899/Very-Short-Simple-Java-O(N)-Solution
 */
package com.zea7ot.leetcode.lvl3.lc0333

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED
import com.zea7ot.leetcode.util.dataStructure.tree.TreeNode

@Suppress(UNUSED)
class SolutionApproach0PostorderRecursive {
    private companion object {
        private const val RANGE = 1e4.toInt() + 1
    }

    fun largestBSTSubtree(root: TreeNode?): Int {
        val subtree = postorder(root)
        return subtree.size
    }

    private fun postorder(node: TreeNode?): Subtree {
        if (node == null) return Subtree(RANGE, -RANGE, 0)

        val left = postorder(node.left)
        val right = postorder(node.right)
        val value = node.`val`

        return if (value in left.max + 1 until right.min) {
            val min = minOf(value, left.min)
            val max = maxOf(value, right.max)
            val size = left.size + right.size + 1
            Subtree(min, max, size)
        } else {
            val size = maxOf(left.size, right.size)
            Subtree(-RANGE, RANGE, size)
        }
    }

    private data class Subtree(val min: Int, val max: Int, val size: Int)
}