/**
 * https://leetcode.com/problems/house-robber-iii/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 *
 * References:
 *  https://leetcode.com/problems/house-robber-iii/discuss/79330/step-by-step-tackling-of-the-problem
 */
package com.zea7ot.leetcode.lvl4.lc0337

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED
import com.zea7ot.leetcode.utils.dataStructure.tree.TreeNode

@Suppress(UNUSED)
class SolutionApproach0DFSMemo {
    fun rob(root: TreeNode?): Int {
        val res = dfs(root)
        return maxOf(res[0], res[1])
    }

    private fun dfs(node: TreeNode?): IntArray {
        val res = IntArray(2)

        node?.let {
            val left = dfs(it.left)
            val right = dfs(it.right)

            res[0] = maxOf(left[0], left[1]) + maxOf(right[0], right[1])
            res[1] = it.`val` + left[0] + right[0]
        }

        return res
    }
}