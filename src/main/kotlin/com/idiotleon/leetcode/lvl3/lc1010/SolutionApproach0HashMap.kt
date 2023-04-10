/**
 * https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/
 *
 * Time Complexity:     O(`nTimes`)
 * Space Complexity:    O(`nTimes`)
 *
 * References:
 *  https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/discuss/256726/JavaPython-3-O(n)-code-w-comment-similar-to-Two-Sum/644125
 *  https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/discuss/256726/JavaPython-3-O(n)-code-w-comment-similar-to-Two-Sum
 */
package com.idiotleon.leetcode.lvl3.lc1010

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0HashMap {
    private companion object {
        private const val MOD = 60
    }

    fun numPairsDivisibleBy60(times: IntArray): Int {
        // not used
        // val nTimes = times.size

        val moddedTimeToFreq = HashMap<Int, Int>()

        var count = 0
        for (time in times) {
            val modTime = time % MOD
            val theOther = if (modTime == 0) 0 else MOD - modTime
            count += moddedTimeToFreq[theOther] ?: 0
            moddedTimeToFreq[modTime] = 1 + (moddedTimeToFreq[modTime] ?: 0)
        }

        return count
    }
}