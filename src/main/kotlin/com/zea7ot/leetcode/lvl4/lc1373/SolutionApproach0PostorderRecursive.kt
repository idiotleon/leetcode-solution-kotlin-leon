/**
 * https://leetcode.com/problems/maximum-sum-bst-in-binary-tree/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 *
 * References:
 *  https://leetcode.com/problems/maximum-sum-bst-in-binary-tree/discuss/534877/Java-One-pass-post-order-DFS-O(N)
 *  https://leetcode.com/problems/maximum-sum-bst-in-binary-tree/discuss/531822/Java-Post-Order-Traverse-with-Comment-Clean-code
 */
package com.zea7ot.leetcode.lvl4.lc1373

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED
import com.zea7ot.leetcode.util.dataStructure.tree.TreeNode

@Suppress(UNUSED)
class SolutionApproach0PostorderRecursive {
    private companion object {
        private const val RANGE = 4 * 1e4.toInt() + 1
    }

    fun maxSumBST(root: TreeNode?): Int {
        val maxSum = intArrayOf(0)
        postorder(root, maxSum)
        return maxSum[0]
    }

    private fun postorder(node: TreeNode?, maxSum: IntArray): Subtree {
        if (node == null) return Subtree(true, RANGE, -RANGE, 0)

        val left = postorder(node.left, maxSum)
        val right = postorder(node.right, maxSum)

        val value = node.`val`
        val isBST = left.isBST && right.isBST && (value in left.max + 1 until right.min)

        val sum = left.sum + right.sum + value

        if (isBST) maxSum[0] = maxOf(maxSum[0], sum)

        val min = minOf(value, left.min)
        val max = maxOf(value, right.max)

        return Subtree(isBST, min, max, sum)
    }

    private data class Subtree(val isBST: Boolean, val min: Int, val max: Int, val sum: Int)
}