/**
 * https://leetcode.com/problems/paint-house-ii/
 *
 * Time Complexity:     O(`nHouses` * `nColors`)
 * Space Complexity:    O(1)
 *
 * References:
 *  https://leetcode.com/problems/paint-house-ii/discuss/69495/Fast-DP-Java-solution-Runtime-O(nk)-space-O(1)/143746
 *  https://leetcode.com/problems/paint-house-ii/discuss/69495/Fast-DP-Java-solution-Runtime-O(nk)-space-O(1)
 */
package com.zea7ot.leetcode.lvl4.lc0265

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP2Dimen {
    fun minCostII(costs: Array<IntArray>): Int {
        // sanity check, required
        if (costs.isEmpty() || costs[0].isEmpty()) return 0

        val nHouses = costs.size
        val nColors = costs[0].size
        if (nColors == 1) return if (nHouses == 1) costs[0][0] else -1

        var prevMin = 0
        var prevSecMin = 0
        var idxPrevMin = -1

        for (idxHouse in costs.indices) {
            var curMin = Int.MAX_VALUE
            var curSecMin = Int.MAX_VALUE
            var idxCurMin = -1

            for (idxColor in costs[idxHouse].indices) {
                val value = costs[idxHouse][idxColor] + if (idxColor == idxPrevMin) prevSecMin else prevMin

                when {
                    idxCurMin < 0 || value < curMin -> { // when value < curMin, or not initialized
                        curSecMin = curMin
                        curMin = value
                        idxCurMin = idxColor
                    }

                    value < curSecMin -> { // when curMin <= value < curSecMin
                        curSecMin = value
                    }

                    else -> {

                    }
                }
            }

            prevMin = curMin
            prevSecMin = curSecMin
            idxPrevMin = idxCurMin
        }

        return prevMin
    }
}