package com.idiotleon.leetcode.lvl3.lc0279

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/perfect-squares/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * Reference:
 * https://leetcode.com/problems/perfect-squares/discuss/805994/4-approaches-or-Java
 */
@Suppress(UNUSED)
class SolutionApproach2DFSNaive {
    fun numSquares(n: Int) = dfs(n)

    private fun dfs(n: Int): Int {
        if (n <= 3) return n

        var min = n + 1
        var factor = 1
        while (factor * factor <= n) {
            min = minOf(min, 1 + dfs(n - factor * factor))
            ++factor
        }

        return min
    }
}