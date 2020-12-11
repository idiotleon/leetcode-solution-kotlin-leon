/**
 * @author: Leon
 * https://leetcode.com/problems/combination-sum-iv/
 *
 * Time Complexity:     O(9 * 8 * ... * (9 - `k` + 1)) ~ O(`k`)
 * Space Complexity:    O(`k`) + O(1) / O(`k` * 9) ~ O(`k`)
 */
package com.zea7ot.leetcode.lvl3.lc0216.withBit

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0Backtrack {
    private companion object {
        // +1, to give up index 0 (turn 0-indexed to 1-indexed)
        // +1, to pad with one more element
        private const val RANGE = 9 + 1
    }

    fun combinationSum3(k: Int, n: Int): List<List<Int>> {

        val path = mutableListOf<Int>()
        val paths = mutableListOf<MutableList<Int>>()

        val bitMask = 1 shl RANGE

        backtrack(1, bitMask, k, n, path, paths)

        return paths
    }

    private fun backtrack(numStart: Int,
                          bitMask: Int,
                          k: Int,
                          target: Int,
                          path: MutableList<Int>,
                          paths: MutableList<MutableList<Int>>) {
        if (k < 0 || target < 0 || numStart == RANGE + 1) return

        if (target == 0) {
            if (k == 0) {
                paths.add(path.toMutableList())
                return
            }
        }

        for (num in numStart until RANGE) {
            // to prune the backtrack/dfs path
            if (num > target) break
            if ((bitMask and (1 shl num)) == 0) { // if this `num` was used before
                val newBitMask = bitMask and (1 shl num)
                path.add(num)
                backtrack(num + 1, newBitMask, k - 1, target - num, path, paths)
                path.removeAt(path.size - 1)
            }
        }
    }
}