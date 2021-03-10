/**
 * https://leetcode.com/problems/perfect-squares/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * References:
 *  https://leetcode.com/problems/perfect-squares/discuss/805994/4-approaches-or-Java
 */
package com.an7one.leetcode.lvl3.lc0279

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

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