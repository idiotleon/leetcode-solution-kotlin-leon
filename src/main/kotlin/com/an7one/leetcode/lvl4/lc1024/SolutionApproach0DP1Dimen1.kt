/**
 * https://leetcode.com/problems/video-stitching/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * References:
 *  https://leetcode.com/problems/video-stitching/discuss/270350/Java-DP-Short-Solution-!!!
 */
package com.an7one.leetcode.lvl4.lc1024

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP1Dimen1 {
    fun videoStitching(clips: Array<IntArray>, T: Int): Int {
        val dp = IntArray(T + 1) { idx -> if (idx == 0) 0 else T + 1 }

        for (curSec in 0..T) { // current second/time
            for ((start, end) in clips) {
                if (curSec in start..end) {
                    dp[curSec] = minOf(dp[curSec], dp[start] + 1)
                }
            }

            if (dp[curSec] == T + 1) return -1
        }

        return dp[T]
    }
}