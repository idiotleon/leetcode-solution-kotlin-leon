/**
 * @author: Leon
 * https://leetcode.com/problems/combination-sum-iii/
 *
 * Time Complexity:     O(9! / (k! * (9 - k)!))
 * Space Complexity:    O(`k`)
 */
package com.an7one.leetcode.lvl3.lc0216

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0Backtrack {
    fun combinationSum3(k: Int, n: Int): List<List<Int>> {
        val path = mutableListOf<Int>()
        val paths = mutableListOf<MutableList<Int>>()

        backtrack(1, k, n, path, paths)

        return paths
    }

    private fun backtrack(
        numStart: Int,
        k: Int,
        target: Int,
        path: MutableList<Int>,
        paths: MutableList<MutableList<Int>>
    ) {
        if (k < 0 || target < 0 || numStart == 10) return

        if (target == 0) {
            if (k == 0) {
                paths.add(path.toMutableList());
            }

            return
        }

        for (num in numStart until 10) {
            path.add(num)
            backtrack(num + 1, k - 1, target - num, path, paths)
            path.removeAt(path.size - 1)
        }
    }
}