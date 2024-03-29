package com.idiotleon.leetcode.lvl2.lc0078

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/subsets-ii/
 *
 * Time Complexity:     O(`nNums` * (2 ^ nNums)) + O(`nNums` * lg(`nNums`)) ~ O(`nNums` * (`nNums` ^ 2))
 *  `paths.add(path.toMutableList())` costs O(`nNums`)
 *
 * Space Complexity:    O(`nNums` *  (2 ^ `nNums`))
 *
 * References:
 *  https://leetcode.com/problems/subsets/solution/
 *  https://medium.com/@vasanths294/permutation-combination-subset-time-complexity-eca924e00071
 */
@Suppress(UNUSED)
class SolutionApproach0Backtrack {
    fun subsets(nums: IntArray): List<List<Int>> {
        val paths = mutableListOf<MutableList<Int>>()
        // sanity check
        if (nums.isEmpty())
            return paths

        val path = mutableListOf<Int>()
        backtrack(0, path, nums, paths)

        return paths
    }

    private fun backtrack(
        startIdx: Int,
        path: MutableList<Int>,
        nums: IntArray,
        paths: MutableList<MutableList<Int>>
    ) {
        val nNums = nums.size
        paths.add(path.toMutableList())

        for (idx in startIdx until nNums) {
            path.add(nums[idx])
            backtrack(idx + 1, path, nums, paths)
            path.removeAt(path.size - 1)
        }
    }
}