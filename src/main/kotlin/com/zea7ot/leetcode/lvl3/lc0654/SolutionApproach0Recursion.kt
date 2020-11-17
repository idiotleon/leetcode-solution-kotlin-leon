/**
 * https://leetcode.com/problems/maximum-binary-tree/
 *
 * Time Complexity:     O(N * lg(N)), O(N ^ 2) in the worst case
 * Space Complexity:    O(lg(N)), O(N) in the worst case
 *
 * References:
 *  https://leetcode.com/problems/maximum-binary-tree/discuss/106149/Java-solution-recursion
 */
package com.zea7ot.leetcode.lvl3.lc0654

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED
import com.zea7ot.leetcode.utils.dataStructure.tree.TreeNode

@Suppress(UNUSED)
class SolutionApproach0Recursion {
    fun constructMaximumBinaryTree(nums: IntArray) = dfs(0, nums.lastIndex, nums)

    private fun dfs(lo: Int, hi: Int, nums: IntArray): TreeNode? {
        if (lo > hi) return null

        var idxMax = lo
        for (idx in lo..hi) {
            if (nums[idx] > nums[idxMax]) {
                idxMax = idx
            }
        }

        val root = TreeNode(nums[idxMax])
        root.left = dfs(lo, idxMax - 1, nums)
        root.right = dfs(idxMax + 1, hi, nums)

        return root
    }
}