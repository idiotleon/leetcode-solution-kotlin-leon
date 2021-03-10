/**
 * https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/
 *
 * Time Complexity:     O(`totalTimes`)
 * Space Complexity:    O(`totalTimes`)
 *
 * References:
 *  https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/discuss/256726/JavaPython-3-O(n)-code-w-comment-similar-to-Two-Sum/644125
 *  https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/discuss/256726/JavaPython-3-O(n)-code-w-comment-similar-to-Two-Sum
 */
package com.an7one.leetcode.lvl3.lc1010

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0HashMap {
    private companion object {
        private const val MOD = 60
    }

    fun numPairsDivisibleBy60(times: IntArray): Int {
        // not used
        // val totalTimes = times.size

        val freqs = HashMap<Int, Int>()

        var count = 0
        for (time in times) {
            val modTime = time % MOD
            val theOther = if (modTime == 0) 0 else MOD - modTime
            count += freqs[theOther] ?: 0
            freqs[modTime] = 1 + (freqs[modTime] ?: 0)
        }

        return count
    }
}