/**
 * https://leetcode.com/problems/soup-servings/
 *
 * Time Complexity:     O(`N` ^ 2)
 * Space Complexity:    O(`N`)
 *
 * References:
 *  https://leetcode.com/problems/soup-servings/discuss/121740/Straightforward-Java-Recursion-with-Memorization
 *  https://leetcode.com/problems/soup-servings/discuss/195582/A-Mathematical-Analysis-of-the-Soup-Servings-Problem
 *  https://leetcode.com/problems/soup-servings/discuss/121711/C%2B%2BJavaPython-When-N-greater-4800-just-return-1
 */
package com.zea7ot.leetcode.lvl5.lc0808

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DFSMemo {
    private companion object {
        private val SERVE_A = intArrayOf(100, 75, 50, 25)
        private val SERVE_B = intArrayOf(0, 25, 50, 75)
    }

    fun soupServings(N: Int): Double {
        if (N > 5000) return 1.0

        val memo = Array(N + 1) { Array<Double?>(N + 1) { null } }
        return dfs(N, N, memo)
    }

    private fun dfs(serveA: Int, serveB: Int, memo: Array<Array<Double?>>): Double {
        if (serveA <= 0 && serveB <= 0) return 0.5
        if (serveA <= 0) return 1.0
        if (serveB <= 0) return 0.0

        memo[serveA][serveB]?.let { return it }
        var prob = 0.0
        for (d in 0 until 4) {
            prob += dfs(serveA - SERVE_A[d], serveB - SERVE_B[d], memo)
        }

        prob *= 0.25
        memo[serveA][serveB] = prob
        return prob
    }
}