/**
 * https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/
 *
 * Time Complexity:     O(`nTimes`)
 * Space Complexity:    O(`RANGE`)
 *
 * References:
 *  https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/discuss/256738/JavaC%2B%2BPython-Two-Sum-with-K-60
 */
package com.idiotleon.leetcode.lvl3.lc1010

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0HashMap2 {
    private companion object {
        private const val MOD = 60

        // for modular purpose, to add 100 instead of 1
        private const val RANGE = 500 + 100
    }

    fun numPairsDivisibleBy60(times: IntArray): Int {
        // not used
        // val nTimes = times.size

        val freqs = IntArray(MOD)

        var count = 0

        for (time in times) {
            count += freqs[(RANGE - time) % MOD]
            freqs[time % 60] += 1
        }

        return count
    }
}