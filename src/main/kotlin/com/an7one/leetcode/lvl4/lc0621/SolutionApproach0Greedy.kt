/**
 * https://leetcode.com/problems/task-scheduler/
 *
 * Time Complexity:     O(`nTasks`)
 * Space Complexity:    O(1)
 *
 * References:
 *  http://zxi.mytechroad.com/blog/greedy/leetcode-621-task-scheduler/
 */
package com.an7one.leetcode.lvl4.lc0621

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0Greedy {
    fun leastInterval(tasks: CharArray, n: Int): Int {
        val nTasks = tasks.size

        val freqs = IntArray(26) { 0 }
        for (task in tasks) {
            ++freqs[task - 'A']
        }

        val maxFreq = freqs.max() ?: 0

        var ans = (maxFreq - 1) * (n + 1)
        for (freq in freqs) {
            if (freq == maxFreq) ++ans
        }

        return maxOf(ans, nTasks)
    }
}