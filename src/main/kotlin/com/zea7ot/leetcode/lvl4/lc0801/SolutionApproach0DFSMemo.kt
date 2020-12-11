/**
 * https://leetcode.com/problems/minimum-swaps-to-make-sequences-increasing/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * References:
 *  https://leetcode.com/problems/minimum-swaps-to-make-sequences-increasing/discuss/262241/Recursive-with-memoization-(beats-100.00-)%3A
 */
package com.zea7ot.leetcode.lvl4.lc0801

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DFSMemo {
    private companion object {
        private const val RANGE = 2e3.toInt() + 1

        private const val NOT_SWAP = 0
        private const val SWAP = 1
    }

    fun minSwap(A: IntArray, B: IntArray): Int {
        val totalNums = A.size
        val dp = Array(totalNums) { Array<Int?>(2) { null } }

        return dfs(0, -1, -1, NOT_SWAP, A, B, dp)
    }

    private fun dfs(idx: Int, prevA: Int, prevB: Int, swapState: Int, A: IntArray, B: IntArray, dp: Array<Array<Int?>>): Int {
        val totalNums = A.size
        if (idx == totalNums) return 0
        dp[idx][swapState]?.let { return it }

        var minSwaps = RANGE

        // not to swap
        if (A[idx] > prevA && B[idx] > prevB) {
            minSwaps = dfs(idx + 1, A[idx], B[idx], NOT_SWAP, A, B, dp)
        }

        // to swap
        if (B[idx] > prevA && A[idx] > prevB) {
            // to perform swap
            minSwaps = minOf(minSwaps, 1 + dfs(idx + 1, B[idx], A[idx], SWAP, A, B, dp))
        }

        dp[idx][swapState] = minSwaps
        return minSwaps
    }
}