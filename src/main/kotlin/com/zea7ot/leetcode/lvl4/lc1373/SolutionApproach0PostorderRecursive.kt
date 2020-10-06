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

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED
import com.zea7ot.leetcode.utils.data_structure.tree.TreeNode

@Suppress(UNUSED)
class SolutionApproach0PostorderRecursive {
    fun maxSumBST(root: TreeNode?): Int {
        val maxSum = intArrayOf(0)
        postorder(root, maxSum)
        return maxSum[0]
    }

    private fun postorder(node: TreeNode?, maxSum: IntArray): Result {
        node?.let {
            val left = postorder(it.left, maxSum)
            val right = postorder(it.right, maxSum)

            val nodeVal = it.`val`
            val isBST = left.isBST && right.isBST && nodeVal > left.max && nodeVal < right.min

            val sum = nodeVal + left.sum + right.sum

            if (isBST) {
                maxSum[0] = maxOf(maxSum[0], sum)
            }

            val min = minOf(nodeVal, left.min)
            val max = maxOf(nodeVal, right.max)

            return Result(isBST, min, max, sum)
        }

        return Result(true, Int.MAX_VALUE, Int.MIN_VALUE, 0)
    }

    private data class Result(val isBST: Boolean, val min: Int, val max: Int, val sum: Int)
}