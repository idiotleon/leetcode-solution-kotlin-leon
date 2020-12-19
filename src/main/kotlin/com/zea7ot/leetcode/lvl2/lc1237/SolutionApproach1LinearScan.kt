/**
 * https://leetcode.com/problems/find-positive-integer-solution-for-a-given-equation/
 *
 * Time Complexity:     O(`RANGE`)
 * Space Complexity:    O(1)
 *
 * References:
 *  https://leetcode.com/problems/find-positive-integer-solution-for-a-given-equation/discuss/414158/JavaPython-3-3-methods%3A-time-O(x-%2B-y)-O(xlogy)-and-O(x-%2B-logy)-w-analysis.
 */
package com.zea7ot.leetcode.lvl2.lc1237

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach1LinearScan {
    private companion object {
        private const val RANGE = 1e3.toInt()
    }

    fun findSolution(customFunction: FakeCustomFunction, z: Int): List<List<Int>> {
        val ans = ArrayList<List<Int>>()
        var x = 1
        var y = RANGE

        while (y > 0 && x <= RANGE) {
            val value = customFunction.f(x, y)
            when {
                value < z -> ++x
                value > z -> --y
                else -> ans.add(arrayListOf(x++, y--))
            }
        }

        return ans
    }
}