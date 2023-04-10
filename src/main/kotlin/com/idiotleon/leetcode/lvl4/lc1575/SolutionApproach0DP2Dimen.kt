package com.idiotleon.leetcode.lvl4.lc1575

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import kotlin.math.abs

/**
 * @author: Leon
 * https://leetcode.com/problems/count-all-possible-routes/
 *
 * Time Complexity:     O(`fuel` * (`nLocations` ^ 2))
 * Space Complexity:    O(`fuel` * `nLocations`)
 *
 * Reference:
 * https://leetcode.com/problems/count-all-possible-routes/discuss/831152/Java-Bottom-Up
 * https://leetcode.com/problems/count-all-possible-routes/discuss/832678/JAVA-For-Beginners-Detailed-explanation-Brute-force-to-Memoization
 */
@Suppress(UNUSED)
class SolutionApproach0DP2Dimen {
    private companion object {
        private const val MOD = 1e9.toLong() + 7
    }

    fun countRoutes(locations: IntArray, start: Int, finish: Int, fuel: Int): Int {
        val nLocations = locations.size
        val dp = Array(nLocations) { idxCity -> LongArray(fuel + 1) { if (idxCity == finish) 1 else 0 } }

        for (fl in 0..fuel) {
            for (startCity in locations.indices) {
                for (endCity in locations.indices) {
                    if (startCity == endCity) continue

                    val cost = abs(locations[startCity] - locations[endCity])
                    if (cost <= fl) {
                        dp[startCity][fl] += dp[endCity][fl - cost] % MOD
                        dp[startCity][fl] %= MOD
                    }
                }
            }
        }

        return dp[start][fuel].toInt()
    }
}