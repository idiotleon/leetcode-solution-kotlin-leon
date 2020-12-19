/**
 * https://leetcode.com/problems/russian-doll-envelopes/
 *
 * Time Complexity:     O(`totalEnvelops` * lg(`totalEnvelops`))
 * Space Complexity:    O(`totalEnvelops`)
 *
 * References:
 *  https://leetcode.com/problems/russian-doll-envelopes/discuss/82763/Java-NLogN-Solution-with-Explanation
 */
package com.zea7ot.leetcode.lvl4.lc0354

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP1DimenWithBinarySearch {
    fun maxEnvelopes(envelopes: Array<IntArray>): Int {
        val totalEnvelops = envelopes.size
        envelopes.sortWith(compareBy({ it[0] }, { -it[1] }))

        val dp = IntArray(totalEnvelops) { 0 }
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