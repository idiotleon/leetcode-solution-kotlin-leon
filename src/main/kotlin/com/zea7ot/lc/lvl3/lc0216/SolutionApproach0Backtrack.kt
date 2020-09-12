/**
 * @author: Leon
 * https://leetcode.com/problems/combination-sum-iii/
 *
 * Time Complexity:     O(9! / (k! * (9 - k)!))
 * Space Complexity:    O(`k`)
 */
package com.zea7ot.lc.lvl3.lc0216

import com.zea7ot.lc.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0Backtrack {
    fun combinationSum3(k: Int, n: Int): List<List<Int>> {
        val ans = ArrayList<MutableList<Int>>()

        backtrack(k, n, 1, arrayListOf(), ans)
        return ans
    }

    private fun backtrack(k: Int, n: Int, start: Int,
                          path: ArrayList<Int>,
                          paths: ArrayList<MutableList<Int>>): Unit {
        if (k < 0) return

        if (n == 0) {
            if (k == 0) {
                paths.add(path.toMutableList());
            }

            return
        }

        for (i in start until 10) {
            path.add(i)
            backtrack(k - 1, n - i, i + 1, path, paths)
            path.remove(path.last())
        }
    }
}