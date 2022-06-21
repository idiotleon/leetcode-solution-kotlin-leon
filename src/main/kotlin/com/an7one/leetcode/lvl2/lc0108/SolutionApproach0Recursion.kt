package com.an7one.leetcode.lvl2.lc0108

import com.an7one.leetcode.util.Constant.Annotation.UNUSED
import com.an7one.leetcode.util.dataStructure.tree.TreeNode

/**
 * @author: Leon
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 *
 * Time Complexity:     O(`nNums`)
 * Space Complexity:    O(lg(`nNums`))
 *
 * a top-down approach
 */
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