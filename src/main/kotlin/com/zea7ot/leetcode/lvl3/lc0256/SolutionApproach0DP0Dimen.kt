/**
 * https://leetcode.com/problems/paint-house/
 *
 * Time Complexity:     O(`nHouses`)
 * Space Complexity:    O(1)
 *
 * References:
 *  https://leetcode.com/problems/paint-house/discuss/68211/Simple-java-DP-solution
 *  https://leetcode.com/problems/paint-house/discuss/68203/Share-my-very-simple-Java-solution-with-explanation.
 */
package com.zea7ot.leetcode.lvl3.lc0256

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP0Dimen {
    fun minCost(costs: Array<IntArray>): Int {
        // not used
        // val nHouses = costs.size

        var prevColor0 = 0
        var prevColor1 = 0
        var prevColor2 = 0

        for (idx in costs.indices) {
            val curColor0 = costs[idx][0] + minOf(prevColor1, prevColor2)
            val curColor1 = costs[idx][1] + minOf(prevColor0, prevColor2)
            val curColor2 = costs[idx][2] + minOf(prevColor0, prevColor1)

            prevColor0 = curColor0
            prevColor1 = curColor1
            prevColor2 = curColor2
        }

        return minOf(prevColor0, prevColor1, prevColor2)
    }
}