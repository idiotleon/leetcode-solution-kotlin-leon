/**
 * https://leetcode.com/problems/find-positive-integer-solution-for-a-given-equation/
 *
 * Time Complexity:     O(`x` * lg(`y`))
 * Space Complexity:    O(1)
 *
 * References:
 *  https://leetcode.com/problems/find-positive-integer-solution-for-a-given-equation/discuss/414158/JavaPython-3-3-methods%3A-time-O(x-%2B-y)-O(xlogy)-and-O(x-%2B-logy)-w-analysis.
 */
package com.idiotleon.leetcode.lvl2.lc1237

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0BinarySearch1 {
    private companion object {
        private const val RANGE = 1e3.toInt()
    }

    fun findSolution(customFunction: FakeCustomFunction, z: Int): List<List<Int>> {
        val ans = ArrayList<List<Int>>()
        for (x in 1..RANGE) {
            var lo = 1
            var hi = RANGE + 1

            while (lo < hi) {
                val y = lo + (hi - lo) / 2
                if (customFunction.f(x, y) < z) {
                    lo = y + 1
                } else {
                    hi = y
                }
            }

            if (customFunction.f(x, lo) == z) {
                ans.add(arrayListOf(x, lo))
            }
        }

        return ans
    }
}