/**
 * https://leetcode.com/problems/perfect-squares/
 *
 * Time Complexity:     O(`n` * sqrt(`n`))
 * Space Complexity:    O(`n`)
 *
 * References:
 *  https://leetcode.com/problems/perfect-squares/discuss/805994/4-approaches-or-Java
 */
package com.an7one.leetcode.lvl3.lc0279

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DFSMemo {
    fun numSquares(n: Int): Int {
        val memo = HashMap<Int, Int>()
        return dfs(n, memo)
    }

    private fun dfs(num: Int, memo: HashMap<Int, Int>): Int {
        if (num <= 3) return num

        memo[num]?.let { return it }

        var min = Int.MAX_VALUE
        var factor = 1
        while (factor * factor <= num) {
            min = minOf(min, 1 + dfs(num - factor * factor, memo))
            ++factor
        }
        memo[num] = min
        return min
    }
}