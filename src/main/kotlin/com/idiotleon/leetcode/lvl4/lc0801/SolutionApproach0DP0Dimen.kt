/**
 * https://leetcode.com/problems/minimum-swaps-to-make-sequences-increasing/
 *
 * Time Complexity:     O(`totalNums`)
 * Space Complexity:    O(1)
 *
 * References:
 *  https://leetcode.com/problems/minimum-swaps-to-make-sequences-increasing/discuss/119879/C++JavaPython-DP-O(N)-Solution/561174
 *  https://leetcode.com/problems/minimum-swaps-to-make-sequences-increasing/discuss/119879/C%2B%2BJavaPython-DP-O(N)-Solution
 */
package com.idiotleon.leetcode.lvl4.lc0801

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP0Dimen {
    fun minSwap(A: IntArray, B: IntArray): Int {
        val nNums = A.size
        // base cases
        var prevSwap = 1
        var prevNotSwap = 0

        for (idx in 1 until nNums) {
            var swap = nNums
            var notSwap = nNums

            if (A[idx - 1] < A[idx] && B[idx - 1] < B[idx]) {
                swap = prevSwap + 1
                notSwap = prevNotSwap
            }

            if (A[idx - 1] < B[idx] && B[idx - 1] < A[idx]) {
                swap = minOf(swap, prevNotSwap + 1)
                notSwap = minOf(notSwap, prevSwap)
            }

            prevSwap = swap
            prevNotSwap = notSwap
        }

        return minOf(prevSwap, prevNotSwap)
    }
}