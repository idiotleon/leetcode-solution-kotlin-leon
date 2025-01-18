package com.idiotleon.leetcode.lvl4.lc1235

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/maximum-profit-in-job-scheduling/
 *
 * Time Complexity:     O(`nJobs` ^ 2) + O(`nJobs` * lg(`nJobs`)) ~ (`nJobs` ^ 2)
 * Space Complexity:    O(`nJobs`)
 *
 * Reference:
 * https://leetcode.com/problems/maximum-profit-in-job-scheduling/discuss/408985/Java-fast-DP/367947
 * https://leetcode.com/problems/maximum-profit-in-job-scheduling/discuss/408985/Java-fast-DP
 */
@Suppress(UNUSED)
class Solution0DP1Dimen {
    fun jobScheduling(startTimes: IntArray, endTimes: IntArray, profits: IntArray): Int {
        val nJobs = startTimes.size

        val jobs = Array(nJobs) { idx -> Job(startTimes[idx], endTimes[idx], profits[idx]) }
        // to sort the `jobs` array
        jobs.sortBy { it.endTime }

        val dp = IntArray(nJobs) { idx -> jobs[idx].profit }

        for (hi in 1 until nJobs) {
            for (lo in hi - 1 downTo 0) {
                if (jobs[lo].endTime <= jobs[hi].startTime) {
                    dp[hi] = maxOf(dp[hi], jobs[hi].profit + dp[lo])
                    // for pruning purpose
                    break
                }
            }

            dp[hi] = maxOf(dp[hi], dp[hi - 1])
        }

        return dp[nJobs - 1]
    }

    private data class Job(val startTime: Int, val endTime: Int, val profit: Int)
}