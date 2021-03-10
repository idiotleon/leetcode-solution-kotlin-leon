/**
 * https://leetcode.com/problems/insert-interval/
 *
 * Time Complexity:     O(`totalIntervals`)
 * Space Complexity:    O(`totalIntervals`) / O(1)
 *
 * References:
 *  https://leetcode.com/problems/insert-interval/discuss/21602/Short-and-straight-forward-Java-solution/242084
 */
package com.an7one.leetcode.lvl4.lc0057

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0Greedy {
    fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
        // not used
        // val totalIntervals = intervals.size

        val ans = ArrayList<IntArray>()
        var prev = newInterval
        for (cur in intervals) {
            when {
                prev[1] < cur[0] -> {
                    ans.add(prev)
                    prev = cur
                }

                prev[0] > cur[1] -> {
                    ans.add(cur)
                }

                else -> {
                    prev[0] = minOf(prev[0], cur[0])
                    prev[1] = maxOf(prev[1], cur[1])
                }
            }
        }

        ans.add(prev)
        return ans.toTypedArray()
    }
}