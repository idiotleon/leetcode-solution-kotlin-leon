/**
 * https://leetcode.com/problems/divisor-game/
 *
 * Time Complexity:     O(`N`)
 * Space Complexity:    O(`N`)
 *
 * References:
 *  https://leetcode.com/problems/divisor-game/discuss/274608/Simple-DP-Java-Solution
 */
package com.idiotleon.leetcode.lvl2.lc1025

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DFSMemo {
    fun divisorGame(N: Int): Boolean {
        val memo = Array<Boolean?>(maxOf(2, N + 1)) { null }.also {
            it[0] = true
            it[1] = false
        }

        return dfs(N, memo)
    }

    private fun dfs(n: Int, memo: Array<Boolean?>): Boolean {
        if (n == 1) return false

        memo[n]?.let { return it }

        var canWin = false

        var num = 1
        while (num * num <= n) {
            if (n % num == 0) {
                if (!dfs(n - num, memo) || !dfs(n - (n / num), memo)) {
                    canWin = true
                    break
                }
            }

            ++num
        }

        memo[n] = canWin
        return canWin
    }
}