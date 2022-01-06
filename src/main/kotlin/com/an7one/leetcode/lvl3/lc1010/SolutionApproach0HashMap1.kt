/**
 * https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/
 *
 * Time Complexity:     O(`nTimes`)
 * Space Complexity:    O(`nTimes`)
 *
 * References:
 *  https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/discuss/256726/JavaPython-3-O(n)-code-w-comment-similar-to-Two-Sum
 */
package com.an7one.leetcode.lvl3.lc1010

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0HashMap1 {
    private companion object {
        private const val MOD = 60
    }

    fun numPairsDivisibleBy60(times: IntArray): Int {
        // not used
        // val nTimes = times.size

        val freqs = HashMap<Int, Int>()

        var count = 0
        for (time in times) {
            val theOther = (MOD - time % MOD) % MOD
            count += freqs[theOther] ?: 0
            freqs[time % MOD] = 1 + (freqs[time % MOD] ?: 0)
        }

        return count
    }
}