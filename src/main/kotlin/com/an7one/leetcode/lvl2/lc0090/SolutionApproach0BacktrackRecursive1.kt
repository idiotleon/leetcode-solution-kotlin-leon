package com.an7one.leetcode.lvl2.lc0090

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/subsets-ii/
 *
 * Time Complexity:     O(2 ^ `nNums`)
 * Space Complexity:    O()
 *
 * References:
 *  https://leetcode.com/problems/subsets-ii/discuss/169226/Java-Two-Way-of-Recursive-thinking
 */
@Suppress(UNUSED)
class SolutionApproach0BacktrackRecursive1 {
    fun subsetsWithDup(nums: IntArray): List<List<Int>> {
        val path = mutableListOf<Int>()
        val paths = mutableListOf<List<Int>>()

        // sorting is required
        nums.sort()
        backtrack(0, path, nums, paths)

        return paths
    }

    private fun backtrack(
        idxStart: Int,
        path: MutableList<Int>,
        nums: IntArray,
        paths: MutableList<List<Int>>
    ) {
        val nNums = nums.size
        paths.add(path.toList())

        val used = HashSet<Int>()
        for (idx in idxStart until nNums) {
            if (!used.add(nums[idx])) continue
            path.add(nums[idx])
            backtrack(idx + 1, path, nums, paths)
            path.removeAt(path.size - 1)
        }
    }
}