/**
 * https://leetcode.com/problems/stone-game-v/
 *
 * Time Complexity:     O(`nStones` ^ 3)
 * Space Complexity:    O(`nStones` ^ 2)
 *
 * References:
 *  https://leetcode.com/problems/stone-game-v/discuss/806717/Java-Detailed-Explanation-Easy-Understand-DFS-+-Memo-Top-Down-DP/685600
 *  https://leetcode.com/problems/stone-game-v/discuss/806717/Java-Detailed-Explanation-Easy-Understand-DFS-%2B-Memo-Top-Down-DP
 */
package com.zea7ot.leetcode.lvl4.lc1563

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DFSMemo {
    fun stoneGameV(stoneValues: IntArray): Int {
        val nStones = stoneValues.size
        val prefixSums = IntArray(nStones + 1) { 0 }
        for (idx in stoneValues.indices) {
            prefixSums[idx + 1] = prefixSums[idx] + stoneValues[idx]
        }

        val memo = Array(nStones + 1) { Array<Int?>(nStones + 1) { null } }
        return dfs(0, nStones - 1, prefixSums, memo)
    }

    private fun dfs(lo: Int, hi: Int, prefixSums: IntArray, memo: Array<Array<Int?>>): Int {
        if (lo == hi) return 0

        if (lo + 1 == hi) return minOf(prefixSums[lo + 1] - prefixSums[lo],
                prefixSums[hi + 1] - prefixSums[hi])

        memo[lo][hi]?.let { return it }

        var maxSum = Int.MIN_VALUE

        // left half: [lo, idx], right half: [idx + 1, hi]
        for (idx in lo until hi) {
            val leftSum = prefixSums[idx + 1] - prefixSums[lo]
            val rightSum = prefixSums[hi + 1] - prefixSums[idx + 1]

            maxSum = when {
                leftSum > rightSum -> { // to pick the right half
                    maxOf(maxSum, dfs(idx + 1, hi, prefixSums, memo) + rightSum)
                }

                leftSum < rightSum -> { // to pick the left half
                    maxOf(maxSum, dfs(lo, idx, prefixSums, memo) + leftSum)
                }

                else -> { // to pick whichever is larger
                    maxOf(maxSum,
                            maxOf(dfs(idx + 1, hi, prefixSums, memo),
                                    dfs(lo, idx, prefixSums, memo)) + leftSum)
                }
            }
        }

        memo[lo][hi] = maxSum
        return maxSum
    }
}