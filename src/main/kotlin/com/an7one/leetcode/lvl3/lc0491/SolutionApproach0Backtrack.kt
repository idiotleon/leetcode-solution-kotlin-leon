package com.an7one.leetcode.lvl3.lc0491

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/increasing-subsequences/
 *
 * Time Complexity:     O(`nNums` * (2 ^ `nNums`))
 * Space Complexity:    O(`nNums`)
 *
 * Reference:
 * https://leetcode.com/problems/increasing-subsequences/discuss/97147/Java-solution-beats-100
 * https://leetcode.com/problems/increasing-subsequences/discuss/97147/Java-solution-beats-100/498426
 *
 * about why a local set:
 * https://leetcode.com/problems/increasing-subsequences/discuss/97130/Java-20-lines-backtracking-solution-using-set-beats-100./101617
 */
@Suppress(UNUSED)
class SolutionApproach0Backtrack {
    fun findSubsequences(nums: IntArray): List<List<Int>> {
        val path = mutableListOf<Int>()
        val paths = mutableListOf<List<Int>>()

        backtrack(0, path, nums, paths)
        return paths
    }

    private fun backtrack(
        idxStart: Int, path: MutableList<Int>, nums: IntArray, paths: MutableList<List<Int>>
    ) {
        val nNums = nums.size

        if (path.size > 1) paths.add(path.toList())

        val used = HashSet<Int>()
        for (idx in idxStart until nNums) {
            if (used.contains(nums[idx])) continue

            if (path.isEmpty() || nums[idx] >= path.last()) {
                used.add(nums[idx])
                path.add(nums[idx])
                backtrack(idx + 1, path, nums, paths)
                path.removeAt(path.size - 1)
            }
        }
    }
}