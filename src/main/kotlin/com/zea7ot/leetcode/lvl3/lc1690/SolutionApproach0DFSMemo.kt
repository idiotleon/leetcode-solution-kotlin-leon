/**
 * https://leetcode.com/problems/stone-game-vii/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * References:
 *  https://leetcode.com/problems/stone-game-vii/discuss/970268/C++Python-O(n-*-n)/791280
 *  https://leetcode.com/problems/stone-game-vii/discuss/970268/C%2B%2BPython-O(n-*-n)
 */
package com.zea7ot.leetcode.lvl3.lc1690

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DFSMemo {
    fun stoneGameVII(stones: IntArray): Int {
        val nStones = stones.size
        val memo = Array(nStones) { Array<Int?>(nStones) { null } }

        val sum = stones.sum()
        return dfs(0, nStones - 1, sum, stones, memo)
    }

    private fun dfs(lo: Int, hi: Int, sum: Int, stones: IntArray, memo: Array<Array<Int?>>): Int {
        if (lo == hi) return 0

        memo[lo][hi]?.let { return it }

        val maxDiff = maxOf(
            sum - stones[lo] - dfs(lo + 1, hi, sum - stones[lo], stones, memo),
            sum - stones[hi] - dfs(lo, hi - 1, sum - stones[hi], stones, memo)
        )

        memo[lo][hi] = maxDiff
        return maxDiff
    }
}