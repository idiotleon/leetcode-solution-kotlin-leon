package com.idiotleon.leetcode.lvl4.lc1335

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/minimum-difficulty-of-a-job-schedule/
 *
 * Time Complexity:     O((`nJobs` ^ 2) * `d`)
 * Space Complexity:    O(`nJobs` * `d`)
 *
 * Reference:
 * https://leetcode.com/problems/minimum-difficulty-of-a-job-schedule/discuss/490316/javacpython3-dp-ond-solution/968560
 */
@Suppress(UNUSED)
class SolutionApproach0DFSMemo {
    fun minDifficulty(jobDifficulties: IntArray, d: Int): Int {
        val nJobs = jobDifficulties.size
        if (nJobs < d) {
            return -1
        }

        val memo = Array(nJobs) { Array<Int?>(d + 1) { null } }

        return dfs(d, 0, jobDifficulties, memo)
    }

    private fun dfs(
        curDay: Int, curJob: Int, jobDifficulties: IntArray, memo: Array<Array<Int?>>
    ): Int {
        val nJobs = jobDifficulties.size
        if (curDay == 0 && curJob == nJobs) {
            return 0
        }

        if (curDay == 0 || curJob == nJobs) {
            return Int.MAX_VALUE
        }

        memo[curJob][curDay]?.let { return it }

        var curMax = jobDifficulties[curJob]
        var minDiff = Int.MAX_VALUE
        for (schedule in curJob until nJobs) {
            curMax = maxOf(curMax, jobDifficulties[schedule])
            val temp = dfs(curDay - 1, schedule + 1, jobDifficulties, memo)
            if (temp != Int.MAX_VALUE) minDiff = minOf(minDiff, temp + curMax)
        }

        memo[curJob][curDay] = minDiff
        return minDiff
    }
}