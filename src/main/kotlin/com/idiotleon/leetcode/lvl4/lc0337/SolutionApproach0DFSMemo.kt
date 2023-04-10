package com.idiotleon.leetcode.lvl4.lc0337

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import com.idiotleon.leetcode.util.dataStructure.tree.TreeNode

/**
 * @author: Leon
 * https://leetcode.com/problems/house-robber-iii/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(N) + O(H) ~ O(N)
 *
 * Reference:
 * https://leetcode.com/problems/partition-to-k-equal-sum-subsets/discuss/108730/javacstraightforward-dfs-solution
 */
@Suppress(UNUSED)
class SolutionApproach0DFSMemo {
    fun rob(root: TreeNode?): Int {
        return dfs(root, HashMap())
    }

    private fun dfs(node: TreeNode?, memo: HashMap<TreeNode, Int>): Int {
        var res = 0
        node?.let {
            memo[it]?.let { `val` -> return `val` }

            it.left?.let { left ->
                res += dfs(left.left, memo) + dfs(left.right, memo)
            }

            it.right?.let { right ->
                res += dfs(right.left, memo) + dfs(right.right, memo)
            }

            res = maxOf(res + it.`val`, dfs(it.left, memo) + dfs(it.right, memo))
        }

        return res
    }
}