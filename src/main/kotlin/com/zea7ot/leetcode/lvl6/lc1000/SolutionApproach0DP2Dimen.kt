/**
 * https://leetcode.com/problems/minimum-cost-to-merge-stones/
 *
 * Time Complexity:     O((`nStones` ^ 3) / `K`)
 * Space Complexity:    O(`nStones` ^ 2)
 *
 * `dp[lo][hi]`, the minimum cost required to merge stones[lo: hi].
 *  the merged pile(s) do(es) not have to be 1, but can be as many as it requires
 *
 * References:
 *  https://leetcode.com/problems/minimum-cost-to-merge-stones/discuss/247567/JavaC%2B%2BPython-DP
 *  Paid Course, 100min: https://www.acwing.com/video/35/
 */
package com.zea7ot.leetcode.lvl6.lc1000

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP2Dimen {
    fun mergeStones(stones: IntArray, K: Int): Int {
        val nStones = stones.size
        if ((nStones - 1) % (K - 1) > 0) return -1

        val prefixSums = IntArray(nStones + 1) { 0 }
        for (idx in stones.indices) {
            prefixSums[idx + 1] = prefixSums[idx] + stones[idx]
        }

        val dp = Array(nStones) { IntArray(nStones) { 0 } }
        for (len in K..nStones) {
            for (lo in 0 until nStones - len + 1) {
                val hi = lo + len - 1
                dp[lo][hi] = Int.MAX_VALUE

                for (k in lo until hi step K - 1) {
                    dp[lo][hi] = minOf(dp[lo][hi], dp[lo][k] + dp[k + 1][hi])
                }

                if ((hi - lo) % (K - 1) == 0) {
                    dp[lo][hi] += prefixSums[hi + 1] - prefixSums[lo]
                }
            }
        }

        return dp[0][nStones - 1]
    }
}