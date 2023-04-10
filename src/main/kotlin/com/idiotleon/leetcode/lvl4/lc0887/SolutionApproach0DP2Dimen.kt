/**
 * @author: Leon
 * https://leetcode.com/problems/super-egg-drop/
 *
 * Time Complexity:     O(`nEggs` * `nFloors`)
 * Space Complexity:    O(`nEggs` * `nFloors`)
 *
 * Reference:
 *  https://leetcode.com/problems/super-egg-drop/discuss/158974/C%2B%2BJavaPython-2D-and-1D-DP-O(KlogN)
 */
package com.idiotleon.leetcode.lvl4.lc0887

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP2Dimen {
    fun superEggDrop(nEggs: Int, nFloors: Int): Int {
        val dp = Array(nFloors + 1) { Array(nEggs + 1) { 0 } }

        var floor = 0
        while (dp[floor][nEggs] < nFloors) {
            ++floor

            for (egg in 1..nEggs) {
                dp[floor][egg] = dp[floor - 1][egg - 1] + dp[floor - 1][egg] + 1
            }
        }

        return floor
    }
}