/**
 * https://leetcode.com/problems/subsets-ii/
 *
 * Time Complexity:     O(`nNums` * (2 ^ nNums)) + O(`nNums` * lg(`nNums`)) ~ O(`nNums` * (`nNums` ^ 2))
 *  `paths.add(path.toMutableList())` costs O(`nNums`)
 *
 * Space Complexity:    O(`nNums` *  (2 ^ `nNums`))
 *
 * References:
 *  https://medium.com/@vasanths294/permutation-combination-subset-time-complexity-eca924e00071
 */
package com.zea7ot.leetcode.lvl2.lc0090

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0Backtrack {
    fun subsetsWithDup(nums: IntArray): List<List<Int>> {
        val paths = mutableListOf<MutableList<Int>>()
        // sanity check
        if (nums.isEmpty()) return paths

        nums.sort()
        val path = mutableListOf<Int>()

        backtrack(0, path, nums, paths)

        return paths
    }

    private fun backtrack(idxStart: Int,
                          path: MutableList<Int>,
                          nums: IntArray,
                          paths: MutableList<MutableList<Int>>) {
        val nNums = nums.size
        paths.add(path.toMutableList())

        for (idx in idxStart until nNums) {
            if (idx != idxStart && nums[idx - 1] == nums[idx]) continue
            path.add(nums[idx])
            backtrack(idx + 1, path, nums, paths)
            path.removeAt(path.size - 1)
        }
    }
}