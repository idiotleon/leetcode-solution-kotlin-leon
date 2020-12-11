/**
 * https://leetcode.com/problems/minimum-swaps-to-make-sequences-increasing/
 *
 * Time Complexity:     O(`totalNums`)
 * Space Complexity:    O(`totalNums`)
 *
 * References:
 *  https://leetcode.com/problems/minimum-swaps-to-make-sequences-increasing/discuss/119879/C++JavaPython-DP-O(N)-Solution/561174
 *  https://leetcode.com/problems/minimum-swaps-to-make-sequences-increasing/discuss/119879/C%2B%2BJavaPython-DP-O(N)-Solution
 */
package com.zea7ot.leetcode.lvl4.lc0801

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP1Dimen {
    fun minSwap(A: IntArray, B: IntArray): Int {
        val totalNums = A.size
        val swap = IntArray(totalNums) { 0 }
        // base case
        swap[0] = 1
        val notSwap = IntArray(totalNums) { 0 }
        // base case, omitted
        // notSwap[0] = 0

        for (idx in 1 until totalNums) {
            notSwap[idx] = totalNums
            swap[idx] = totalNums
            if (A[idx - 1] < A[idx] && B[idx - 1] < B[idx]) {
                notSwap[idx] = notSwap[idx - 1]
                swap[idx] = swap[idx - 1] + 1
            }

            if (A[idx - 1] < B[idx] && B[idx - 1] < A[idx]) {
                notSwap[idx] = minOf(notSwap[idx], swap[idx - 1])
                swap[idx] = minOf(swap[idx], notSwap[idx - 1] + 1)
            }
        }

        return minOf(swap[totalNums - 1], notSwap[totalNums - 1])
    }
}