/**
 * https://leetcode.com/problems/minimum-number-of-refueling-ts/
 *
 * Time Complexity:     O(`nStations` ^ 2)
 * Space Complexity:    O(`nStations`)
 *
 * dp[t], means the furthest distance one can get with `t` times of refueling
 *  if dp[t] >= stations[idx][0], one can refuel:
 *  dp[t + 1] = max(dp[t + 1], dp[t] + stations[idx][1])
 *
 * References:
 *  https://leetcode.com/problems/minimum-number-of-refueling-ts/discuss/149839/DP-O(N2)-and-Priority-Queue-O(NlogN)
 */
package com.idiotleon.leetcode.lvl4.lc0871

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP1Dimen {
    fun minRefuelStops(target: Int, startFuel: Int, stations: Array<IntArray>): Int {
        val nStations = stations.size

        val dp = IntArray(nStations + 1) { 0 }.also {
            it[0] = startFuel
        }

        for (idx in stations.indices) {
            for (t in idx downTo 0) {
                if (dp[t] >= stations[idx][0]) {
                    dp[t + 1] = maxOf(dp[t + 1], dp[t] + stations[idx][1])
                }
            }
        }

        return dp.indexOfFirst { it >= target }
    }
}