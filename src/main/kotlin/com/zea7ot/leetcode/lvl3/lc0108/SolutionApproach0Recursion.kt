/**
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 *
 * Time Complexity:     O(`nNums`)
 * Space Complexity:    O(lg(`nNums`))
 *
 * a top-down approach
 */
package com.zea7ot.leetcode.lvl3.lc0108

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED
import com.zea7ot.leetcode.util.dataStructure.tree.TreeNode

@Suppress(UNUSED)
class SolutionApproach0Recursion {
    fun sortedArrayToBST(nums: IntArray): TreeNode? {
        // not used
        // val nNums = nums.size

        return buildTree(0, nums.lastIndex, nums)
    }

    private fun buildTree(lo: Int, hi: Int, nums: IntArray): TreeNode? {
        if (lo > hi) return null

        val mid = lo + (hi - lo) / 2
        val root = TreeNode(nums[mid])

        root.left = buildTree(lo, mid - 1, nums)
        root.right = buildTree(mid + 1, hi, nums)
        return root
    }
}