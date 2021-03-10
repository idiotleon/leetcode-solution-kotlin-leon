/**
 * https://leetcode.com/problems/diet-plan-performance/
 *
 * Time Complexity:     O(`totalCal`)
 * Space Complexity:    O(1)
 *
 * References:
 *  https://leetcode.com/problems/diet-plan-performance/discuss/371843/JavaPython-3-Sliding-window-w-brief-explanation-and-analysis.
 */
package com.an7one.leetcode.lvl2.lc1176

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0SlidingWindow {
    fun dietPlanPerformance(calories: IntArray, k: Int, lower: Int, upper: Int): Int {
        // not used
        // val totalCal = calories.size

        var points = 0

        var kDays = 0

        for (idx in calories.indices) {
            kDays += calories[idx]

            if (idx >= k - 1) {
                if (idx > k - 1) {
                    kDays -= calories[idx - k]
                }

                if (kDays < lower) --points
                else if (kDays > upper) ++points
            }
        }

        return points
    }
}