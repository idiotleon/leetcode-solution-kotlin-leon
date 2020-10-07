/**
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 *
 * a top-down approach
 *
 * References:
 *  https://leetcode.com/problems/binary-tree-maximum-path-sum/discuss/39775/Accepted-short-solution-in-Java
 */
package com.zea7ot.leetcode.lvl4.lc0124

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED
import com.zea7ot.leetcode.utils.dataStructure.TreeNode

@Suppress(UNUSED)
class SolutionApproach0PostorderRecursive {
    fun maxPathSum(root: TreeNode?): Int {
        val sum = IntArray(1) { Int.MIN_VALUE }
        postorder(root, sum)
        return sum[0]
    }

    private fun postorder(node: TreeNode?, sum: IntArray): Int {
        node?.let {
            val left = postorder(it.left, sum)
            val right = postorder(it.right, sum)

            sum[0] = maxOf(sum[0], left + right + it.`val`)

            return maxOf(0, maxOf(left, right) + it.`val`)
        }

        return 0
    }
}