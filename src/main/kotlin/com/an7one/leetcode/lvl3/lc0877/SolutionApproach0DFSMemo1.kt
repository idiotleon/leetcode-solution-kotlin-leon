/**
 * https://leetcode.com/problems/stone-game/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * References:
 *  https://leetcode.com/problems/stone-game/discuss/154660/Java-This-is-minimax-+-dp-(fully-detailed-explanation-+-generalization-+-easy-understand-code)/565603
 *  https://leetcode.com/problems/stone-game/discuss/154660/Java-This-is-minimax-%2B-dp-(fully-detailed-explanation-%2B-generalization-%2B-easy-understand-code)
 */
package com.an7one.leetcode.lvl3.lc0877

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DFSMemo1 {
    fun stoneGame(piles: IntArray): Boolean {
        val nPiles = piles.size
        val prefixSums = piles.copyOf()
        for (idx in 1 until nPiles) {
            prefixSums[idx] += prefixSums[idx - 1]
        }

        val memo = Array(nPiles) { Array<Int?>(nPiles) { null } }
        val alexGain = dfs(0, nPiles - 1, prefixSums, piles, memo)
        val leeGain = prefixSums.last() - alexGain
        return alexGain > leeGain
    }

    private fun dfs(
        lo: Int,
        hi: Int,
        prefixSums: IntArray,
        piles: IntArray,
        memo: Array<Array<Int?>>
    ): Int {

        if (lo > hi) return 0
        memo[lo][hi]?.let { return it }

        // both ends inclusive
        val sum = prefixSums[hi] - prefixSums[lo] + piles[lo]
        
        // to minimize the gain of the next player
        val minOpponentGain = minOf(
            dfs(lo + 1, hi, prefixSums, piles, memo),
            dfs(lo, hi - 1, prefixSums, piles, memo)
        )

        val curMaxGain = sum - minOpponentGain
        memo[lo][hi] = curMaxGain
        return curMaxGain
    }
}