/**
 * https://leetcode.com/problems/video-stitching/
 *
 * Time Complexity:     O(`T` * `nClips`)
 * Space Complexity:    O(`T`)
 *
 * `dp[i]`, the furthest video clip time at `i`th-second it can reach
 *
 * References:
 *  https://leetcode.com/problems/video-stitching/discuss/270149/C++-DP-solution:-very-similar-to-minimum-number-of-refueling-stops/643860
 */
package com.zea7ot.leetcode.lvl4.lc1024

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP1Dimen {
    fun videoStitching(clips: Array<IntArray>, T: Int): Int {
        // not used
        // val nClips = clips.size

        val dp = IntArray(T + 1) { 0 }

        for (curSec in 1..T) { // the current second/time
            for ((start, end) in clips) {
                if (dp[curSec - 1] >= start) {
                    dp[curSec] = maxOf(dp[curSec], end)
                }
            }

            if (dp[curSec] >= T) return curSec
        }

        return -1
    }
}