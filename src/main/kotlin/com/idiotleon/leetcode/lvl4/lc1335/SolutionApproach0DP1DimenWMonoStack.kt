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
class SolutionApproach0DP1DimenWMonoStack {
    private companion object {
        private const val RANGE_DATA = 1e3.toInt() + 7
    }

    fun minDifficulty(jobDifficulties: IntArray, d: Int): Int {
        val nJobs = jobDifficulties.size
        if (nJobs < d) {
            return -1
        }

        var dp = IntArray(nJobs) { RANGE_DATA }
        var dp2 = IntArray(nJobs) { 0 }

        val stack = ArrayDeque<Int>()

        for (curDay in 0 until d) {
            stack.clear()
            for (curJob in curDay until nJobs) {
                dp2[curJob] = if (curJob > 0) dp[curJob - 1] + jobDifficulties[curJob] else jobDifficulties[curJob]

                while (stack.isNotEmpty() && jobDifficulties[stack.last()] <= jobDifficulties[curJob]) {
                    val job = stack.removeLast()
                    dp2[curJob] = minOf(
                        dp2[curJob], dp2[job] - jobDifficulties[job] + jobDifficulties[curJob]
                    )
                }

                if (stack.isNotEmpty()) {
                    dp2[curJob] = minOf(dp2[curJob], dp2[stack.last()])
                }

                stack.addLast(curJob)
            }

            val temp = dp
            dp = dp2
            dp2 = temp
        }

        return dp[nJobs - 1]
    }
}