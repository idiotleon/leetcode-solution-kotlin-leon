/**
 * https://leetcode.com/problems/maximum-profit-in-job-scheduling/
 *
 * Time Complexity:     O(`totalJobs` ^ 2) + O(`totalJobs` * lg(`totalJobs`)) ~ (`totalJobs` ^ 2)
 * Space Complexity:    O(`totalJobs`)
 *
 * References:
 *  https://leetcode.com/problems/maximum-profit-in-job-scheduling/discuss/408985/Java-fast-DP/367947
 *  https://leetcode.com/problems/maximum-profit-in-job-scheduling/discuss/408985/Java-fast-DP
 */
package com.idiotleon.leetcode.lvl4.lc1235

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP1Dimen {
    fun jobScheduling(startTimes: IntArray, endTimes: IntArray, profits: IntArray): Int {
        // total amount of jobs
        val totalJobs = startTimes.size

        val jobs = Array(totalJobs) { idx -> Job(startTimes[idx], endTimes[idx], profits[idx]) }
        // to sort the `jobs` array
        jobs.sortBy { it.endTime }

        val dp = IntArray(totalJobs) { idx -> jobs[idx].profit }

        for (hi in 1 until totalJobs) {
            for (lo in hi - 1 downTo 0) {
                if (jobs[lo].endTime <= jobs[hi].startTime) {
                    dp[hi] = maxOf(dp[hi], jobs[hi].profit + dp[lo])
                    // for pruning purpose
                    break
                }
            }

            dp[hi] = maxOf(dp[hi], dp[hi - 1])
        }

        return dp[totalJobs - 1]
    }

    private data class Job(val startTime: Int, val endTime: Int, val profit: Int)
}