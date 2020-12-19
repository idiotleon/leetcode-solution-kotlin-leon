/**
 * https://leetcode.com/problems/count-all-possible-routes/
 *
 * Time Complexity:     O(`fuel` * (`nLocations` ^ 2))
 * Space Complexity:    O(`fuel` * `nLocations`)
 *
 * References:
 *  https://leetcode.com/problems/count-all-possible-routes/discuss/830400/Dynamic-Programming-or-Simple-Explanation
 *  https://leetcode.com/problems/count-all-possible-routes/discuss/832678/JAVA-For-Beginners-Detailed-explanation-Brute-force-to-Memoization
 */
package com.zea7ot.leetcode.lvl4.lc1575

import kotlin.math.abs
import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DFSMemo {
    private companion object {
        private const val MOD = 1e9.toInt() + 7
    }

    fun countRoutes(locations: IntArray, start: Int, finish: Int, fuel: Int): Int {
        val nLocations = locations.size
        val memo = Array(nLocations) { Array<Long?>(fuel + 1) { null } }
        return dfs(start, fuel, finish, locations, memo).toInt()
    }

    private fun dfs(
        curCity: Int, fuel: Int, endCity: Int,
        locations: IntArray,
        memo: Array<Array<Long?>>
    ): Long {
        if (fuel < 0) return 0
        memo[curCity][fuel]?.let { return it }
        var count = if (curCity == endCity) 1L else 0L
        for (nextCity in locations.indices) {
            if (curCity == nextCity) continue
            count += dfs(nextCity, fuel - abs(locations[curCity] - locations[nextCity]), endCity, locations, memo) % MOD
            count %= MOD
        }
        memo[curCity][fuel] = count
        return count
    }
}