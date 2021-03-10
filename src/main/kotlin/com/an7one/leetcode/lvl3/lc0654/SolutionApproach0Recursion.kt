/**
 * https://leetcode.com/problems/maximum-binary-tree/
 *
 * Time Complexity:     O(N * lg(N)), O(N ^ 2) in the worst case
 * Space Complexity:    O(lg(N)), O(N) in the worst case
 *
 * References:
 *  https://leetcode.com/problems/maximum-binary-tree/discuss/106149/Java-solution-recursion
 */
package com.an7one.leetcode.lvl3.lc0654

import com.an7one.leetcode.util.Constant.Annotation.UNUSED
import com.an7one.leetcode.util.dataStructure.tree.TreeNode

@Suppress(UNUSED)
class SolutionApproach0Recursion {
    fun constructMaximumBinaryTree(nums: IntArray) = buildTree(0, nums.lastIndex, nums)

    private fun buildTree(lo: Int, hi: Int, nums: IntArray): TreeNode? {
        if (lo > hi) return null

        var idxMax = -1
        var valueMax = Int.MIN_VALUE
        for (idx in lo..hi) {
            if (valueMax < nums[idx]) {
                idxMax = idx
                valueMax = nums[idx]
            }
        }

        val root = TreeNode(valueMax)
        root.left = buildTree(lo, idxMax - 1, nums)
        root.right = buildTree(idxMax + 1, hi, nums)
        return root
    }
}