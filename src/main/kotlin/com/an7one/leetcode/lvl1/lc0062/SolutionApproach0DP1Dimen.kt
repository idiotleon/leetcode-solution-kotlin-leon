package com.an7one.leetcode.lvl1.lc0062

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/unique-paths/
 *
 * Time Complexity:     O(`m` * `n`)
 * Space Complexity:    O(`n`)
 *
 * Reference:
 * https://leetcode.com/problems/unique-paths/discuss/22954/C%2B%2B-DP
 */
@Suppress(UNUSED)
class SolutionApproach0DP1Dimen {
    fun uniquePaths(m: Int, n: Int): Int {
        val cur = IntArray(n) { 1 }

        for (row in 1 until m) {
            for (col in 1 until n) {
                cur[col] += cur[col - 1]
            }
        }

        return cur[n - 1]
    }
}