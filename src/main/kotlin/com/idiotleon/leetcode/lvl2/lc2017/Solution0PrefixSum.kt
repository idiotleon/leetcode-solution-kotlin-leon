package com.idiotleon.leetcode.lvl2.lc2017

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/grid-game/
 *
 * Time Complexity:     O(`nCols`)
 * Space Complexity:    O(1)
 *
 * Reference:
 * https://leetcode.com/problems/grid-game/solutions/1486340/c-java-python-robot1-minimize-topsum-and-bottomsum-of-robot-2-picture-explained/
 */
@Suppress(UNUSED)
class Solution0PrefixSum {
    fun gridGame(grid: Array<IntArray>): Long {
        val nCols = grid[0].size
        var topRowSum: Long = grid[0].sumOf { it.toLong() }
        var bottomRowSum: Long = 0L
        var ans = Long.MAX_VALUE
        for (c in 0 until nCols) {
            topRowSum -= grid[0][c]
            ans = minOf(ans, maxOf(topRowSum, bottomRowSum))
            bottomRowSum += grid[1][c]
        }

        return ans
    }
}