/**
 * https://leetcode.com/problems/find-positive-integer-solution-for-a-given-equation/
 *
 * Time Complexity:     O(`x` + lg(`y`))
 * Space Complexity:    O(1)
 *
 * References:
 *  https://leetcode.com/problems/find-positive-integer-solution-for-a-given-equation/discuss/414158/JavaPython-3-3-methods%3A-time-O(x-%2B-y)-O(xlogy)-and-O(x-%2B-logy)-w-analysis.
 */
package com.zea7ot.leetcode.lvl2.lc1237

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0BinarySearch {
    private companion object {
        private const val RANGE = 1e3.toInt()
    }

    fun findSolution(customFunction: FakeCustomFunction, z: Int): List<List<Int>> {
        val ans = ArrayList<List<Int>>()
        var left = 1
        var right = RANGE + 1

        for (x in 1..RANGE) {
            // pruning here
            if (customFunction.f(x, left) > z || customFunction.f(x, right) < z) continue

            var lo = left
            var hi = right

            while (lo < hi) {
                val y = lo + (hi - lo) / 2
                if (customFunction.f(x, y) < z) {
                    lo = y + 1
                } else {
                    hi = y
                }
            }

            val value = customFunction.f(x, lo)
            if (value >= z) {
                if (value == z) ans.add(arrayListOf(x, lo))
                right = lo
            } else {
                left = lo
            }
        }

        return ans
    }
}