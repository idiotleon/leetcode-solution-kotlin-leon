/**
 * https://leetcode.com/problems/minimum-number-of-refueling-ts/
 *
 * Time Complexity:     O(`totalStations` ^ 2)
 * Space Complexity:    O(`totalStations`)
 *
 * dp[t], means the furthest distance one can get with `t` times of refueling
 *  if dp[t] >= stations[idx][0], one can refuel:
 *  dp[t + 1] = max(dp[t + 1], dp[t] + stations[idx][1])
 *
 * References:
 *  https://leetcode.com/problems/minimum-number-of-refueling-ts/discuss/149839/DP-O(N2)-and-Priority-Queue-O(NlogN)
 */
package com.zea7ot.leetcode.lvl4.lc0871

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP1Dimen {
    fun minRefuelStops(target: Int, startFuel: Int, stations: Array<IntArray>): Int {
        val totalStations = stations.size

        val dp = IntArray(totalStations + 1)
        dp[0] = startFuel

        for (idx in 0 until totalStations) {
            for (t in idx downTo 0) {
                if (dp[t] >= stations[idx][0]) {
                    dp[t + 1] = maxOf(dp[t + 1], dp[t] + stations[idx][1])
                }
            }
        }

        for (i in 0..totalStations) {
            if (dp[i] >= target) {
                return i
            }
        }

        return -1
    }
}