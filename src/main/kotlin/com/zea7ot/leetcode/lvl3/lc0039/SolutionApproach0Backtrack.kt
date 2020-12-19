/**
 * @author: Leon
 * https://leetcode.com/problems/combination-sum/
 *
 * Time Complexity:     O(`nNums` ^ (`target` / min + 1))
 *  min, the minimum value among `nums`
 *
 * Space Complexity:    O(`target` / min)
 *  min, the minimum value among `nums`
 *
 * Sorting can help prune the backtrack path
 *
 * References:
 *  https://leetcode.com/problems/combination-sum/solution/
 */
package com.zea7ot.leetcode.lvl3.lc0039

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0Backtrack {
    fun combinationSum(nums: IntArray, target: Int): List<List<Int>> {
        val path = mutableListOf<Int>()
        val paths = mutableListOf<MutableList<Int>>()

        backtrack(0, target, path, nums, paths)

        return paths
    }

    private fun backtrack(idxStart: Int,
                          target: Int,
                          path: MutableList<Int>,
                          nums: IntArray,
                          paths: MutableList<MutableList<Int>>) {

        val nNums = nums.size
        if (target < 0) return
        if (target == 0) {
            paths.add(path.toMutableList())
            return
        }

        for (idx in idxStart until nNums) {
            path.add(nums[idx])
            backtrack(idx, target - nums[idx], path, nums, paths)
            path.removeAt(path.size - 1)
        }
    }
}