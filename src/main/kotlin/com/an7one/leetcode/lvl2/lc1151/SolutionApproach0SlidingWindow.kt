/**
 * https://leetcode.com/problems/minimum-swaps-to-group-all-1s-together/
 *
 * Time Complexity:     O(`nData`)
 * Space Complexity:    O(1)
 *
 * References:
 *  https://leetcode.com/problems/minimum-swaps-to-group-all-1s-together/discuss/355386/JavaPython-3-Sliding-Window-O(n)-code-w-brief-explanation-and-analysis.
 */
package com.an7one.leetcode.lvl2.lc1151

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0SlidingWindow {
    fun minSwaps(data: IntArray): Int {
        // not used
        // val nData = data.size

        // the most 1s, within the fixed-size sliding window, can have
        var most = 0
        // total 1s,
        // also the window size
        val sum = data.sum()

        // fixed-size window
        // `lo` can be acquired from `hi`
        // var hi = 0

        // running count of 1s
        var ones = 0

        for (hi in data.indices) {
            // amount of the 1s in the sliding window
            ones += data[hi]

            if (hi > sum - 1) { // to narrow down the window
                ones -= data[hi - sum]
            }

            most = maxOf(most, ones)
        }

        return sum - most
    }
}