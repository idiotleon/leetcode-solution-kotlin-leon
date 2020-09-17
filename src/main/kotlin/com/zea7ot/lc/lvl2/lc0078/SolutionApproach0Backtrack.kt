/**
 * https://leetcode.com/problems/subsets-ii/
 *
 * Time Complexity:     O(N * 2 ^ N) + O(N * lg(N)) ~ O(N * 2 ^ 2)
 *  `ans.add(new ArrayList<Integer>(intermediate));` is of O(N)
 *
 * Space Complexity:    O(N *  (2 ^ N))
 *
 * References:
 *  https://medium.com/@vasanths294/permutation-combination-subset-time-complexity-eca924e00071
 */
package com.zea7ot.lc.lvl2.lc0078

import com.zea7ot.lc.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0Backtrack {
    fun subsets(nums: IntArray): List<List<Int>> {
        val paths: MutableList<MutableList<Int>> = ArrayList()
        // sanity check
        if (nums.isEmpty()) return paths

        val path = arrayListOf<Int>()
        backtrack(0, path, nums, paths)

        return paths
    }

    private fun backtrack(startIdx: Int,
                          path: MutableList<Int>,
                          nums: IntArray,
                          paths: MutableList<MutableList<Int>>) {
        val size = nums.size
        paths.add(path.toMutableList())

        for (i in startIdx until size) {
            path.add(nums[i])
            backtrack(i + 1, path, nums, paths)
            path.remove(path.last())
        }
    }
}