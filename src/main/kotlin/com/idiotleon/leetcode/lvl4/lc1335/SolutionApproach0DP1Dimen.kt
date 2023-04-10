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
class SolutionApproach0DP1Dimen {
    fun minDifficulty(jobDifficulties: IntArray, d: Int): Int {
        val nJobs = jobDifficulties.size
        if (nJobs < d)
            return -1

        val dp = IntArray(nJobs + 1) { 0 }.also {
            for (idx in nJobs - 1 downTo 0) {
                it[idx] = maxOf(it[idx + 1], jobDifficulties[idx])
            }
        }

        for (curDay in 2..d) {
            for (curJob in 0..nJobs - curDay) {
                var localMax = 0
                dp[curJob] = Int.MAX_VALUE
                for (schedule in curJob..nJobs - curDay) {
                    localMax = maxOf(localMax, jobDifficulties[schedule])
                    dp[curJob] = minOf(dp[curJob], localMax + dp[schedule + 1])
                }
            }
        }

        return dp[0]
    }
}