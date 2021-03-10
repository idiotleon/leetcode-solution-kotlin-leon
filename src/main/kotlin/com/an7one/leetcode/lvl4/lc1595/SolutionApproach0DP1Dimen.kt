/**
 * https://leetcode.com/problems/minimum-cost-to-connect-two-groups-of-points/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * References:
 *  https://leetcode.com/problems/minimum-cost-to-connect-two-groups-of-points/discuss/855425/Java-bottom-up-DP-with-bit-mask/704737
 *  https://leetcode.com/problems/minimum-cost-to-connect-two-groups-of-points/discuss/855425/Java-bottom-up-DP-with-bit-mask
 */
package com.an7one.leetcode.lvl4.lc1595

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP1Dimen {
    fun connectTwoGroups(costs: List<List<Int>>): Int {
        val nCosts = costs.size
        // not used
        // val nPoints = costs[0].size

        val range = 1 shl nCosts
        var dp = IntArray(range) { Int.MAX_VALUE }.also {
            it[0] = 0
        }

        for (idxPoint in costs[0].indices) {
            val next = IntArray(range) { Int.MAX_VALUE }

            for (k in 0 until range) {
                for (idxCost in costs.indices) {
                    val bitMask = k or (1 shl idxCost)

                    if (dp[k] != Int.MAX_VALUE) {
                        next[bitMask] = minOf(
                            next[bitMask],
                            dp[k] + costs[idxCost][idxPoint]
                        )
                    }

                    if ((k and (1 shl idxCost)) == 0) {
                        if (next[k] != Int.MAX_VALUE) {
                            next[bitMask] = minOf(next[bitMask], next[k] + costs[idxCost][idxPoint])
                        }
                    }
                }
            }

            dp = next
        }

        return dp[range - 1]
    }
}