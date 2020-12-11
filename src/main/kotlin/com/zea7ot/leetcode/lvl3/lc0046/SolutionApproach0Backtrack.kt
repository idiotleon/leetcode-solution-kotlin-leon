/**
 * @author: Leon
 * https://leetcode.com/problems/permutations/
 *
 * Time Complexity:     O(2 ^ `nNums`)
 * Space Complexity:    O(`nNums`)
 */
package com.zea7ot.leetcode.lvl3.lc0046

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0Backtrack {
    fun permute(nums: IntArray): List<List<Int>> {

        val nNums = nums.size

        val used = BooleanArray(nNums) { false }
        val path = mutableListOf<Int>()
        val paths = mutableListOf<MutableList<Int>>()

        backtrack(nums, used, path, paths)

        return paths
    }

    private fun backtrack(nums: IntArray,
                          used: BooleanArray,
                          path: MutableList<Int>,
                          paths: MutableList<MutableList<Int>>) {

        val nNums = nums.size
        if (path.size == nNums) {
            paths.add(path.toMutableList())
            return
        }

        for (idx in nums.indices) {
            if (used[idx]) continue

            path.add(nums[idx])
            used[idx] = true
            backtrack(nums, used, path, paths)
            path.removeAt(path.size - 1)
            used[idx] = false
        }
    }
}