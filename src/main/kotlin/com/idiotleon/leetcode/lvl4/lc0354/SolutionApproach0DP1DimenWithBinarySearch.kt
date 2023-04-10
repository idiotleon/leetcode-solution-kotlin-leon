package com.idiotleon.leetcode.lvl4.lc0354

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/russian-doll-envelopes/
 *
 * Time Complexity:     O(`nEnvelops` * lg(`nEnvelops`))
 * Space Complexity:    O(`nEnvelops`)
 *
 * References:
 * https://leetcode.com/problems/russian-doll-envelopes/discuss/82763/Java-NLogN-Solution-with-Explanation
 */
@Suppress(UNUSED)
class SolutionApproach0DP1DimenWithBinarySearch {
    fun maxEnvelopes(envelopes: Array<IntArray>): Int {
        val nEnvelops = envelopes.size
        envelopes.sortWith(compareBy({ it[0] }, { -it[1] }))

        val dp = IntArray(nEnvelops) { 0 }
        var size = 0

        for (envelope in envelopes) {
            var lo = 0
            var hi = size

            while (lo < hi) {
                val mid = lo + (hi - lo) / 2
                if (dp[mid] < envelope[1]) {
                    lo = mid + 1
                } else {
                    hi = mid
                }
            }

            dp[lo] = envelope[1]

            if (lo == size) {
                ++size
            }
        }

        return size
    }
}