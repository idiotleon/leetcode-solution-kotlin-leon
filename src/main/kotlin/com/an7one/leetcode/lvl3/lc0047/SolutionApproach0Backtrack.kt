/**
 * @author: Leon
 * https://leetcode.com/problems/permutations/
 *
 * Time Complexity:     O(N * N!)
 * Space Complexity:    O(N * N!) / O(1) + O(N * lg(N)) + O(N)
 *
 * References:
 *  https://leetcode.com/problems/permutations/solution/
 */
package com.an7one.leetcode.lvl3.lc0047

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0Backtrack {
    fun permuteUnique(nums: IntArray): List<List<Int>> {
        val nNums = nums.size

        nums.sort()

        val used = BooleanArray(nNums) { false }

        val path = mutableListOf<Int>()
        val paths = mutableListOf<MutableList<Int>>()

        backtrack(used, nums, path, paths)

        return paths
    }

    private fun backtrack(
        used: BooleanArray,
        nums: IntArray,
        path: MutableList<Int>,
        paths: MutableList<MutableList<Int>>
    ) {

        val nNums = nums.size
        if (path.size == nNums) {
            paths.add(path.toMutableList())
            return
        }

        for (idx in nums.indices) {
            if (used[idx]) continue
            if (idx > 0 && !used[idx - 1] && nums[idx - 1] == nums[idx]) continue

            path.add(nums[idx])
            used[idx] = true
            backtrack(used, nums, path, paths)
            path.removeAt(path.size - 1)
            used[idx] = false
        }
    }
}