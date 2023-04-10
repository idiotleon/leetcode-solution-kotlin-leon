/**
 * https://leetcode.com/problems/minimum-difficulty-of-a-job-schedule/
 *
 * Time Complexity:     O((`nJobs` ^ 2) * `d`)
 * Space Complexity:    O(`nJobs` * `d`)
 *
 * Reference:
 *  https://leetcode.com/problems/minimum-difficulty-of-a-job-schedule/discuss/490316/javacpython3-dp-ond-solution/968560
 */
package com.idiotleon.leetcode.lvl4.lc1335

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP2Dimen {
    fun minDifficulty(jobDifficulties: IntArray, d: Int): Int {
        val nJobs = jobDifficulties.size
        if (nJobs < d)
            return -1

        val dp = Array(d) { IntArray(nJobs) { 0 } }.also {
            it[0][0] = jobDifficulties[0]
            for (job in 1 until nJobs) {
                it[0][job] = maxOf(jobDifficulties[job], it[0][job - 1])
            }
        }

        for (curDay in 1 until d) {
            for (curJob in curDay until nJobs) {
                var localMax = jobDifficulties[curJob]
                dp[curDay][curJob] = Int.MAX_VALUE
                for (schedule in curJob downTo curDay) {
                    localMax = maxOf(localMax, jobDifficulties[schedule])
                    dp[curDay][curJob] = minOf(
                        dp[curDay][curJob],
                        dp[curDay - 1][schedule - 1] + localMax
                    )
                }
            }
        }

        return dp[d - 1][nJobs - 1]
    }
}