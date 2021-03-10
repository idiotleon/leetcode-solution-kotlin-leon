/**
 * https://leetcode.com/problems/maximum-product-of-splitted-binary-tree/
 *
 * Time Complexity:     O(2 * N) ~ O(N)
 * Space Complexity:    O(H)
 *
 * to fire two rounds of (almost the same) postorder traversals:
 *  1st to get the total sum of all the tree nodes
 *  2nd to find the max product based on the traversal and the "sum"
 *
 * References:
 *  https://leetcode.com/problems/maximum-product-of-splitted-binary-tree/discuss/496496/Java-Two-Pass-PostOrder-Traversal
 *  https://leetcode.com/problems/maximum-product-of-splitted-binary-tree/discuss/496549/JavaC%2B%2BPython-Easy-and-Concise
 */
package com.an7one.leetcode.lvl3.lc1339

import com.an7one.leetcode.util.Constant.Annotation.UNUSED
import com.an7one.leetcode.util.dataStructure.tree.TreeNode

@Suppress(UNUSED)
class SolutionApproach0PostorderRecursive {
    private companion object {
        private const val MOD = 1e9.toInt() + 7
    }

    fun maxProduct(root: TreeNode?): Int {
        val sum = getSum(root)

        val maxProd = longArrayOf(0L)
        getMaxProduct(root, maxProd, sum)

        return (maxProd[0] % MOD).toInt()
    }

    private fun getMaxProduct(node: TreeNode?, maxProd: LongArray, sum: Long): Long {
        if (node == null) return 0

        val left = getMaxProduct(node.left, maxProd, sum)
        val right = getMaxProduct(node.right, maxProd, sum)
        val curSum = left + right + node.`val`.toLong()

        maxProd[0] = maxOf(maxProd[0], curSum * (sum - curSum))

        return curSum
    }

    private fun getSum(node: TreeNode?): Long {
        if (node == null) return 0

        val left = getSum(node.left)
        val right = getSum(node.right)

        return left + right + node.`val`.toLong()
    }
}